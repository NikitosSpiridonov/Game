package ru.netology;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class GameTest {
    @Test
    public void testWhenFirstPlayerNotExist() {
        Player artem = new Player(1, "Артем", 222);
        Game game = new Game();
        game.register(artem);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Никита", "Артем"));

    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player artem = new Player(1, "Артем", 222);
        Game game = new Game();
        game.register(artem);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Артем", "Никита"));

    }

    @Test
    public void testWhenSecondPlayerWin() {
        Player nikita = new Player(1, "Никита", 252);
        Player artem = new Player(2, "Артем", 212);
        Game game = new Game();
        game.register(nikita);
        game.register(artem);
        int actual = game.round("Артем", "Никита");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerWin() {
        Player artem = new Player(123, "Артем", 262);
        Player nikita = new Player(1223, "Никита", 232);
        Game game = new Game();
        game.register(artem);
        game.register(nikita);
        int actual = game.round("Артем", "Никита");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenDraw() {
        Player nikita = new Player(151, "Никита", 252);
        Player artem = new Player(123, "Артем", 252);
        Game game = new Game();
        game.register(nikita);
        game.register(artem);
        int actual = game.round("Артем", "Никита");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }
}