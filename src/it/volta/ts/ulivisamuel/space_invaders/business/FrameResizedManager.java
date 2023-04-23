package it.volta.ts.ulivisamuel.space_invaders.business;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import it.volta.ts.ulivisamuel.space_invaders.main.Config;

public class FrameResizedManager extends ComponentAdapter implements ComponentListener
{
	private Config        configInstance;
	private PlayerManager playerManager;
	private AlienManager  alienManager;
	private RocketManager rocketManager;
	
	//---------------------------------------------------------------------------------------------
	
	public FrameResizedManager()
	{
		configInstance = Config.getInstance();
		playerManager  = configInstance.getPlayerManager();
		alienManager   = configInstance.getAlienManager();
		rocketManager  = configInstance.getRocketManager();
	}
	
	//---------------------------------------------------------------------------------------------
	
	@Override
	public void componentResized(ComponentEvent e) 
	{
		configInstance.setOldFrameWidth(configInstance.getFrameWidth());
    	configInstance.setFrameWidth(e.getComponent().getWidth());
    	configInstance.setOldFrameHeight(configInstance.getFrameHeight());
    	configInstance.setFrameHeight(e.getComponent().getHeight());
    	playerManager.resetPlayerPosition();
    	alienManager.resetPlayerPosition();
    	rocketManager.resetPlayerPosition();
	}
}
