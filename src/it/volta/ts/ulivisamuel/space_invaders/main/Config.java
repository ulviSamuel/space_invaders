package it.volta.ts.ulivisamuel.space_invaders.main;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import it.volta.ts.ulivisamuel.space_invaders.bean.Entity;
import it.volta.ts.ulivisamuel.space_invaders.bean.Rocket;
import it.volta.ts.ulivisamuel.space_invaders.business.AlienManager;
import it.volta.ts.ulivisamuel.space_invaders.business.PlayerManager;
import it.volta.ts.ulivisamuel.space_invaders.business.RocketManager;
import it.volta.ts.ulivisamuel.space_invaders.views.MainView;
import it.volta.ts.ulivisamuel.space_invaders.views.PlayerView;
import it.volta.ts.ulivisamuel.space_invaders.views.RocketView;

public class Config 
{
	private static final Config        istance        = new Config();
	private              Entity        player         = new Entity();
	private              Entity        alien          = new Entity();
	private              Rocket        rocket         = new Rocket();
	private              MainView      mainView       = null;
	private              PlayerManager playerManager  = null;
	private              AlienManager  alienManager   = null;
	private              RocketManager rocketManager  = null;
	private              RocketView    rocketView     = null;
	private              PlayerView    playerView     = null;
	private              JButton       shootButton    = new JButton(new ImageIcon("img//space_invaders_buttonSkin.png"));
	private              int           frameWidth     = 0;
	private              int           frameHeight    = 0;
	private              int           oldFrameWidth  = 0;
	private              int           oldFrameHeight = 0;
	private              int           playerSpeed    = 10;
	private              int           alienSpeed     = 10;
	private              int           rocketSpeed    = 20;
	private              int           distFromEdge   = 40;
	private              int           distFrEdPlayer = 30;
	private              int           distFrEdgRock  = 270;
	private              int           distAccForCol  = 40;
	private              int           distBtwBtnPlay = 0;
	private              int           distBtwTopUfo  = 20;
	private              int           minFrameWidth  = 600;
	private              int           minFrameHeight = 500;
	private              long          timeBfMoveUfo  = 100;
	private              long          timeBfMoveRock = 100;
	private              long          explosionDur   = 200;
	private              long          timeBfRest     = 5000;
	
	//---------------------------------------------------------------------------------------------

	private Config() {}
	
	//---------------------------------------------------------------------------------------------

	public static Config getInstance() 
	{
		return istance;
	}
	
	//---------------------------------------------------------------------------------------------

	public Entity getPlayer() 
	{
		return player;
	}
	
	public int getFrameWidth()
	{
		return frameWidth;
	}
	
	public int getPlayerSpeed()
	{
		return playerSpeed;
	}
	
	public int getOldFrameWidth()
	{
		return oldFrameWidth;
	}
	
	public PlayerManager getPlayerManager() 
	{
		if(playerManager == null)
			playerManager = new PlayerManager();
		return playerManager;
	}
	
	public Entity getAlien() 
	{
		return alien;
	}
	
	public int getAlienSpeed() 
	{
		return alienSpeed;
	}
	
	public long getTimeBfMoveUfo() 
	{
		return timeBfMoveUfo;
	}
	
	public AlienManager getAlienManager() 
	{
		if(alienManager == null)
			alienManager = new AlienManager();
		return alienManager;
	}
	
	public int getDistFromEdge() 
	{
		return distFromEdge;
	}
	
	public int getDistFrEdPlayer()
	{
		return distFrEdPlayer;
	}

	public MainView getMainView()
	{
		if(mainView == null)
			mainView = new MainView();
		return mainView;
	}
	
	public RocketView getRocketView()
	{
		if(rocketView == null)
			rocketView = new RocketView();
		return rocketView;
	}
	
	public Rocket getRocket()
	{
		return rocket;
	}
	
	public int getRocketSpeed()
	{
		return rocketSpeed;
	}
	
	public long getTimeBfMoveRock()
	{
		return timeBfMoveRock;
	}
	
	public RocketManager getRocketManager() 
	{
		if(rocketManager == null)
			rocketManager = new RocketManager();
		return rocketManager;
	}
	
	public int getFrameHeight() 
	{
		return frameHeight;
	}
	
	public int getOldFrameHeight() 
	{
		return oldFrameHeight;
	}
	
