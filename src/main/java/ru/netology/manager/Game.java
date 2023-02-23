package ru.netology.manager;

import ru.netology.domain.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {

    HashMap<String, Player> players = new HashMap<>();

    public void register(String nik, Player player) {
        players.put(nik, player);
    }

    public Player findByName(String name) {

        for (String key : players.keySet()) {
            Player value = players.get(key);
            if (value.getName() == name) {
                return value;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Element with name: " + playerName1 + " not found");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Element with name: " + playerName2 + " not found");
        }
        int result = 0;
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        int strength1 = player1.getStrength();
        int strength2 = player2.getStrength();
        if (strength1 == strength2) {
            result = 0;
        }
        if (strength1 > strength2) {
            result = 1;
        }
        if (strength1 < strength2) {
            result = 2;
        }
        return result;
    }
}
