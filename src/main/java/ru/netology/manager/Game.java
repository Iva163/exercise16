package ru.netology.manager;

import ru.netology.domain.Player;

import java.util.HashMap;

public class Game {

    HashMap<String, Player> players = new HashMap<>();

    public void register(String name, Player player) {
        players.put(name, player);
    }

    public Player findByName(String name) {
        Player player = players.get(name);
        if (player == null) {
            throw new NotRegisteredException(name);
        }
        return player;
    }

    public int round(String playerName1, String playerName2) {
        int strength1 = findByName(playerName1).getStrength();
        int strength2 = findByName(playerName2).getStrength();
        if (strength1 == strength2) {
            return 0;
        }
        if (strength1 > strength2) {
            return 1;
        }
        return 2;
    }
}
