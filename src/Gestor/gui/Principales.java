package Gestor.gui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Principales {
    private JTextField textField1;
    private JPasswordField passwordField;
    private JButton entrarButton;
    private JButton salirButton;

    public Principales() {
        JFrame frame = new JFrame("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        textField1 = new JTextField();
        textField1.setBounds(10, 20, 150, 25);
        panel.add(textField1);

        passwordField = new JPasswordField();
        passwordField.setBounds(10, 50, 150, 25);
        panel.add(passwordField);

        entrarButton = new JButton("Entrar");
        entrarButton.setBounds(170, 20, 100, 25);
        panel.add(entrarButton);

        salirButton = new JButton("Salir");
        salirButton.setBounds(170, 50, 100, 25);
        panel.add(salirButton);

        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón Entrar presionado.");
                String username = textField1.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                // Verificar si el nombre de usuario y la contraseña son correctos
                if (username.equals("admin") && Arrays.equals(passwordChars, "pass1234".toCharArray())) {
                    JOptionPane.showMessageDialog(null, "Bienvenido, " + username + "!");

                    // Abrir el formulario personal
                    abrirFormularioPersonal();
                } else {
                    JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos.");
                }

                // Limpiar la contraseña después de su uso
                Arrays.fill(passwordChars, '0');
                passwordField.setText(""); // Limpiar el campo de la contraseña visualmente
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón Salir presionado.");
                System.exit(0); // Salir de la aplicación
            }
        });

        frame.setVisible(true);
    }

    private void abrirFormularioPersonal() {
        // Crear una instancia del formulario personal y mostrarlo
        personal formPersonal = new personal();
        JFrame framePersonal = new JFrame("Personal Form");
        framePersonal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        framePersonal.setSize(300, 200);
        framePersonal.setContentPane(formPersonal.aspirantesAPuestosButton.getParent()); // Para asegurarse de que los componentes se agreguen al JFrame correctamente
        framePersonal.setVisible(true);
    }

    public static void main(String[] args) {
        new Principales();
    }
}
