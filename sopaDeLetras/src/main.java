import java.awt.GridLayout;
import java.util.Random;
import javax.swing.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class main {

    public static int contarPalabras(File fichero) {
        int contador = 0;
        try (Scanner s = new Scanner(fichero)) {
            while (s.hasNextLine()) {
                s.nextLine();
                contador++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("El archivo no se encontró: " + e.getMessage());
        }
        return contador;
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

            if (direccion == 0) {
                int fila = random.nextInt(filas);
                int columna = random.nextInt(columnas - palabra.length() + 1);

                if (verificarPosicion(matriz, fila, columna, palabra, 0, 1)) {
                    colocarEnPosicion(matriz, fila, columna, palabra, 0, 1);
                    colocada = true;
                }
            } else if (direccion == 1) {
                int fila = random.nextInt(filas - palabra.length() + 1);
                int columna = random.nextInt(columnas);

                if (verificarPosicion(matriz, fila, columna, palabra, 1, 0)) {
                    colocarEnPosicion(matriz, fila, columna, palabra, 1, 0);
                    colocada = true;
                }
            } else if (direccion == 2) {
                int fila = random.nextInt(filas - palabra.length() + 1);
                int columna = random.nextInt(columnas - palabra.length() + 1);

                if (verificarPosicion(matriz, fila, columna, palabra, 1, 1)) {
                    colocarEnPosicion(matriz, fila, columna, palabra, 1, 1);
                    colocada = true;
                }
            } else {
                int fila = random.nextInt(filas - palabra.length() + 1);
                int columna = random.nextInt(columnas - palabra.length() + 1) + palabra.length() - 1;

                if (columna >= columnas)
                    continue;

                if (verificarPosicion(matriz, fila, columna, palabra, 1, -1)) {
                    colocarEnPosicion(matriz, fila, columna, palabra, 1, -1);
                    colocada = true;
                }
            }

            if (!colocada) {
                direccion = (direccion + 1) % 4;
            }
        }
    }

    private static boolean verificarPosicion(JTextField[][] matriz, int fila, int columna,
            String palabra, int pasoFila, int pasoColumna) {
        for (int i = 0; i < palabra.length(); i++) {
            int f = fila + i * pasoFila;
            int c = columna + i * pasoColumna;

            if (f >= matriz.length || c >= matriz[0].length || c < 0) {
                return false;
            }

            String textoCelda = matriz[f][c].getText();
            if (!textoCelda.equals("*") && !textoCelda.equals(String.valueOf(palabra.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    private static void colocarEnPosicion(JTextField[][] matriz, int fila, int columna,
            String palabra, int pasoFila, int pasoColumna) {
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
        int contador = contarPalabras(fichero);
        String[] palabras = new String[contador];

        try (Scanner s = new Scanner(fichero)) {
            for (int i = 0; i < contador; i++) {
                palabras[i] = s.nextLine().toUpperCase().trim();
            }
        } catch (FileNotFoundException e) {
            System.err.println("El archivo no se encontró: " + e.getMessage());
            return null;
        }
        return palabras;
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
        JFrame ventana = new JFrame("Sopa de Letras Completa");
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

    public static void main(String[] args) {
        // Configurar la ventana principal
        int filas = 20;
        int columnas = 20;
        File fichero = new File("/home/rodrigo/Documentos/java_practica/sopa_letra.txt");

        // Cargar palabras desde archivo
        String[] palabras = cargarPalabras(fichero);
        if (palabras == null)
            return;

        // Crear matriz GUI
        JTextField[][] matriz = crearMatrizGUI(filas, columnas);

        // Colocar palabras en la matriz
        colocarPalabrasEnMatriz(matriz, palabras, filas, columnas);

        // Rellenar espacios vacíos
        rellenarEspaciosVacios(matriz, filas, columnas);

        // Crear y mostrar ventana
        JFrame ventana = crearVentana(matriz, filas, columnas);
        ventana.setVisible(true);
    }
}
