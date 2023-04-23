package it.volta.ts.ulivisamuel.space_invaders.business;

import it.volta.ts.ulivisamuel.space_invaders.bean.Rocket;
import it.volta.ts.ulivisamuel.space_invaders.main.Config;

public class RocketManager extends Thread
{
	private Rocket  rocket;
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
		rocket.setxPosition(configInstance.getPlayer().getPosition());
		while(!gameFinished)
		{
			onYMove();
			pause(configInstance.getTimeBfMoveRock());
		}
		this.interrupt();
	}
	
	//---------------------------------------------------------------------------------------------

	public void onYMove() 
	{
		rocket.setyPosition(rocket.getyPosition() - configInstance.getRocketSpeed());
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

	public void resetPlayerPosition() 
	{
		try
		{
			rocket.setyPosition((rocket.getyPosition() * configInstance.getFrameWidth()) / configInstance.getOldFrameWidth());
		}
		catch(java.lang.ArithmeticException e){}
	}
}
