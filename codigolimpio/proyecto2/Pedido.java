public class Pedido { 
    private final String idPedido; 
    private final Cliente cliente; 
    private final List<Item> items; 
    private final LocalDateTime fechaPedido; 
     
    public Pedido(String idPedido, Cliente cliente, List<Item> items, LocalDateTime fechaPedido) { 
        this.idPedido = idPedido; 
        this.cliente = cliente; 
        this.items = new ArrayList<>(items); 
        this.fechaPedido = fechaPedido; 
    } 
     
    public double calcularTotal() { 
        double subtotal = calcularSubtotal(); 
        double descuento = calcularDescuento(subtotal); 
        return subtotal - descuento; 
    } 
     
    private double calcularSubtotal() { 
        return items.stream() 
            .mapToDouble(Item::getPrecio) 
            .sum(); 
    } 
     
    private double calcularDescuento(double subtotal) { 
        EstrategiaDescuento estrategia = FabricaEstrategiaDescuento.crearPara(cliente); 
        return estrategia.calcular(subtotal); 
    } 
     
    // Getters 
    public Cliente getCliente() { return cliente; } 
    public LocalDateTime getFechaPedido() { return fechaPedido; } 
} 
 
