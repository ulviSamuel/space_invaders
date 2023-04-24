package it.volta.ts.ulivisamuel.space_invaders.business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.volta.ts.ulivisamuel.space_invaders.main.Config;

public class ShootButtonListener implements ActionListener 
{
	 private Config        configIstance;
	 private RocketManager rocketManager;
	 
	 //--------------------------------------------------------------------------------------------
	 
	 public ShootButtonListener()
	 {
		 configIstance = Config.getInstance();
		 rocketManager = configIstance.getRocketManager();
	 }
	
	//---------------------------------------------------------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(rocketManager.isInterrupted() || !rocketManager.isAlive())
		{
			configIstance.setRocketManager(new RocketManager());
			configIstance.getRocketView().setVisible(true);
			rocketManager = configIstance.getRocketManager();
			rocketManager.start();
			configIstance.getMainView().requestFocusInWindow();
		}
	}
}
