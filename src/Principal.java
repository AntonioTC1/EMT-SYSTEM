import Gestor.empresarial.datos.DatosPersonales;
import Gestor.empresarial.datos.DatosEmpresariales;
import java.util.Scanner;

import java.util.Scanner;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar usuario y contraseña
        System.out.println("Por favor, ingrese se usuario y contraseña:");
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        // Verificar usuario y contraseña
        if (usuario.equals("admin") && contraseña.equals("pass1804")) {
            System.out.println("¡Bienvenido!");

            // Ahora que las credenciales son válidas, mostramos el menú
            mostrarMenu(scanner);
        } else {
            System.out.println("Usuario o contraseña incorrectos. Saliendo del programa...");
        }

        scanner.close();
    }

    // Método para mostrar el menú
    private static void mostrarMenu(Scanner scanner) {
        DatosPersonales datosPersonales = new DatosPersonales();
        DatosEmpresariales datosEmpresariales = null;

        int opcion;
        do {
            System.out.println("\nMENU:");
            System.out.println("1. Llenar Solicitud (Datos Personales)");
            System.out.println("2. Agregar Datos Empresariales");
            System.out.println("3. Mostrar datos ingresados");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nLlenar Solicitud (Datos Personales):");
                    System.out.println("Ingrese el ID:");
                    int id = scanner.nextInt();
                    datosPersonales.setId(id);

                    System.out.println("Ingrese el nombre:");
                    String nombre = scanner.next();
                    datosPersonales.setNombre(nombre);

                    System.out.println("Ingrese los apellidos:");
                    String apellidos = scanner.next();
                    datosPersonales.setApellidos(apellidos);

                    System.out.println("Ingrese el correo:");
                    String correo = scanner.next();
                    datosPersonales.setCorreo(correo);

                    System.out.println("Ingrese el número de WhatsApp:");
                    String whatsapp = scanner.next();
                    datosPersonales.setWhatsApp(whatsapp);
                    break;
                case 2:
                    if (datosPersonales.getId() != 0) {
                        System.out.println("\nAgregar Datos Empresariales:");
                        int datosPersonalesId = datosPersonales.getId();

                        System.out.println("Ingrese la adscripción:");
                        String adscripcion = scanner.next();

                        System.out.println("Ingrese el teléfono exterior:");
                        String telefonoExterior = scanner.next();

                        System.out.println("Ingrese el puesto:");
                        String puesto = scanner.next();

                        datosEmpresariales = new DatosEmpresariales(datosPersonalesId, adscripcion, telefonoExterior, puesto);
                        System.out.println("Datos Empresariales agregados con éxito.");
                    } else {
                        System.out.println("Primero debe ingresar los datos personales.");
                    }
                    break;

                case 3:
                    System.out.println("\nDatos ingresados:");
                    System.out.println("Datos Personales:");
                    System.out.println("ID: " + datosPersonales.getId());
                    System.out.println("Nombre: " + datosPersonales.getNombre());
                    System.out.println("Apellidos: " + datosPersonales.getApellidos());
                    System.out.println("Correo: " + datosPersonales.getCorreo());
                    System.out.println("WhatsApp: " + datosPersonales.getWhatsApp());

                    if (datosEmpresariales != null) {
                        System.out.println("\nDatos Empresariales:");
                        System.out.println("ID: " + datosEmpresariales.getId2());
                        System.out.println("Adscripción: " + datosEmpresariales.getAdscripcion());
                        System.out.println("Teléfono Exterior: " + datosEmpresariales.getTelefonoExterior());
                        System.out.println("Puesto: " + datosEmpresariales.getPuesto());
                    } else {
                        System.out.println("\nDatos Empresariales no ingresados.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }
}
