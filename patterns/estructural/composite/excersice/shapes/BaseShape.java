package patterns.estructural.composite.excersice.shapes;

import java.awt.*;

abstract class BaseShape implements Shape {

    public int x;
    public int y;
    public Color color;
    private boolean selected = false; // Indica si la forma está seleccionada

    // Constructor para inicializar las coordenadas y el color
    BaseShape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * Métodos para obtener las coordenadas de la forma
     * @return Coordenada en la {x, y} de la forma
     */
    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    /** 
     * Métodos para obtener el ancho y alto de la forma
     * @return Ancho y alto de la forma en defecto es 0
    */
    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    // Método para mover la forma a nuevas coordenadas
    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    // Método para verificar si un punto está dentro de los límites de la forma
    @Override
    public boolean isInsideBounds(int x, int y) {
        return x > getX() && x < (getX() + getWidth()) &&
               y > getY() && y < (getY() + getHeight());
    }

    // Métodos para seleccionar y deseleccionar la forma
    @Override
    public void select() {
        selected = true;
    }

    @Override
    public void unSelect() {
        selected = false;
    }

    // Método para verificar si la forma está seleccionada
    @Override
    public boolean isSelected() {
        return selected;
    }

    // Método para habilitar el estilo de selección en el gráfico
    void enableSelectionStyle(Graphics graphics) {
        graphics.setColor(Color.LIGHT_GRAY);

        Graphics2D g2 = (Graphics2D) graphics;
        float[] dash1 = {2.0f};
        g2.setStroke(new BasicStroke(1.0f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                2.0f, dash1, 0.0f));
    }

    // Método para deshabilitar el estilo de selección en el gráfico
    void disableSelectionStyle(Graphics graphics) {
        graphics.setColor(color);
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setStroke(new BasicStroke());
    }

    // Método para pintar la forma en el gráfico
    @Override
    public void paint(Graphics graphics) {
        if (isSelected()) {
            enableSelectionStyle(graphics);
        }
        else {
            disableSelectionStyle(graphics);
        }
    }
}
