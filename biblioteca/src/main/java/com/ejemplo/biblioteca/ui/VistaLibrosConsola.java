package com.ejemplo.biblioteca.ui;

import com.ejemplo.biblioteca.modelo.Libro;
import java.util.List;

/**
 * Vista de consola para mostrar información de la biblioteca.
 *
 * <p>Principio aplicado: <b>LSP</b>.
 * Esta clase puede reemplazar a cualquier otra {@code VistaLibros} sin que
 * el código cliente necesite cambios. Una futura {@code VistaLibrosHtml} o
 * {@code VistaLibrosJson} funcionarían de la misma manera.</p>
 */
public class VistaLibrosConsola implements VistaLibros {

    private static final String SEPARADOR = "─".repeat(50);

    @Override
    public void mostrarLibros(List<Libro> libros, String titulo) {
        System.out.println("\n" + SEPARADOR);
        System.out.println("  " + titulo.toUpperCase());
        System.out.println(SEPARADOR);
        if (libros.isEmpty()) {
            System.out.println("  (sin resultados)");
        } else {
            libros.forEach(libro -> System.out.println("  " + libro));
        }
        System.out.println(SEPARADOR);
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        System.out.println("✓ " + mensaje);
    }

    @Override
    public void mostrarError(String error) {
        System.err.println("✗ ERROR: " + error);
    }
}
