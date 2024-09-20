package patterns.comportamiento.command.excersice.commands;

import patterns.comportamiento.command.excersice.editor.Editor;

public class CopyCommand extends Command {

    public CopyCommand(Editor editor) {
        super(editor); // Llamamos al constructor de la clase padres
    }

    @Override
    public boolean execute() {
        editor.clipboard = editor.textField.getSelectedText();  // Copiamos el texto seleccionado
        return false;
    }
}
