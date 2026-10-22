package com.urreadiego.poo.modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Ejemplo de escritura de archivos de texto.
 */
public class CrearArchivo {

    private static final String NOMBRE_ARCHIVO = "miArchivo.txt";

    public static void main(String[] args) {
        try (PrintWriter escritor = new PrintWriter(new FileWriter(NOMBRE_ARCHIVO))) {
            escritor.println("Hola, este es mi primer archivo en Java.");
            escritor.println("Estoy practicando el manejo de archivos.");
            System.out.println("Archivo creado con éxito: " + NOMBRE_ARCHIVO);
        } catch (IOException e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
