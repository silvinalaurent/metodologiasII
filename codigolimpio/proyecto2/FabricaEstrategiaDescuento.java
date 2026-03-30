public class FabricaEstrategiaDescuento { 
    public static EstrategiaDescuento crearPara(Cliente cliente) { 
        return switch (cliente.getNivel()) { 
            case VIP -> new DescuentoClienteVipStrategy(cliente.getHistorialCompras()); 
            case REGULAR -> new DescuentoClienteRegularStrategy(); 
            case BASICO -> new SinDescuentoStrategy(); 
        }; 
    } 
} 
