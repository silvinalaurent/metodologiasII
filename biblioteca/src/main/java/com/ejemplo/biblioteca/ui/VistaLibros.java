package com.ejemplo.biblioteca.ui;

import com.ejemplo.biblioteca.modelo.Libro;
import java.util.List;

/**
 * Contrato para la presentación de información al usuario.
 *
 * <p>Principios aplicados:</p>
 * <ul>
 *   <li><b>SRP</b>: Separamos la presentación del negocio. El servicio no imprime
 *       directamente, delega en esta interfaz.</li>
 *   <li><b>LSP</b> (Liskov Substitution): Cualquier implementación de esta interfaz
 *       puede usarse sin cambiar el código que la consume.</li>
 * </ul>
 */
public interface VistaLibros {

    /**
     * Muestra una lista de libros al usuario.
     *
     * @param libros la lista a mostrar
     * @param titulo encabezado de la sección
     */
    void mostrarLibros(List<Libro> libros, String titulo);

    /**
     * Muestra un mensaje informativo.
     *
     * @param mensaje el texto a mostrar
     */
    void mostrarMensaje(String mensaje);

    /**
     * Muestra un mensaje de error.
     *
     * @param error descripción del error
     */
    void mostrarError(String error);
}
