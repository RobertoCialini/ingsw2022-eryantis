package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandInterface;
import it.polimi.ingsw.utils.IdManager;

import java.io.Serializable;

/**
 * card #3
 */
public class IslandInfluenceCard implements ExpertCard, Serializable {

    /**
     * Default constructor
     */
    public IslandInfluenceCard(CardManager cardManager) {
        this.id = "40";
        this.manager=cardManager;
        IdManager.getInstance().addExpertCard(this);
    }

    /**
     * 
     */
    private String id;

    /**
     *
     */
    private Integer cost = 3;

    /**
     *
     */
    private CardManager manager;

    /**
     * @param island
     */
    public void apply(IslandInterface island) {
        manager.getInfluenceManager().calculateInfluence(island); // the influence calculus is immediately applied on the chosen island
        incrementCost();
    }

    /**
     * @return
     */
    public Integer getCost() {
        return this.cost;
    }

    /**
     * 
     */
    private void incrementCost() {
        cost = cost + 1;
    }

    /**
     *
     * @return
     */
    @Override
    public String getId() {
        return this.id;
    }

}