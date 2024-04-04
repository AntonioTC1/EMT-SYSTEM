package Gestor.gui;

import javax.swing.*;
import Gestor.empresarial.datos.DatosPersonales;

public class DatosAspirantes {
    private JPanel panel;
    private JTextField ID;
    private JTextField Nombre;
    private JTextField apellido;
    private JTextField correo;
    private JTextField whatsapp;
    private JButton salirButton;
    private JButton guardarButton;

    // Método para llenar los campos de texto con los datos de un objeto DatosPersonales
    public void llenarCampos(DatosPersonales datos) {
        ID.setText(String.valueOf(datos.getId()));
        Nombre.setText(datos.getNombre());
        apellido.setText(datos.getApellidos());
        correo.setText(datos.getCorreo());
        whatsapp.setText(datos.getWhatsApp());
    }

    // Método para obtener los datos ingresados en los campos de texto y crear un nuevo objeto DatosPersonales
    public DatosPersonales obtenerDatos() {
        DatosPersonales datos = new DatosPersonales();
        datos.setId(Integer.parseInt(ID.getText()));
        datos.setNombre(Nombre.getText());
        datos.setApellidos(apellido.getText());
        datos.setCorreo(correo.getText());
        datos.setWhatsApp(whatsapp.getText());
        return datos;
    }

    // Método para obtener el panel principal que contiene los componentes
    public JPanel getPanel() {
        return panel;
    }

    public DatosAspirantes() {
        guardarButton = new JButton("Guardar");
        salirButton = new JButton("Salir");

        guardarButton.addActionListener(e -> {
            // Obtener los datos ingresados
            DatosPersonales datos = obtenerDatos();

            // Aquí puedes hacer algo con los datos, como guardarlos en una base de datos o en un archivo
            // Por ahora, simplemente los mostramos en la consola
            System.out.println("Datos obtenidos:");
            System.out.println("ID: " + datos.getId());
            System.out.println("Nombre: " + datos.getNombre());
            System.out.println("Apellidos: " + datos.getApellidos());
            System.out.println("Correo: " + datos.getCorreo());
            System.out.println("WhatsApp: " + datos.getWhatsApp());
        });

        salirButton.addActionListener(e -> {
            // Aquí puedes agregar la lógica para cerrar el formulario si es necesario
        });
    }

}
