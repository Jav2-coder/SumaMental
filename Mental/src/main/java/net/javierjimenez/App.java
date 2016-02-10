package net.javierjimenez;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Insets;

public class App {

	private JLabel lblCalculadora = new JLabel("0");
	
	private JFrame frame;

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
		
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		frame.getContentPane().setLayout(gridBagLayout);
		
		JButton btnHola = new JButton("Hola");
		GridBagConstraints gbc_btnHola = new GridBagConstraints();
		gbc_btnHola.insets = new Insets(0, 0, 0, 5);
		gbc_btnHola.gridx = 0;
		gbc_btnHola.gridy = 0;
		frame.getContentPane().add(btnHola, gbc_btnHola);
		
		lblCalculadora.setBackground(Color.gray);
		lblCalculadora.setForeground(Color.BLACK);
		lblCalculadora.setOpaque(true);
		GridBagConstraints g = new GridBagConstraints();
		g.fill = GridBagConstraints.BOTH;

		g.weightx = 0.5;
		g.weighty = 0.5;

		g.gridwidth = 3;
		g.gridheight = 1;

		g.gridx = 1;
		g.gridy = 0;
		frame.getContentPane().add(lblCalculadora, g);
	}
}
