package keyboard_warrior.world;

public class Map {
	public static int maxSize =17;
	private static int currentX;
	private static int currentY;

	private Location[][] theMap;

	public Map(){
	 	theMap = new Location[maxSize][maxSize];
		//set up all locations here
		theMap[9][0] = new Location("A river bank.","A river runs to the south, impassible cliffs lie to the east and the west.");
		theMap[9][1] = new Location("A passage between cliffs.","You can hear a river running to the south, the cliffs to the east and the west leave you wrapped in the shade, you can make out something in the shadows to the north");

	}

	public void move(String direction){
		direction = direction.toLowerCase();

		switch (direction){
			case "west":
				setLocation(currentX - 1, currentY);
				break;
			case "east":
				setLocation(currentX + 1, currentY);
				break;
			case "north":
				setLocation(currentX, currentY + 1);
				break;
			case "south":
				setLocation(currentX, currentY - 1);
				break;
		}
	}

	public void setLocation(int x, int y)
	{
		if (x < 0 || x > maxSize - 1)
		{
			System.out.println("You cannot go that way!");
			return;
		}

		if (y < 0 || y > maxSize - 1)
		{
			System.out.println("You cannot go that way!");
			return;
		}

		if (theMap[x][y] == null)
		{
			System.out.println("You cannot go that way!");
			return;
		}

		//If we made it here then it should be a valid move;

		currentX = x;
		currentY = y;

		System.out.println("Location: (" + currentX + ", " + currentY + "): " + getCurrentLocation().getName());
		System.out.println();
		System.out.println(getCurrentLocation().getDescription());
	}

	public Location getCurrentLocation(){
		return theMap[currentX][currentY];
	}

}

