/************************************************************
 Input.java
 Software Engineering | Project #3 | Team 5
 Cristian Cedeno, Ethan Hannen, Fahad Dawood, Nicholas Boyum
*************************************************************/

package cen4010.pa4;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Input extends JTextField
{
    static boolean[] errors = new boolean[3];
    public static Input[] inputs = new Input[3];
    int index;

    public Input(String t, int index)
    {
        super(2);
        super.setText(t);
        this.index = index;
        this.setFont(this.getFont().deriveFont(15.f));
        this.setHorizontalAlignment(JTextField.CENTER);
        inputs[index] = this;
 
        this.addKeyListener(new KeyAdapter()
        {
            public void keyReleased(KeyEvent e)
            {
                JTextField f = (JTextField) e.getSource();
                String s = f.getText();

                try
                {
                    int i = Integer.parseInt(s);
 
                    if (i < 3 || i > 9)
                    {
                        errors[index] = true;
                        View.showError("Invalid Range: Must be 3 ~ 9");
                        if (i > 9)
                            f.setText(Character.toString(f.getText().charAt(0)));
                    }
                    else
                    {
                        errors[index] = false;
                        if (!errorsExist())
                            View.resetError();
                    }
                }
                catch(NumberFormatException ex)
                {
                    errors[index] = true;
                    View.showError("Invalid Input");
                }
            }
        });
    }

    public static boolean errorsExist()
    {
        return errors[0] || errors[1] || errors[2];
    }
}

@SuppressWarnings("serial")
class RadioButton extends JRadioButton
{
	public RadioButton(String name, AI aiType)
	{
		super(name, aiType == Opponent.aiType);
		this.setOpaque(false);
		this.setForeground(Themes.current == Theme.WINTER ? Color.black : Color.white);
	    this.addItemListener(new ItemListener() {    
	        public void itemStateChanged(ItemEvent e) {   
	           Game.toggleAI(aiType); // Add AI Level
	        }
	     });
	}
	public RadioButton(String name, Theme theme)
	{
		super(name, Themes.current == theme);
		this.setForeground(Themes.current == Theme.WINTER ? Color.black : Color.white);
		this.setOpaque(false);
	    this.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent e) {   
	           Themes.current = theme;
	           Game.newGame();
	        }
	     });
	}
}
