package state;

import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class State extends JPanel
{
	protected int width, height;
	protected double scale = 1;

	public void create() {}
	public void destroy() {}
	public void update(KeyEvent e) {}

	public State()
	{
		super();
	}

	public void render()
	{
		repaint();
	}

	public void scale(double scale)
	{
		this.scale = scale;
	}

	public void setSize(double width, double height)
	{
		this.width = (int) width;
		this.height = (int) height;
	}
}
