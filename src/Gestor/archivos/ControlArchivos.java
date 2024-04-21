package Gestor.archivos;

public class ControlArchivos {
    private String nomArchivo; // Nombre del archivo
    // Constructor que recibe el nombre del archivo al instanciar la clase
    public ControlArchivos(String nomArchivo) {
        this.nomArchivo = nomArchivo;
    }
    // Métodos para realizar operaciones básicas con archivos
    public boolean Crear() {
        System.out.println("Creando Archivo..."); // Mensaje de creación
        return true;
    }
    public boolean Eliminar() {
        System.out.println("Eliminando Archivo..."); // Mensaje de eliminación
        return true;
    }
    public boolean Cambiar(String nuevoNombre) {
        System.out.println("Cambiando nombre del archivo a: " + nuevoNombre); // Mensaje de cambio de nombre
        this.nomArchivo = nuevoNombre;
        return true;
    }
    public boolean Mover(String nuevaUbicacion) {
        System.out.println("Moviendo el archivo a: " + nuevaUbicacion); // Mensaje de movimiento
        // Lógica para mover el archivo a una nueva ubicación
        return true;
    }
}

