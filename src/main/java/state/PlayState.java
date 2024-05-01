package state;

import entity.Action;
import entity.Entity;
import entity.Mob;
import entity.Scheduler;
import entity.User;
import map.Coord;
import map.RoomGenerator;
import map.SpawnPointGenerator;
import map.Tile;
import map.World;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import static main.Main.stack;
import static map.World.States;

public class PlayState extends State
{
	private static Random rng = new Random();
	private int level;
	private final int LEVEL_MAX;
	private Scheduler scheduler;
	private World world;
	private User user;

	public PlayState()
	{
		super();
		setBackground(Color.BLACK);

		level = 1;
		LEVEL_MAX = 8;
		loadLevel();
	}

	private void loadLevel()
	{
		int numRooms = (level + 1) + (level + 1) * (level + 1);
		
		int[][] room = RoomGenerator.generate(numRooms);

		ArrayList<Coord> userSpawns = SpawnPointGenerator.generate(room, Tile.USER.index);
		ArrayList<Coord> itemSpawns = SpawnPointGenerator.generate(room, Tile.POTION.index);
		ArrayList<Coord> mobSpawns = SpawnPointGenerator.generate(room, Tile.MOB.index);

		// room is mutated during spawn generation,
		// so create world here
		world = new World(room);

		Coord start = userSpawns.remove(rng.nextInt(userSpawns.size()));
		world.set(start.x, start.y, Tile.USER);
		user = new User(start);
		scheduler = new Scheduler(user);

		int keysPending = world.keysMax;
		while (keysPending-- > 0)
		{
			Coord c = itemSpawns.remove(rng.nextInt(itemSpawns.size()));
			world.set(c.x, c.y, Tile.KEY);
		}

		int potions = itemSpawns.size();
		int potionsPending = potions > 0 ? 1 + rng.nextInt(potions) : 0;
		while (potionsPending-- > 0)
		{
			Coord c = itemSpawns.remove(rng.nextInt(itemSpawns.size()));
			world.set(c.x, c.y, Tile.POTION);
		}

		int mobs = mobSpawns.size();
		int mobsPending = Math.min(mobs, level + rng.nextInt(mobs));
		while (mobsPending-- > 0)
		{
			Coord c = mobSpawns.remove(rng.nextInt(mobSpawns.size()));
			world.set(c.x, c.y, Tile.MOB);
			Mob mob = new Mob(c, user);
			scheduler.add(mob);
		}
	}

	public void update(KeyEvent e)
	{
		update(e.getKeyChar());
	}

	public void update(char c)
	{
		switch (c)
		{
			case 'w' -> user.move(0, -1);
			case 's' -> user.move(0, 1);
			case 'a' -> user.move(-1, 0);
			case 'd' -> user.move(1, 0);
			case ' ' -> user.skipTurn();
			//case '?' -> stack.push(new HelpState());
		}

		if (world.state == States.RUNNING)
		{
			scheduler.update(world);
		}

		if (world.state == States.WIN)
		{
			if (level < LEVEL_MAX)
			{
				level++;	
				loadLevel();
				//stack.push(new ContinueState());
			}
			else
			{
			//	stack.pop();
			//	stack.push(new GameOverState("win"));
			}
		}
		else if (world.state == States.LOSE)
		{
		//	stack.pop();
		//	stack.push(new GameOverState("lose"));
		}
	}

	public void setSize(double width, double height)
	{
		super.setSize(width / Tile.TILE_SIZE, height / Tile.TILE_SIZE);
	}

	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, width * Tile.TILE_SIZE, height * Tile.TILE_SIZE);

		g2d.scale(scale, scale);

		int ox = Math.max(0, Math.min(user.x - width / 2, world.width - width));
		int oy = Math.max(0, Math.min(user.y - height / 2, world.height - height));

		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++)
				g2d.drawImage(world.get(x + ox, y + oy).texture, x * Tile.TILE_SIZE, y * Tile.TILE_SIZE, this);

		g2d.setColor(Color.RED);
		g2d.drawString("outside", 0, 0);
	}
}
