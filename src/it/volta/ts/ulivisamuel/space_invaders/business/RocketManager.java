package it.volta.ts.ulivisamuel.space_invaders.business;

import it.volta.ts.ulivisamuel.space_invaders.bean.Rocket;
import it.volta.ts.ulivisamuel.space_invaders.main.Config;

public class RocketManager extends Thread
{
	private Rocket  rocket;
	private Config  configInstance;
	private boolean rocketExploded;

	//---------------------------------------------------------------------------------------------
	
	public RocketManager()
	{
		configInstance = Config.getInstance();
		rocket         = configInstance.getRocket();
		rocketExploded   = false;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public void interrompiThread()
	{
		rocketExploded = true;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public void run()
	{
		rocket.setxPosition(configInstance.getPlayer().getPosition());
		while(!rocketExploded)
		{
			onYMove();
			pause(configInstance.getTimeBfMoveRock());
		}
		this.interrupt();
	}
	
	//---------------------------------------------------------------------------------------------

	private void onYMove()
	{
		if(rocket.getyPosition() > -configInstance.getFrameHeight() + 210)
			rocket.setyPosition(rocket.getyPosition() - configInstance.getRocketSpeed());
		else
			rocketExploded = true;
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
			rocket.setxPosition((rocket.getxPosition() * configInstance.getFrameWidth()) / configInstance.getOldFrameWidth());
			rocket.setyPosition((rocket.getyPosition() * configInstance.getFrameHeight()) / configInstance.getOldFrameHeight());
		}
		catch(java.lang.ArithmeticException e){}
	}
}
