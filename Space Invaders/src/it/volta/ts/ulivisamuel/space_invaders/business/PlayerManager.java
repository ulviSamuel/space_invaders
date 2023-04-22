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
		if(player.getxPosition() != configInstance.getFrameWidth()/2)
		{
			if(player.getxPosition() > configInstance.getFrameWidth()/2 - configInstance.getDistFromEdge())
				player.setxPosition(player.getxPosition() + (configInstance.getFrameWidth()/2 - player.getxPosition())- configInstance.getDistFrEdPlayer());
			else
				player.setxPosition(player.getxPosition() + configInstance.getPlayerSpeed());
		}
	}
	
	//---------------------------------------------------------------------------------------------

	@Override
	public void onLeftMove() 
	{
		if(player.getxPosition() != (-configInstance.getFrameWidth()/2))
		{
			if(player.getxPosition() < -configInstance.getFrameWidth()/2 + configInstance.getDistFromEdge())
				player.setxPosition((player.getxPosition() + (-configInstance.getFrameWidth()/2 - player.getxPosition())) + configInstance.getDistFrEdPlayer());
			else
				player.setxPosition(player.getxPosition() - configInstance.getPlayerSpeed());
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	@Override
	public void resetPlayerPosition()
	{
		try
		{
			player.setxPosition((player.getxPosition() * configInstance.getFrameWidth()) / configInstance.getOldFrameWidth());
		}
		catch(java.lang.ArithmeticException e){}
	}
}
