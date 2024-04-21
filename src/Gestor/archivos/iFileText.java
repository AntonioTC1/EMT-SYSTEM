package Gestor.archivos;

interface iFileText {
    void AbrirModoLectura(); // Abrir el archivo en modo lectura
    String Leer(); // Leer el contenido del archivo
    void AbrirModoEscritura(); // Abrir el archivo en modo escritura
    void Escribir(String contenido); // Escribir en el archivo
    void Cerrar(); // Cerrar el archivo
}
