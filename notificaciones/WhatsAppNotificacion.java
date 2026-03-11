public class WhatsAppNotificacion implements CanalNotificacion { 
    @Override 
    public void enviar(String destino, String mensaje) { 
        System.out.println("💬 Enviando WhatsApp a: " + destino); 
        System.out.println("   Mensaje: " + mensaje); 
        System.out.println("   Usando API de WhatsApp..."); 
        System.out.println("   ¡WhatsApp enviado!"); 
    } 
     
    @Override 
    public String getTipoCanal() { 
        return "WHATSAPP"; 
    } 
}