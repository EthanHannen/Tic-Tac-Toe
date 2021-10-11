package cen4010.pa4;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

enum Theme
{
	DEFAULT,
	CHECKER,
	WINTER
}

public class Themes {
	static Theme current = Theme.DEFAULT;
}

//JFrames

@SuppressWarnings("serial")
class DefaultFrame extends JFrame
{
	public DefaultFrame(String name, int w, int h)
	{
		super(name);
        this.setSize(w, h);
        this.getContentPane().setBackground(DefaultColor.BACKGROUND);
	}
}

@SuppressWarnings("serial")
class CheckerFrame extends JFrame
{
	public CheckerFrame(String name, int w, int h)
	{
		super(name);
        this.setSize(w, h);
        this.getContentPane().setBackground(CheckerColor.BACKGROUND);
	}
}

@SuppressWarnings("serial")
class WinterFrame extends JFrame
{
	public WinterFrame(String name, int w, int h)
	{
		super(name);
        this.setSize(w, h);
        this.getContentPane().setBackground(WinterColor.BACKGROUND);
	}
}

//JPanels

@SuppressWarnings("serial")
class DefaultPanel extends JPanel
{
	public DefaultPanel(LayoutManager lm, Dimension d)
	{
		super(lm);
		this.setBackground(DefaultColor.BACKGROUND);
		this.setPreferredSize(d);
	}
}

@SuppressWarnings("serial")
class CheckerPanel extends JPanel
{
	public CheckerPanel(LayoutManager lm, Dimension d)
	{
		super(lm);
		this.setBackground(CheckerColor.BACKGROUND);
		this.setPreferredSize(d);
	}
}

@SuppressWarnings("serial")
class WinterPanel extends JPanel
{
	public WinterPanel(LayoutManager lm, Dimension d)
	{
		super(lm);
		this.setBackground(WinterColor.BACKGROUND);
		this.setPreferredSize(d);
	}
}

// Labels

@SuppressWarnings("serial")
class DefaultLabel extends JLabel
{
	public DefaultLabel(String name, int size)
	{
		super();
	    this.setBackground(DefaultColor.BACKGROUND);
	    this.setForeground(DefaultColor.FOREGROUND);
	    this.setFont(new Font("Arial", Font.PLAIN, size));
	    this.setText(name);
	    this.setHorizontalAlignment(JLabel.LEFT);
	    this.setOpaque(true);
	}
}

@SuppressWarnings("serial")
class CheckerLabel extends JLabel
{
	public CheckerLabel(String name, int size)
	{
		super();
	    this.setBackground(CheckerColor.BACKGROUND);
	    this.setForeground(CheckerColor.FOREGROUND);
	    this.setFont(new Font("Arial", Font.PLAIN, size));
	    this.setText(name);
	    this.setHorizontalAlignment(JLabel.LEFT);
	    this.setOpaque(true);
	}
}

@SuppressWarnings("serial")
class WinterLabel extends JLabel
{
	public WinterLabel(String name, int size)
	{
		super();
	    this.setBackground(WinterColor.BACKGROUND);
	    this.setForeground(WinterColor.FOREGROUND);
	    this.setFont(new Font("Arial", Font.PLAIN, size));
	    this.setText(name);
	    this.setHorizontalAlignment(JLabel.LEFT);
	    this.setOpaque(true);
	}
}

//Button

@SuppressWarnings("serial")
class DefaultButton extends Button
{
  public DefaultButton(String text, ButtonType t)
  {
      super(text, t);
      this.setBackground(DefaultColor.BACKGROUND);
      this.setForeground(DefaultColor.FOREGROUND);
      this.setFont(Fonts.ARIAL_SMALL);
  }    
}

@SuppressWarnings("serial")
class CheckerButton extends Button
{
  public CheckerButton(String text, ButtonType t)
  {
      super(text, t);
      this.setBackground(CheckerColor.BACKGROUND);
      this.setForeground(CheckerColor.FOREGROUND);
      this.setFont(Fonts.ARIAL_SMALL);
  }
}

@SuppressWarnings("serial")
class WinterButton extends Button
{
  public WinterButton(String text, ButtonType t)
  {
      super(text, t);
      this.setBackground(WinterColor.BACKGROUND);
      this.setForeground(WinterColor.FOREGROUND);
      this.setFont(Fonts.ARIAL_SMALL);
  }
}

// Boxes

@SuppressWarnings("serial")
class DefaultBox extends Box
{
    public DefaultBox(int i)
    {
        super();
        this.setBorder(BorderFactory.createLineBorder(DefaultColor.BORDER));
        this.setBackground(DefaultColor.BACKGROUND);
        this.setForeground(DefaultColor.FOREGROUND);
        this.setFont(Fonts.INK_FREE_SMALL);
    }    
}

@SuppressWarnings("serial")
class CheckerBox extends Box
{
    public CheckerBox(int i)
    {
        super();
        this.setBorder(BorderFactory.createLineBorder(CheckerColor.BORDER));
        
        if (i % 2 == 0)
        {
	        this.setBackground(CheckerColor.BACKGROUND);
	        this.setForeground(CheckerColor.FOREGROUND);
        }
        else
        {
        	this.setBackground(CheckerColor.FOREGROUND);
	        this.setForeground(CheckerColor.BACKGROUND);
        }
        this.setFont(Fonts.INK_FREE_SMALL);
    }    
}

@SuppressWarnings("serial")
class WinterBox extends Box
{
    public WinterBox(int i)
    {
        super();
        this.setBorder(BorderFactory.createLineBorder(WinterColor.BORDER));
        this.setBackground(WinterColor.BOX_BACKGROUND);
        this.setForeground(WinterColor.FOREGROUND);
        this.setFont(Fonts.ARIAL_LARGE);
    }    
}