import java.awt.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;  
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.Image;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import java.util.*;

public class PuzzleFenetre extends JFrame{
		private Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		private int hauteur = (int)tailleEcran.getHeight();
		private int largeur = (int)tailleEcran.getWidth();
		private int     xSourisClick;
		private int     ySourisClick;
		public PuzzleFenetre(){
			super();
			setTitle("Puzzle");
			setSize(largeur,hauteur); 
			setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
			setResizable(false); 
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			setContentPane(buildContentPane());
			this.setVisible(true);
		}
		private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.black);
		affichePieces(panel);
		return panel;
		}
		/*charge les différentes pièces du puzzle : -1 pour bord,1 pour un bout qui sort et 0 pour un trou */
		/* il faut encore créer un rectangle de la taille final du puzzle et tester les connexions */
		public void affichePieces(JPanel pan){
			JButton b0=new JButton();
			String iconfilePath0 = this.getClass().getClassLoader().getResource("P01-1-1.png").getFile();
			b0.setIcon(new ImageIcon(iconfilePath0));
			b0.setBorder(BorderFactory.createEmptyBorder());
			b0.setContentAreaFilled(false);
			b0.setFocusable(false);
			pan.add(b0); 
			b0.addMouseMotionListener(new MesEvenementsSouris());
			b0.addMouseListener(new MesEvenementsSouris());
			JButton b1=new JButton();
			String iconfilePath1 = this.getClass().getClassLoader().getResource("P10-10.png").getFile();
			b1.setIcon(new ImageIcon(iconfilePath1));
			b1.setBorder(BorderFactory.createEmptyBorder());
			b1.setContentAreaFilled(false);
			b1.setFocusable(false);
			pan.add(b1); 
			b1.addMouseMotionListener(new MesEvenementsSouris());
			b1.addMouseListener(new MesEvenementsSouris());
			JButton b2=new JButton();
			String iconfilePath2 = this.getClass().getClassLoader().getResource("P0101.png").getFile();
			b2.setIcon(new ImageIcon(iconfilePath2));
			b2.setBorder(BorderFactory.createEmptyBorder());
			b2.setContentAreaFilled(false);
			b2.setFocusable(false);
			pan.add(b2); 
			b2.addMouseMotionListener(new MesEvenementsSouris());
			b2.addMouseListener(new MesEvenementsSouris()); 
			JButton b3=new JButton();
			String iconfilePath3 = this.getClass().getClassLoader().getResource("P101-1.png").getFile();
			b3.setIcon(new ImageIcon(iconfilePath3));
			b3.setBorder(BorderFactory.createEmptyBorder());
			b3.setContentAreaFilled(false);
			b3.setFocusable(false);
			pan.add(b3); 
			b3.addMouseMotionListener(new MesEvenementsSouris());
			b3.addMouseListener(new MesEvenementsSouris());
			JButton b4=new JButton();
			String iconfilePath4 = this.getClass().getClassLoader().getResource("P-1-101.png").getFile();
			b4.setIcon(new ImageIcon(iconfilePath4));
			b4.setBorder(BorderFactory.createEmptyBorder());
			b4.setContentAreaFilled(false);
			b4.setFocusable(false);
			pan.add(b4); 
			b4.addMouseMotionListener(new MesEvenementsSouris());
			b4.addMouseListener(new MesEvenementsSouris());
			JButton b5=new JButton();
			String iconfilePath5 = this.getClass().getClassLoader().getResource("P-110-1.png").getFile();
			b5.setIcon(new ImageIcon(iconfilePath5));
			b5.setBorder(BorderFactory.createEmptyBorder());
			b5.setContentAreaFilled(false);
			b5.setFocusable(false);
			pan.add(b5); 
			b5.addMouseMotionListener(new MesEvenementsSouris());
			b5.addMouseListener(new MesEvenementsSouris());
			JButton b6=new JButton();
			String iconfilePath6 = this.getClass().getClassLoader().getResource("P-1010.png").getFile();
			b6.setIcon(new ImageIcon(iconfilePath6));
			b6.setBorder(BorderFactory.createEmptyBorder());
			b6.setContentAreaFilled(false);
			b6.setFocusable(false);
			pan.add(b6); 
			b6.addMouseMotionListener(new MesEvenementsSouris());
			b6.addMouseListener(new MesEvenementsSouris());
			JButton b7=new JButton();
			String iconfilePath7 = this.getClass().getClassLoader().getResource("P1-110.png").getFile();
			b7.setIcon(new ImageIcon(iconfilePath7));
			b7.setBorder(BorderFactory.createEmptyBorder());
			b7.setContentAreaFilled(false);
			b7.setFocusable(false);
			pan.add(b7); 
			b7.addMouseMotionListener(new MesEvenementsSouris());
			b7.addMouseListener(new MesEvenementsSouris());
			JButton b8=new JButton();
			String iconfilePath8 = this.getClass().getClassLoader().getResource("P0-1-11.png").getFile();
			b8.setIcon(new ImageIcon(iconfilePath8));
			b8.setBorder(BorderFactory.createEmptyBorder());
			b8.setContentAreaFilled(false);
			b8.setFocusable(false);
			pan.add(b8); 
			b8.addMouseMotionListener(new MesEvenementsSouris());
			b8.addMouseListener(new MesEvenementsSouris());
		}
		public class MesEvenementsSouris implements MouseMotionListener, MouseListener {
		   public void mouseMoved(MouseEvent e) {}
 
		   public void mouseDragged(MouseEvent e) {
      		   e.getComponent().setLocation(e.getComponent().getX() + e.getX() - xSourisClick, 
				                          e.getComponent().getY() + e.getY() - ySourisClick);
    		 }
 
        	  public void mouseClicked(MouseEvent e) {}
 
		  public void mousePressed(MouseEvent e) {
           	 		xSourisClick = e.getX();
				ySourisClick = e.getY();
		  }
 
		  public void mouseReleased(MouseEvent e) {
			//vérifier ici si la connexion est valide ou pas (à écrire en utilisant une fonction déjà écrite)
			//sinon erreur et pioche
			}
 
		  public void mouseEntered(MouseEvent e) {}
 
		  public void mouseExited(MouseEvent e) {}
		}
}
