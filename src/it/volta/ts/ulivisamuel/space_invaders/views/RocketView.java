package it.volta.ts.ulivisamuel.space_invaders.views;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import it.volta.ts.ulivisamuel.space_invaders.bean.Rocket;
import it.volta.ts.ulivisamuel.space_invaders.interfaces.ModifiedPlayer;
import it.volta.ts.ulivisamuel.space_invaders.interfaces.ModifiedRocket;
import it.volta.ts.ulivisamuel.space_invaders.main.Config;

@SuppressWarnings("serial")
public class RocketView extends JLabel implements ModifiedRocket
{
	private Rocket rocket;
	
	//---------------------------------------------------------------------------------------------
	
	public RocketView()
	{
		super(new ImageIcon("img\\space_invaders_rocket.png"));
		rocket = Config.getInstance().getRocket();
		rocket.addListener(this);
	}
	
	//---------------------------------------------------------------------------------------------

	@Override
	public void onPlayerModifed()
	{
		this.setLocation(rocket.getxPosition(), rocket.getyPosition());
	}
	
	//---------------------------------------------------------------------------------------------

	@Override
	public void rocketExploded()
	{
		this.setVisible(false);
	}
}
