package it.volta.ts.ulivisamuel.space_invaders.bean;

import java.util.ArrayList;
import java.util.List;

import it.volta.ts.ulivisamuel.space_invaders.interfaces.ModifiedRocket;

public class Rocket
{
	private int                  yPosition;
	private int                  xPosition;
	private boolean              rocketExploded;
	private boolean              rocketCollided;
	private List<ModifiedRocket> listeners;
	
	//---------------------------------------------------------------------------------------------
	
	public Rocket()
	{
		yPosition      = 0;
		xPosition      = 0;
		setRocketExploded(false);
		listeners      = new ArrayList<ModifiedRocket>();
	}
	
	//---------------------------------------------------------------------------------------------
	
	public int getyPosition() 
	{
		return yPosition;
	}
	
	public int getxPosition()
	{
		return xPosition;
	}
	
	public boolean isRocketExploded()
	{
		return rocketExploded;
	}
	
	public boolean isRocketCollided()
	{
		return rocketCollided;
	}

	
	
	public void setyPosition(int xPosition) 
	{
		this.yPosition = xPosition;
		alertListeners();
	}

	public void setxPosition(int xPosition) 
	{
		this.xPosition = xPosition;
	}
	
	public void setRocketExploded(boolean rocketExploded)
	{
		this.rocketExploded = rocketExploded;
		if(rocketExploded == true)
			alertListenersExplosion();
	}
	
	public void setRocketCollided(boolean rocketCollided) 
	{
		this.rocketCollided = rocketCollided;
		if(rocketCollided == true)
			alertListenersCollision();
	}	
	
	//---------------------------------------------------------------------------------------------
	
	public void addListener(ModifiedRocket modifiedPlayer)
	{
		listeners.add(modifiedPlayer);
	}
	
	public void removeListener(ModifiedRocket modifiedPlayer)
	{
		listeners.remove(modifiedPlayer);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void alertListeners()
	{
		for(ModifiedRocket modifiedPlayer : listeners)
			modifiedPlayer.onPlayerModifed();
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void alertListenersExplosion()
	{
		for(ModifiedRocket modifiedPlayer : listeners)
			modifiedPlayer.rocketExploded();
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void alertListenersCollision()
	{
		for(ModifiedRocket modifiedPlayer : listeners)
			modifiedPlayer.rocketCollided();
	}
}

