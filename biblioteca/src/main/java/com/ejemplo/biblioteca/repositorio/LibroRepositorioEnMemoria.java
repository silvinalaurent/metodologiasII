package com.ejemplo.biblioteca.repositorio;

import com.ejemplo.biblioteca.modelo.Libro;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementación en memoria del repositorio de libros.
 *
 * <p>Principios aplicados:</p>
 * <ul>
 *   <li><b>OCP</b> (Open/Closed): El servicio no necesita modificarse si mañana
 *       reemplazamos esta clase por {@code LibroRepositorioBaseDeDatos}. Solo
 *       creamos una nueva clase que implemente la misma interfaz.</li>
 *   <li><b>DIP</b>: Esta clase concreta es un "detalle" que puede intercambiarse
 *       sin afectar la lógica de negocio.</li>
 * </ul>
 */
public class LibroRepositorioEnMemoria implements LibroRepositorio {

    private final Map<String, Libro> almacenamiento = new HashMap<>();

    @Override
    public void guardar(Libro libro) {
        almacenamiento.put(libro.getIsbn(), libro);
    }

    @Override
    public Optional<Libro> buscarPorIsbn(String isbn) {
        return Optional.ofNullable(almacenamiento.get(isbn));
    }

    @Override
    public List<Libro> obtenerTodos() {
        return new ArrayList<>(almacenamiento.values());
    }

    @Override
    public List<Libro> obtenerDisponibles() {
        return almacenamiento.values().stream()
            .filter(Libro::isDisponible)
            .collect(Collectors.toList());
    }
}
