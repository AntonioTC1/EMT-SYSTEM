package Gestor.errores;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class GestionErrores {
    private final Map<Integer, String> error;
    private boolean existeError;
    private int noError;
    private String descripcionTecnica;
    private BufferedWriter writer;

    public GestionErrores(BufferedWriter writer) {
        this.error = new HashMap<>(); // Inicializar el mapa de errores
        this.existeError = false;
        this.noError = 0;
        this.descripcionTecnica = null;
        this.writer = writer;
    }

    public void cargarErrores() {
        // Agregar los errores al mapa
        error.put(1, "Error de lectura de archivo");
        error.put(2, "Error de escritura en archivo");
        error.put(3, "Error al elegir una opción");
    }

    public void setNoError(int noError, String descripcion) {
        this.noError = noError;
        this.descripcionTecnica = descripcion;
    }

    public String getError() {
        if (existeError) {
            return "Error " + noError + ": " + descripcionTecnica;
        }
        return null;
    }

    public String getErrorTecnico() {
        return descripcionTecnica;
    }

    public boolean existeError() {
        return existeError;
    }

    public void guardarError(String mensaje) {
        if (writer != null) {
            try {
                writer.write(mensaje + "\n");
                writer.flush(); // Forzar la escritura en el archivo
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo de errores: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo de errores no está inicializado correctamente.");
        }
    }

    public void cerrarArchivo() {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo de errores: " + e.getMessage());
            }
        }
    }

    public int leerOpcion(Scanner scanner) {
        int opcion = 0;
        try {
            opcion = scanner.nextInt();
        } catch (Exception e) {
            guardarError("El usuario ingresó un valor no numérico: " + scanner.next());
        }
        return opcion;
    }
}
