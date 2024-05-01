package map;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public enum Tile
{
	FLOOR(0, 0),
	WALL(1, 0),
	USER(2, 0),
	MOB(0, 1),
	POTION(1, 1),
	STAIR(2, 1),
	LOCK(0, 2),
	KEY(1, 2),
	NONE(2, 2);

	public static final int TILE_SIZE = 16;
	public int index;
	public BufferedImage texture;

	private Tile(int x, int y)
	{
		this.texture = Parser.texture(x, y, TILE_SIZE);
		this.index = Parser.index++;
		Parser.tiles[this.index] = this;
	}

	public static Tile parse(int index)
	{
		return Parser.tiles[Math.min(index, NONE.index)];
	}
}

class Parser
{
	public static int index = 0;
	public static Tile[] tiles = new Tile[9];
	private static final String IMG_PATH = "tileset.png";
	private static BufferedImage tileset;

	static
	{
		try
		{
			InputStream in = Tile.class.getClassLoader().getResourceAsStream(IMG_PATH);
			tileset = ImageIO.read(in);

			Graphics2D g2d = tileset.createGraphics();
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
			g2d.dispose();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static BufferedImage texture(int x, int y, int size)
	{
		return tileset.getSubimage(x * size, y * size, size, size);
	}
}
