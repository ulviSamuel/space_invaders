package it.volta.ts.ulivisamuel.space_invaders.business;

import it.volta.ts.ulivisamuel.space_invaders.bean.Entity;
import it.volta.ts.ulivisamuel.space_invaders.main.Config;

public class RocketManager extends Thread
{
	private Entity  rocket;
	private Config  configInstance;
	private boolean gameFinished;

	//---------------------------------------------------------------------------------------------
	
	public RocketManager()
	{
		configInstance = Config.getInstance();
		rocket         = configInstance.getRocket();
		gameFinished   = false;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public void interrompiThread()
	{
		gameFinished = true;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public void run()
	{
		while(!gameFinished)
		{
			
		}
	}

	//---------------------------------------------------------------------------------------------
	
	private void pause(long time)
	{
		try 
		{
			Thread.sleep(time);
		} 
		catch (InterruptedException e) 
		{
			Thread.currentThread().interrupt();
            return;
		}
	}
	
	//---------------------------------------------------------------------------------------------

	public void onYMove() 
	{
		rocket.setPosition(rocket.getPosition() + configInstance.getAlienSpeed());
	}
}
