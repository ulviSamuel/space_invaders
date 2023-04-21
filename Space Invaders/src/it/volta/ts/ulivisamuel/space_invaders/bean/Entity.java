package it.volta.ts.ulivisamuel.space_invaders.bean;

import java.util.ArrayList;
import java.util.List;

import it.volta.ts.ulivisamuel.space_invaders.interfaces.ModifiedPlayer;
import it.volta.ts.ulivisamuel.space_invaders.main.Config;

public class Entity
{
	private int                  xPosition;
	private List<ModifiedPlayer> listeners;
	
	//---------------------------------------------------------------------------------------------
	
	public Entity()
	{
		xPosition      = 0;
		listeners      = new ArrayList<ModifiedPlayer>();
	}
	
	//---------------------------------------------------------------------------------------------
	
	public int getxPosition() 
	{
		return xPosition;
	}

	
	
	public void setxPosition(int xPosition) 
	{
		this.xPosition = xPosition;
		alertListeners();
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
