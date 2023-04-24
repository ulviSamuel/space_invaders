package it.volta.ts.ulivisamuel.space_invaders.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.volta.ts.ulivisamuel.space_invaders.business.FrameResizedManager;
import it.volta.ts.ulivisamuel.space_invaders.business.KeyboardListener;
import it.volta.ts.ulivisamuel.space_invaders.main.Config;

@SuppressWarnings("serial")
public class MainView extends JFrame
{
	private JPanel mainPanel;
	private JPanel headerPanel;
	private JPanel centerPanel;
	private JPanel footerPanel;
	private Config configInstance;
	
	//---------------------------------------------------------------------------------------------
	
	public MainView()
	{
		super("Space Invaders");
		configInstance = Config.getInstance();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\space_invaders_logo.png"));
		formatMainPanel();
		this.add(mainPanel);
		this.setMinimumSize(new Dimension(configInstance.getMinFrameWidth(), configInstance.getMinFrameHeight()));
		this.addKeyListener(new KeyboardListener());
		this.addComponentListener(new FrameResizedManager());
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void formatMainPanel() 
	{
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
		mainPanel.setLayout(new BorderLayout());
		formatHeaderPanel();
		formatCenterPanel();
		formatFooterPanel();
		mainPanel.add(headerPanel, BorderLayout.NORTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(footerPanel, BorderLayout.SOUTH);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void formatHeaderPanel()
	{
		headerPanel = new JPanel();
		headerPanel.setLayout(new BorderLayout());
		headerPanel.add(Box.createVerticalStrut(configInstance.getDistBtwTopUfo()), BorderLayout.NORTH);
		headerPanel.add(new AlienView(), BorderLayout.CENTER);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void formatCenterPanel()
	{
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		RocketView rocketView = configInstance.getRocketView();
		rocketView.setVerticalAlignment(JLabel.BOTTOM);
		rocketView.setVisible(false);
		centerPanel.add(rocketView, BorderLayout.CENTER);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void formatFooterPanel()
	{
		footerPanel = new JPanel();
		footerPanel.setLayout(new BorderLayout());
		footerPanel.add(configInstance.getPlayerView(), BorderLayout.NORTH);
		footerPanel.add(Box.createVerticalStrut(configInstance.getDistBtwBtnPlay()), BorderLayout.CENTER);
		JButton shootButton = configInstance.getShootButton();
		shootButton.addActionListener(e -> nullListener());
		shootButton.setOpaque(false);
		shootButton.setContentAreaFilled(false);
		shootButton.setBorderPainted(false);
		shootButton.setFocusPainted(false);
		JPanel panelTemp = new JPanel();
		panelTemp.add(shootButton);
		footerPanel.add(panelTemp, BorderLayout.SOUTH);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void nullListener()
	{
		this.requestFocusInWindow();
	}
	
	//---------------------------------------------------------------------------------------------
	
	@Override
	public void setVisible(boolean b)
	{
		super.setVisible(b);
		this.requestFocusInWindow();
	}
}
