/************************************************************
 Config.java
 Software Engineering | Project #3 | Team 5
 Cristian Cedeno, Ethan Hannen, Fahad Dawood, Nicholas Boyum
*************************************************************/

package cen4010.pa4;

import java.awt.Color;
import java.awt.Font;

enum AI
{
	NONE,
	LEVEL_1,
	LEVEL_2
}

class DefaultColor
{
    static Color BORDER = Color.LIGHT_GRAY;
    static Color BACKGROUND = Color.BLACK;
    static Color FOREGROUND = Color.white;
    static Color BTN_BACKGROUND = Color.GREEN;
    static Color BTN_FOREGROUND = Color.white;
};

class CheckerColor
{
    static Color BORDER = Color.LIGHT_GRAY;
    static Color BACKGROUND = Color.black;
    static Color FOREGROUND = Color.white;
    static Color BTN_BACKGROUND = Color.GREEN;
    static Color BTN_FOREGROUND = Color.white;
}

class WinterColor
{
    static Color BORDER = Color.WHITE;
    static Color BACKGROUND = Color.CYAN;
    static Color FOREGROUND = Color.BLACK;
    static Color BOX_BACKGROUND = new Color(213,255,255);
}

class Fonts
{
    static Font ARIAL_SMALL    = new Font("Arial", Font.PLAIN, 15);
    static Font ARIAL_LARGE    = new Font("Arial", Font.PLAIN, 20);
    static Font INK_FREE_SMALL = new Font("Ink Free", Font.ITALIC,30);
    static Font INK_FREE_LARGE = new Font("Ink Free", Font.BOLD,40);
};

public class Config 
{
    public int m; // Rows
    public int n; // Columns
    public int k; // Win length
    public int s; // Board size
    
    public Config(int m, int n, int k) 
    {
        this.m = m;
        this.n = n;
        this.k = k;
        this.s = m * n;
    }
    
    public void updateValues()
    {
        if (!Input.errorsExist())
        {
            m = Integer.parseInt(Input.inputs[0].getText());
            n = Integer.parseInt(Input.inputs[1].getText());
            k = Integer.parseInt(Input.inputs[2].getText());
            s = m * n;
        }
    }
}
