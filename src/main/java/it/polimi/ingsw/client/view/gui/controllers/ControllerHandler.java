package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.client.Client;
import it.polimi.ingsw.client.ClientState;
import it.polimi.ingsw.client.view.gui.GuiMain;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerHandler {

    /**
     *
     */
    private static Stage stage;

    /**
     *
     */
    private Client client;

    /**
     *
     */
    private ClientState clientState;

    /**
     *
     * @param client
     */
    private static ControllerHandler controllerHandler;

    /**
     * Default constructor
     */
    public ControllerHandler() {

    }

    /**
     *
     * @return the instance of the controller handler
     */
    public static ControllerHandler getInstance(){
        if (controllerHandler==null) {
            controllerHandler = new ControllerHandler();
        }
        return controllerHandler;
    }

    /**
     *
     */
    public void receiveMessage() {
        client.asyncReadFromSocket(client.getOUt());
    }

    /**
     *
     * @return
     */
    public Client getClient() {
        return this.client;
    }

    /**
     *
     * @return
     */
    public Stage getStage() {
        return stage;
    }

    /**
     *
     * @param stage
     */
    public static void setStage(Stage stage) {
        ControllerHandler.stage = stage;
    }

    /**
     *
     * @param clientState
     */
    public void setClientState(ClientState clientState){
        this.clientState = clientState;
    }

    /**
     *
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     *
     * @throws IOException
     */
    public void chooseScene() throws IOException {

        switch (clientState) {
            case LOGIN:
                GuiMain guiMain = new GuiMain();
                guiMain.launchApp();
                break;
            case PLAYING:
                switch (client.getGame().getCurrentPlayer().getPlayerPhase()) {
                    case SET_UP_PHASE:
                            System.out.println("Setup");
                            GuiLoginController loginController = new GuiLoginController();
                            Platform.runLater(() -> {
                                try {
                                    loginController.changeScene();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            });
                            break;
                    case CHOOSING_ASSISTANT:
                        GuiChooseWizardAndColorController colorController = new GuiChooseWizardAndColorController();
                        Platform.runLater(() -> {
                            try {
                                colorController.changeScene();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                }
        }

    }

    /**
     * This method write to the server socket synchronized with the read
     * @param object the object we need to send
     */
    public void write(Object object) {
        synchronized (client) {
            try {
                client.getIn().writeObject(object);
                client.getIn().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
