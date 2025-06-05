import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class SopaDeLetrasInterfaz extends JFrame {
    //variables
    private static final int TAM = 20;
    private JTextField[][] matriz = new JTextField[TAM][TAM];
    private JButton btnResolver, btnNuevaSopa;

    private List<JLabel> etiquetasPalabras = new ArrayList<>();
    private List<JTextField> camposTiempos = new ArrayList<>();
    private JTextField txtTiempoTotal;

    // Palabras solicitadas
    private final String[] palabras = {
        "inteligencia", "pacman", "matrix", "aprendizaje", "juegos", "prolog",
        "simulacion", "skynet", "busqueda", "logica", "nexus", "deckard",
        "bioinformatica", "razonamiento", "genetica", "robotica", "turing", "jframe",
        "java", "humanidad", "lisp", "pong", "utopia", "atari"
    };

    
    public SopaDeLetrasInterfaz() {
        setTitle("Sopa de Letras - Curso de IA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null); // Centrada
        setMinimumSize(new Dimension(1000, 600));
        setLayout(new BorderLayout());

        initUI();
    }

    private void initUI() {
        // Título
        JLabel titulo = new JLabel("Sopa de Letras", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        titulo.setForeground(new Color(44, 62, 80));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(titulo, BorderLayout.NORTH);

        // Panel matriz
        JPanel panelMatriz = new JPanel(new GridLayout(TAM, TAM, 1, 1));
        panelMatriz.setBackground(new Color(220, 220, 250));

        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                JTextField celda = new JTextField();
                celda.setFont(new Font("Consolas", Font.PLAIN, 10));
                celda.setHorizontalAlignment(JTextField.CENTER);
                celda.setEditable(false);
                celda.setBackground(Color.WHITE);
                celda.setPreferredSize(new Dimension(22, 22));
                matriz[i][j] = celda;
                panelMatriz.add(celda);
            }
        }

        JScrollPane scrollMatriz = new JScrollPane(panelMatriz);
        scrollMatriz.setPreferredSize(new Dimension(500, 500));

        // Panel palabras + tiempos
        JPanel panelLateral = new JPanel();
        panelLateral.setLayout(new BoxLayout(panelLateral, BoxLayout.Y_AXIS));
        panelLateral.setBackground(new Color(245, 255, 250));
        panelLateral.setBorder(BorderFactory.createTitledBorder("Palabras y Tiempos (ms)"));

        for (String palabra : palabras) {
            JPanel fila = new JPanel(new BorderLayout(5, 5));
            fila.setBackground(new Color(245, 255, 250));

            JLabel lbl = new JLabel(palabra);
            lbl.setPreferredSize(new Dimension(110, 20));
            JTextField tiempo = new JTextField(6);
            tiempo.setEditable(false);
            tiempo.setBackground(new Color(255, 255, 204)); // amarillo claro

            etiquetasPalabras.add(lbl);
            camposTiempos.add(tiempo);

            fila.add(lbl, BorderLayout.WEST);
            fila.add(tiempo, BorderLayout.CENTER);
            panelLateral.add(fila);
        }

        panelLateral.add(Box.createVerticalStrut(10));
        JLabel lblTotal = new JLabel("Tiempo total:");
        txtTiempoTotal = new JTextField(8);
        txtTiempoTotal.setEditable(false);
        txtTiempoTotal.setBackground(new Color(204, 255, 255));

        panelLateral.add(lblTotal);
        panelLateral.add(txtTiempoTotal);

        JScrollPane scrollPalabras = new JScrollPane(panelLateral);
        scrollPalabras.setPreferredSize(new Dimension(250, 500));

        // Panel central: matriz + lista de palabras

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollMatriz, scrollPalabras);
        splitPane.setResizeWeight(0.7); // matriz ocupa más
        add(splitPane, BorderLayout.CENTER);

        // Panel inferior: botones

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.setBackground(new Color(240, 255, 255));

        btnResolver = new JButton("Resolver Sopa");
        btnNuevaSopa = new JButton("Nueva Sopa");

        btnResolver.setPreferredSize(new Dimension(180, 40));
        btnNuevaSopa.setPreferredSize(new Dimension(180, 40));
        btnResolver.setBackground(new Color(144, 238, 144));
        btnNuevaSopa.setBackground(new Color(173, 216, 230));

        panelBotones.add(btnResolver);
        panelBotones.add(btnNuevaSopa);

        add(panelBotones, BorderLayout.SOUTH);

        // === Listeners de los botones ===
        btnResolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resolverSopa();
            }
        });

        btnNuevaSopa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarNuevaSopa();
            }
        });
    }

    // Buscar palabra en matriz de chars
    public static boolean buscarMatriz(char[][] matriz, String palabra, JTextField[][] matrix) {
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
                        colorear(dir, matrix,i,j,palabra);
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

    // ==== funcion de los  botones  ====

    private void resolverSopa() {
        /* llamr a resolver sopa cuando este listo
         * 
         * 
         */
        File fichero = new File("src/sopa_letra.txt");
        String[] palabras = cargarPalabras(fichero);

        char[][] matrizChar = extraerMatrizCaracteres(matriz);
        for (String palabra : palabras) {
            boolean encontrada = buscarMatriz(matrizChar, palabra, matriz);
            System.out.println(palabra + ": " + (encontrada ? "ENCONTRADA" : "NO ENCONTRADA"));
        }
        JOptionPane.showMessageDialog(this, "Función para resolver");
    }

    private void generarNuevaSopa() {
        /*llamar a generar sopa 
         * 
         * 
         * 
         */
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                matriz[i][j].setText("*");
                matriz[i][j].setBackground(Color.WHITE);
            }
        }
        File fichero = new File("src/sopa_letra.txt");

        String[] palabras = cargarPalabras(fichero);
        if (palabras == null) return;
        // Usar las palabras definidas en la clase en lugar de cargarlas de un archivo
        colocarPalabrasEnMatriz(matriz, palabras, TAM, TAM);
        rellenarEspaciosVacios(matriz, TAM, TAM);
        JOptionPane.showMessageDialog(this, "Función para nueva sopa .");
    }

    public static void colorear(int c, JTextField [][] matriz, int x, int y, String palabra){
        int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
        int aux=x, auy=y;
        for (int i=0; i<palabra.length(); i++) {
            matriz[aux][auy].setBackground(Color.YELLOW);  // Color amarillo
            aux+=dx[c];
            auy+=dy[c];
        }
    }
    
    public static void main(String[] args) {
        
        
        SwingUtilities.invokeLater(() -> {
            new SopaDeLetrasInterfaz().setVisible(true);
        });
    }
}
