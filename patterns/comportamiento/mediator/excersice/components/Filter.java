package patterns.comportamiento.mediator.excersice.components;

import patterns.comportamiento.mediator.excersice.mediator.Mediator;
import patterns.comportamiento.mediator.excersice.mediator.Note;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Concrete components don't talk with each other. They have only one
 * communication channel–sending requests to the mediator.
 */
public class Filter extends JTextField implements Component {
    // Mediador para manejar la comunicación entre componentes.
    private Mediator mediator;
    // Modelo de lista que contiene los elementos a filtrar.
    private ListModel listModel;

    // Constructor vacío.
    public Filter() {}

    // Método para establecer el mediador.
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // Método protegido que procesa eventos de teclado en el componente.
    @Override
    protected void processComponentKeyEvent(KeyEvent keyEvent) {
        // Obtiene el texto actual del campo de texto.
        String start = getText();
        // Llama al método de búsqueda de elementos con el texto actual.
        searchElements(start);
    }

    // Método para establecer el modelo de lista.
    public void setList(ListModel listModel) {
        this.listModel = listModel;
    }

    // Método privado que busca elementos en la lista que contienen el texto dado.
    private void searchElements(String s) {
        // Si el modelo de lista es nulo, no hace nada.
        if (listModel == null) {
            return;
        }

        // Si el texto está vacío, establece la lista completa en el mediador.
        if (s.equals("")) {
            mediator.setElementsList(listModel);
            return;
        }

        // Crea una lista temporal de notas.
        ArrayList<Note> notes = new ArrayList<>();
        // Recorre todos los elementos del modelo de lista y los agrega a la lista temporal.
        for (int i = 0; i < listModel.getSize(); i++) {
            notes.add((Note) listModel.getElementAt(i));
        }
        // Crea un nuevo modelo de lista para los resultados filtrados.
        DefaultListModel<Note> listModel = new DefaultListModel<>();
        // Recorre la lista temporal de notas.
        for (Note note : notes) {
            // Si el nombre de la nota contiene el texto dado, la agrega al modelo de lista filtrado.
            if (note.getName().contains(s)) {
                listModel.addElement(note);
            }
        }
        // Establece la lista filtrada en el mediador.
        mediator.setElementsList(listModel);
    }

    // Método para obtener el nombre del componente.
    @Override
    public String getName() {
        return "Filter";
    }
}