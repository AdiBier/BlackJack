

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Wygrana extends JFrame {


	public Wygrana(String nazwa) {
		super("BlackJack");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 150);
		setLocation(820, 350);
		JTextField wygrana =new JTextField(nazwa);
		JPanel wynik = new JPanel();
		wynik.setPreferredSize(new Dimension(180, 120));
		add(BorderLayout.CENTER, wynik);
		wynik.add(wygrana);

	setVisible(true);

	}

}
