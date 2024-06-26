/*
 * Finalized legend:
 * 0 -> . -> floor
 * 1 -> # -> wall
 * 2 -> @ -> user
 * 3 -> & -> mob
 * 4 -> ! -> potion
 * 5 -> > -> stair
 * 6 -> ? -> lock
 * 7 -> $ -> key
 * 8 ->   -> none (8 or default)
 * They are ordered in logical explanation order (realized during creation of help screen)
 */

package map;

public class Rooms
{
	public static final int SIZE = 8;

	public static int[][] start = {
		{ 1, 1, 1, 0, 0, 1, 1, 1 },
		{ 1, 2, 2, 2, 2, 2, 2, 1 },
		{ 1, 2, 2, 2, 2, 2, 2, 1 },
		{ 0, 2, 2, 2, 2, 2, 2, 0 },
		{ 0, 2, 2, 2, 2, 2, 2, 0 },
		{ 1, 2, 2, 2, 2, 2, 2, 1 },
		{ 1, 2, 2, 2, 2, 2, 2, 1 },
		{ 1, 1, 1, 0, 0, 1, 1, 1 }
	};

	public static int[][] end = {
		{ 1, 1, 1, 0, 0, 1, 1, 1 },
		{ 1, 0, 0, 0, 0, 0, 0, 1 },
		{ 1, 0, 1, 1, 1, 1, 0, 1 },
		{ 0, 0, 1, 6, 5, 1, 0, 0 },
		{ 0, 0, 1, 6, 1, 1, 0, 0 },
		{ 1, 0, 1, 6, 1, 0, 0, 1 },
		{ 1, 0, 0, 0, 0, 0, 0, 1 },
		{ 1, 1, 1, 0, 0, 1, 1, 1 }
	};

	public static int[][][] any = {
		{
			{ 1, 1, 1, 0, 0, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 1, 1, 0, 3, 0, 1 },
			{ 0, 0, 1, 4, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 0, 3, 0, 0, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 0, 0, 1, 1, 1 }
		},
		{
			{ 1, 1, 1, 0, 0, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 4, 0, 0, 0, 0, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 0, 0, 0, 0, 3, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 0, 0, 1, 1, 1 }
		},
		{
			{ 1, 1, 1, 0, 0, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 1, 0, 0, 1, 0, 1 },
			{ 0, 0, 1, 4, 0, 1, 0, 0 },
			{ 0, 0, 1, 0, 3, 1, 0, 0 },
			{ 1, 0, 1, 0, 0, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 0, 0, 1, 1, 1 }
		},
		{
			{ 1, 1, 1, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 1, 1, 1 },
			{ 0, 0, 0, 0, 4, 0, 0, 0 },
			{ 0, 3, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 3, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 1, 1, 1 }
		},
		{
			{ 1, 1, 1, 0, 0, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 1, 3, 0, 1, 0, 1 },
			{ 0, 0, 4, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 3, 0, 0, 0 },
			{ 1, 0, 1, 0, 0, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 0, 0, 1, 1, 1 }
		},
		{
			{ 1, 1, 1, 0, 0, 1, 1, 1 },
			{ 1, 1, 0, 0, 0, 0, 1, 1 },
			{ 1, 0, 0, 0, 0, 3, 0, 1 },
			{ 0, 0, 0, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 4, 1, 0, 0, 0 },
			{ 1, 3, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 0, 0, 0, 0, 1, 1 },
			{ 1, 1, 1, 0, 0, 1, 1, 1 }
		},
		{
			{ 1, 1, 1, 0, 0, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 3, 0, 0, 3, 0, 1 },
			{ 0, 0, 0, 1, 1, 0, 0, 0 },
			{ 0, 0, 0, 1, 1, 0, 0, 0 },
			{ 1, 0, 4, 0, 0, 3, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 0, 0, 1, 1, 1 }
		},
		{
			{ 1, 1, 1, 0, 0, 1, 1, 1 },
			{ 1, 3, 0, 0, 0, 0, 3, 1 },
			{ 1, 0, 1, 1, 1, 1, 0, 1 },
			{ 0, 0, 1, 1, 1, 1, 0, 0 },
			{ 0, 0, 1, 1, 0, 1, 0, 0 },
			{ 1, 0, 1, 1, 1, 1, 0, 1 },
			{ 1, 4, 0, 0, 0, 0, 3, 1 },
			{ 1, 1, 1, 0, 0, 1, 1, 1 }
		},
		{
			{ 1, 1, 1, 0, 0, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 1, 0, 1, 1, 0, 1 },
			{ 0, 0, 1, 0, 4, 1, 0, 0 },
			{ 0, 0, 0, 3, 0, 0, 0, 0 },
			{ 1, 0, 1, 0, 1, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 0, 0, 1, 1, 1 }
		},
		{
			{ 1, 1, 1, 0, 0, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 1, 1, 3, 1, 0, 1 },
			{ 0, 0, 1, 1, 0, 1, 0, 0 },
			{ 0, 0, 3, 0, 4, 1, 0, 0 },
			{ 1, 0, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 0, 0, 1, 1, 1 }
		}
	};
}
