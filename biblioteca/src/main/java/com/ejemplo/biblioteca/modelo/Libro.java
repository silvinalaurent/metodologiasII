package com.ejemplo.biblioteca.modelo;

/**
 * Representa un libro en la biblioteca.
 *
 * <p>Principio aplicado: SRP (Single Responsibility Principle).
 * Esta clase solo tiene la responsabilidad de representar los datos de un libro.
 * No sabe cómo guardarse, ni cómo mostrarse en pantalla.</p>
 */
public class Libro {

    private final String isbn;
    private final String titulo;
    private final String autor;
    private boolean disponible;

    /**
     * Crea un nuevo libro.
     *
     * @param isbn    identificador único del libro
     * @param titulo  título del libro
     * @param autor   autor del libro
     */
    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    /**
     * Devuelve el ISBN del libro.
     *
     * @return el ISBN
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Devuelve el título del libro.
     *
     * @return el título
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Devuelve el autor del libro.
     *
     * @return el autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Indica si el libro está disponible para préstamo.
     *
     * @return true si está disponible
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Marca el libro como prestado.
     */
    public void prestar() {
        this.disponible = false;
    }

    /**
     * Marca el libro como devuelto.
     */
    public void devolver() {
        this.disponible = true;
    }

    @Override
    public String toString() {
        return String.format("[%s] \"%s\" - %s (%s)",
            isbn,
            titulo,
            autor,
            disponible ? "disponible" : "prestado"
        );
    }
}
