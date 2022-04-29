package it.polimi.ingsw.model.rounds;

import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.enumerations.*;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Cloud;

import java.util.Collections;
import java.util.LinkedList;

public class SetUpRound implements  RoundInterface{
    /**
     *
     * @param game Pass the referement of game
     */
    public SetUpRound(Game game) {
        this.game=game;
        playersList=this.game.getPlayerList();
    }
    /**
     *
     */
    private LinkedList<Wizard> wizards=new LinkedList<>();

    /**
     *
     */
    private LinkedList<PlayerColor> colors=new LinkedList<>();


    /**
     *
     */
    private Game game;
    /**
     *
     */
    private LinkedList<Player> playersList=new LinkedList<Player>();
    /**
     * Card played
     */
    private LinkedList<AssistantCard> assistantCards=new LinkedList<>();
    /**
     *
     */
    private LinkedList<Player> playersListOrdered=new LinkedList<>();
    /**
     *
     * @return
     */
    @Override
    public Boolean checkRoundEnded() {
        if (playersListOrdered.size()==playersList.size()) {
            Collections.shuffle(playersListOrdered);
            game.setOrderedPLayerList(playersListOrdered);
            this.game.setRound(game.setPianificationnRoundState());
            game.inizializeGame();
        }
        return true;
    }


    /**
     * @param student
     * @return
     */
    @Override
    public Boolean moveStudentIngressToHall(Student student) {
        return null;
    }

    /**
     * @param student
     * @param island
     * @return
     */
    @Override
    public Boolean moveStudentIngressToIsland(Student student, Island island) {
        return null;
    }

    /**
     * @param jumps
     * @return
     */
    @Override
    public Boolean moveMotherNature(Integer jumps) {
        return null;
    }

    /**
     * @param assistantCard
     * @param player
     * @return
     */
    @Override
    public Boolean playAssistantCard(AssistantCard assistantCard, Player player) {
        return null;
    }

    /**
     * @param expertCard
     * @param string
     * @return
     */
    @Override
    public Boolean playExpertCard(ExpertCard expertCard, String string) {
        return null;
    }

    /**
     * @param student
     * @param island
     * @return
     */
    @Override
    public Boolean expertStudentToIsland(Student student, Island island) {
        return null;
    }

    /**
     * @param studentCard
     * @param Ingress
     * @return
     */
    @Override
    public Boolean expertIngressCardSwap(Student studentCard, Student Ingress) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Boolean finishExpertMove() {
        return null;
    }

    /**
     * @param studentHall
     * @param studentIngress
     * @return
     */
    @Override
    public Boolean expertIngressHallSwap(Student studentHall, Student studentIngress) {
        return null;
    }

    /**
     * @param student
     * @return
     */
    @Override
    public Boolean expertStudentToHall(Student student) {
        return null;
    }

    /**
     * @param cloud
     * @return
     */
    @Override
    public Boolean chooseCloud(Cloud cloud) {
        return null;
    }

    private void expertMoveStudentToBag(Game game, Color color) {

    }

    /**
     *
     * @param player        The player who is choosing
     * @param color         The color we want
     * @param wizard        The wizard we want
     * @return              True if the parameters are acceptable, false instead
     */
    public Boolean chooseColorAndDeck(Player player, PlayerColor color, Wizard wizard) {
        if (colors.contains(color) || wizards.contains(wizard) || player.getPlayerPhase() != PlayerPhase.SET_UP_PHASE)
            return false;
        wizards.add(wizard);
        colors.add(color);
        playersListOrdered.add(player);
        return checkRoundEnded();
    }

}