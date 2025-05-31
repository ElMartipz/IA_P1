import javax.swing.*;

public class App {
    public static void main(String[] args) {
        // Crear un JFrame (ventana)
        JFrame ventana = new JFrame("Mi Ventana en Blanco");
        
        // Configurar tamaño de la ventana (ancho, alto)
        ventana.setSize(400, 300);
        
        // Cerrar la aplicación al cerrar la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Hacer visible la ventana
        ventana.setVisible(true);
    }
}
