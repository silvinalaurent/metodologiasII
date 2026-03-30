
public class DescuentoClienteRegularStrategy implements EstrategiaDescuento { 
    private static final double TASA_DESCUENTO_REGULAR = 0.05; 
     
    @Override 
    public double calcular(double subtotal) { 
        return subtotal * TASA_DESCUENTO_REGULAR; 
    } 
}
