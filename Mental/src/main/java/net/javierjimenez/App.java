package net.javierjimenez;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class App {

	private JLabel lblOperacio = new JLabel("", SwingConstants.CENTER);
	
	private JLabel lblError = new JLabel("", SwingConstants.CENTER);

	private JLabel lblSegons = new JLabel("0", SwingConstants.CENTER);

	private JFrame frame;

	private String[] operacions = { "+", "-", "*" };

	private int NUM_MAX = 10;

	private int valor1, valor2, resultat;

	private int seg = 0;

	private int cont = 0;

	Random rnd = new Random();

	String signe;

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

		Timer time = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seg = seg + 1;
				String temps = String.valueOf(seg);
				lblSegons.setText(temps);
			}
		});

		time.start();

		frame = new JFrame();
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		frame.getContentPane().setLayout(gridBagLayout);
		GridBagConstraints g = new GridBagConstraints();

		lblOperacio.setFont(new Font("Serif", Font.BOLD, 25));

		valor1 = rnd.nextInt(NUM_MAX + 1);
		valor2 = rnd.nextInt(NUM_MAX) + 1;

		signe = operacions[rnd.nextInt(operacions.length)];

		String val1 = String.valueOf(valor1);
		String val2 = String.valueOf(valor2);

		lblOperacio.setText(val1 + signe + val2);
		g.fill = GridBagConstraints.BOTH;

		g.weightx = 0.5;
		g.weighty = 1.5;

		g.gridwidth = 1;
		g.gridheight = 1;

		g.gridx = 0;
		g.gridy = 1;
		frame.getContentPane().add(lblOperacio, g);

		JLabel lblTitol = new JLabel("Quan dóna...", SwingConstants.CENTER);
		lblTitol.setFont(new Font("Serif", Font.PLAIN, 35));
		g.fill = GridBagConstraints.BOTH;

		g.weightx = 0.5;
		g.weighty = 1;

		g.gridwidth = 1;
		g.gridheight = 1;

		g.gridx = 0;
		g.gridy = 0;

		frame.getContentPane().add(lblTitol, g);

		lblError.setFont(new Font("Serif", Font.BOLD, 15));
		lblError.setForeground(Color.red);
		g.fill = GridBagConstraints.BOTH;

		g.weightx = 0.5;
		g.weighty = 0.5;

		g.gridwidth = 1;
		g.gridheight = 1;

		g.gridx = 0;
		g.gridy = 2;

		frame.getContentPane().add(lblError, g);

		JTextField resposta = new JTextField("");
		resposta.setHorizontalAlignment(JTextField.CENTER);
		g.fill = GridBagConstraints.BOTH;

		g.weightx = 0.5;
		g.weighty = 0.5;

		g.gridwidth = 1;
		g.gridheight = 1;

		g.gridx = 0;
		g.gridy = 3;
		frame.getContentPane().add(resposta, g);

		JButton buttonPnt = new JButton("Fet!");
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

				if (cont == 2) {

					time.stop();

					JOptionPane.showMessageDialog(frame, "Has trigat " + String.valueOf(seg) + " segons.",
							"Felicitats!", JOptionPane.PLAIN_MESSAGE);

					System.exit(0);

				} else {
						
					resultatOperacio(resposta.getText());
					
				}
			}

		});

		g.fill = GridBagConstraints.BOTH;

		g.weightx = 0.5;
		g.weighty = 1.5;

		g.gridwidth = 1;
		g.gridheight = 1;

		g.gridx = 0;
		g.gridy = 5;
		frame.getContentPane().add(lblSegons, g);
	}

	private void resultatOperacio(String r) {

		switch(signe){
		case "+":
			resultat = valor1 + valor2;
			break;
		case "-":
			resultat = valor1 - valor2;
			break;
		case "*":
			resultat = valor1 * valor2;
			break;
		}
		
		if(r.equals(String.valueOf(resultat))){
			cont++;
			
			valor1 = rnd.nextInt(NUM_MAX + 1);
			valor2 = rnd.nextInt(NUM_MAX) + 1;

			signe = operacions[rnd.nextInt(operacions.length)];

			String val1 = String.valueOf(valor1);
			String val2 = String.valueOf(valor2);

			lblOperacio.setText(val1 + signe + val2);
			lblError.setText("");
		} else {
			lblError.setText("Error: Resposta incorrecta!");
		}
	}
}
