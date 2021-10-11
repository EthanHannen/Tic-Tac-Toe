/************************************************************
 Game.java
 Software Engineering | Project #3 | Team 5
 Cristian Cedeno, Ethan Hannen, Fahad Dawood, Nicholas Boyum
*************************************************************/

package cen4010.pa4;

import java.awt.Color;

public class Game
{   
    static CountDown timer;
    static Config options;
    static Grid grid;
    static View view;

    static boolean playerTurn = true;
    static boolean gameOver = false;
    public static String xPattern;
    public static String oPattern;

    public Game()
    {
        timer = new CountDown();
        options = new Config(3, 3, 3);
        grid = new Grid(options);
        view = new View(grid, options);
        buildWinStrings();
    }

    public static void newGame()
    {
        // Update/Refresh variables
        Opponent.turn = false;
        playerTurn = true;
        gameOver = false;
        options.updateValues();
        buildWinStrings();
        
        // Rebuild view
        view.destroy(); 
        grid = new Grid(options);
        view = new View(grid, options);
    }
    
    public static void buildWinStrings()
    {
    	xPattern = "";
    	oPattern = "";
        for (int i = 0; i < options.k; i++)
        {
        	xPattern += "X";
        	oPattern += "O";
        }
    }
    
    public static void resetGame()
    {
        view.updateMessage(" Player\'s Turn");
        timer.reset();
    }
    
    public static void setPlayerTurn(boolean turn)
    {
        playerTurn = turn;
    }
    
    public static void toggleAI(AI aiType)
    {
    	Opponent.aiType = aiType;
    	newGame();
    }
    
    public static void updateTimer(short timeLeft)
    {
        if (timeLeft != 0 && !gameOver)
        {
            if (timeLeft <= 3)
                view.setTimeColor(Color.RED);
            view.updateTime(" Time Remaining: " + timeLeft);
        }
        else
        {
            gameOver = true;
            view.updateTime(" Time Remaining: " + timeLeft);
            if (Opponent.aiType != AI.NONE)
            	view.updateMessage(" Time\'s up! " + (playerTurn ? "Computer" : "Player") + " wins!");
            else
            	view.updateMessage(" Time\'s up! Player " + (playerTurn ? "2" : "1") + " wins!");
        }
    }
    
    public static void markBlock(Box b)
    {
        if (gameOver || b.getText() != "") return;

        grid.markBox(b, (playerTurn ? "X": "O"));
        gameOver = checkWin(b);

        // Try to clean this up?
        if (gameOver)
        {
            timer.stop();
            if (Opponent.aiType != AI.NONE)
            	view.updateMessage((playerTurn ? "Player" : "Computer") + " wins!");
            else
            	view.updateMessage("Player " + (playerTurn ? "1" : "2") + " wins!");
        }
        else if (grid.addMarkCount() == options.s)
        {
            timer.stop();
            view.updateMessage(" Draw!");
        }
        else
        {
            timer.reset();
            setPlayerTurn(!playerTurn);
            
            if (Opponent.aiType != AI.NONE)
            {
            	view.updateMessage((playerTurn ? "Player" : "Computer") + "\'s Turn");
            	Opponent.play(grid, options);
            }            	
            else
            {
            	view.updateMessage("Player " + (playerTurn ? "1" : "2") + "\'s Turn");
            }
        }
        view.setTimeColor(Color.WHITE);
        b.highlight();
    }
    
    public static boolean hasPattern(String s)
    {
    	return s.contains(xPattern) || s.contains(oPattern);
    }
    
    public static boolean checkWin(Box box)
    {
    	Line line = grid.getLines(null);
    	
    	if (hasPattern(line.row))
        {
            for (int i = 0; i < options.n; i++)
                view.showWinner(grid.getBox(box.row, i));
            return true;
        }
        if (hasPattern(line.col))
        {
            for (int i = 0; i < options.m; i++)
                view.showWinner(grid.getBox(i, box.col));
            return true;
        }
        if (hasPattern(line.diag))
        {
            return true;
        }
        if (hasPattern(line.anti))
        {
            return true;
        }
        return false;
    }
}