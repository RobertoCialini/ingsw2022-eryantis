package it.polimi.ingsw.Model.ExpertCards.Deck;

import it.polimi.ingsw.Model.ExpertCards.ExpertCard;
import it.polimi.ingsw.Model.ObjectTypes.fixedObjectStudent;
import it.polimi.ingsw.Model.Pawns.Student;
import java.util.*;

/**
 * 
 */
public class StudentToIslandCard implements ExpertCard, fixedObjectStudent {

    /**
     * Default constructor
     */
    public StudentToIslandCard() {
    }

    /**
     * 
     */
    private String id;

    /**
     * 
     */
    public void apply() {
        // TODO implement here
    }

    /**
     * @return
     */
    public Integer getCost() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void incrementCost() {
        // TODO implement here
    }

    /**
     * @param student
     */
    public void addStudent(Student student) {
        // TODO implement here
    }

    /**
     * @param student
     */
    public void removeStudent(Student student) {
        // TODO implement here
    }

    /**
     * @return
     */
    public LinkedList<Student> getStudents() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Integer numOfStudents() {
        // TODO implement here
        return null;
    }

}