package fr.toss.common.world.labyrinthe;

public enum Direction {

	GAUCHE(-1, 0),
	DROITE(1, 0),
	BAS(0, -1),
	HAUT(0, 1);

	Direction opposite;
	int x;
	int z;
	
	Direction(int a, int b)
	{
		this.x = a;
		this.z = b;
	}
	
	Direction get_opposite()
	{
		if (this == BAS)
			return (HAUT);
		else if (this == HAUT)
			return (BAS);
		else if (this == GAUCHE)
			return (DROITE);
		else
			return (GAUCHE);

	}

	public int getId()
	{
		if (this == Direction.GAUCHE)
			return (0);
		else if (this == Direction.DROITE)
			return (1);
		else if (this == Direction.BAS)
			return (2);
		return (3);
	}
}
