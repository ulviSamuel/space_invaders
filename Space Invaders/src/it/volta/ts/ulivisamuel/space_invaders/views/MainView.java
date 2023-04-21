package it.volta.ts.ulivisamuel.space_invaders.views;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import it.volta.ts.ulivisamuel.space_invaders.business.FrameResizedManager;
import it.volta.ts.ulivisamuel.space_invaders.business.KeyboardListener;
import it.volta.ts.ulivisamuel.space_invaders.main.Config;

@SuppressWarnings("serial")
public class MainView extends JFrame
{
	private JPanel     mainPanel;
	private JPanel     headerPanel;
	private JPanel     centerPanel;
	private JPanel     footerPanel;
	private PlayerView playerView;
	
	//---------------------------------------------------------------------------------------------
	
	public MainView()
	{
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\space_invaders_logo.png"));
		formatMainPanel();
		this.add(mainPanel);
		this.pack();
		this.addKeyListener(new KeyboardListener());
		this.addComponentListener(new FrameResizedManager());
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void formatMainPanel() 
	{
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
		mainPanel.setLayout(new BorderLayout());
		formatFooterPanel();
		mainPanel.add(footerPanel, BorderLayout.SOUTH);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void formatHeadrPanel()
	{
		
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void formatCenterPanel()
	{
		
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void formatFooterPanel()
	{
		footerPanel = new JPanel();
		footerPanel.setLayout(new BorderLayout());
		playerView = new PlayerView();
		footerPanel.add(playerView, BorderLayout.CENTER);
	}
}
