
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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Strona_startowa extends JFrame {
	private Losowanie L;
	private int ii;
	private int jj;
	private int dlaGraczaKarty[][];
	private int dlaKrukieraKarty[][];

	public Strona_startowa() {
		super("BlackJack");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 600);
		setLocation(350, 150);
		dlaGraczaKarty = new int[13][4];
		dlaKrukieraKarty = new int[13][4];
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				dlaGraczaKarty[i][j] = 0;
				dlaKrukieraKarty[i][j] = 0;
			}
		}

		// Krukier

		JPanel Krukier = new JPanel();
		Krukier.setPreferredSize(new Dimension(180, 120));
		add(BorderLayout.NORTH, Krukier);
		Krukier.add(BorderLayout.NORTH, new JLabel("KRUKIER"));

		// Gracz

		JPanel Gracz = new JPanel();
		Gracz.setPreferredSize(new Dimension(180, 120));
		add(BorderLayout.SOUTH, Gracz);
		Gracz.add(BorderLayout.SOUTH, new JLabel("GRACZ"));

		// Liczydlo player
		JLabel sumaP = new JLabel();
		Deck aDeck = new Deck();
		Gracz.add(sumaP);

		// Liczydlo kruk
		JLabel sumaK = new JLabel();
		Krukier.add(sumaK);

		// HIT
		JButton Hit = new JButton("HIT");
		add(BorderLayout.EAST, Hit);

		// Stand
		JButton Stand = new JButton("Stand");
		add(BorderLayout.WEST, Stand);

		// przyciski pod karty
		JButton dlagracza[];
		dlagracza = new JButton[10];

		JButton dlakrukiera[];
		dlakrukiera = new JButton[10];

		// los
		L = new Losowanie();
		L.losujGracz(2);

		// do hita //all cards player
		int a = 0;
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				if (L.getGracz()[i][j] == 1) {
					dlaGraczaKarty[i][j] = 1;
				}
			}
		}

		String suma1 = "" + aDeck.suma(dlaGraczaKarty);
		sumaP.setText(suma1);

		// krukier pamiec

		String suma2 = "" + aDeck.suma(dlaKrukieraKarty);
		sumaK.setText(suma2);

		// karty gracza
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				if (L.getGracz()[i][j] == 1) {
					String zm = j + "" + i + ".jpg";
					ImageIcon karty = new ImageIcon(zm);
					dlagracza[a] = new JButton();
					dlagracza[a].setIcon(karty);
					Gracz.add(dlagracza[a]);
					a++;
				}
			}
		}

		// Losowanie L1=new Losowanie();
		L.losujKrukier(2);
		// all cards Krukiera
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				if (L.getKrukier()[i][j] == 1) {
					dlaKrukieraKarty[i][j] = 1;
				}
			}
		}

		// karty krukiera

		int b = 0;

		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				if (L.getKrukier()[i][j] == 1) {
					if (b == 0) {
						ImageIcon odwrocona = new ImageIcon("hideandseek.jpg");
						dlakrukiera[b] = new JButton();
						dlakrukiera[b].setIcon(odwrocona);
						Krukier.add(dlakrukiera[b]);
						ii = i;
						jj = j;
						b++;
					} else {
						String zm = j + "" + i + ".jpg";
						ImageIcon karty = new ImageIcon(zm);
						dlakrukiera[b] = new JButton();
						dlakrukiera[b].setIcon(karty);
						Krukier.add(dlakrukiera[b]);
						b++;
					}
				}
			}
		}
		setVisible(true);
		// przycisk hit
		Hit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				L.losujGracz(1);
				int c = 0;
				for (int i = 0; i < 13; i++) {
					for (int j = 0; j < 4; j++) {
						if (L.getGracz()[i][j] == 1) {
							if (dlaGraczaKarty[i][j] != 1) {
								String zm = j + "" + i + ".jpg";
								ImageIcon karty = new ImageIcon(zm);
								dlagracza[c] = new JButton();
								dlagracza[c].setIcon(karty);
								Gracz.add(dlagracza[c]);
								c++;
								dlaGraczaKarty[i][j] = 1;
							}
						}
					}
				}
				String suma1 = "" + aDeck.suma(dlaGraczaKarty);
				sumaP.setText(suma1);

				setVisible(true);

			}
		});
		// przycisk stand
		Stand.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String zm1 = jj + "" + ii + ".jpg";
				ImageIcon seek = new ImageIcon(zm1);
				dlakrukiera[0].setIcon(seek);
				// for (int i = 0; i < 13; i++) {
				// for (int j = 0; j < 4; j++) {
				// System.out.print(dlaKrukieraKarty[i][j] + " ");
				// }
				// System.out.println();
				// }
				// System.out.println(aDeck.suma(dlaKrukieraKarty));
				String suma2 = "" + aDeck.suma(dlaKrukieraKarty);
				sumaK.setText(suma2);
				setVisible(true);
				int d = 0;
				while (aDeck.suma(dlaKrukieraKarty) <= 17) {
					L.losujKrukier(1);
					for (int i = 0; i < 13; i++) {
						for (int j = 0; j < 4; j++) {
							if (L.getKrukier()[i][j] == 1) {
								if (dlaKrukieraKarty[i][j] != 1) {
									String zm = j + "" + i + ".jpg";
									ImageIcon karty = new ImageIcon(zm);
									dlakrukiera[d] = new JButton();
									dlakrukiera[d].setIcon(karty);
									Krukier.add(dlakrukiera[d]);
									d++;
									dlaKrukieraKarty[i][j] = 1;
								}
							}
						}
					}
				}
				suma2 = "" + aDeck.suma(dlaKrukieraKarty);
				sumaK.setText(suma2);
				setVisible(true);
				if (aDeck.suma(dlaKrukieraKarty) > 21 || aDeck.suma(dlaKrukieraKarty) < aDeck.suma(dlaGraczaKarty)) {
					EventQueue.invokeLater(new Runnable() {
						@Override
						public void run() {

							new Wygrana("Wygrana!");

						}
					});
				}
				if (aDeck.suma(dlaKrukieraKarty) == aDeck.suma(dlaGraczaKarty)) {
					EventQueue.invokeLater(new Runnable() {
						@Override
						public void run() {

							new Wygrana("Remis!");

						}
					});
				}
				if (aDeck.suma(dlaGraczaKarty) < aDeck.suma(dlaKrukieraKarty) && aDeck.suma(dlaKrukieraKarty) <= 21) {
					EventQueue.invokeLater(new Runnable() {
						@Override
						public void run() {

							new Wygrana("Przegrana!");

						}
					});
				}
				if (aDeck.suma(dlaGraczaKarty) > 21) {
					EventQueue.invokeLater(new Runnable() {
						@Override
						public void run() {

							new Wygrana("Przegrana!");

						}
					});
				}

			}
		});

	}

}
