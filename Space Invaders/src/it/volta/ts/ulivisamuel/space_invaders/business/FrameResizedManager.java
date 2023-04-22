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
	
	//---------------------------------------------------------------------------------------------
	
	public FrameResizedManager()
	{
		configInstance = Config.getInstance();
		playerManager  = configInstance.getPlayerManager();
		alienManager   = configInstance.getAlienManager();
	}
	
	//---------------------------------------------------------------------------------------------
	
	@Override
	public void componentResized(ComponentEvent e) 
	{
		configInstance.setOldFrameWidth(configInstance.getFrameWidth());
    	configInstance.setFrameWidth(e.getComponent().getWidth());
    	playerManager.resetPlayerPosition();
    	alienManager.resetPlayerPosition();
	}
}
