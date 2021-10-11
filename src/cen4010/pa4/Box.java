/************************************************************
 Box.java
 Software Engineering | Project #3 | Team 5
 Cristian Cedeno, Ethan Hannen, Fahad Dawood, Nicholas Boyum
*************************************************************/

package cen4010.pa4;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.SwingWorker;

@SuppressWarnings("serial")
public class Box extends Button 
{
    public int row;
    public int col;
    public boolean changeBack = true;

    public Box()
    {
        super("", ButtonType.MARK);
    }
    
    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (!Opponent.turn)
            Game.markBlock(this);
    }
    
    public void highlight()
    {
        Box b = this;
        Color fg = this.getForeground();
        Color bg = this.getBackground();
		this.setForeground(Color.black);
		this.setBackground(Color.green);

        SwingWorker<Boolean, Void> worker = 
            new SwingWorker<Boolean, Void>()
            {
                @Override
                protected Boolean doInBackground() throws Exception
                {
                    try {
                        Thread.sleep(1500); // Leave green for 1.5 sec
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return true;
                }
                
                // Once the worker thread is done, change color back
                protected void done()
                {
                    // Revert to original colors
                    if (changeBack)
                    {
                        b.setForeground(fg);
                        b.setBackground(bg);
                    }
                }
            };
        worker.execute(); // Execute doInBackground()
    }
}