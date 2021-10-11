package cen4010.pa4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TicTest {

    @Test
    // Test that Config options are created
    void testConfigCreation()
    {
    	Config options = new Config(3,3,3);
        assertNotNull(options);
    }
    
    @Test
    // Test that grid object created
    void testGridCreation()
    {
    	Config options = new Config(3,3,3);
    	Grid grid = new Grid(options);
        assertNotNull(grid);
    }

    @Test
    // Test that View object created
    void testViewCreation()
    {
    	Config options = new Config(3,3,3);
    	Grid grid = new Grid(options);
    	View view = new View(grid, options);
        assertNotNull(view);
    }
    
    @Test
    // Test that Game object created
    void testGameCreation()
    {
    	Game game = new Game();
        assertNotNull(game);
    }
    
    @Test
    // Test that player marks box correctly
    void testPlayerMarking()
    {
    	Game.newGame();
    	Game.markBlock(Game.grid.getBox(0, 0));
    	assertTrue(Game.grid.getBox(0, 0).getText() == "X");
    }
    
    @Test
    // Test that opponent marks box correctly
    void testOpponentMarking()
    { 
    	Game.markBlock(Game.grid.getBox(0, 0)); // Will flip player turn
    	Game.markBlock(Game.grid.getBox(1, 1));
    	assertTrue(Game.grid.getBox(1, 1).getText() == "O");
    }
    
    @Test
    // Test for horizontal win on m = 5, n = 4, k = 3
    void testHorizontalWin3()
    {
    	Input.inputs[0].setText("5");
    	Input.inputs[1].setText("4");
    	Input.inputs[2].setText("3"); 
    	Game.newGame();
    	Game.xPattern = "XXX";
    	Game.grid.markBox(0, 0, "X");
    	Game.grid.markBox(0, 1, "X");
    	Game.grid.markBox(0, 2, "X");
    	assertTrue(Game.checkWin(Game.grid.getBox(0, 2)));
    }
    
    @Test
    // Test for horizontal win on m = 5, n = 5, k = 5
    void testHorizontalWin5()
    {
    	Input.inputs[0].setText("5");
    	Input.inputs[1].setText("5");
    	Input.inputs[2].setText("5"); 
    	Game.newGame();
    	Game.xPattern = "XXXXX";
    	Game.grid.markBox(0, 0, "X");
    	Game.grid.markBox(0, 1, "X");
    	Game.grid.markBox(0, 2, "X");
    	Game.grid.markBox(0, 3, "X");
    	Game.grid.markBox(0, 4, "X");
    	assertTrue(Game.checkWin(Game.grid.getBox(0,  4)));
    }
    
    @Test
    // Test for vertical win on m = 5, n = 4, k = 3
    void testVerticalWin3()
    {
    	Input.inputs[0].setText("5");
    	Input.inputs[1].setText("4");
    	Input.inputs[2].setText("3"); 
    	Game.newGame();
    	Game.oPattern = "OOO";
    	Game.grid.markBox(0, 0, "O");
    	Game.grid.markBox(1, 0, "O");
    	Game.grid.markBox(2, 0, "O");
    	assertTrue(Game.checkWin(Game.grid.getBox(2, 0)));
    }


    @Test
    // Test for vertical win on m = 5, n = 5, k = 5
    void testVerticalWin5()
    {
    	Input.inputs[0].setText("5");
    	Input.inputs[1].setText("5");
    	Input.inputs[2].setText("5"); 
    	Game.newGame();    	
    	Game.oPattern = "OOOOO";
    	Game.grid.markBox(0, 0, "O");
    	Game.grid.markBox(1, 0, "O");
    	Game.grid.markBox(2, 0, "O");
    	Game.grid.markBox(3, 0, "O");
    	Game.grid.markBox(4, 0, "O");
    	assertTrue(Game.checkWin(Game.grid.getBox(4, 0)));
    }

    @Test
    // Test for diagonal win
    void testDiagonalWin5()
    {
    	Input.inputs[0].setText("5");
    	Input.inputs[1].setText("5");
    	Input.inputs[2].setText("5"); 
    	Game.newGame();    	
    	Game.oPattern = "OOOOO";
    	Game.grid.markBox(0, 0, "O");
    	Game.grid.markBox(1, 1, "O");
    	Game.grid.markBox(2, 2, "O");
    	Game.grid.markBox(3, 3, "O");
    	Game.grid.markBox(4, 4, "O");
    	assertTrue(Game.checkWin(Game.grid.getBox(4, 4)));
    }
    
    @Test
    // Test for anti-diagonal win 
    void testAntiDiagonalWin5()
    {
    	Input.inputs[0].setText("5");
    	Input.inputs[1].setText("5");
    	Input.inputs[2].setText("5"); 
    	Game.newGame();    	
    	Game.oPattern = "OOOOO";
    	Game.grid.markBox(0, 4, "O");
    	Game.grid.markBox(1, 3, "O");
    	Game.grid.markBox(2, 2, "O");
    	Game.grid.markBox(3, 1, "O");
    	Game.grid.markBox(4, 0, "O");
    	assertTrue(Game.checkWin(Game.grid.getBox(4, 0)));
    }
    
    @Test
    // Test for horizontal win of odd-shaped n x m matrix
    void testOddMatrixHorizontalWin()
    {
    	Input.inputs[0].setText("3");
    	Input.inputs[1].setText("8");
    	Input.inputs[2].setText("8");
    	Game.newGame();    	
    	Game.oPattern = "OOO";
    	Game.grid.markBox(0, 0, "O");
    	Game.grid.markBox(0, 1, "O");
    	Game.grid.markBox(0, 2, "O");
    	assertTrue(Game.checkWin(Game.grid.getBox(0, 2)));
    }
    
    @Test
    // Test for horizontal win of odd-shaped n x m matrix when k is too large
    void testOddMatrixHorizontalNoWin()
    {
    	Input.inputs[0].setText("3");
    	Input.inputs[1].setText("8");
    	Input.inputs[2].setText("8");
    	Game.newGame();    	
    	Game.oPattern = "OOOOOOOO";
    	Game.grid.markBox(0, 0, "O");
    	Game.grid.markBox(0, 1, "O");
    	Game.grid.markBox(0, 2, "O");
    	Game.grid.markBox(0, 3, "O");
    	Game.grid.markBox(0, 4, "O");
    	Game.grid.markBox(0, 5, "O");
    	Game.grid.markBox(0, 6, "O");
    	assertFalse(Game.checkWin(Game.grid.getBox(0, 6)));
    }
    
    @Test
    // Test for horizontal win of odd-shaped n x m matrix when k is too large
    void testOddMatrixVerticalNoWin()
    {
    	Input.inputs[0].setText("3");
    	Input.inputs[1].setText("8");
    	Input.inputs[2].setText("8");
    	Game.newGame();
    	Game.oPattern = "OOOOOOOO";
    	Game.grid.markBox(0, 0, "O");
    	Game.grid.markBox(1, 0, "O");
    	Game.grid.markBox(2, 0, "O");
    	assertFalse(Game.checkWin(Game.grid.getBox(2, 0)));
    }
    
    @Test
    // Test for anti-diagonal win in odd-shaped n x m matrix on right side
    void testOddMatrixDiagonal()
    {
    	Input.inputs[0].setText("3");
    	Input.inputs[1].setText("5");
    	Input.inputs[2].setText("3"); 
    	Game.newGame();    	
    	Game.oPattern = "OOO";
    	Game.grid.markBox(0, 4, "O");
    	Game.grid.markBox(1, 3, "O");
    	Game.grid.markBox(2, 2, "O");
    	assertTrue(Game.checkWin(Game.grid.getBox(2, 2)));
    }
    
    @Test
    // Test for anti-diagonal win in odd-shaped n x m matrix on right side
    void testOddMatrixDiagonalLeft()
    {
    	Input.inputs[0].setText("8");
    	Input.inputs[1].setText("3");
    	Input.inputs[2].setText("3");
    	Game.newGame();    	
    	Game.xPattern = "XXX";
    	Game.grid.markBox(0, 0, "X");
    	Game.grid.markBox(1, 1, "X");
    	Game.grid.markBox(2, 2, "X");
    	assertTrue(Game.checkWin(Game.grid.getBox(2, 2)));
    }
    
    @Test
    // Test AI for coverage
    void testAILevel1()
    {
    	Input.inputs[0].setText("3");
    	Input.inputs[1].setText("3");
    	Input.inputs[2].setText("3");
    	Game.newGame();
    	Game.toggleAI(AI.LEVEL_1);
    	Game.markBlock(Game.grid.getBox(0, 0));
    	
    	assertFalse(Game.checkWin(Game.grid.getBox(2, 2)));
    }
}
