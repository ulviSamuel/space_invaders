package it.volta.ts.ulivisamuel.space_invaders.views;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import it.volta.ts.ulivisamuel.space_invaders.bean.Entity;
import it.volta.ts.ulivisamuel.space_invaders.interfaces.ModifiedPlayer;
import it.volta.ts.ulivisamuel.space_invaders.main.Config;

@SuppressWarnings("serial")
public class PlayerView extends JLabel implements ModifiedPlayer
{
	private Entity player;
	
	//---------------------------------------------------------------------------------------------
	
	public PlayerView()
	{
		super(new ImageIcon("img\\space_invaders_player.png"));
		player = Config.getInstance().getPlayer();
		player.addListener(this);
	}

	//---------------------------------------------------------------------------------------------
	
	@Override
	public void onPlayerModifed() 
	{
		this.setLocation(player.getxPosition(), 0);
	}
}
