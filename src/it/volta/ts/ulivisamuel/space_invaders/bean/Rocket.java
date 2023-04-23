package it.volta.ts.ulivisamuel.space_invaders.bean;

import java.util.ArrayList;
import java.util.List;

import it.volta.ts.ulivisamuel.space_invaders.interfaces.ModifiedPlayer;

public class Rocket
{
	private int                  yPosition;
	private int                  xPosition;
	private boolean              rocketExploded;
	private List<ModifiedPlayer> listeners;
	
	//---------------------------------------------------------------------------------------------
	
	public Rocket()
	{
		yPosition      = 0;
		xPosition      = 0;
		setRocketExploded(false);
		listeners      = new ArrayList<ModifiedPlayer>();
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
	}
	
	//---------------------------------------------------------------------------------------------
	
	public void addListener(ModifiedPlayer modifiedPlayer)
	{
		listeners.add(modifiedPlayer);
	}
	
	public void removeListener(ModifiedPlayer modifiedPlayer)
	{
		listeners.remove(modifiedPlayer);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void alertListeners()
	{
		for(ModifiedPlayer modifiedPlayer : listeners)
			modifiedPlayer.onPlayerModifed();
	}
}

