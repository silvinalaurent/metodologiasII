package com.ejemplo.biblioteca.repositorio;

import com.ejemplo.biblioteca.modelo.Libro;
import java.util.List;
import java.util.Optional;

/**
 * Contrato para el almacenamiento de libros.
 *
 * <p>Principios aplicados:</p>
 * <ul>
 *   <li><b>DIP</b> (Dependency Inversion): Las clases de servicio dependen de esta
 *       abstracción, no de una implementación concreta como una base de datos.</li>
 *   <li><b>ISP</b> (Interface Segregation): La interfaz solo expone operaciones
 *       relacionadas con libros. No mezcla responsabilidades.</li>
 * </ul>
 */
public interface LibroRepositorio {

    /**
     * Guarda un libro en el repositorio.
     *
     * @param libro el libro a guardar
     */
    void guardar(Libro libro);

    /**
     * Busca un libro por su ISBN.
     *
     * @param isbn el ISBN a buscar
     * @return un Optional con el libro si existe
     */
    Optional<Libro> buscarPorIsbn(String isbn);

    /**
     * Devuelve todos los libros del repositorio.
     *
     * @return lista de todos los libros
     */
    List<Libro> obtenerTodos();

    /**
     * Devuelve solo los libros disponibles para préstamo.
     *
     * @return lista de libros disponibles
     */
    List<Libro> obtenerDisponibles();
}
