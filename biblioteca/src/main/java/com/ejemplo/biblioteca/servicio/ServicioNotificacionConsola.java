package com.ejemplo.biblioteca.servicio;

/**
 * Implementación de notificaciones por consola.
 *
 * <p>Principio aplicado: <b>OCP</b>.
 * Para agregar notificaciones por email, creamos {@code ServicioNotificacionEmail}
 * sin tocar esta clase ni el servicio de préstamos.</p>
 */
public class ServicioNotificacionConsola implements ServicioNotificacion {

    @Override
    public void notificar(String mensaje) {
        System.out.println("[NOTIFICACIÓN] " + mensaje);
    }
}
