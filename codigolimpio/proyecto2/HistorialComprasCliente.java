public class HistorialComprasCliente { 
    private final List<Pedido> pedidos; 
     
    public HistorialComprasCliente(List<Pedido> pedidos) { 
        this.pedidos = pedidos; 
    } 
     
    public int obtenerCantidadComprasUltimoMes() { 
        LocalDateTime haceUnMes = LocalDateTime.now().minusMonths(1); 
        return (int) pedidos.stream() 
            .filter(pedido -> pedido.getFechaPedido().isAfter(haceUnMes)) 
            .count(); 
    } 
} 
