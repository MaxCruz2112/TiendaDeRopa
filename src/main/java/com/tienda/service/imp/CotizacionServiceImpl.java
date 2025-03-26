package com.tienda.service.imp;

import com.tienda.entity.Cotizacion;
import com.tienda.entity.DetalleCotizacion;
import com.tienda.entity.Prenda;
import com.tienda.entity.Sucursal;
import com.tienda.entity.Vendedor;
import com.tienda.repository.ICotizacionRepository;
import com.tienda.repository.IPrendaRepository;
import com.tienda.repository.ISucursalRepository;
import com.tienda.repository.IVendedorRepository;
import com.tienda.service.ICotizacionService;
import com.tienda.service.dto.CotizacionRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CotizacionServiceImpl implements ICotizacionService {

    @Autowired
    private ICotizacionRepository cotizacionRepository;

    @Autowired
    private IVendedorRepository vendedorRepository;

    @Autowired
    private ISucursalRepository sucursalRepository;

    @Autowired
    private IPrendaRepository prendaRepository;

    @Override
    public Cotizacion crearCotizacion(CotizacionRequestDTO request) {
        // Buscar el vendedor
        Vendedor vendedor = vendedorRepository.findById(request.getVendedorId())
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));

        // Buscar la sucursal
        Sucursal sucursal = sucursalRepository.findById(request.getSucursalId())
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        // Crear la cotización
        Cotizacion cotizacion = new Cotizacion();
        cotizacion.setCodigo(generarCodigoCotizacion()); // Generar código único
        cotizacion.setFechaCotizacion(LocalDate.now());
        cotizacion.setVendedor(vendedor);
        cotizacion.setSucursal(sucursal);

        // Validar detalles y calcular subtotales
        List<DetalleCotizacion> detalles = request.getDetalles().stream().map(detalleDTO -> {
            Prenda prenda = prendaRepository.findById(detalleDTO.getPrendaId())
                    .orElseThrow(() -> new RuntimeException("Prenda no encontrada"));

            // Validar que haya suficiente stock
            if (detalleDTO.getCantidad() > prenda.getCantidadStock()) {
                throw new RuntimeException("No hay suficiente stock para la prenda con ID " + prenda.getId());
            }

            // Calcular el subtotal usando el precio final de la prenda
            double precioFinal = prenda.calcularPrecioFinal();
            double subtotal = detalleDTO.getCantidad() * precioFinal;

            // Actualizar el stock de la prenda
            int nuevoStock = prenda.getCantidadStock() - detalleDTO.getCantidad();
            prenda.setCantidadStock(nuevoStock);
            prendaRepository.save(prenda); // Guardar la prenda actualizada

            // Crear el detalle de la cotización
            DetalleCotizacion detalle = new DetalleCotizacion();
            detalle.setCotizacion(cotizacion); // Asignar la instancia de Cotizacion
            detalle.setPrenda(prenda);
            detalle.setCantidad(detalleDTO.getCantidad());
            detalle.setSubtotal(subtotal); // Guardar el subtotal calculado

            return detalle;
        }).toList();

        cotizacion.setDetalles(detalles);

        // Guardar la cotización
        return cotizacionRepository.save(cotizacion);
    }

    private String generarCodigoCotizacion() {
        // Obtener el último código registrado
        String ultimoCodigo = cotizacionRepository.findUltimoCodigo()
                .orElse("COT-0000"); // Usamos "COT-0000" como valor predeterminado si no hay códigos previos

        // Extraer el número secuencial del último código
        String numeroStr = ultimoCodigo.substring(4); // Quitamos "COT-"
        int numero = Integer.parseInt(numeroStr);

        // Incrementar el número secuencial
        int nuevoNumero = numero + 1;

        // Formatear el nuevo código
        return String.format("COT-%04d", nuevoNumero);
    }

    @Override
    public Cotizacion buscarCotizacionPorVendedorYCodigo(Long vendedorId, String codigo) {
        return cotizacionRepository.findByCodigoAndVendedorId(codigo, vendedorId)
                .orElseThrow(() -> new RuntimeException("Cotización no encontrada para el vendedor con ID " + vendedorId + " y código " + codigo));
    }
       
}