package ru.netology.manager;

import ru.netology.domain.Player;

import java.util.ArrayList;

public class Game {

    ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }

        int strength1 = player1.getStrength();
        int strength2 = player2.getStrength();
        if (strength1 == strength2) {
            return 0;
        }
        if (strength1 > strength2) {
            return 1;
        }
        return 2;
    }
}
