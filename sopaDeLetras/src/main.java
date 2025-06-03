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
    
        ArrayList<String> palabras = new ArrayList<>();
        palabras.add("HOLA");
        palabras.add(",MUNDO");

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
        buscarMatriz(matriz, palabras);

        // Añadir panel a la ventana y hacer visible
        ventana.add(panel);
        ventana.setVisible(true);
    }  

    public static void buscarMatriz(char[][] matriz, String palabras) {
        boolean encontrado=false;

        //direcciones
        int [] dx= {0,-1,-1,-1,0,1,1,1};
        int [] dy= {-1,-1,0,1,1,1,0,-1};
        
        char [] palabraChar= palabras.toCharArray();
        //recorre toda la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

            if(palabraChar[0]==matriz[i][j]){
                System.out.println("detecte la palabra en "+i+" y "+j);
                for(int dir=0; dir<8 && encontrado==false; dir++){
                    //auxiliares
                    int x=i;
                    int y=j;
                    for(int c=0; c<palabras.length();c++){
                        if(palabraChar[c]!=matriz[x][y]){
                            break;
                        }else{
                            x+=dx[dir];
                            y+=dy[dir];
                        }
                        if(c==palabras.length()-1){
                            encontrado=true;
                            break;
                        }
                    }

                }
            }

            if(encontrado){
                System.out.println("palabra encontrada en: "+i+" "+j);
                break;
            }

        }
        if(encontrado){
                
            break;
        }
        }
        
    }
}