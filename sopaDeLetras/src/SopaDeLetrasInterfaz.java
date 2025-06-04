import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class SopaDeLetrasInterfaz extends JFrame {

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

    // ==== funcion de los  botones  ====

    private void resolverSopa() {
        /* llamr a resolver sopa cuando este listo
         * 
         * 
         */
        JOptionPane.showMessageDialog(this, "Función para resolver");
    }

    private void generarNuevaSopa() {
        /*llamar a generar sopa 
         * 
         * 
         * 
         */
        JOptionPane.showMessageDialog(this, "Función para nueva sopa .");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SopaDeLetrasInterfaz().setVisible(true);
        });
    }
}
