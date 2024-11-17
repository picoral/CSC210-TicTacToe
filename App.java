package com.tictactoe;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    public void drawBoard(Group group) {
        Line vLineOne = new Line();
        vLineOne.setStartX(200.0f);
        vLineOne.setStartY(50.0f);
        vLineOne.setEndX(200.0f);
        vLineOne.setEndY(550.0f);
        group.getChildren().add(vLineOne);

        Line vLineTwo = new Line();
        vLineTwo.setStartX(400.0f);
        vLineTwo.setStartY(50.0f);
        vLineTwo.setEndX(400.0f);
        vLineTwo.setEndY(550.0f);
        group.getChildren().add(vLineTwo);

        Line hLineOne = new Line();
        hLineOne.setStartX(50.0f);
        hLineOne.setStartY(200.0f);
        hLineOne.setEndX(550.0f);
        hLineOne.setEndY(200.0f);
        group.getChildren().add(hLineOne);

        Line hLineTwo = new Line();
        hLineTwo.setStartX(50.0f);
        hLineTwo.setStartY(400.0f);
        hLineTwo.setEndX(550.0f);
        hLineTwo.setEndY(400.0f);
        group.getChildren().add(hLineTwo);
    }

    // Noughts and Crosses
    public void drawNought(int x, int y, Group group) {
         Circle nought = new Circle();
         nought.setRadius(50);
         nought.setCenterX(x);
         nought.setCenterY(y);
         nought.setFill(Color.TRANSPARENT);
         nought.setStroke(Color.BLACK);
         nought.setStrokeWidth(20.0);
         group.getChildren().add(nought);
    }

    public void drawCross(int x, int y, Group group){
        Polygon crossOne = new Polygon();
        crossOne.getPoints().addAll(new Double[]{
            x - 60.0,  y + 40.0,
            x + 40.0, y - 60.0,
            x + 60.0,  y - 40.0,
            x - 40.0, y + 60.0 });
        group.getChildren().add(crossOne);

        Polygon crossTwo = new Polygon();
        crossTwo.getPoints().addAll(new Double[]{
            x + 60.0,  y + 40.0,
            x - 40.0, y - 60.0,
            x - 60.0,  y - 40.0,
            x + 40.0, y + 60.0 });
        group.getChildren().add(crossTwo);
    }

    public int getCleanCoord(int coord) {
        coord -= 50;
        coord /= 175;
        return coord;
    }

    public void wonLineVertical(int x, Group group) {
        x = 125 + x * 175; 
        Polygon vLine = new Polygon();
        vLine.getPoints().addAll(new Double[]{
            x - 7.5,  50.0,
            x + 7.5, 50.0,
            x + 7.5, 550.0,
            x - 7.5, 550.0 });
        vLine.setFill(Color.CADETBLUE);
        group.getChildren().add(vLine);
    }

    public void wonLineHorizontal(int y, Group group) {
        y = 125 + y * 175; 
        Polygon vLine = new Polygon();
        vLine.getPoints().addAll(new Double[]{
            50.0,  y - 7.5,
            50.0, y + 7.5,
            550.0, y + 7.5,
            550.0, y - 7.5});
        vLine.setFill(Color.CADETBLUE);
        group.getChildren().add(vLine);
    }

    public void wonLineDiagonal(int n, Group group) {
        if (n == 0) {
            Polygon dLine = new Polygon();
            dLine.getPoints().addAll(new Double[]{
            60.0,  50.0,
            50.0,  60.0,
            540.0, 550.0,
            550.0, 540.0});
            dLine.setFill(Color.CADETBLUE);
            group.getChildren().add(dLine);
        } else {
            Polygon dLine = new Polygon();
            dLine.getPoints().addAll(new Double[]{
                550.0,  60.0,
                540.0,  50.0,
                50.0, 540.0,
                60.0, 550.0});
            dLine.setFill(Color.CADETBLUE);
            group.getChildren().add(dLine);
        }   
    }

    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        drawBoard(root);
    
        scene = new Scene(root, 600, 600);
 
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, (mouseEvent) -> {
            int y = (int) mouseEvent.getX();
            int x = (int) mouseEvent.getY();
            System.out.println(getCleanCoord(x) + " " + getCleanCoord(y));
            int xCoord = 125 + getCleanCoord(y) * 175;
            int yCoord = 125 + getCleanCoord(x) * 175;
            //drawNought(xCoord, yCoord, root);
            drawCross(xCoord, yCoord, root);

        });

        // first argument is 0-2
        //wonLineVertical(1, root);

        // first argument is 0-2
        //wonLineHorizontal(2, root);

        // first argument is 0-1
        wonLineDiagonal(1, root);

        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}