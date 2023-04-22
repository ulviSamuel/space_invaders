package it.volta.ts.ulivisamuel.space_invaders.business;

import it.volta.ts.ulivisamuel.space_invaders.bean.Entity;
import it.volta.ts.ulivisamuel.space_invaders.interfaces.MoveEntity;
import it.volta.ts.ulivisamuel.space_invaders.main.Config;

public class PlayerManager implements MoveEntity
{
	private Entity player;
	private Config configInstance;
	
	//---------------------------------------------------------------------------------------------
	
	public PlayerManager()
	{
		configInstance = Config.getInstance();
		player         = configInstance.getPlayer();
	}
	
	//---------------------------------------------------------------------------------------------
	
	@Override
	public void onRightMove()
	{
		if(player.getPosition() != configInstance.getFrameWidth()/2)
		{
			if(player.getPosition() > configInstance.getFrameWidth()/2 - configInstance.getDistFromEdge())
				player.setPosition(player.getPosition() + (configInstance.getFrameWidth()/2 - player.getPosition())- configInstance.getDistFrEdPlayer());
			else
				player.setPosition(player.getPosition() + configInstance.getPlayerSpeed());
		}
	}
	
	//---------------------------------------------------------------------------------------------

	@Override
	public void onLeftMove() 
	{
		if(player.getPosition() != (-configInstance.getFrameWidth()/2))
		{
			if(player.getPosition() < -configInstance.getFrameWidth()/2 + configInstance.getDistFromEdge())
				player.setPosition((player.getPosition() + (-configInstance.getFrameWidth()/2 - player.getPosition())) + configInstance.getDistFrEdPlayer());
			else
				player.setPosition(player.getPosition() - configInstance.getPlayerSpeed());
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	@Override
	public void resetPlayerPosition()
	{
		try
		{
			int value = (player.getPosition() * configInstance.getFrameWidth()) / configInstance.getOldFrameWidth();
			player.setPosition(value);
		}
		catch(java.lang.ArithmeticException e){}
	}
}
