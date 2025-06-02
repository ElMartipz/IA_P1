import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.*;

public class main {
    public static void main(String[] args) {

        // Configurar la ventana principal
        char[][] matriz = {
            {'H', 'O', 'L', 'A', 'X', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P'},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'C', 'X', 'X', 'X'},
            {'M', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'W', 'X', 'X', 'X'},
            {'U', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X'},
            {'N', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'O', 'X', 'X', 'X'},
            {'D', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
        };
        JFrame ventana = new JFrame("Matriz 20x20 de JTextField");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1000, 1000);  // Tamaño ajustado para visualizar 20x20

        // Crear un panel con GridLayout de 20 filas x 20 columnas
        JPanel panelSopa = new JPanel(new GridLayout(20, 20));  // (filas, columnas, espacio_horizontal, espacio_vertical)
        //panel principal
        JPanel panelPrincipal= new JPanel(new FlowLayout());

        
        // Matriz de JTextField 20x20
        JTextField[][] matrizTextFields = new JTextField[20][20];
        Random random = new Random();
        // Llenar la matriz y añadir al panelSopa de letras
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                matrizTextFields[i][j] = new JTextField();
                // Generar letra mayúscula aleatoria y asignarla al JTextField
                //char letra = (char) (random.nextInt(26) + 'A');
                matrizTextFields[i][j].setText(String.valueOf(matriz[i][j]));
                // matrizTextFields[i][j].setHorizontalAlignment(JTextField.CENTER);
                // matrizTextFields[i][j].setHorizontalAlignment(JTextField.CENTER);  // Texto centrado
                //matrizTextFields[i][j].setText("E");
                panelSopa.add(matrizTextFields[i][j]);
            }
        }
        //Textos
        JPanel panelTextos = new JPanel(new GridLayout(4, 2));
        JLabel label1= new JLabel("NUMEROS CLAVE");
        JLabel label2= new JLabel("Tiempo Total");
        JLabel label3= new JLabel("Letra");
        JLabel label4= new JLabel("Tiempo de busqueda");
        JLabel label5= new JLabel("inteligencia");
        panelTextos.add(label1);
        panelTextos.add(label2);
        panelTextos.add(label3);
        panelTextos.add(label4);
        panelTextos.add(label5);
        //añadir al panel principal
        panelPrincipal.add(panelSopa);
        panelPrincipal.add(panelTextos);
        // Añadir panel a la ventana y hacer visible
        ventana.add(panelPrincipal);
        ventana.setVisible(true);
    }
}