	public int getDistFrEdgRock() 
	{
		return distFrEdgRock;
	}
	
	public JButton getShootButton()
	{
		return shootButton;
	}
	
	public long getExplosionDur() 
	{
		return explosionDur;
	}
	
	public PlayerView getPlayerView()
	{
		if(playerView == null)
			playerView = new PlayerView();
		return playerView;
	}
	
	public long getTimeBfRest() 
	{
		return timeBfRest;
	}
	
	public int getDistAccForCol() 
	{
		return distAccForCol;
	}
	
	public int getDistBtwBtnPlay()
	{
		return distBtwBtnPlay;
	}
	
	public int getMinFrameHeight() 
	{
		return minFrameHeight;
	}

	public int getMinFrameWidth() 
	{
		return minFrameWidth;
	}
	
	public int getDistBtwTopUfo()
	{
		return distBtwTopUfo;
	}
	
	
	
	public void setPlayer(Entity player) 
	{
		this.player = player;
	}
	
	public void setPlayerXPosition(int xPosition) 
	{
		player.setPosition(xPosition);
	}

	public void setFrameWidth(int frameWidth) 
	{
		this.frameWidth = frameWidth;
	}

	public void setPlayerSpeed(int playerSpeed) 
	{
		this.playerSpeed = playerSpeed;
	}

	public void setOldFrameWidth(int oldFrameWidth) 
	{
		this.oldFrameWidth = oldFrameWidth;
	}

	public void setPlayerManager(PlayerManager playerManager) 
	{
		this.playerManager = playerManager;
	}

	public void setAlien(Entity alien) 
	{
		this.alien = alien;
	}

	public void setAlienSpeed(int alienSpeed)
	{
		this.alienSpeed = alienSpeed;
	}

	public void setTimeBfMoveUfo(long timeBfMoveUfo) 
	{
		this.timeBfMoveUfo = timeBfMoveUfo;
	}

	public void setAlienManager(AlienManager alienManager) 
	{
		this.alienManager = alienManager;
	}

	public void setDistFromEdge(int distFromEdge) 
	{
		this.distFromEdge = distFromEdge;
	}

	public void setDistFrEdPlayer(int distFrEdPlayer) 
	{
		this.distFrEdPlayer = distFrEdPlayer;
	}

	public void setMainView(MainView mainView) 
	{
		this.mainView = mainView;
	}

	public void setRocketView(RocketView rocketView) 
	{
		this.rocketView = rocketView;
	}

	public void setRocket(Rocket rocket)
	{
		this.rocket = rocket;
	}

	public void setRocketSpeed(int rocketSpeed) 
	{
		this.rocketSpeed = rocketSpeed;
	}

	public void setTimeBfMoveRock(long timeBfMoveRock)
	{
		this.timeBfMoveRock = timeBfMoveRock;
	}

	public void setRocketManager(RocketManager rocketManager) 
	{
		this.rocketManager = rocketManager;
	}

	public void setFrameHeight(int frameHeight)
	{
		this.frameHeight = frameHeight;
	}

	public void setOldFrameHeight(int oldFrameHeight)
	{
		this.oldFrameHeight = oldFrameHeight;
	}

	public void setDistFrEdgRock(int distFrEdgRock) 
	{
		this.distFrEdgRock = distFrEdgRock;
	}

	public void setShootButton(JButton shootButton)
	{
		this.shootButton = shootButton;
	}

	public void setExplosionDur(long explosionDur)
	{
		this.explosionDur = explosionDur;
	}

	public void setPlayerView(PlayerView playerView) 
	{
		this.playerView = playerView;
	}

	public void setTimeBfRest(long timeBfRest) 
	{
		this.timeBfRest = timeBfRest;
	}

	public void setDistAccForCol(int distAccForCol) 
	{
		this.distAccForCol = distAccForCol;
	}

	public void setDistBtwBtnPlay(int distBtwBtnPlay) 
	{
		this.distBtwBtnPlay = distBtwBtnPlay;
	}

	public void setMinFrameWidth(int minFrameWidth)
	{
		this.minFrameWidth = minFrameWidth;
	}

	public void setMinFrameHeight(int minFrameHeight) 
	{
		this.minFrameHeight = minFrameHeight;
	}

	public void setDistBtwTopUfo(int distBtwTopUfo) 
	{
		this.distBtwTopUfo = distBtwTopUfo;
	}
}
