package patterns.comportamiento.command.excersice.editor;

import patterns.comportamiento.command.excersice.commands.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Editor {
    // Declaración de variables de instancia
    public JTextArea textField; // Área de texto del editor
    public String clipboard; // Portapapeles para copiar y pegar texto
    private CommandHistory history = new CommandHistory(); // Historial de comandos ejecutados

    // Método de inicialización del editor
    public void init() {
        // Creación de la ventana principal del editor
        JFrame frame = new JFrame("Text editor (type & use buttons, Luke!)");
        JPanel content = new JPanel(); // Panel principal de contenido
        frame.setContentPane(content); // Establecer el panel de contenido en el marco
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Configurar la operación de cierre
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS)); // Establecer el diseño del panel de contenido

        // Creación del área de texto
        textField = new JTextArea();
        textField.setLineWrap(true); // Habilitar el ajuste de línea
        content.add(textField); // Agregar el área de texto al panel de contenido

        // Creación del panel de botones
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Panel de botones con diseño de flujo
        JButton ctrlC = new JButton("Ctrl+C"); // Botón de copiar
        JButton ctrlX = new JButton("Ctrl+X"); // Botón de cortar
        JButton ctrlV = new JButton("Ctrl+V"); // Botón de pegar
        JButton ctrlZ = new JButton("Ctrl+Z"); // Botón de deshacer
        Editor editor = this; // Referencia al editor actual

        // Asignación de acciones a los botones
        ctrlC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new CopyCommand(editor)); // Ejecutar comando de copiar
            }
        });
        ctrlX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new CutCommand(editor)); // Ejecutar comando de cortar
            }
        });
        ctrlV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new PasteCommand(editor)); // Ejecutar comando de pegar
            }
        });
        ctrlZ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                undo(); // Ejecutar comando de deshacer
            }
        });

        // Agregar los botones al panel de botones
        buttons.add(ctrlC);
        buttons.add(ctrlX);
        buttons.add(ctrlV);
        buttons.add(ctrlZ);
        content.add(buttons); // Agregar el panel de botones al panel de contenido

        // Configuración de la ventana principal
        frame.setSize(450, 200); // Establecer el tamaño de la ventana
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        frame.setVisible(true); // Hacer visible la ventana
    }

    // Método para ejecutar un comando
    private void executeCommand(Command command) {
        if (command.execute()) { // Si el comando se ejecuta correctamente
            history.push(command); // Agregar el comando al historial
        }
    }

    // Método para deshacer el último comando
    private void undo() {
        if (history.isEmpty()) return; // Si el historial está vacío, no hacer nada

        Command command = history.pop(); // Obtener el último comando del historial
        if (command != null) {
            command.undo(); // Deshacer el comando
        }
    }
}