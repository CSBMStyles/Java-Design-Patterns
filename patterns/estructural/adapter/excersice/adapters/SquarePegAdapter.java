package patterns.estructural.adapter.excersice.adapters;

import patterns.estructural.adapter.excersice.round.RoundPeg;
import patterns.estructural.adapter.excersice.square.SquarePeg;

public class SquarePegAdapter extends RoundPeg {
    private SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        double result;
        // Calcula el radio de la clavija cuadrada
        result = (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
        // Devuelve el radio de la clavija cuadrada
        return result;
    }

}
