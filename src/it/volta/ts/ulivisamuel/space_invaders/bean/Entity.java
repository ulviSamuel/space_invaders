package it.volta.ts.ulivisamuel.space_invaders.bean;

import java.util.ArrayList;
import java.util.List;

import it.volta.ts.ulivisamuel.space_invaders.interfaces.ModifiedPlayer;

public class Entity
{
	private int                  position;
	private List<ModifiedPlayer> listeners;
	
	//---------------------------------------------------------------------------------------------
	
	public Entity()
	{
		position      = 0;
		listeners      = new ArrayList<ModifiedPlayer>();
	}
	
	//---------------------------------------------------------------------------------------------
	
	public int getPosition() 
	{
		return position;
	}

	
	
	public void setPosition(int xPosition) 
	{
		this.position = xPosition;
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
