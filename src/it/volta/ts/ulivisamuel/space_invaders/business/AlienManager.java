package it.volta.ts.ulivisamuel.space_invaders.business;

import it.volta.ts.ulivisamuel.space_invaders.bean.Entity;
import it.volta.ts.ulivisamuel.space_invaders.interfaces.MoveEntity;
import it.volta.ts.ulivisamuel.space_invaders.main.Config;

public class AlienManager extends Thread implements MoveEntity
{
	private Entity  alien;
	private Config  configInstance;
	private int     phaseNumber;
	private boolean gameFinished;
	
	//---------------------------------------------------------------------------------------------
	
	public AlienManager()
	{
		configInstance = Config.getInstance();
		alien          = configInstance.getAlien();
		phaseNumber    = 0;
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
		moveAlien();
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void moveAlien()
	{
		while(!gameFinished)
		{
			if(phaseNumber == 1)
				onLeftMove();
			else
				onRightMove();
			pause(configInstance.getTimeBfMoveUfo());
		}
		this.interrupt();
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
	
	@Override
	public void onRightMove()
	{
		if(alien.getPosition() < (configInstance.getFrameWidth() / 2) - configInstance.getDistFromEdge())
			alien.setPosition(alien.getPosition() + configInstance.getAlienSpeed());
		else
			phaseNumber = 1;
	}
	
	//---------------------------------------------------------------------------------------------

	@Override
	public void onLeftMove() 
	{
		if(alien.getPosition() > (-configInstance.getFrameWidth() / 2) + configInstance.getDistFromEdge())
			alien.setPosition(alien.getPosition() - configInstance.getAlienSpeed());
		else
			phaseNumber = 0;
	}
	
	//---------------------------------------------------------------------------------------------

	@Override
	public void resetPlayerPosition() 
	{
		try
		{
			alien.setPosition((alien.getPosition() * configInstance.getFrameWidth()) / configInstance.getOldFrameWidth());
		}
		catch(java.lang.ArithmeticException e){}
	}
}
