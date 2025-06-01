import java.awt.GridLayout;
import java.util.Random;
import javax.swing.*;

public class main {
    public static void main(String[] args) {
        // Configurar la ventana principal
        JFrame ventana = new JFrame("Matriz 20x20 de JTextField");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 800);  // Tamaño ajustado para visualizar 20x20

        // Crear un panel con GridLayout de 20 filas x 20 columnas
        JPanel panel = new JPanel(new GridLayout(20, 20, 2, 2));  // (filas, columnas, espacio_horizontal, espacio_vertical)
        
        // Matriz de JTextField 20x20
        JTextField[][] matrizTextFields = new JTextField[20][20];
        Random random = new Random();
        // Llenar la matriz y añadir al panel
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                matrizTextFields[i][j] = new JTextField();
                // Generar letra mayúscula aleatoria y asignarla al JTextField
                char letra = (char) (random.nextInt(26) + 'A');
                matrizTextFields[i][j].setText(String.valueOf(letra));
                matrizTextFields[i][j].setHorizontalAlignment(JTextField.CENTER);
                matrizTextFields[i][j].setHorizontalAlignment(JTextField.CENTER);  // Texto centrado
                //matrizTextFields[i][j].setText("E");
                panel.add(matrizTextFields[i][j]);
            }
        }

        // Añadir panel a la ventana y hacer visible
        ventana.add(panel);
        ventana.setVisible(true);
    }
}