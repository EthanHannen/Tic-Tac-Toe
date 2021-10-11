package cen4010.pa4;

import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public interface AbstractFactory
{
	JFrame getFrame(String name, int w, int h);
	JPanel getPanel(LayoutManager lm, Dimension d);
	JLabel getLabel(String name, int size);	
	Button getButton(String text, ButtonType t);
	Box getBox(int i);
}

class FactoryProducer
{
	public static AbstractFactory getFactory() {
		if (Themes.current == Theme.DEFAULT)
			return new DefaultFactory();
		if (Themes.current == Theme.CHECKER)
			return new CheckerFactory();
		if (Themes.current == Theme.WINTER)
			return new WinterFactory();
		return null;
	}
}

class DefaultFactory implements AbstractFactory
{
	public DefaultFactory() {
		
	}
	@Override
	public JFrame getFrame(String name, int w, int h) {
		return new DefaultFrame(name, w, h);
	}
	@Override
	public JPanel getPanel(LayoutManager lm, Dimension d) {
		return new DefaultPanel(lm, d);
	}
	@Override
	public JLabel getLabel(String name, int size) {
		return new DefaultLabel(name, size);
	}
	@Override
	public Button getButton(String text, ButtonType t) {
		return new DefaultButton(text, t);
	}
	@Override
	public Box getBox(int i) {
		return new DefaultBox(i);
	}
}

class CheckerFactory implements AbstractFactory
{
	public CheckerFactory() {
	}
	@Override
	public JFrame getFrame(String name, int w, int h) {
		return new CheckerFrame(name, w, h);
	}
	@Override
	public JPanel getPanel(LayoutManager lm, Dimension d) {
		return new CheckerPanel(lm, d);
	}
	@Override
	public JLabel getLabel(String name, int size) {
		return new CheckerLabel(name, size);
	}
	@Override
	public Button getButton(String text, ButtonType t) {
		return new CheckerButton(text, t);
	}
	@Override
	public Box getBox(int i) {
		return new CheckerBox(i);
	}
}

class WinterFactory implements AbstractFactory
{
	public WinterFactory() {
	}
	@Override
	public JFrame getFrame(String name, int w, int h) {
		return new WinterFrame(name, w, h);
	}
	@Override
	public JPanel getPanel(LayoutManager lm, Dimension d) {
		return new WinterPanel(lm, d);
	}
	@Override
	public JLabel getLabel(String name, int size) {
		return new WinterLabel(name, size);
	}
	@Override
	public Button getButton(String text, ButtonType t) {
		return new WinterButton(text, t);
	}
	@Override
	public Box getBox(int i) {
		return new WinterBox(i);
	}
}