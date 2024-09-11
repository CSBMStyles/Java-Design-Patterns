package patterns.estructural.adapter.excersice;

import patterns.estructural.adapter.excersice.adapters.SquarePegAdapter;
import patterns.estructural.adapter.excersice.round.RoundHole;
import patterns.estructural.adapter.excersice.round.RoundPeg;
import patterns.estructural.adapter.excersice.square.SquarePeg;

public class Demo {
    public static void main(String[] args) {
    
        // Crea un agujero redondo con un radio de 5
        RoundHole hole = new RoundHole(5);
        
        // Crea una clavija redonda con un radio de 5
        RoundPeg rpeg = new RoundPeg(5);
    
        // Verifica si la clavija redonda cabe en el agujero redondo
        if (hole.fits(rpeg)) {
            System.out.println("El agujero redondo tiene un radio de: " + hole.getRadius() + " y la clavija redonda tiene un radio de: " + rpeg.getRadius() + "."); // Imprime que la clavija redonda cabe en el agujero redondo
        }
    
        // Crea una clavija cuadrada con un ancho de 2
        SquarePeg smallSqPeg = new SquarePeg(2);
        
        // Crea una clavija cuadrada con un ancho de 20
        SquarePeg largeSqPeg = new SquarePeg(20);
    
        // Adapta la clavija cuadrada pequeña para que pueda ser tratada como una clavija redonda
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        
        // Adapta la clavija cuadrada grande para que pueda ser tratada como una clavija redonda
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        
        // Verifica si la clavija cuadrada pequeña adaptada cabe en el agujero redondo
        if (hole.fits(smallSqPegAdapter)) {
            System.out.println("Square peg w2 fits round hole r5."); // Imprime que la clavija cuadrada pequeña cabe en el agujero redondo
        }
        
        // Verifica si la clavija cuadrada grande adaptada no cabe en el agujero redondo
        if (!hole.fits(largeSqPegAdapter)) {
            System.out.println("Square peg w20 does not fit into round hole r5."); // Imprime que la clavija cuadrada grande no cabe en el agujero redondo
        }
    }
}
