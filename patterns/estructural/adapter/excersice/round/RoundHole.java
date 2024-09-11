package patterns.estructural.adapter.excersice.round;

/**
 * RoundHoles are compatible with RoundPegs.
 */
public class RoundHole {
    private double radius;

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public boolean fits(RoundPeg peg) {

        boolean result;
        
        // Compara el radio del agujero redondo  con el radio de la clavija redonda si el radio del agujero es mayor o igual al radio de la clavija, entonces la clavija cabe en el agujero
        result = (this.getRadius() >= peg.getRadius());
        
        // Devuelve el resultado de la comparación
        return result;
    }
}
