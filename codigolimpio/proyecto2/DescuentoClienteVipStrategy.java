public class DescuentoClienteVipStrategy implements EstrategiaDescuento { 
    private static final double TASA_DESCUENTO_VIP = 0.10; 
    private static final int CANTIDAD_MINIMA_COMPRAS_DESCUENTO_EXTRA = 3; 
    private final HistorialComprasCliente historialCompras; 
     
    public DescuentoClienteVipStrategy(HistorialComprasCliente historialCompras) { 
        this.historialCompras = historialCompras; 
    } 
     
    @Override 
    public double calcular(double subtotal) { 
        double descuento = subtotal * TASA_DESCUENTO_VIP; 
         
        if (tieneAltaFrecuenciaDeCompras()) { 
            descuento += subtotal * 0.05; // 5% extra por frecuencia 
        } 
         
        return descuento; 
    } 
     
    private boolean tieneAltaFrecuenciaDeCompras() { 
        return historialCompras.obtenerCantidadComprasUltimoMes() >= CANTIDAD_MINIMA_COMPRAS_DESCUENTO_EXTRA; 
    } 
} 
 
