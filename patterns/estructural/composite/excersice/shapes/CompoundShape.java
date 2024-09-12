package patterns.estructural.composite.excersice.shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompoundShape extends BaseShape {
    // List to hold child shapes
    protected List<Shape> children = new ArrayList<>();

    // Constructor that accepts multiple shapes and adds them to the children list
    public CompoundShape(Shape... components) {
        super(0, 0, Color.BLACK); // Call to the superclass constructor
        add(components); // Add the components to the children list
    }

    // Method to add a single shape to the children list
    public void add(Shape component) {
        children.add(component);
    }

    // Method to add multiple shapes to the children list
    public void add(Shape... components) {
        children.addAll(Arrays.asList(components));
    }

    // Method to remove a single shape from the children list
    public void remove(Shape child) {
        children.remove(child);
    }

    // Method to remove multiple shapes from the children list
    public void remove(Shape... components) {
        children.removeAll(Arrays.asList(components));
    }

    // Method to clear all shapes from the children list
    public void clear() {
        children.clear();
    }

    // Override method to get the minimum x-coordinate of all child shapes
    @Override
    public int getX() {
        if (children.size() == 0) {
            return 0;
        }
        int x = children.get(0).getX();
        for (Shape child : children) {
            if (child.getX() < x) {
                x = child.getX();
            }
        }
        return x;
    }

    // Override method to get the minimum y-coordinate of all child shapes
    @Override
    public int getY() {
        if (children.size() == 0) {
            return 0;
        }
        int y = children.get(0).getY();
        for (Shape child : children) {
            if (child.getY() < y) {
                y = child.getY();
            }
        }
        return y;
    }

    // Override method to get the width of the compound shape
    @Override
    public int getWidth() {
        int maxWidth = 0;
        int x = getX();
        for (Shape child : children) {
            int childsRelativeX = child.getX() - x;
            int childWidth = childsRelativeX + child.getWidth();
            if (childWidth > maxWidth) {
                maxWidth = childWidth;
            }
        }
        return maxWidth;
    }

    // Override method to get the height of the compound shape
    @Override
    public int getHeight() {
        int maxHeight = 0;
        int y = getY();
        for (Shape child : children) {
            int childsRelativeY = child.getY() - y;
            int childHeight = childsRelativeY + child.getHeight();
            if (childHeight > maxHeight) {
                maxHeight = childHeight;
            }
        }
        return maxHeight;
    }

    // Override method to move all child shapes by a given x and y offset
    @Override
    public void move(int x, int y) {
        for (Shape child : children) {
            child.move(x, y);
        }
    }

    // Override method to check if a point is inside the bounds of any child shape
    @Override
    public boolean isInsideBounds(int x, int y) {
        for (Shape child : children) {
            if (child.isInsideBounds(x, y)) {
                return true;
            }
        }
        return false;
    }

    // Override method to unselect the compound shape and all its child shapes
    @Override
    public void unSelect() {
        super.unSelect();
        for (Shape child : children) {
            child.unSelect();
        }
    }

    // Method to select a child shape at a given point
    public boolean selectChildAt(int x, int y) {
        for (Shape child : children) {
            if (child.isInsideBounds(x, y)) {
                child.select();
                return true;
            }
        }
        return false;
    }

    // Override method to paint the compound shape and its child shapes
    @Override
    public void paint(Graphics graphics) {
        if (isSelected()) {
            enableSelectionStyle(graphics);
            graphics.drawRect(getX() - 1, getY() - 1, getWidth() + 1, getHeight() + 1);
            disableSelectionStyle(graphics);
        }

        for (Shape child : children) {
            child.paint(graphics);
        }
    }
}
