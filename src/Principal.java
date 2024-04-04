import Gestor.empresarial.datos.DatosPersonales;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DatosPersonales datos = new DatosPersonales();

        System.out.println("Ingrese el ID:");
        int id = scanner.nextInt();
        datos.setId(id);

        System.out.println("Ingrese el nombre:");
        String nombre = scanner.next();
        datos.setNombre(nombre);

        System.out.println("Ingrese los apellidos:");
        String apellidos = scanner.next();
        datos.setApellidos(apellidos);

        System.out.println("Ingrese el correo:");
        String correo = scanner.next();
        datos.setCorreo(correo);

        System.out.println("Ingrese el número de WhatsApp:");
        String whatsapp = scanner.next();
        datos.setWhatsApp(whatsapp);

        System.out.println("\nDatos ingresados:");
        System.out.println("ID: " + datos.getId());
        System.out.println("Nombre: " + datos.getNombre());
        System.out.println("Apellidos: " + datos.getApellidos());
        System.out.println("Correo: " + datos.getCorreo());
        System.out.println("WhatsApp: " + datos.getWhatsApp());

        scanner.close();
    }
}
