package com.ejemplo.biblioteca;

import com.ejemplo.biblioteca.modelo.Libro;
import com.ejemplo.biblioteca.repositorio.LibroRepositorioEnMemoria;
import com.ejemplo.biblioteca.servicio.ServicioNotificacionConsola;
import com.ejemplo.biblioteca.servicio.ServicioPrestamo;
import com.ejemplo.biblioteca.ui.VistaLibros;
import com.ejemplo.biblioteca.ui.VistaLibrosConsola;

/**
 * Punto de entrada de la aplicación.
 *
 * <p>Aquí se "ensamblan" todas las dependencias (Composition Root).
 * Cada pieza es intercambiable gracias al principio <b>DIP</b>.</p>
 */
public class Aplicacion {

    /**
     * Método principal de la aplicación.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Ensamblamos las dependencias — el único lugar donde usamos "new"
        ServicioPrestamo servicio = new ServicioPrestamo(
            new LibroRepositorioEnMemoria(),
            new ServicioNotificacionConsola()
        );
        VistaLibros vista = new VistaLibrosConsola();

        // Datos de ejemplo
        Libro libro1 = new Libro("978-0-13-468599-1", "Clean Code", "Robert C. Martin");
        Libro libro2 = new Libro("978-0-20-163361-5", "The Pragmatic Programmer", "Hunt & Thomas");
        Libro libro3 = new Libro("978-0-59-651798-1", "Head First Design Patterns", "Freeman et al.");

        servicio.registrarLibro(libro1);
        servicio.registrarLibro(libro2);
        servicio.registrarLibro(libro3);

        // Mostrar catálogo completo
        vista.mostrarLibros(
            new LibroRepositorioEnMemoria().obtenerTodos(),
            "Catálogo inicial"
        );

        // Simular un préstamo
        try {
            servicio.prestarLibro("978-0-13-468599-1", "Ana García");
            servicio.prestarLibro("978-0-13-468599-1", "Pedro Ruiz"); // debe fallar
        } catch (IllegalStateException e) {
            vista.mostrarError(e.getMessage());
        }

        // Devolver un libro
        servicio.devolverLibro("978-0-13-468599-1", "Ana García");
    }
}
