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
            if (player.getName() == name) {
                return player;
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