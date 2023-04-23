package it.volta.ts.ulivisamuel.space_invaders.business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.volta.ts.ulivisamuel.space_invaders.main.Config;

public class ShootButtonListener implements ActionListener 
{
	 private Config        configIstnace;
	 private RocketManager rocketManager;
	 
	 //--------------------------------------------------------------------------------------------
	 
	 public ShootButtonListener()
	 {
		 configIstnace = Config.getInstance();
		 rocketManager = configIstnace.getRocketManager();
	 }
	
	//---------------------------------------------------------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(rocketManager.isInterrupted() || !rocketManager.isAlive())
		{
			configIstnace.setRocketManager(new RocketManager());
			configIstnace.getRocketView().setVisible(true);
			rocketManager = configIstnace.getRocketManager();
			rocketManager.start();
			configIstnace.getMainView().requestFocusInWindow();
		}
	}
}
