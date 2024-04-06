package Gestor.gui;


import javax.swing.*;

public class personal {
    public JButton aspirantesAPuestosButton;
    public JButton datosDeEmpleadosButton;


    public personal() {
        aspirantesAPuestosButton.addActionListener(e -> {
            // Crear una instancia del GUI DatosAspirantes y mostrarlo
            DatosAspirantes datosAspirantesForm = new DatosAspirantes();
            JFrame frame = new JFrame("Datos de Aspirantes");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setContentPane(datosAspirantesForm.getPanel());
            frame.pack();
            frame.setVisible(true);
        });

        datosDeEmpleadosButton.addActionListener(e -> {
            // Aquí puedes agregar la lógica para el botón de datos de empleados
        });
    }
}
