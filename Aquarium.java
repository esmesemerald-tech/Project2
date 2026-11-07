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
            p.turnLeft(120);
        }
        p.finishFill();
    }

    //Drawing a rectangle
    static void drawRectangle(double x, double y, double width, double height, java.awt.Color color, PainterAPI p){
        placement(x, y, p);
        p.startFill(color);
        for(int i = 0; i < 2; i++){
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
        //CHANGE THE DARK_GRAY TO A DIFFERENT COLOR
        //the first box of the cat tree
        drawRectangle(x, y, 200, 150, java.awt.Color.GRAY, p);
        //the door of the cat tree
        drawRectangle(x + 40, y - 50, 100, 100, java.awt.Color.DARK_GRAY, p);
        //The poll of the cat tree
        drawRectangle(x + 70, y + 150, 50, 150, java.awt.Color.GRAY, p);
        //The top of the cat tree
        drawRectangle(x, y+170, 200, 20, java.awt.Color.GRAY, p);

    }
    static void drawOrangeCat(double x, double y, double radius, double size, java.awt.Color color, PainterAPI p){
        //The body of the cat
        drawCircle(x, y, radius, color, p);
        //The head of the cat
        drawCircle(x, y + 100, radius - 30, color, p);
        //The left ear of the cat
        drawTriangle(x - 60, y + 150, size, color, p);
        //The right ear of the cat
        drawTriangle(x + 60, y + 150, size, color, p);
        //The left eye of the cat
        drawCircle(x - 35, y + 120, radius/10, java.awt.Color.BLACK, p);
        //The right eye of the cat
        drawCircle(x + 25, y + 120, radius/10, java.awt.Color.BLACK, p);
        //drawing the mouth of the cat
        placement(x, y + 85, p);
        p.setPenWidth(3);
        p.forward(size/3);
        placement(x, y + 85, p); //Setting the same position to draw the other side of the mouth
        p.turnLeft(50);
        p.forward(size/3);
        //drawing the nose of the cat
        p.setPenWidth(1); //Setting 
        p.turnRight(50);
        drawTriangle(x, y + 95, size/3, java.awt.Color.PINK, p);
    }
    static void drawGrayCat(double x, double y, double radius, double size, java.awt.Color color, PainterAPI p){
        //The body of the cat
        drawCircle(x, y, radius, color, p);
        //The head of the cat
        drawCircle(x, y + 50, radius - 20, color, p);
        //The left ear of the cat
        drawTriangle(x - 25, y + 75, size, color, p);
        //The right ear of the cat
        drawTriangle(x + 25, y + 75, size, color, p);
        //The left eye of the cat
        drawCircle(x - 15, y + 55, radius/10, java.awt.Color.BLACK, p);
        //The right eye of the cat
        drawCircle(x + 15, y + 55, radius/10, java.awt.Color.BLACK, p);
        //drawing the mouth of the cat
        placement(x, y + 40, p);
        p.setPenWidth(2);
        p.forward(size/3);
        placement(x, y + 40, p); //Setting the same position to draw the other side of the mouth
        p.turnLeft(50);
        p.forward(size/3);
        //Drawing the nose of the cat
        p.setPenWidth(1); //Setting the pen width back to 1
        p.turnRight(50);
        drawTriangle(x, y + 45, size/3, java.awt.Color.PINK, p);
    }

    static void drawWhiteRat(double x, double y, double radius, double size, java.awt.Color color, PainterAPI p){
        //The body of the rat
        drawCircle(x, y, radius, color, p);
        //The head of the rat
        p.turnLeft(90);
        drawTriangle(x + 30, y, size, color, p);
        //The nose of the rat
        drawTriangle(x + 30, y + 10, size/3, java.awt.Color.PINK, p);
        //The left eye of the rat
        drawCircle(x + 15, y + 15, radius/10, java.awt.Color.BLACK, p);
        //The right eye of the rat
        drawCircle(x + 25, y + 20, radius/10, java.awt.Color.BLACK, p);
        //Whiskers of the rat
        placement(x + 30, y + 10, p);
        p.setPenWidth(2);
        p.setPenColor(color);
        p.turnRight(100);
        p.backward(size/2);
        placement(x+10, y+5, p);
        p.setPenColor(java.awt.Color.BLACK);
        p.turnLeft(120);
        p.forward(size/2);
        //The tail of the rat
        placement(x - 50, y + 10, p);
        p.setPenColor(java.awt.Color.PINK);
        p.setPenWidth(3);
        p.turnRight(10);
        p.forward(size);
    }
    public static void main(String[] args) {
         CanvasAPI canvas = Graphics.createCanvas(800, 600, "My First Drawing");

        PainterAPI p = canvas.getPainter();

        //The center of the canvas
        drawCircle(0, 0, 20, java.awt.Color.BLUE, p);

        p.setSpeed(3); // Lower number means faster, zero means as fast as possible.
        drawCatTree(-400, -150, p);
        //drawing thhe orange cat
        drawOrangeCat(0, -220, 100, 50, java.awt.Color.ORANGE, p);
        //drawing the gray cat
        drawGrayCat(-250, 70, 50, 25, java.awt.Color.GRAY, p);
        //Drawing the white rat
        drawWhiteRat(-300, -280, 20, 30, java.awt.Color.WHITE, p);
    }

}