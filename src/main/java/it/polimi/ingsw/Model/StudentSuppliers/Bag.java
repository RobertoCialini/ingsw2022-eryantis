package it.polimi.ingsw.Model.StudentSuppliers;

import it.polimi.ingsw.Model.Enumerations.Color;
import it.polimi.ingsw.Model.ExpertCards.ExpertCard;
import it.polimi.ingsw.Model.Islands.Island;
import it.polimi.ingsw.Model.Pawns.Student;
import it.polimi.ingsw.Model.Player.Board.Ingress;
import java.util.*;

/**
 * 
 */
public class Bag {

    /**
     * Default constructor
     */
    public Bag() {
    }

    /**
     * 
     */
    private Integer yellowStudentsNum;

    /**
     * 
     */
    private Integer blueStudentsNum;

    /**
     * 
     */
    private Integer greenStudentsNum;

    /**
     * 
     */
    private Integer redStudentsNum;

    /**
     * 
     */
    private Integer pinkStudentsNum;

    /**
     * 
     */
    private String id;

    /**
     * @return
     */
    public Student newStudent() {
        // TODO implement here
        return null;
    }

    /**
     * @param island
     */
    public void addStudentsOnIsland(Island island) {
        // TODO implement here
    }

    /**
     * @param cloud
     */
    public void addStudentsOnCloud(Cloud cloud) {
        // TODO implement here
    }

    /**
     * @param ingress
     */
    public void addStudentOnIngress(Ingress ingress) {
        // TODO implement here
    }

    /**
     * @param color
     */
    public void reinsertStudent(Color color) {
        // TODO implement here
    }

    /**
     * @param expertCard
     */
    public void addStudentOnCard(ExpertCard expertCard) {
        // TODO implement here
    }

}