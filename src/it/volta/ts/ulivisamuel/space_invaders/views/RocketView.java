package it.volta.ts.ulivisamuel.space_invaders.views;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import it.volta.ts.ulivisamuel.space_invaders.bean.Rocket;
import it.volta.ts.ulivisamuel.space_invaders.interfaces.ModifiedRocket;
import it.volta.ts.ulivisamuel.space_invaders.main.Config;

@SuppressWarnings("serial")
public class RocketView extends JLabel implements ModifiedRocket
{
	private Rocket rocket;
	private Config configInstance;
	
	//---------------------------------------------------------------------------------------------
	
	public RocketView()
	{
		super(new ImageIcon("img\\space_invaders_rocket.png"));
		configInstance = Config.getInstance();
		rocket         = configInstance.getRocket();
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
		this.setIcon(new ImageIcon("img\\space_invaders_explosion.png"));
		hangOn();
		onPlayerModifed();
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void hangOn()
	{
		Timer timer = new Timer();
		timer.schedule(new TimerTask()
		{
		    public void run() 
		    {
		    	hideRocket();
		    }
		}, configInstance.getExplosionDur());
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void hideRocket()
	{
		this.setVisible(false);
		this.setIcon(new ImageIcon("img\\space_invaders_rocket.png"));
	}
}
