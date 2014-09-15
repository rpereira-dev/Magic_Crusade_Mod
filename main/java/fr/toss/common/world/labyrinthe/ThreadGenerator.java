package fr.toss.common.world.labyrinthe;

public class ThreadGenerator extends Thread implements Runnable {
	
	Labyrinthe lab;
	
	public ThreadGenerator(Labyrinthe l)
	{
		this.lab = l;
	}
	
	@Override
	public void		run()
	{
		System.out.println("Generation starting");
		long time = System.currentTimeMillis();
		float size;
		int i;
		int j;
		
		size = this.lab.size * this.lab.size;
		i = 0;
		while (i < this.lab.size)
		{
			j = 0;
			while (j < this.lab.size)
			{
				if (this.lab.world == null)
					break ;
				this.lab.cellules[i][j].generate(this.lab.world, this.lab.x, this.lab.y, this.lab.z);
				j++;
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {}
			}
			i++;
			System.out.println(((i * this.lab.size) / size * 100) + "%");
		}
		System.out.println("Endded, Taken: " + ((System.currentTimeMillis() - time) / 1000.0f) + " seconds");
	}

}
