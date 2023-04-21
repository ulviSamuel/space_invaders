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
		gameFinished   = true;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public void run()
	{
		while(!gameFinished)
			moveAlien();
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void moveAlien()
	{
		if(phaseNumber == 1)
			onLeftMove();
		else
			onRightMove();
	}
	
	//---------------------------------------------------------------------------------------------
	
	@Override
	public void onRightMove()
	{
		alien.setxPosition(alien.getxPosition() + configInstance.getAlienSpeed());
	}
	
	//---------------------------------------------------------------------------------------------

	@Override
	public void onLeftMove() 
	{
		alien.setxPosition(alien.getxPosition() - configInstance.getAlienSpeed());
	}
	
	//---------------------------------------------------------------------------------------------

	@Override
	public void resetPlayerPosition() 
	{
		
	}
}
