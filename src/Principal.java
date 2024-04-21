import Gestor.archivos.ArchivoTexto;
import Gestor.empresarial.datos.DatosPersonales;
import Gestor.empresarial.datos.DatosEmpresariales;
import Gestor.empresarial.empresa.Empresa;
import Gestor.empresarial.contrato.contrato;
import Gestor.archivos.ControlArchivos;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Scanner;

import java.util.Scanner;

public class

Principal {
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
        Empresa empresa = null;
        contrato contrato = null;
        ArchivoTexto archivo = new ArchivoTexto("C:\\Users\\Public\\Documents\\txt\\datos.txt");

        int opcion;
        int opcion1;
        do {
            System.out.println("\nMENU:");
            System.out.println("1. Agregar datos");
            System.out.println("2. Mostrar datos ingresados");
            System.out.println("3. Crear Contrato");
            System.out.println("4. guardar datos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    int subOpcion;
                    do{
                        System.out.println("1. Llenar Solicitud (Datos Personales)");
                        System.out.println("2. Agregar Datos Empresariales");
                        System.out.println("3. Agregar Datos de la empresa");
                        subOpcion = scanner.nextInt();
                        switch (subOpcion) {
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
                                System.out.println("\nAgregar Datos Empresariales:");
                                if (datosPersonales != null) {
                                    System.out.println("Ingrese la adscripción:");
                                    String adscripcion = scanner.next();

                                    System.out.println("Ingrese el teléfono exterior:");
                                    String telefonoExterior = scanner.next();

                                    System.out.println("Ingrese el puesto:");
                                    String puesto = scanner.next();

                                    datosEmpresariales = new DatosEmpresariales(datosPersonales.getId(), adscripcion, telefonoExterior, puesto);
                                    System.out.println("Datos Empresariales agregados con éxito.");
                                } else {
                                    System.out.println("Primero debe ingresar los datos personales.");
                                }
                                break;
                            case 3:
                                System.out.println("\nAgregar Datos de la Empresa:");
                                System.out.println("\nAgregar Datos de la Empresa:");
                                if (datosPersonales != null && datosEmpresariales != null) {
                                    System.out.println("Ingrese el nombre de la empresa:");
                                    String nombreEmpresa = scanner.next();

                                    System.out.println("Ingrese el representante legal:");
                                    String representanteLegal = scanner.next();

                                    System.out.println("Ingrese el teléfono de la empresa:");
                                    String telefonoEmpresa = scanner.next();

                                    // Crear una nueva instancia de Empresa con los datos proporcionados
                                    empresa = new Empresa(nombreEmpresa, representanteLegal, telefonoEmpresa);
                                    System.out.println("Datos de la empresa agregados con éxito.");
                                } else {
                                    System.out.println("Primero debe ingresar los datos personales y empresariales.");
                                }
                                break;
                            case 0:
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                        }
                    } while (subOpcion != 0);
                   break;
                case 2:
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
                case 3:
                    System.out.println("\nCrear Contrato:");
                    if (datosPersonales != null && datosEmpresariales != null && empresa != null) {
                        System.out.print("Ingrese el número de contrato: ");
                        int noContrato = scanner.nextInt();

                        System.out.print("Ingrese el año del contrato: ");
                        int annio = scanner.nextInt();

                        contrato = new contrato(datosPersonales.getId());
                        contrato.setNoContrato(noContrato);
                        contrato.setAnnio(annio);

                        System.out.println("Contrato creado con éxito.");
                    } else {
                        System.out.println("Primero debe ingresar los datos personales, empresariales y de la empresa.");
                    }
                    break;
                case 4:
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
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }
}