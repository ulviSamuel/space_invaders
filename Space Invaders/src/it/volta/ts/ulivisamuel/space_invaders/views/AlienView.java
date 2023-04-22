package it.volta.ts.ulivisamuel.space_invaders.views;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import it.volta.ts.ulivisamuel.space_invaders.bean.Entity;
import it.volta.ts.ulivisamuel.space_invaders.interfaces.ModifiedPlayer;
import it.volta.ts.ulivisamuel.space_invaders.main.Config;

@SuppressWarnings("serial")
public class AlienView extends JLabel implements ModifiedPlayer
{
	private Entity alien;
	
	//---------------------------------------------------------------------------------------------
	
	public AlienView()
	{
		super(new ImageIcon("img\\space_invaders_alien.png"));
		alien = Config.getInstance().getAlien();
		alien.addListener(this);
	}

	//---------------------------------------------------------------------------------------------
	
	@Override
	public void onPlayerModifed() 
	{
		this.setLocation(alien.getPosition(), this.getY());
	}
}
