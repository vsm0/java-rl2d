package main;

import state.PlayState;
import state.StateStack;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main
{
	public static StateStack stack;

	public static void main(String... args)
	{
		SwingUtilities.invokeLater(
			() -> {
				JFrame frame = new JFrame();
				frame.setBackground(Color.BLACK);
				frame.setSize(480, 352);
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);

				stack = new StateStack(frame);
				stack.push(new PlayState());
			}
		);
	}
}
