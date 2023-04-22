package it.volta.ts.ulivisamuel.space_invaders.main;

import it.volta.ts.ulivisamuel.space_invaders.bean.Entity;
import it.volta.ts.ulivisamuel.space_invaders.business.AlienManager;
import it.volta.ts.ulivisamuel.space_invaders.business.PlayerManager;

public class Config 
{
	private static final Config        istance        = new Config();
	private              Entity        player         = new Entity();
	private              Entity        alien          = new Entity();
	private              PlayerManager playerManager  = null;
	private              AlienManager  alienManager   = null;
	private              int           frameWidth     = 0;
	private              int           oldFrameWidth  = 0;
	private              int           playerSpeed    = 10;
	private              int           alienSpeed     = 10;
	private              int           distFromEdge   = 40;
	private              int           distFrEdPlayer = 30;
	private              long          timeBfMoveUfo  = 100;
	
	//---------------------------------------------------------------------------------------------

	private Config() {}
	
	//---------------------------------------------------------------------------------------------

	public static Config getInstance() 
	{
		return istance;
	}
	
	//---------------------------------------------------------------------------------------------

	public Entity getPlayer() 
	{
		return player;
	}
	
	public int getFrameWidth()
	{
		return frameWidth;
	}
	
	public int getPlayerSpeed()
	{
		return playerSpeed;
	}
	
	public int getOldFrameWidth()
	{
		return oldFrameWidth;
	}
	
	public PlayerManager getPlayerManager() 
	{
		if(playerManager == null)
			playerManager = new PlayerManager();
		return playerManager;
	}
	
	public Entity getAlien() 
	{
		return alien;
	}
	
	public int getAlienSpeed() 
	{
		return alienSpeed;
	}
	
	public long getTimeBfMoveUfo() 
	{
		return timeBfMoveUfo;
	}
	
	public AlienManager getAlienManager() 
	{
		if(alienManager == null)
			alienManager = new AlienManager();
		return alienManager;
	}
	
	public int getDistFromEdge() 
	{
		return distFromEdge;
	}
	
	public int getDistFrEdPlayer()
	{
		return distFrEdPlayer;
	}

	
	
	public void setPlayer(Entity player) 
	{
		this.player = player;
	}
	
	public void setPlayerXPosition(int xPosition) 
	{
		player.setxPosition(xPosition);
	}

	public void setFrameWidth(int frameWidth) 
	{
		this.frameWidth = frameWidth;
	}

	public void setPlayerSpeed(int playerSpeed) 
	{
		this.playerSpeed = playerSpeed;
	}

	public void setOldFrameWidth(int oldFrameWidth) 
	{
		this.oldFrameWidth = oldFrameWidth;
	}

	public void setPlayerManager(PlayerManager playerManager) 
	{
		this.playerManager = playerManager;
	}

	public void setAlien(Entity alien) 
	{
		this.alien = alien;
	}

	public void setAlienSpeed(int alienSpeed)
	{
		this.alienSpeed = alienSpeed;
	}

	public void setTimeBfMoveUfo(long timeBfMoveUfo) 
	{
		this.timeBfMoveUfo = timeBfMoveUfo;
	}

	public void setAlienManager(AlienManager alienManager) 
	{
		this.alienManager = alienManager;
	}

	public void setDistFromEdge(int distFromEdge) 
	{
		this.distFromEdge = distFromEdge;
	}

	public void setDistFrEdPlayer(int distFrEdPlayer) 
	{
		this.distFrEdPlayer = distFrEdPlayer;
	}
}
