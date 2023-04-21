package it.volta.ts.ulivisamuel.space_invaders.business;

import it.volta.ts.ulivisamuel.space_invaders.bean.Player;
import it.volta.ts.ulivisamuel.space_invaders.interfaces.MoveObject;
import it.volta.ts.ulivisamuel.space_invaders.main.Config;

public class PlayerManager implements MoveObject
{
	private Player player;
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
			if(player.getxPosition() > configInstance.getFrameWidth()/2 - 40)
				player.setxPosition(player.getxPosition() + (configInstance.getFrameWidth()/2 - player.getxPosition())- 30);
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
			if(player.getxPosition() < -configInstance.getFrameWidth()/2 + 40)
				player.setxPosition((player.getxPosition() + (-configInstance.getFrameWidth()/2 - player.getxPosition())) + 30);
			else
				player.setxPosition(player.getxPosition() - configInstance.getPlayerSpeed());
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	@Override
	public void resetPlayerPosition()
	{
		player.setxPosition((player.getxPosition() * configInstance.getFrameWidth()) / configInstance.getOldFrameWidth());
	}
}
