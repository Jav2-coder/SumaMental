package net.javierjimenez;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class App {

	private JLabel lblOperacio = new JLabel("Operacio");
	
	private JFrame frame;
	
	private static int NUM_MAX = 100;
	
	private int valor1 = 0;
	
	private int valor2 = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Random rnd = new Random();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblTitol = new JLabel("Quan dóna...");
		GridBagConstraints g = new GridBagConstraints();
		g.fill = GridBagConstraints.BOTH;
		
		g.weightx = 0.5;
		g.weighty = 1;
		
		g.gridwidth = 1;
		g.gridheight = 1;
		
		g.gridx = 0;
		g.gridy = 0;
		
		frame.getContentPane().add(lblTitol, g);
		g.fill = GridBagConstraints.BOTH;

		g.weightx = 0.5;
		g.weighty = 1.5;

		g.gridwidth = 1;
		g.gridheight = 1;

		g.gridx = 0;
		g.gridy = 1;
		frame.getContentPane().add(lblOperacio, g);
		
		JLabel lblError = new JLabel("");
		g.fill = GridBagConstraints.BOTH;
		
		g.weightx = 0.5;
		g.weighty = 0.5;
		
		g.gridwidth = 1;
		g.gridheight = 1;
		
		g.gridx = 0;
		g.gridy = 2;
		
		frame.getContentPane().add(lblError, g);
		
		JTextField resposta = new JTextField("");
		g.fill = GridBagConstraints.BOTH;

		g.weightx = 0.5;
		g.weighty = 0.5;

		g.gridwidth = 1;
		g.gridheight = 1;

		g.gridx = 0;
		g.gridy = 3;
		frame.getContentPane().add(resposta, g);
		
		JButton buttonPnt = new JButton(".");
		g.fill = GridBagConstraints.BOTH;

		g.weightx = 0.5;
		g.weighty = 0.5;

		g.gridwidth = 1;
		g.gridheight = 1;

		g.gridx = 0;
		g.gridy = 4;
		frame.getContentPane().add(buttonPnt, g);
		
		buttonPnt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame finalFrame = new JFrame();
				finalFrame.setVisible(true);
				finalFrame.setBounds(150, 150, 400, 200);
				finalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JButton closeAll = new JButton("Aceptar");
				finalFrame.getContentPane().add(closeAll);
				
				closeAll.addActionListener(new ActionListener () {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						finalFrame.dispose();
					}
				});
			}
		});
		
		
	}
}
