import edu.cymbal.graphics.CanvasAPI;
import edu.cymbal.graphics.Graphics;
import edu.cymbal.graphics.PainterAPI;

public class Aquarium {
    /*
    * Modify the pen to change positions and the color of the outline.    
     */
    //Moving the pen to a specific location without drawing anything
    static void placement(double x, double y, PainterAPI p){
        p.liftPen();
        p.moveTo(x, y);
        p.lowerPen();
    }

    // //Setting the color of the pen's outline
    // static void setColorOutLine(java.awt.Color color, PainterAPI p){
    //     p.setPenColor(color);
    // }

    /*
    * Modifying the pen to draw a filled shape with a specific color.
     */
    //Drawing a circle
    static void drawCircle(double x, double y, double radius, java.awt.Color color, PainterAPI p){
        placement(x, y - radius, p);
        p.startFill(color);
        p.circle(radius);
        p.finishFill();
    }

    //Drawing a triangle
    static void drawTriangle(double x, double y, double size, java.awt.Color color, PainterAPI p){
        placement(x, y, p);
        p.startFill(color);
        for(int i = 0; i < 4; i++){
            p.forward(size);
            p.turnRight(120);
        }
        p.finishFill();
    }

    //Drawing a rectangle
    static void drawRectangle(double x, double y, double width, double height, java.awt.Color color, PainterAPI p){
        placement(x, y, p);
        p.startFill(color);
        for(int i = 0; i < 5; i++){
            p.forward(width);
            p.turnRight(90);
            p.forward(height);
            p.turnRight(90);
        }
        p.finishFill();
    }

    /*
    * Have the pen start drawing the elements by using the methods
     */
    static void drawCatTree(double x, double y, PainterAPI p){
        //the fist box of the cat tree
        drawRectangle(x, y, 200, 150, java.awt.Color.GRAY, p);
        //the door of the cat tree
        drawRectangle(x +150 , y-150, 100, 100, java.awt.Color.DARK_GRAY, p);
        

    }
    public static void main(String[] args) {
         CanvasAPI canvas = Graphics.createCanvas(800, 600, "My First Drawing");

        PainterAPI p = canvas.getPainter();

        //The center of the canvas
        drawCircle(0, 0, 20, java.awt.Color.BLUE, p);

        p.setSpeed(5); // Lower number means faster, zero means as fast as possible.
        drawCatTree(-400, -150, p);
    }

}