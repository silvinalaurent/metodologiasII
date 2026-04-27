package com.ejemplo.biblioteca;

import com.ejemplo.biblioteca.modelo.Libro;
import com.ejemplo.biblioteca.repositorio.LibroRepositorioEnMemoria;
import com.ejemplo.biblioteca.servicio.ServicioPrestamo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests unitarios para el servicio de préstamos.
 *
 * <p>Gracias al principio <b>DIP</b>, podemos inyectar un repositorio en memoria
 * y una notificación de prueba sin tocar el código de producción.</p>
 */
class ServicioPrestamoTest {

    /** Captura los mensajes de notificación enviados durante el test. */
    private List<String> mensajesCapturados;
    private ServicioPrestamo servicio;
    private LibroRepositorioEnMemoria repositorio;

    @BeforeEach
    void configurar() {
        mensajesCapturados = new ArrayList<>();
        repositorio = new LibroRepositorioEnMemoria();
        // Inyectamos una notificación "spy" que solo guarda mensajes
        servicio = new ServicioPrestamo(repositorio, mensajesCapturados::add);
    }

    @Test
    @DisplayName("Registrar un libro lo guarda en el repositorio")
    void registrarLibroLoGuarda() {
        Libro libro = new Libro("123", "Test", "Autor");
        servicio.registrarLibro(libro);
        assertTrue(repositorio.buscarPorIsbn("123").isPresent());
    }

    @Test
    @DisplayName("Prestar un libro lo marca como no disponible")
    void prestarLibroLoPonePrestado() {
        Libro libro = new Libro("123", "Test", "Autor");
        servicio.registrarLibro(libro);
        servicio.prestarLibro("123", "Ana");
        assertFalse(repositorio.buscarPorIsbn("123").get().isDisponible());
    }

    @Test
    @DisplayName("Prestar un libro ya prestado lanza excepción")
    void prestarLibroPrestadoFalla() {
        Libro libro = new Libro("123", "Test", "Autor");
        servicio.registrarLibro(libro);
        servicio.prestarLibro("123", "Ana");
        assertThrows(IllegalStateException.class, () -> servicio.prestarLibro("123", "Pedro"));
    }

    @Test
    @DisplayName("Devolver un libro lo marca como disponible")
    void devolverLibroLoPonerDisponible() {
        Libro libro = new Libro("123", "Test", "Autor");
        servicio.registrarLibro(libro);
        servicio.prestarLibro("123", "Ana");
        servicio.devolverLibro("123", "Ana");
        assertTrue(repositorio.buscarPorIsbn("123").get().isDisponible());
    }

    @Test
    @DisplayName("Las operaciones envían notificaciones")
    void operacionesEnvianNotificaciones() {
        Libro libro = new Libro("123", "Test", "Autor");
        servicio.registrarLibro(libro);
        servicio.prestarLibro("123", "Ana");
        assertEquals(2, mensajesCapturados.size());
    }
}
