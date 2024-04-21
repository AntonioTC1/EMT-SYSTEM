package Gestor.archivos;

import java.io.*;

public class ArchivoTexto extends ControlArchivos implements iFileText {
    private File file; // Representa el archivo en sí
    private BufferedReader br; // Permite leer caracteres de un archivo
    private BufferedWriter bw; // Proporciona escritura de líneas eficiente
    // Constructor que recibe el nombre del archivo al instanciar la clase
    public ArchivoTexto(String nomArchivo) {
        super(nomArchivo);
        this.file = new File(nomArchivo);
    }
    // Constructor que recibe el nombre del archivo y el modo de lectura al instanciar la clase
    public ArchivoTexto(String nomArchivo, boolean modoLectura) {
        super(nomArchivo);
        this.file = new File(nomArchivo);
    }
    // Implementación del método para abrir el archivo en modo lectura
    public void AbrirModoLectura() {
        try {
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo en modo lectura");
        }
    }
    // Implementación del método para leer el contenido del archivo
    public String Leer() {
        try {
            if (br != null) {
                StringBuilder contenido = new StringBuilder();
                String linea;
                // Leer líneas del archivo y construir contenido
                while ((linea = br.readLine()) != null) {
                    contenido.append(linea).append("\n");
                }
                return contenido.toString();
            } else {
                System.out.println("Error: BufferedReader no inicializado. Abre el archivo en modo lectura primero.");
                return null;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
            return null;
        }
    }
    // Implementación del método para abrir el archivo en modo escritura
    public void AbrirModoEscritura() {
        try {
            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            System.out.println("Modo Escritura activado. Nombre del archivo: " + file.getName());
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo en modo escritura");
        }
    }
    // Implementación del método para escribir en el archivo
    public void Escribir(String contenido) {

        try {
            bw.write(contenido);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo");
        }
    }
    // Implementación del método para cerrar el archivo
    public void Cerrar() {
        try {
            // Cerrar el BufferedReader y BufferedWriter si están inicializados
            if (br != null) br.close();
            if (bw != null) bw.close();
            System.out.println("Cerrando el archivo. Nombre del archivo: " + file.getName());
        } catch (IOException e) {
            System.out.println("Error al cerrar el archivo");
        }
    }
    // Clase principal que contiene el método main para probar la funcionalidad de las clases
    public static void main(String[] args) {
        // Ejemplo de uso
        ArchivoTexto archivo = new ArchivoTexto("ejemplo.txt");
        archivo.AbrirModoLectura();
        System.out.println("Contenido del archivo:\n" + archivo.Leer());
        archivo.Cerrar();
        archivo.AbrirModoEscritura();
        archivo.Escribir("Hola, este es un ejemplo de archivos en Java.");
        archivo.Cerrar();
    }
}
