
package it.polimi.ingsw.client.view.gui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiLoadGameController {

    @FXML
    private AnchorPane scenePane;
    @FXML
    private Button loadButton;
    @FXML
    private Button newButton;

    /**
     * Reference to the stage
     */
    Scene scene;

    /**
     * Reference to the scene
     */
    Stage stage;

    /**
     * Shows the scene
     * @throws IOException
     */
    public void show() throws IOException {
        stage = new Stage();
        GUIController.getInstance().getStage().close();
        GUIController.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/loadgame-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();
        resize(stage);
    }

    /**
     * Click to load previous game
     * @param mouseEvent
     */
    public void onLoadClick(MouseEvent mouseEvent) throws IOException {
        stage = new Stage();
        GUIController.getInstance().getStage().close();
        GUIController.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/loading-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();
        GUIController.getInstance().write("1");
        resize(stage);
    }

    /**
     * Click to start a new game and login
     * @param mouseEvent
     */
    public void onNewClick(MouseEvent mouseEvent) throws IOException {
        stage = new Stage();
        GUIController.getInstance().getStage().close();
        GUIController.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/loading-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();
        GUIController.getInstance().write("0");
        resize(stage);
    }

    /**
     * Window resize
     */
    public void resize(Stage stage) {
        double height = stage.getHeight();
        double width = stage.getWidth();

        //stage min sizes
        stage.setMinHeight(450);
        stage.setMinWidth(800);

        //horizontal listener
        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            double scaleX = newVal.doubleValue()/width;
            scenePane.setScaleX(scaleX);
            scenePane.setTranslateX(scenePane.getTranslateX() + (newVal.doubleValue()-oldVal.doubleValue())/2);
        });

        //vertical listener
        stage.heightProperty().addListener((obs, oldVal, newVal) -> {
            double scaleY = newVal.doubleValue()/height;
            scenePane.setScaleY(scaleY);
            scenePane.setTranslateY(scenePane.getTranslateY() + (newVal.doubleValue()-oldVal.doubleValue())/2);
        });
    }
}