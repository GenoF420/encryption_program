import java.awt.*;
import java.awt.event.*;

public class Test {
    public static void main(String[] args) {
        Frame frame = new Frame("Button Example");

        // Crear un botón
        Button button = new Button("Click Me");

        // Agregar un ActionListener al botón
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button was clicked!");
            }
        });

        // Configurar el diseño y agregar el botón al marco
        frame.setLayout(new FlowLayout());
        frame.add(button);

        // Configurar el tamaño y mostrar el marco
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
