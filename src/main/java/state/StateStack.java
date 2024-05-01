package state;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;
import javax.swing.JFrame;

public class StateStack extends Stack<State> implements KeyListener
{
	private double width, height;
	private JFrame frame;
	private volatile boolean ready, canResize;

	public StateStack(JFrame frame)
	{
		super();
		this.frame = frame;
		frame.addKeyListener(this);
		ready = canResize = true;

		width = 352;
		height = 240;
		frame.setMinimumSize(new Dimension((int) width, (int) height));

		frame.addComponentListener(
			new ComponentAdapter()
			{
				public void componentResized(ComponentEvent e)
				{
					if (ready)
						resize();
				}
			}
		);
	}

	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e)
	{
		if (!ready)
			return;

		ready = false;
		
		peek().update(e);
		peek().render();

		ready = true;
	}

	public State push(State state)
	{
		state.create();
		state.setSize(width, height);

		if (!isEmpty())
			frame.remove(peek());

		frame.add(state);
		super.push(state);
		resize();
		return state;
	}

	public State pop()
	{
		State old = peek();
		old.destroy();
		super.pop();
		resize();
		frame.setContentPane(peek());
		return old;
	}

	public void swap(State state)
	{
		pop();
		canResize = false;
		push(state);
	}

	public void resize()
	{
		if (!canResize || isEmpty())
			return;

		canResize = false;

		Dimension size = frame.getSize();
		double scale = Math.min(size.width / width, size.height / height);

		peek().scale(scale);

		canResize = true;
	}
}
