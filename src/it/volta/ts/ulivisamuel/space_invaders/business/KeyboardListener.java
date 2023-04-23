package it.volta.ts.ulivisamuel.space_invaders.business;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import it.volta.ts.ulivisamuel.space_invaders.main.Config;

public class KeyboardListener extends KeyAdapter implements KeyListener
{
	private PlayerManager playerManager;
	private AlienManager  alienManager;
	private Config        configInstance;
	private boolean       gameStarted;
	
	//---------------------------------------------------------------------------------------------
	
	public KeyboardListener()
	{
		configInstance = Config.getInstance();
		playerManager  = configInstance.getPlayerManager();
		alienManager   = configInstance.getAlienManager();
		gameStarted    = false;
	}
	
	//---------------------------------------------------------------------------------------------
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		if(!gameStarted)
		{
			startAndStopAlien();
			setShootListener();
		}
		switch(e.getKeyCode())
		{
		case 37:
		case 65:
			playerManager.onLeftMove();
			break;
		case 39:
		case 68:
			playerManager.onRightMove();
			break;
		}
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void startAndStopAlien()
	{
		if(alienManager != null)
			alienManager.interrompiThread();
		configInstance.setAlienManager(new AlienManager());
		alienManager = configInstance.getAlienManager();
		alienManager.start();
		gameStarted = true;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void setShootListener()
	{
		configInstance.getShootButton().addActionListener(new ShootButtonListener());
	}
}
