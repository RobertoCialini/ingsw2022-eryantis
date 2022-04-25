package it.polimi.ingsw.expertCardsTest;

import it.polimi.ingsw.model.calculations.professor.ProfessorManager;
import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.IslandManager;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Bag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardManagerTest {
        /**
         * Test the getMotherNature method
         */

        @Test
        public void getMotherNatureTest() {
            MotherNature motherNature = new MotherNature();
            LinkedList<Player> player = new LinkedList<>();
            player.add(new Player("vittorio"));
            Bag bag = new Bag();
            IslandManager islandManager = new IslandManager(motherNature);
            ProfessorManager professorManager = new ProfessorManager(player);
            CardManager cardManager = new CardManager(motherNature, islandManager, professorManager, player, bag);
            assertTrue(cardManager.getMotherNature() == motherNature);
        }

        /**
         * Test setUpCards method
         */

        @Test
        public void getCardsTest() {
            MotherNature motherNature = new MotherNature();
            LinkedList<Player> player = new LinkedList<>();
            player.add(new Player("vittorio"));
            Bag bag = new Bag();
            IslandManager islandManager = new IslandManager(motherNature);
            ProfessorManager professorManager = new ProfessorManager(player);
            CardManager cardManager = new CardManager(motherNature, islandManager, professorManager, player, bag);
            cardManager.getCardsTest();
            assertTrue(cardManager.getDeck().size() == 3);

        }

        /**
         * Test setCurrentCard method
         */

        @Test
        public void setCurrentCardTest() {
            MotherNature motherNature = new MotherNature();
            LinkedList<Player> player = new LinkedList<>();
            player.add(new Player("vittorio"));
            Bag bag = new Bag();
            IslandManager islandManager = new IslandManager(motherNature);
            ProfessorManager professorManager = new ProfessorManager(player);
            CardManager cardManager = new CardManager(motherNature, islandManager, professorManager, player, bag);
            ExpertCard expertCard = cardManager.getThreeExpertCards().get(0);
            cardManager.setCurrentCard(expertCard);
            assertTrue(cardManager.getCurrentCard() == expertCard);

        }

        /**
         * Test getCurrentCard method
         */
        @Test
        public void getCurrentCardTest() {
            MotherNature motherNature = new MotherNature();
            LinkedList<Player> player = new LinkedList<>();
            player.add(new Player("vittorio"));
            Bag bag = new Bag();
            IslandManager islandManager = new IslandManager(motherNature);
            ProfessorManager professorManager = new ProfessorManager(player);
            CardManager cardManager = new CardManager(motherNature, islandManager, professorManager, player, bag);
            ExpertCard expertCard = cardManager.getThreeExpertCards().get(0);
            cardManager.setCurrentCard(expertCard);
            assertTrue(cardManager.getCurrentCard() == expertCard);

        }

        /**
         * Test the gePlayerList method
         */

        @Test
        public void getPlayerListTest() {
            MotherNature motherNature = new MotherNature();
            LinkedList<Player> player = new LinkedList<>();
            player.add(new Player("vittorio"));
            Bag bag = new Bag();
            IslandManager islandManager = new IslandManager(motherNature);
            ProfessorManager professorManager = new ProfessorManager(player);
            CardManager cardManager = new CardManager(motherNature, islandManager, professorManager, player, bag);
            assertTrue(cardManager.getPlayerList().get(0).getName() == "vittorio");
        }

        /**
         * Test the getBag method
         */
        @Test
        public void getBagTest() {
            MotherNature motherNature = new MotherNature();
            LinkedList<Player> player = new LinkedList<>();
            player.add(new Player("vittorio"));
            Bag bag = new Bag();
            IslandManager islandManager = new IslandManager(motherNature);
            ProfessorManager professorManager = new ProfessorManager(player);
            CardManager cardManager = new CardManager(motherNature, islandManager, professorManager, player, bag);
            assertTrue(cardManager.getBag() == bag);
        }


        /**
         * Test getThreeExpertCards method
         */

        @Test
        public void getThreeExpertCardTest() {
            MotherNature motherNature = new MotherNature();
            LinkedList<Player> player = new LinkedList<>();
            player.add(new Player("vittorio"));
            Bag bag = new Bag();
            IslandManager islandManager = new IslandManager(motherNature);
            ProfessorManager professorManager = new ProfessorManager(player);
            CardManager cardManager = new CardManager(motherNature, islandManager, professorManager, player, bag);
            LinkedList<ExpertCard> newDeck = cardManager.getThreeExpertCards();
            assertTrue(newDeck.size() == 3);
            for (int i=0; i<3; i++) {
                assertTrue(newDeck.get(i).equals(cardManager.getDeck().get(i)));
            }
        }
}

