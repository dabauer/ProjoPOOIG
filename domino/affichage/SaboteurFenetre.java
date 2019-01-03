import java.awt.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

package domino.affichage;

public class SaboteurFenetre extends JFrame{
		private Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		private int hauteur = (int)tailleEcran.getHeight();
		private int largeur = (int)tailleEcran.getWidth();
		public SaboteurFenetre(){
			super();
			setTitle("Saboteur");
			setSize(hauteur,largeur);
			setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			buildContentPane();
			this.setVisible(true);
		}
		private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.white);
		return panel;
		}
}
