package it.polimi.ingsw.Model.Islands;

import it.polimi.ingsw.Model.Enumerations.Color;
import it.polimi.ingsw.Model.Enumerations.PlayerColor;

import java.util.*;

/**
 * 
 */
public class IslandGroup implements IslandInterface {

    /**
     * Default constructor
     */
    public IslandGroup() {
    }
    /**
     *
     */
    private boolean isDenied;

    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private Collection<Island> islands;


    /**
     * @param island
     */
    public void addIsland(Island island) {
        // TODO implement here
    }

    /**
     * @param islandGroup
     */
    public void addIslandGroup(IslandGroup islandGroup) {
        // TODO implement here
    }

    /**
     * @param color 
     * @return
     */
    public Integer numOfStudents(Color color) {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void setDeny() {
        // TODO implement here
    }


   public boolean getDeny(){
        return isDenied;
    }

    /**
     * 
     */
    public void removeDeny() {
        // TODO implement here
    }

    /**
     * @return
     */
    public Integer numOfTowers() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public PlayerColor influenceColor() {
        // TODO implement here
        return null;
    }

}