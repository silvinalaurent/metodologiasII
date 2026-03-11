public interface CanalNotificacion { 
    void enviar(String destino, String mensaje); 
    String getTipoCanal(); 
}