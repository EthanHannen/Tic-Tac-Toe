/************************************************************
 Grid.java
 Software Engineering | Project #3 | Team 5
 Cristian Cedeno, Ethan Hannen, Fahad Dawood, Nicholas Boyum
*************************************************************/

package cen4010.pa4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class View
{
    public static JFrame window;
    static JLabel errorMessage;
    JLabel timeRemaining;
    JLabel playerMessage;

    View(Grid grid, Config options)
    {
    	AbstractFactory Factory = FactoryProducer.getFactory();

        double ratio = Math.min(options.n, options.m) * 1. / Math.max(options.n,  options.m);
        int width = (int)(600 * (options.n > options.m ? 1 : ratio));
        width = Math.max(width,  400);
        int height = (int)(600 * (options.m > options.n ? 1 : ratio));
        
        /**************************
        Window Control Panel (P1)
        **************************/
        
        JPanel P1 = Factory.getPanel(new FlowLayout(FlowLayout.RIGHT), new Dimension(width, 30)); 
        JButton min = Factory.getButton("\u2014 ", ButtonType.MIN);
        JButton exit = Factory.getButton(" X", ButtonType.EXIT);
        P1.add(min);
        P1.add(exit);

        /**************************
         Title Panel (P2)
        **************************/

        JPanel P2 = Factory.getPanel(new FlowLayout(FlowLayout.CENTER), new Dimension(width, 60)); 
        JLabel title = Factory.getLabel(" Tic Tac Toe", 40);
        P2.add(title);
        
        /**************************
         Error Panel (P3)
        **************************/
        
        JPanel P3 = Factory.getPanel(new FlowLayout(FlowLayout.RIGHT), new Dimension(width, 25)); 
        errorMessage = Factory.getLabel("", 20);
        errorMessage.setFont(Fonts.ARIAL_SMALL); // Override
        errorMessage.setForeground(Color.red); // Override
        P3.add(errorMessage);

        /**************************
         User Controls (P4)
        **************************/
        
        JPanel P4 = Factory.getPanel(new GridBagLayout(), new Dimension(width, 40)); 
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 20;
        c.weightx = 0.7;
        c.gridwidth = 2;

        JButton newGame = Factory.getButton("New Game", ButtonType.NEW);
        newGame.setBackground(Color.green); // Override
        newGame.setForeground(Color.black); // Override
        P4.add(newGame, c);

        // User-defined grid settings
        JPanel control = Factory.getPanel(new FlowLayout(FlowLayout.RIGHT), new Dimension(width, 45));
        
        JLabel M = Factory.getLabel(" M ", 20);
        JLabel N = Factory.getLabel(" N ", 20);
        JLabel K = Factory.getLabel(" K ", 20);
        JTextField m = new Input(String.valueOf(options.m), 0);
        JTextField n = new Input(String.valueOf(options.n), 1);
        JTextField k = new Input(String.valueOf(options.k), 2);
        
        // Add AI Field
        JRadioButton rb1 = new RadioButton("Two Player", AI.NONE);
        JRadioButton rb2 = new RadioButton("AI Level 1", AI.LEVEL_1);
        JRadioButton rb3 = new RadioButton("AI Level 2", AI.LEVEL_2);
        
        control.add(rb1);
        control.add(rb2);
        control.add(rb3);
        control.add(M);
        control.add(m);
        control.add(N);
        control.add(n);
        control.add(K);
        control.add(k);

        c.gridx = 4;
        c.gridy = 0;
        c.weightx = 1.5;
        c.gridwidth = 5;
        c.fill = GridBagConstraints.HORIZONTAL;
        P4.add(control, c);

        /**************************
         Theme Panel (P5)
        **************************/
        
        JPanel P5 = Factory.getPanel(new FlowLayout(FlowLayout.RIGHT), new Dimension(width, 25));
        JRadioButton t1 = new RadioButton("Default Theme", Theme.DEFAULT);
        JRadioButton t2 = new RadioButton("Checker Theme", Theme.CHECKER);
        JRadioButton t3 = new RadioButton("Winter Theme", Theme.WINTER);
        
        P5.add(t1);
        P5.add(t2);
        P5.add(t3);
        
        /**************************
         Game Grid Panel (P5)
        **************************/

        JPanel P6 = Factory.getPanel(new GridLayout(options.m, options.n), new Dimension(width, height));

        int counter = 0;
        for(int i = 0; i < options.m; i++)
        {
            for (int j = 0; j < options.n; j ++)
            {
                Box b = Factory.getBox(counter++);
                grid.addBox(i, j, b);
                b.row = i;
                b.col = j;
                P6.add(b);
            }
        }
        
        /**************************
         Information Panel (P6)
         **************************/

        JPanel P7 = Factory.getPanel(new GridLayout(), new Dimension(width, 30));
        timeRemaining = Factory.getLabel(" Time Remaining: 10", 20);
        playerMessage = Factory.getLabel((Opponent.aiType != AI.NONE ? " Player's" : " Player 1's") + " Turn", 20);
        P7.add(timeRemaining);
        P7.add(playerMessage);

        /**************************
         Window Frame
         **************************/

        window = Factory.getFrame("Tic Tac Toe", width + 40, height + 250);
        window.add(P1);
        window.add(P2);
        window.add(P3);
        window.add(P4);
        window.add(P5);
        window.add(P6);
        window.add(P7);
        window.setLocationRelativeTo(null); // Center
        window.setLayout(new FlowLayout(FlowLayout.CENTER));
        window.setUndecorated(true);
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void updateTime(String t)
    {
        timeRemaining.setText(t);
    }
    
    public void updateMessage(String t)
    {
        playerMessage.setText(t);
    }
    
    public void setTimeColor(Color c)
    {
        timeRemaining.setForeground(c);
    }
    
    public void setMessageColor(Color c)
    {
        playerMessage.setForeground(c);
    }
    
    public static void showError(String e)
    {
        errorMessage.setText(e);
    }
    
    public static void resetError()
    {
        errorMessage.setText("");
    }
    
    public void showWinner(Box b)
    {
        if (b == null)
            return;
        b.changeBack = false;
        b.setBackground(Color.green);
        b.setForeground(Color.black);
    }
    
    public static void minimizeWindow()
    {
        window.setState(Frame.ICONIFIED);
    }
    
    public static void closeWindow()
    {
        System.exit(0);
    }
    
    public void destroy()
    {
        window.setVisible(false); 
        window.dispose(); 
    }
}
