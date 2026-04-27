package com.ejemplo.biblioteca.servicio;

import com.ejemplo.biblioteca.modelo.Libro;
import com.ejemplo.biblioteca.repositorio.LibroRepositorio;

/**
 * Gestiona los préstamos de libros.
 *
 * <p>Principios aplicados:</p>
 * <ul>
 *   <li><b>DIP</b> (Dependency Inversion): Este servicio recibe sus dependencias
 *       desde afuera (inyección de dependencias en el constructor). Depende de las
 *       abstracciones {@code LibroRepositorio} y {@code ServicioNotificacion},
 *       no de clases concretas.</li>
 *   <li><b>SRP</b>: Esta clase solo se ocupa de la lógica de préstamos.
 *       No sabe cómo guardar libros ni cómo enviar mensajes.</li>
 * </ul>
 */
public class ServicioPrestamo {

    private final LibroRepositorio repositorio;
    private final ServicioNotificacion notificacion;

    /**
     * Crea el servicio inyectando las dependencias necesarias.
     *
     * @param repositorio   fuente de datos de libros
     * @param notificacion  canal para enviar mensajes
     */
    public ServicioPrestamo(LibroRepositorio repositorio, ServicioNotificacion notificacion) {
        this.repositorio = repositorio;
        this.notificacion = notificacion;
    }

    /**
     * Registra el alta de un libro en la biblioteca.
     *
     * @param libro el libro a registrar
     */
    public void registrarLibro(Libro libro) {
        repositorio.guardar(libro);
        notificacion.notificar("Libro registrado: " + libro.getTitulo());
    }

    /**
     * Presta un libro a un usuario. Falla si el libro no existe o no está disponible.
     *
     * @param isbn     el ISBN del libro a prestar
     * @param usuario  nombre del usuario que solicita el préstamo
     * @throws IllegalArgumentException si el libro no existe
     * @throws IllegalStateException    si el libro no está disponible
     */
    public void prestarLibro(String isbn, String usuario) {
        Libro libro = repositorio.buscarPorIsbn(isbn)
            .orElseThrow(() -> new IllegalArgumentException("Libro no encontrado: " + isbn));

        if (!libro.isDisponible()) {
            throw new IllegalStateException("El libro no está disponible: " + libro.getTitulo());
        }

        libro.prestar();
        notificacion.notificar(usuario + " tomó prestado: " + libro.getTitulo());
    }

    /**
     * Registra la devolución de un libro.
     *
     * @param isbn    el ISBN del libro que se devuelve
     * @param usuario nombre del usuario que devuelve el libro
     * @throws IllegalArgumentException si el libro no existe
     */
    public void devolverLibro(String isbn, String usuario) {
        Libro libro = repositorio.buscarPorIsbn(isbn)
            .orElseThrow(() -> new IllegalArgumentException("Libro no encontrado: " + isbn));

        libro.devolver();
        notificacion.notificar(usuario + " devolvió: " + libro.getTitulo());
    }
}
