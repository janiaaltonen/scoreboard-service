package controller;

import model.Player;
import java.util.List;

public interface PlayerList {

    List<Player> getAllScores(String sort);

    boolean addNewScore(Player player);
}
