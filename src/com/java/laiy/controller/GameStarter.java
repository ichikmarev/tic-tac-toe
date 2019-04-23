package com.java.laiy.controller;

import com.java.laiy.model.Board;
import com.java.laiy.model.Figure;
import com.java.laiy.model.Player;
import com.java.laiy.model.exceptions.InvalidBoardSizeException;
import com.java.laiy.view.SwingGameView;

public class GameStarter {

    public static Game defaultStart(){
        final int boardSize = 3;
        final String gameName = "XO";
        final String playerOneName = "Игрок 'X'";
        final String playerTwoName = "Игрок 'O'";
        return customStart(boardSize,playerOneName,playerTwoName, gameName);
    }

    public static Game customStart(final int BOARD_SIZE, final String playerOneName, final String playerTwoName, final String gameName){
        Board board = new Board(BOARD_SIZE);
        final Player[] players = new Player[2];
        players[0] = new Player(playerOneName, Figure.X);
        players[1] = new Player(playerTwoName, Figure.O);
        final GameController gameController = new GameController(gameName, players, board);
        final SwingGameView swingGameView = new SwingGameView(gameController);
        final Game game = new Game(swingGameView);
        return game;
    }
}
