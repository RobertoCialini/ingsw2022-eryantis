package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.MessageMethod;
import it.polimi.ingsw.message.PlayExpertCard;
import it.polimi.ingsw.model.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GuiChooseExpertCardController implements Initializable {

    /**
     *
     */
    @FXML
    AnchorPane scenePane;

    /**
     * Keep the reference to the last image light up
     */
    private ImageView  lastLight;

    /**
     * Used to have the id of the selected expert card
     */
    private String idExpert;

    /**
     * Reference to game
     */
    private Game game;

    /**
     * Reference to the stage
     */
    private Stage stage;

    /**
     *
     */
    private Scene scene;

    /**
     *
     */
    private String cardOnePath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front1.jpg";

    /**
     *
     */
    private String cardTwoPath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front12.jpg";

    /**
     *
     */
    private String cardThreePath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front2.jpg";

    /**
     *
     */
    private String cardFourPath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front3.jpg";

    /**
     *
     */
    private String cardFivePath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front4.jpg";

    /**
     *
     */
    private String cardSixPath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front5.jpg";

    /**
     *
     */
    private String cardSevenPath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front6.jpg";

    /**
     *
     */
    private String cardEightPath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front7.jpg";

    /**
     *
     */
    private String cardNinePath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front8.jpg";

    /**
     *
     */
    private String cardTenPath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front9.jpg";

    /**
     *
     */
    private String cardElevenPath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front10.jpg";

    /**
     *
     */
    private String cardTwelvePath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front11.jpg";

    /**
     *
     */
    @FXML
    private ImageView expertCard1;

    /**
     *
     */
    @FXML
    private ImageView expertCard2;

    /**
     *
     */
    @FXML
    private ImageView expertCard3;

    /**
     *
     */
    @FXML
    private Text coins;

    /**
     *
     */
    @FXML
    private Text costCard1;

    /**
     *
     */
    @FXML
    private Text costCard2;

    /**
     *
     */
    @FXML
    private Text costCard3;

    /**
     * go back to action phase
     * @param mouseEvent
     */
    public void onBackClick(MouseEvent mouseEvent) throws IOException {
        stage = new Stage();
        ControllerHandler.getInstance().getStage().close();
        ControllerHandler.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/actionPhase-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();

        GuiActionPhaseController actionController = fxmlLoader.getController();
        actionController.resize(stage);
    }

    /**
     * choose the selected card
     * @param mouseEvent
     */
    public void onNextClick(MouseEvent mouseEvent) throws IOException {
        if(idExpert!=null) {
            switch (idExpert) {
                case "38":
                    MessageMethod messageMethod38 = new PlayExpertCard();
                    ControllerHandler.getInstance().setIdExpertCardPlayed("38");
                    ((PlayExpertCard) messageMethod38).setExpertCard("38");
                    ControllerHandler.getInstance().write(messageMethod38);
                    break;
                case "39":
                    MessageMethod messageMethod39 = new PlayExpertCard();
                    ((PlayExpertCard) messageMethod39).setExpertCard("39");
                    ControllerHandler.getInstance().write(messageMethod39);
                    break;
                case "40":
                    ControllerHandler.getInstance().setIdExpertCardPlayed("40");
                    ControllerHandler.getInstance().setCardNeedIsland(true);
                    sceneAction();
                    break;
                case "41":
                    MessageMethod messageMethod41 = new PlayExpertCard();
                    ((PlayExpertCard) messageMethod41).setExpertCard("41");
                    ControllerHandler.getInstance().write(messageMethod41);
                    break;
                case "42":
                    ControllerHandler.getInstance().setIdExpertCardPlayed("42");
                    ControllerHandler.getInstance().setCardNeedIsland(true);
                    sceneAction();
                    break;
                case "43":
                    MessageMethod messageMethod43 = new PlayExpertCard();
                    ((PlayExpertCard) messageMethod43).setExpertCard("43");
                    ControllerHandler.getInstance().write(messageMethod43);
                    break;
                case "44":
                    MessageMethod messageMethod44 = new PlayExpertCard();
                    ControllerHandler.getInstance().setIdExpertCardPlayed("44");
                    ((PlayExpertCard) messageMethod44).setExpertCard("44");
                    ControllerHandler.getInstance().write(messageMethod44);
                    break;
                case "45":
                    scenePlayer();
                    break;
                case "46":
                    ControllerHandler.getInstance().setIdExpertCardPlayed("46");
                    sceneColor();
                    break;
                case "47":
                    MessageMethod messageMethod47 = new PlayExpertCard();
                    ((PlayExpertCard) messageMethod47).setExpertCard("47");
                    ControllerHandler.getInstance().write(messageMethod47);
                    break;
                case "48":
                    MessageMethod messageMethod48 = new PlayExpertCard();
                    ControllerHandler.getInstance().setIdExpertCardPlayed("48");
                    ((PlayExpertCard) messageMethod48).setExpertCard("48");
                    ControllerHandler.getInstance().write(messageMethod48);
                    break;
                case "49":
                    ControllerHandler.getInstance().setIdExpertCardPlayed("49");
                    ControllerHandler.getInstance().setIdExpertCardPlayed("49");
                    sceneColor();
                    break;
            }
        }
    }

    /**
     * Click on the first (of the three) expert card randomly choose for the game
     * @param mouseEvent
     */
    public void clickOnExpert1(MouseEvent mouseEvent) throws IOException {
       if (game.getCardManager().getDeck().get(0).getCost()>game.getCurrentPlayer().getCoins()) {
           coins.setText("You cannot afford this card");
       } else {
           idExpert = game.getCardManager().getDeck().get(0).getId();
           setShadow(expertCard1);
       }
    }

    /**
     * Click on the second (of the three) expert card randomly choose for the game
     * @param mouseEvent
     */
    public void clickOnExpert2(MouseEvent mouseEvent) {
        if (game.getCardManager().getDeck().get(1).getCost()>game.getCurrentPlayer().getCoins()) {
            coins.setText("You cannot afford this card");
        } else {
            idExpert = game.getCardManager().getDeck().get(1).getId();
            coins.setText("Click on card 2");
            setShadow(expertCard2);
        }
    }

    /**
     * Click on the third (of the three) expert card randomly choose for the game
     * @param mouseEvent
     * @throws IOException
     */
    public void clickOnExpert3(MouseEvent mouseEvent) throws IOException {
        if (game.getCardManager().getDeck().get(2).getCost()>game.getCurrentPlayer().getCoins()) {
            coins.setText("You cannot afford this card");
        } else {
            idExpert = game.getCardManager().getDeck().get(2).getId();
            coins.setText("Click on card 3");
            setShadow(expertCard3);
        }
    }

    /**
     * Sets expert card images
     * @param id
     * @param expertCard
     */
    public void setImageExpertCard(String id, ImageView expertCard){
        switch (id) {
            case"38":
                expertCard.setImage(new Image(cardOnePath));
                break;
            case"39":
                expertCard.setImage(new Image(cardTwoPath));
                break;
            case"40":
                expertCard.setImage(new Image(cardThreePath));
                break;
            case"41":
                expertCard.setImage(new Image(cardFourPath));
                break;
            case"42":
                expertCard.setImage(new Image(cardFivePath));
                break;
            case"43":
                expertCard.setImage(new Image(cardSixPath));
                break;
            case"44":
                expertCard.setImage(new Image(cardSevenPath));
                break;
            case"45":
                expertCard.setImage(new Image(cardEightPath));
                break;
            case"46":
                expertCard.setImage(new Image(cardNinePath));
                break;
            case"47":
                expertCard.setImage(new Image(cardTenPath));
                break;
            case"48":
                expertCard.setImage(new Image(cardElevenPath));
                break;
            case"49":
                expertCard.setImage(new Image(cardTwelvePath));
                break;
        }
    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        game = ControllerHandler.getInstance().getClient().getGame();
        setImageExpertCard(game.getCardManager().getDeck().get(0).getId(),expertCard1);
        setImageExpertCard(game.getCardManager().getDeck().get(1).getId(),expertCard2);
        setImageExpertCard(game.getCardManager().getDeck().get(2).getId(),expertCard3);
        coins.setText("You have " + game.getCurrentPlayer().getCoins() + " coins");
        costCard1.setText("Cost: " + game.getCardManager().getDeck().get(0).getCost());
        costCard2.setText("Cost: " + game.getCardManager().getDeck().get(1).getCost());
        costCard3.setText("Cost: " + game.getCardManager().getDeck().get(2).getCost());
    }

    /**
     * go to studentOnCard scene
     * @throws IOException
     */
    public void sceneStudentOnCard() throws IOException {
        stage = new Stage();
        ControllerHandler.getInstance().getStage().close();
        ControllerHandler.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/studentsOnCard-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();

        GuiChooseStudentsOnCardController studentsController = fxmlLoader.getController();
        studentsController.resize(stage);
    }

    /**
     * go to selectColor scene
     * @throws IOException
     */
    public void sceneColor() throws IOException {
        stage = new Stage();
        ControllerHandler.getInstance().getStage().close();
        ControllerHandler.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/selectColorCard-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();

        GuiChooseColorCard studentsController = fxmlLoader.getController();
        studentsController.resize(stage);
    }

    /**
     * go to actionPhase scene
     * @throws IOException
     */
    public void sceneAction() throws IOException {
        stage = new Stage();
        ControllerHandler.getInstance().getStage().close();
        ControllerHandler.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/actionPhase-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();

        GuiActionPhaseController studentsController = fxmlLoader.getController();
        studentsController.resize(stage);
    }

    /**
     * go to selectPlayerCard scene
     * @throws IOException
     */
    public void scenePlayer() throws IOException {
        stage = new Stage();
        ControllerHandler.getInstance().getStage().close();
        ControllerHandler.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/selectPlayerCard-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();

        GuiSelectPlayerCard studentsController = fxmlLoader.getController();
        studentsController.resize(stage);
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

    /**
     * Sets shadows on images
     * @param setImage
     */
    private void setShadow(ImageView setImage) {
        setImage.setEffect(new DropShadow(30, Color.DARKBLUE));
        if (lastLight!=null && lastLight!=setImage) {
            lastLight.setEffect(null);
        }
        lastLight = setImage;
    }

}
