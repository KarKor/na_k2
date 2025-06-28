package pl.umcs.oop.niewiem;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Window extends javafx.scene.canvas.Canvas {
    private final GraphicsContext gc;
    private List<Line> lines = new CopyOnWriteArrayList<>();
    private Point defaultCenter = new Point(getWidth()/2,getHeight()/2);
    private Point center = defaultCenter;
    private double offsetX = 0;
    private double offsetY = 0;

    public void setCenter(Point center) {
        this.center = center;
    }

    public Point getCenter() {
        return center;
    }

    public Window() {
        super(500, 500);
        gc=this.getGraphicsContext2D();

        this.setFocusTraversable(true);
        this.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP -> offsetY += 10;
                case DOWN -> offsetY -= 10;
                case LEFT -> offsetX += 10;
                case RIGHT -> offsetX -= 10;
                default -> {}
            }
            this.setCenter(new Point(defaultCenter.getX()+offsetX, defaultCenter.getY()+offsetY));
            draw();
        });
    }

    public void addToList(double x1, double y1, double x2, double y2, String color){
        lines.add(new Line(color,
                x1 + center.getX(),
                y1 + center.getY(),
                x2+center.getX(),
                y2+center.getY()));
    }

    public void draw(){
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, getWidth(), getHeight());
        for(Line line : lines){
            gc.setStroke(Color.web(line.getColor()));
            gc.strokeLine(line.getXb() + offsetX, line.getYb() + offsetY, line.getXe()+offsetX, line.getYe()+offsetY);
        }
        gc.setFill(Color.BLACK);
        gc.fillText(center.toCenterString(),0,10);
    }
}
