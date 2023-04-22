package it.volta.ts.ulivisamuel.space_invaders.views;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import it.volta.ts.ulivisamuel.space_invaders.bean.Entity;
import it.volta.ts.ulivisamuel.space_invaders.interfaces.ModifiedPlayer;
import it.volta.ts.ulivisamuel.space_invaders.main.Config;

@SuppressWarnings("serial")
public class RocketView extends JLabel implements ModifiedPlayer
{
	private Entity rocket;
	private Config configInstace;
	
	//---------------------------------------------------------------------------------------------
	
	public RocketView()
	{
		super(new ImageIcon("img\\space_invaders_rocket.png"));
		configInstace = Config.getInstance();
		rocket        = configInstace.getRocket();
		rocket.addListener(this);
	}
	
	//---------------------------------------------------------------------------------------------

	@Override
	public void onPlayerModifed()
	{
		this.setLocation(configInstace.getPlayer().getPosition(), rocket.getPosition());
	}
}
