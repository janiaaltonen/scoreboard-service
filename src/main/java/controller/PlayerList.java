package controller;

import model.Player;
import java.util.List;

public interface PlayerList {

    List<Player> getAllScores();

    boolean addNewScore(Player player);
}
