public class SMSNotificacion implements CanalNotificacion { 
    @Override 
    public void enviar(String destino, String mensaje) { 
        System.out.println("📱 Enviando SMS a: " + destino); 
        System.out.println("   Mensaje: " + mensaje); 
        System.out.println("   Conectando con gateway SMS..."); 
        System.out.println("   ¡SMS enviado!"); 
    } 
     
    @Override 
    public String getTipoCanal() { 
        return "SMS"; 
    } 
}