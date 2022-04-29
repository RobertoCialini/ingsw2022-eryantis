package it.polimi.ingsw;

import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.player.Player;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTests {

    @Test
    public void inizializeGameTest(){
        Game game=new Game();
        Player player = new Player("vittorio");
        Player player1 =new Player("elena");
        game.setCurrentPlayer(player);
        LinkedList<Player> lista=new LinkedList<>();
        lista.add(player);
        lista.add(player1);
        player.setPlayerColor(PlayerColor.WHITE);
        player1.setPlayerColor(PlayerColor.GREY);
        game.setPLayerList(lista);
        game.inizializeGame();


        assertTrue(game.getClouds().get(1).getStudents().size()==3  && player.getSchool().getIngress().getStudents().size()==7);
    }
}