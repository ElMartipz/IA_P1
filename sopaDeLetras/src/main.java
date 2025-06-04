import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.*;

public class main {
    public static void main(String[] args) {
        // Configurar la ventana principal
        char[][] matriz = {
            {'H', 'O', 'L', 'A', 'X', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P'},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'U', 'X', 'X', 'X'},
            {'M', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'N', 'X', 'X', 'X'},
            {'U', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X'},
            {'C', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'O', 'X', 'X', 'X'},
            {'P', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
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
    
        ArrayList<String> palabras = new ArrayList<>();
        palabras.add("HOLA"); 
        palabras.add("MUNDO");

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
        // Añadir panel a la ventana y hacer visible
        ventana.add(panel);
        ventana.setVisible(true);

        for (String palabra: palabras){
            if(buscarMatriz(matriz, palabra)){
                System.out.println("Palabra encontrada");
            }else{
                System.out.println("Palabra no encontrada");  
            }
        }
        
    }  

    public static boolean buscarMatriz(char[][] matriz, String palabra) {

        int col = matriz[0].length;

        //direcciones
        int [] dx= {0,-1,-1,-1,0,1,1,1};
        int [] dy= {-1,-1,0,1,1,1,0,-1};
        
        //recorre toda la matriz

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < col; j++) {

                for(int dir=0; dir<8; dir++){
                    //auxiliares
                    int x=i, y=j;
                    int c;
                    
                    for( c=0; c<palabra.length(); c++){
                        if (x<0 || x >= matriz.length || y <0 || y>= col)
                            break;
                        if(matriz[x][y] != palabra.charAt(c))
                            break;

                        x+=dx[dir];
                        y+=dy[dir];
                    }
                    //Si se encontró la palabra
                    if(c==palabra.length()){
                        System.out.println("palabra encontrada en: "+i+" y "+ j);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}