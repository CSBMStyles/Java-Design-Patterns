package patterns.comportamiento.visitor.excersice.shapes;

import patterns.comportamiento.visitor.excersice.visitor.Visitor;

public interface Shape {
    void move(int x, int y);

    void draw();

    String accept(Visitor visitor);
}
