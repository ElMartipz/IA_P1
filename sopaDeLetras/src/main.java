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
                matrizTextFields[i][j].setText(String.valueOf(matriz[i][j]));
                matrizTextFields[i][j].setHorizontalAlignment(JTextField.CENTER);
                matrizTextFields[i][j].setHorizontalAlignment(JTextField.CENTER);  // Texto centrado
                //matrizTextFields[i][j].setText("E");
                panel.add(matrizTextFields[i][j]);
            }
        }
        buscarMatriz(matriz, "HOLA");

        // Añadir panel a la ventana y hacer visible
        ventana.add(panel);
        ventana.setVisible(true);
    }

    public static void buscarMatriz(char[][] matriz, String palabra) {

        char busca[][] = new char[3][3]; // Definimos una matriz que busca
        // Direcciones en el orden: arriba, abajo, izquierda, derecha, 
        // arriba-izquierda, arriba-derecha, abajo-izquierda, abajo-derecha
        int[][] direcciones = {
            {-1, 0},  // arriba
            {1, 0},   // abajo
            {0, -1},  // izquierda
            {0, 1},   // derecha
            {-1, -1}, // arriba-izquierda
            {-1, 1},  // arriba-derecha
            {1, -1},  // abajo-izquierda
            {1, 1}    // abajo-derecha
        };

         
        //recorre toda la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

               // matriz[i][j] =  // Asignamos el valor y luego incrementamos
            }
        }
    }
}