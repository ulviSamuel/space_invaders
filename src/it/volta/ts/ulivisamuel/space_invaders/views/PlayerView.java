package it.volta.ts.ulivisamuel.space_invaders.views;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import it.volta.ts.ulivisamuel.space_invaders.bean.Entity;
import it.volta.ts.ulivisamuel.space_invaders.interfaces.ModifiedRocket;
import it.volta.ts.ulivisamuel.space_invaders.main.Config;

@SuppressWarnings("serial")
public class PlayerView extends JLabel implements ModifiedRocket
{
	private Entity player;
	private Config configInstance;
	
	//---------------------------------------------------------------------------------------------
	
	public PlayerView()
	{
		super(new ImageIcon("img\\space_invaders_player.png"));
		configInstance = Config.getInstance();
		player         = configInstance.getPlayer();
		configInstance.getRocket().addListener(this);
		configInstance.getAlien().addListener(this);
		player.addListener(this);
	}

	//---------------------------------------------------------------------------------------------
	
	@Override
	public void onPlayerModifed() 
	{
		this.setLocation(player.getPosition(), this.getY());
	}
	
	//---------------------------------------------------------------------------------------------

	@Override
	public void rocketExploded() 
	{
		this.setLocation(player.getPosition(), this.getY());
	}

	@Override
	public void rocketCollided() {}
}
