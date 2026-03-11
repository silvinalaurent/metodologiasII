public class Main { 
    public static void main(String[] args) { 
         
        // 1. Crear clientes 
        Cliente ana = new Cliente("Ana García", "ana@email.com", "555-1234"); 
        ana.setPreferencias(true, true); 
         
        Cliente carlos = new Cliente("Carlos López", "carlos@email.com", "555-5678"); 
        carlos.setPreferencias(true, false); 
         
        // 2. Configurar servicio de notificaciones 
        ServicioNotificaciones servicio = new ServicioNotificaciones(); 
         
        servicio.registrarCanal(new EmailNotificacion()); 
        servicio.registrarCanal(new SMSNotificacion()); 
        servicio.registrarCanal(new WhatsAppNotificacion()); 
         
        // 3. Generar mensajes 
        GeneradorMensajes generador = new GeneradorMensajes(); 
        RegistroNotificaciones registro = new RegistroNotificaciones(); 
         
        // 4. Enviar notificaciones 
        System.out.println("\n=== ENVIANDO NOTIFICACIONES ==="); 
         
        String mensajeBienvenida = generador.generarMensajeBienvenida(ana); 
        servicio.notificarCliente(ana, mensajeBienvenida); 
        registro.registrarEnvio(ana.getNombre(), "MÚLTIPLE", mensajeBienvenida); 
         
        String mensajePromo = generador.generarMensajePromocion("Celular", 20); 
        servicio.notificarCliente(carlos, mensajePromo); 
        registro.registrarEnvio(carlos.getNombre(), "MÚLTIPLE", mensajePromo); 
         
        // 5. Mostrar historial 
        registro.mostrarHistorial(); 
    } 
}