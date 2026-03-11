public class GeneradorMensajes { 
     
    public String generarMensajeBienvenida(Cliente cliente) { 
        return "¡Bienvenido " + cliente.getNombre() + "! Gracias por registrarte."; 
    } 
     
    public String generarMensajePromocion(String producto, double descuento) { 
        return "🔥 OFERTA ESPECIAL: " + producto + " con " + descuento + "% de descuento"; 
    } 
     
    public String generarMensajeRecordatorio(String cita, String fecha) { 
        return "⏰ Recordatorio: " + cita + " el día " + fecha; 
    } 
}