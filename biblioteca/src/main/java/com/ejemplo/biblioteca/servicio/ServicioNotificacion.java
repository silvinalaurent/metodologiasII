package com.ejemplo.biblioteca.servicio;

/**
 * Contrato para el envío de notificaciones.
 *
 * <p>Principio aplicado: <b>ISP</b> (Interface Segregation).
 * Esta interfaz es pequeña y concreta: solo define una operación.
 * Si tuviéramos una interfaz grande con {@code enviarEmail()}, {@code enviarSMS()},
 * {@code imprimirTicket()}, las clases que solo necesitan una de ellas
 * se verían forzadas a implementar las demás.</p>
 */
public interface ServicioNotificacion {

    /**
     * Envía una notificación con el mensaje dado.
     *
     * @param mensaje el texto a enviar
     */
    void notificar(String mensaje);
}
