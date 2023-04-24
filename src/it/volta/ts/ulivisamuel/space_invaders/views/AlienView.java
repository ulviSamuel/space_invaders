package it.volta.ts.ulivisamuel.space_invaders.views;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import it.volta.ts.ulivisamuel.space_invaders.bean.Entity;
import it.volta.ts.ulivisamuel.space_invaders.interfaces.ModifiedRocket;
import it.volta.ts.ulivisamuel.space_invaders.main.Config;

@SuppressWarnings("serial")
public class AlienView extends JLabel implements ModifiedRocket
{
	private Entity alien;
	private Config configInstance;
	
	//---------------------------------------------------------------------------------------------
	
	public AlienView()
	{
		super(new ImageIcon("img\\space_invaders_alien.png"));
		configInstance = Config.getInstance();
		alien = configInstance.getAlien();
		alien.addListener(this);
		configInstance.getRocket().addListener(this);
	}

	//---------------------------------------------------------------------------------------------
	
	@Override
	public void onPlayerModifed() 
	{
		this.setLocation(alien.getPosition(), this.getY());
	}
	
	//---------------------------------------------------------------------------------------------

	@Override
	public void rocketExploded() {}
	
	//---------------------------------------------------------------------------------------------

	@Override
	public void rocketCollided() 
	{
		this.setVisible(false);
	}
}
