import java.util.*;
//pu
public class ServicioNotificaciones { 
    private List<CanalNotificacion> canalesDisponibles; 
     
    public ServicioNotificaciones() { 
        this.canalesDisponibles = new ArrayList<>(); 
    } 
     
    public void registrarCanal(CanalNotificacion canal) { 
        canalesDisponibles.add(canal); 
        System.out.println("✅ Canal " + canal.getTipoCanal() + " registrado"); 
    } 
     
    public void notificarCliente(Cliente cliente, String mensaje) { 
        System.out.println("\n🔔 Notificando a: " + cliente.getNombre()); 
         
        for (CanalNotificacion canal : canalesDisponibles) { 
            String destino = obtenerDestino(cliente, canal.getTipoCanal()); 
             
            if (destino != null) { 
                canal.enviar(destino, mensaje); 
            } 
        } 
    } 
     
    private String obtenerDestino(Cliente cliente, String tipoCanal) { 
        switch(tipoCanal) { 
            case "EMAIL": 
                return cliente.prefiereEmail() ? cliente.getEmail() : null; 
            case "SMS": 
                return cliente.prefiereSMS() ? cliente.getTelefono() : null; 
            case "WHATSAPP": 
                return cliente.getTelefono(); 
            default: 
                return null; 
        } 
    } 
}