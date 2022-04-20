package it.polimi.ingsw.model.rounds;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.AssistantCard;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Cloud;

/**
 * 
 */
public class IngressHallSwapActionRound implements RoundInterface {

    /**
     * Default constructor
     */
    public IngressHallSwapActionRound(Game game) {
        this.game=game;
    }
    /**
     *
     */
    Game game;

    /**
     *
     */
    Integer studentsMoved=0;


    @Override
    public Boolean checkRoundEnded() {
        return null;
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
     * @return
     */
    @Override
    public Boolean playExpertCard(ExpertCard expertCard) {
        return null;
    }

    /**
     *
     * @param game
     * @param color
     */
    @Override
    public void expertMoveStudentToBag(Game game, Color color) {

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
     *Called by the controller if he wants to terminate the move
     */
    @Override
    public void finishExpertMove() {
        studentsMoved=0;
        this.game.setRound(this.game.getPreviousRound());
    }

    /**
     * @param studentHall       The student present in the hall
     * @param studentIngress    The student present in the Ingress
     * @return                  True if the move is possible
     */
    @Override
    public Boolean expertIngressHallSwap(Student studentHall, Student studentIngress) {
        Player player= game.getCurrentPlayer();
        player.getSchool().getIngress().addStudent((studentHall));
        player.getSchool().getHall().getLine(studentIngress.getColor()).addStudent(studentIngress);
        studentsMoved++;
        if(studentsMoved==2){
            finishExpertMove();
            return true;
        }
    return false;
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
}