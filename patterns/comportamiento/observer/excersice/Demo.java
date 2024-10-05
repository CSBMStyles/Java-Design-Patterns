package patterns.comportamiento.observer.excersice;

import patterns.comportamiento.observer.excersice.editor.Editor;
import patterns.comportamiento.observer.excersice.listeners.EmailNotificationListener;
import patterns.comportamiento.observer.excersice.listeners.LogOpenListener;

public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("cristianbarrera100@gmail.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
