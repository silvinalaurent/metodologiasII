import java.util.*;

public class RegistroNotificaciones { 
    private List<String> historial = new ArrayList<>(); 
     
    public void registrarEnvio(String cliente, String canal, String mensaje) { 
        String registro = String.format("[%s] Cliente: %s - Canal: %s - Mensaje: %s",  
                                        new Date(), cliente, canal, mensaje); 
        historial.add(registro); 
        System.out.println("📝 Registro guardado: " + registro); 
    } 
     
    public void mostrarHistorial() { 
        System.out.println("\n=== HISTORIAL DE NOTIFICACIONES ==="); 
        for (String registro : historial) { 
            System.out.println(registro); 
        } 
    } 
}