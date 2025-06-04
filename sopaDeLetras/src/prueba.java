import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class prueba {

    // Buscar palabra en matriz de chars
    public static boolean buscarMatriz(char[][] matriz, String palabra) {
        int col = matriz[0].length;
        int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < col; j++) {
                for (int dir = 0; dir < 8; dir++) {
                    int x = i, y = j;
                    int c;
                    for (c = 0; c < palabra.length(); c++) {
                        if (x < 0 || x >= matriz.length || y < 0 || y >= col)
                            break;
                        if (matriz[x][y] != palabra.charAt(c))
                            break;
                        x += dx[dir];
                        y += dy[dir];
                    }
                    if (c == palabra.length()) {
                        System.out.println("Palabra encontrada en: " + i + ", " + j);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String invertirPalabra(String palabra) {
        return new StringBuilder(palabra).reverse().toString();
    }

    public static void colocarPalabra(JTextField[][] matriz, String palabraOriginal, int filas, int columnas) {
        Random random = new Random();
        boolean invertir = random.nextBoolean();
        String palabra = invertir ? invertirPalabra(palabraOriginal) : palabraOriginal;

        int direccion = random.nextInt(4);
        boolean colocada = false;
        int intentos = 0;
        int maxIntentos = 100;

        while (!colocada && intentos < maxIntentos) {
            intentos++;
            int fila = 0, columna = 0;
            int pasoFila = 0, pasoColumna = 0;

            switch (direccion) {
                case 0: // Horizontal
                    fila = random.nextInt(filas);
                    columna = random.nextInt(columnas - palabra.length() + 1);
                    pasoFila = 0; pasoColumna = 1;
                    break;
                case 1: // Vertical
                    fila = random.nextInt(filas - palabra.length() + 1);
                    columna = random.nextInt(columnas);
                    pasoFila = 1; pasoColumna = 0;
                    break;
                case 2: // Diagonal \
                    fila = random.nextInt(filas - palabra.length() + 1);
                    columna = random.nextInt(columnas - palabra.length() + 1);
                    pasoFila = 1; pasoColumna = 1;
                    break;
                case 3: // Diagonal /
                    fila = random.nextInt(filas - palabra.length() + 1);
                    columna = random.nextInt(columnas - palabra.length() + 1) + palabra.length() - 1;
                    pasoFila = 1; pasoColumna = -1;
                    break;
            }

            if (verificarPosicion(matriz, fila, columna, palabra, pasoFila, pasoColumna)) {
                colocarEnPosicion(matriz, fila, columna, palabra, pasoFila, pasoColumna);
                colocada = true;
            } else {
                direccion = (direccion + 1) % 4;
            }
        }
    }

    private static boolean verificarPosicion(JTextField[][] matriz, int fila, int columna, String palabra, int pasoFila, int pasoColumna) {
        for (int i = 0; i < palabra.length(); i++) {
            int f = fila + i * pasoFila;
            int c = columna + i * pasoColumna;

            if (f >= matriz.length || c >= matriz[0].length || c < 0)
                return false;

            String textoCelda = matriz[f][c].getText();
            if (!textoCelda.equals("*") && !textoCelda.equals(String.valueOf(palabra.charAt(i))))
                return false;
        }
        return true;
    }

    private static void colocarEnPosicion(JTextField[][] matriz, int fila, int columna, String palabra, int pasoFila, int pasoColumna) {
        for (int i = 0; i < palabra.length(); i++) {
            int f = fila + i * pasoFila;
            int c = columna + i * pasoColumna;
            matriz[f][c].setText(String.valueOf(palabra.charAt(i)));
        }
    }

    public static void rellenarEspaciosVacios(JTextField[][] matriz, int filas, int columnas) {
        Random random = new Random();
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j].getText().equals("*")) {
                    char letraRandom = letras.charAt(random.nextInt(letras.length()));
                    matriz[i][j].setText(String.valueOf(letraRandom));
                }
            }
        }
    }

    public static String[] cargarPalabras(File fichero) {
        ArrayList<String> lista = new ArrayList<>();
        try (Scanner s = new Scanner(fichero)) {
            while (s.hasNextLine()) {
                lista.add(s.nextLine().trim().toUpperCase());
            }
        } catch (FileNotFoundException e) {
            System.err.println("El archivo no se encontró: " + e.getMessage());
            return null;
        }
        return lista.toArray(new String[0]);
    }

    public static JTextField[][] crearMatrizGUI(int filas, int columnas) {
        JTextField[][] matriz = new JTextField[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = new JTextField(1);
                matriz[i][j].setText("*");
                matriz[i][j].setHorizontalAlignment(JTextField.CENTER);
            }
        }
        return matriz;
    }

    public static JFrame crearVentana(JTextField[][] matriz, int filas, int columnas) {
        JFrame ventana = new JFrame("Sopa de Letras");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(filas, columnas));

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                panel.add(matriz[i][j]);
            }
        }

        ventana.add(panel);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        return ventana;
    }

    public static void colocarPalabrasEnMatriz(JTextField[][] matriz, String[] palabras, int filas, int columnas) {
        for (String palabra : palabras) {
            if (palabra != null && !palabra.isEmpty()) {
                colocarPalabra(matriz, palabra, filas, columnas);
            }
        }
    }

    public static char[][] extraerMatrizCaracteres(JTextField[][] matrizGUI) {
        int filas = matrizGUI.length;
        int columnas = matrizGUI[0].length;
        char[][] matriz = new char[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = matrizGUI[i][j].getText().charAt(0);
            }
        }
        return matriz;
    }

    public static void main(String[] args) {
        int filas = 20;
        int columnas = 20;
        File fichero = new File("src/sopa_letra.txt");

        String[] palabras = cargarPalabras(fichero);
        if (palabras == null) return;

        JTextField[][] matrizGUI = crearMatrizGUI(filas, columnas);
        colocarPalabrasEnMatriz(matrizGUI, palabras, filas, columnas);
        rellenarEspaciosVacios(matrizGUI, filas, columnas);

        JFrame ventana = crearVentana(matrizGUI, filas, columnas);
        ventana.setVisible(true);

        // Mostrar resultados en consola
        char[][] matrizChar = extraerMatrizCaracteres(matrizGUI);
        for (String palabra : palabras) {
            boolean encontrada = buscarMatriz(matrizChar, palabra);
            System.out.println(palabra + ": " + (encontrada ? "ENCONTRADA" : "NO ENCONTRADA"));
        }
    }
}

