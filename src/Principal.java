import Gestor.archivos.ArchivoTexto;
import Gestor.empresarial.datos.DatosPersonales;
import Gestor.empresarial.datos.DatosEmpresariales;
import Gestor.empresarial.empresa.Empresa;
import Gestor.empresarial.contrato.contrato;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import Gestor.errores.GestionErrores;
import java.util.InputMismatchException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Solicitar usuario y contraseña
        System.out.println("Por favor, ingrese su usuario y contraseña:");
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        // Verificar usuario y contraseña
        if (usuario.equals("admin") && contraseña.equals("pass1804")) {
            System.out.println("¡Bienvenido!");

            // Crear una instancia de GestionErrores para manejar los errores
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Public\\Documents\\error1.txt"));
            GestionErrores gestionErrores = new GestionErrores(bufferedWriter);

            // Ahora que las credenciales son válidas, mostramos el menú
            mostrarMenu(scanner, gestionErrores);

            // Cerrar el scanner al finalizar
            scanner.close();
        } else {
            System.out.println("Usuario o contraseña incorrectos. Saliendo del programa...");
        }
    }

    // Método para mostrar el menú y manejar las opciones
    private static void mostrarMenu(Scanner scanner, GestionErrores gestionErrores) {
        DatosPersonales datosPersonales = new DatosPersonales();
        DatosEmpresariales datosEmpresariales = null;
        Empresa empresa = null;
        contrato contrato = null;
        ArchivoTexto archivo = new ArchivoTexto("C:\\Users\\Public\\Documents\\txt\\datos.txt");

        String opcion;
        do {
            System.out.println("\nMENU:");
            System.out.println("1. Agregar datos");
            System.out.println("2. Mostrar datos ingresados");
            System.out.println("3. Crear Contrato");
            System.out.println("4. Guardar datos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    String subOpcion;
                    do {
                        System.out.println("1. Llenar Solicitud (Datos Personales)");
                        System.out.println("2. Agregar Datos Empresariales");
                        System.out.println("3. Agregar Datos de la empresa");
                        System.out.println("0. Volver al menú principal");
                        System.out.print("Seleccione una opción: ");
                        subOpcion = scanner.nextLine();
                        switch (subOpcion) {
                            case "1":
                                System.out.println("\nLlenar Solicitud (Datos Personales):");
                                System.out.println("Ingrese el ID:");
                                int id = leerEntero(scanner);
                                if (id == -1) {
                                    gestionErrores.guardarError("El usuario ingresó un valor no numérico para el ID.");
                                    break;
                                }
                                else{
                                datosPersonales.setId(id);}

                                System.out.println("Ingrese el nombre:");
                                String nombre = scanner.nextLine();
                                datosPersonales.setNombre(nombre);

                                System.out.println("Ingrese los apellidos:");
                                String apellidos = scanner.nextLine();
                                datosPersonales.setApellidos(apellidos);

                                System.out.println("Ingrese el correo:");
                                String correo = scanner.nextLine();
                                datosPersonales.setCorreo(correo);

                                System.out.println("Ingrese el número de WhatsApp:");
                                String whatsapp = scanner.nextLine();
                                datosPersonales.setWhatsApp(whatsapp);
                                break;
                            case "2":
                                System.out.println("\nAgregar Datos Empresariales:");
                                if (datosPersonales != null) {
                                    System.out.println("Ingrese la adscripción:");
                                    String adscripcion = scanner.nextLine();

                                    System.out.println("Ingrese el teléfono exterior:");
                                    String telefonoExterior = scanner.nextLine();

                                    System.out.println("Ingrese el puesto:");
                                    String puesto = scanner.nextLine();

                                    datosEmpresariales = new DatosEmpresariales(datosPersonales.getId(), adscripcion, telefonoExterior, puesto);
                                    System.out.println("Datos Empresariales agregados con éxito.");
                                } else {
                                    System.out.println("Primero debe ingresar los datos personales.");
                                }
                                break;
                            case "3":
                                System.out.println("\nAgregar Datos de la Empresa:");
                                if (datosPersonales != null && datosEmpresariales != null) {
                                    System.out.println("Ingrese el nombre de la empresa:");
                                    String nombreEmpresa = scanner.nextLine();

                                    System.out.println("Ingrese el representante legal:");
                                    String representanteLegal = scanner.nextLine();

                                    System.out.println("Ingrese el teléfono de la empresa:");
                                    String telefonoEmpresa = scanner.nextLine();

                                    empresa = new Empresa(nombreEmpresa, representanteLegal, telefonoEmpresa);
                                    System.out.println("Datos de la empresa agregados con éxito.");
                                } else {
                                    System.out.println("Primero debe ingresar los datos personales y empresariales.");
                                }
                                break;
                            case "0":
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                                gestionErrores.guardarError("Opción no válida: " + subOpcion);
                        }
                    } while (!subOpcion.equals("0"));
                    break;
                case "2":
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
                    System.out.println("\nDatos del Contrato:");
                    if (contrato != null) {
                        System.out.println("No. de Contrato: " + contrato.getNoContrato());
                        System.out.println("Año: " + contrato.getAnnio());
                    } else {
                        System.out.println("Contrato no creado.");
                    }
                    break;
                case "3":
                    System.out.println("\nCrear Contrato:");
                    if (datosPersonales != null && datosEmpresariales != null && empresa != null) {
                        System.out.print("Ingrese el número de contrato: ");
                        int noContrato = leerOpcion(scanner);

                        System.out.print("Ingrese el año del contrato: ");
                        int annio = leerOpcion(scanner);

                        contrato = new contrato(datosPersonales.getId());
                        contrato.setNoContrato(noContrato);
                        contrato.setAnnio(annio);

                        System.out.println("Contrato creado con éxito.");
                    } else {
                        System.out.println("Primero debe ingresar los datos personales, empresariales y de la empresa.");
                    }
                    break;
                case "4":
                    System.out.println("\nGuardando datos...");
                    archivo.AbrirModoEscritura();
                    archivo.Escribir("Datos Personales:\n");
                    archivo.Escribir("ID: " + datosPersonales.getId() + "\n");
                    archivo.Escribir("Nombre: " + datosPersonales.getNombre() + "\n");
                    archivo.Escribir("Apellidos: " + datosPersonales.getApellidos() + "\n");
                    archivo.Escribir("Correo: " + datosPersonales.getCorreo() + "\n");
                    archivo.Escribir("WhatsApp: " + datosPersonales.getWhatsApp() + "\n");

                    if (datosEmpresariales != null) {
                        archivo.Escribir("\nDatos Empresariales:\n");
                        archivo.Escribir("ID: " + datosEmpresariales.getId2() + "\n");
                        archivo.Escribir("Adscripción: " + datosEmpresariales.getAdscripcion() + "\n");
                        archivo.Escribir("Teléfono Exterior: " + datosEmpresariales.getTelefonoExterior() + "\n");
                        archivo.Escribir("Puesto: " + datosEmpresariales.getPuesto() + "\n");
                    } else {
                        archivo.Escribir("\nDatos Empresariales no ingresados.\n");
                    }

                    if (empresa != null) {
                        archivo.Escribir("\nDatos de la Empresa:\n");
                        archivo.Escribir("Nombre: " + empresa.getNombreEmpresa() + "\n");
                        archivo.Escribir("Representante Legal: " + empresa.getRepresentanteLegal() + "\n");
                        archivo.Escribir("Teléfono: " + empresa.getTelefono() + "\n");
                    } else {
                        archivo.Escribir("\nDatos de la Empresa no ingresados.\n");
                    }

                    if (contrato != null) {
                        archivo.Escribir("\nDatos del Contrato:\n");
                        archivo.Escribir("No. de Contrato: " + contrato.getNoContrato() + "\n");
                        archivo.Escribir("Año: " + contrato.getAnnio() + "\n");
                    } else {
                        archivo.Escribir("\nContrato no creado.\n");
                    }
                    archivo.Cerrar();
                    System.out.println("Datos guardados en el archivo.");
                    break;
                case "0":
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    gestionErrores.guardarError("Opción no válida: " + opcion);
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (!opcion.equals("0"));
        gestionErrores.cerrarArchivo();
    }

    private static int leerOpcion(Scanner scanner) {
        int opcion = 0;
        try {
            opcion = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error: se esperaba un número entero.");
        } finally {
            scanner.nextLine(); // Limpiar el buffer de entrada
        }
        return opcion;
    }

    private static int leerEntero(Scanner scanner) {
        int entero = 0;
        try {
            entero = scanner.nextInt();
        } catch (InputMismatchException e) {
            // Guardar el error en GestionErrores
            return -1; // Retornar un valor especial para indicar que hubo un error
        }
        scanner.nextLine();
        return entero;
    }

}

