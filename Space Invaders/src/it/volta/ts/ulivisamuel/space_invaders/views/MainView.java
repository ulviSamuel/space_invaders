package it.volta.ts.ulivisamuel.space_invaders.views;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import it.volta.ts.ulivisamuel.space_invaders.business.FrameResizedManager;
import it.volta.ts.ulivisamuel.space_invaders.business.KeyboardListener;
import it.volta.ts.ulivisamuel.space_invaders.business.ShootButtonListener;
import it.volta.ts.ulivisamuel.space_invaders.main.Config;

@SuppressWarnings("serial")
public class MainView extends JFrame
{
	private JPanel     mainPanel;
	private JPanel     headerPanel;
	private JPanel     footerPanel;
	
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
		formatHeadrPanel();
		formatFooterPanel();
		mainPanel.add(headerPanel, BorderLayout.NORTH);
		mainPanel.add(footerPanel, BorderLayout.SOUTH);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void formatHeadrPanel()
	{
		headerPanel = new JPanel();
		headerPanel.setLayout(new BorderLayout());
		headerPanel.add(new AlienView(), BorderLayout.CENTER);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void formatFooterPanel()
	{
		footerPanel = new JPanel();
		footerPanel.setLayout(new BorderLayout());
		RocketView rocketView = Config.getInstance().getRocketView();
		rocketView.setVisible(false);
		footerPanel.add(rocketView, BorderLayout.NORTH);
		footerPanel.add(new PlayerView(), BorderLayout.CENTER);
		JButton shootButton = new JButton("Spara");
		shootButton.addActionListener(new ShootButtonListener());
		footerPanel.add(shootButton, BorderLayout.SOUTH);
	}
	
	//---------------------------------------------------------------------------------------------
	
	@Override
	public void setVisible(boolean b)
	{
		super.setVisible(b);
		this.requestFocusInWindow();
	}
}
