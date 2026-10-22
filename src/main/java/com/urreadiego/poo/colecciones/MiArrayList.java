package com.urreadiego.poo.colecciones;

import java.util.ArrayList;

/**
 * Colección propia con capacidad máxima, genérica y reutilizable.
 *
 * <p>Extiende {@link ArrayList} para aprovechar su implementación eficiente y
 * añadirle la restricción de tamaño que necesita el proyecto.
 *
 * <pre>{@code
 * MiArrayList<String> lista = new MiArrayList<>(3);
 * lista.add("uno");     // true
 * lista.add("dos");     // true
 * lista.add("tres");    // true
 * lista.add("cuatro");  // false  -> la lista está llena
 * }</pre>
 *
 * @param <E> tipo de los elementos almacenados
 */
public class MiArrayList<E> extends ArrayList<E> {

    private static final long serialVersionUID = 1L;

    private int maxSize;

    /**
     * @param maxSize número máximo de elementos admitidos
     */
    public MiArrayList(int maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException("El tamaño máximo no puede ser negativo");
        }
        this.maxSize = maxSize;
    }

    /**
     * Cambia el límite de elementos de la lista.
     *
     * @param nuevoLimite nuevo número máximo de elementos
     */
    public void setNuevoLimite(int nuevoLimite) {
        if (nuevoLimite < 0) {
            throw new IllegalArgumentException("El tamaño máximo no puede ser negativo");
        }
        this.maxSize = nuevoLimite;
    }

    /**
     * Agrega un elemento si la lista todavía tiene espacio.
     *
     * @param e elemento a agregar
     * @return {@code true} si se agregó, {@code false} si la lista está llena
     */
    @Override
    public boolean add(E e) {
        if (size() >= maxSize) {
            return false;
        }
        return super.add(e);
    }

    /** @return el número máximo de elementos admitidos */
    public int getMaxSize() {
        return maxSize;
    }

    /** @return {@code true} si la lista alcanzó su capacidad máxima */
    public boolean estaLlena() {
        return size() >= maxSize;
    }

    /** @return los espacios disponibles todavía */
    public int getEspaciosDisponibles() {
        return Math.max(0, maxSize - size());
    }
}
