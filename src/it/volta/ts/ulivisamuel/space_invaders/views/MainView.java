package it.volta.ts.ulivisamuel.space_invaders.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.volta.ts.ulivisamuel.space_invaders.business.FrameResizedManager;
import it.volta.ts.ulivisamuel.space_invaders.business.KeyboardListener;
import it.volta.ts.ulivisamuel.space_invaders.business.ShootButtonListener;
import it.volta.ts.ulivisamuel.space_invaders.main.Config;

@SuppressWarnings("serial")
public class MainView extends JFrame
{
	private JPanel mainPanel;
	private JPanel headerPanel;
	private JPanel centerPanel;
	private JPanel footerPanel;
	
	//---------------------------------------------------------------------------------------------
	
	public MainView()
	{
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\space_invaders_logo.png"));
		formatMainPanel();
		this.add(mainPanel);
		this.setMinimumSize(new Dimension(600, 500));
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
		headerPanel.add(new AlienView(), BorderLayout.CENTER);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void formatCenterPanel()
	{
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		RocketView rocketView = Config.getInstance().getRocketView();
		rocketView.setVerticalAlignment(JLabel.BOTTOM);
		rocketView.setVisible(false);
		centerPanel.add(rocketView, BorderLayout.CENTER);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void formatFooterPanel()
	{
		footerPanel = new JPanel();
		footerPanel.setLayout(new BorderLayout());
		footerPanel.add(new PlayerView(), BorderLayout.CENTER);
		JButton shootButton = Config.getInstance().getShootButton();
		shootButton.addActionListener(e -> nullListener());
		footerPanel.add(shootButton, BorderLayout.SOUTH);
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
