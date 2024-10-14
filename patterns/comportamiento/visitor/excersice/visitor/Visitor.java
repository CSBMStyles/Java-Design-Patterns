package patterns.comportamiento.visitor.excersice.visitor;

import patterns.comportamiento.visitor.excersice.shapes.Circle;
import patterns.comportamiento.visitor.excersice.shapes.Dot;
import patterns.comportamiento.visitor.excersice.shapes.Rectangle;
import patterns.comportamiento.visitor.excersice.shapes.CompoundShape;

public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}