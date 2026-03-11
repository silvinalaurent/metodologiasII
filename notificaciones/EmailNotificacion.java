public class EmailNotificacion implements CanalNotificacion { 
    @Override 
    public void enviar(String destino, String mensaje) { 
        System.out.println("📧 Enviando EMAIL a: " + destino); 
        System.out.println("   Mensaje: " + mensaje); 
        System.out.println("   Conectando con servidor SMTP..."); 
        System.out.println("   ¡Email enviado!"); 
    } 
     
    @Override 
    public String getTipoCanal() { 
        return "EMAIL"; 
    } 
}