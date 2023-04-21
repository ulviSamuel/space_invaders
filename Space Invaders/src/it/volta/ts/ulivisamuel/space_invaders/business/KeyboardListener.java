package it.volta.ts.ulivisamuel.space_invaders.business;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import it.volta.ts.ulivisamuel.space_invaders.main.Config;

public class KeyboardListener extends KeyAdapter implements KeyListener
{
	private PlayerManager playerManager;
	
	//---------------------------------------------------------------------------------------------
	
	public KeyboardListener()
	{
		playerManager = Config.getInstance().getPlayerManager();
	}
	
	//---------------------------------------------------------------------------------------------
	
	@Override
	public void keyPressed(KeyEvent e)
	{
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
}
