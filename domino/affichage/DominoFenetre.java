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

public class DominoFenetre extends JFrame{
		private int nbJoueur=2;
		private Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		private int hauteur = (int)tailleEcran.getHeight();
		private int largeur = (int)tailleEcran.getWidth();
		private int     xSourisClick;
		private int     ySourisClick;
		public DominoFenetre(){
			super();
			setTitle("Domino");
			setSize(hauteur,largeur); 
			setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
			setResizable(false); 
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
				setContentPane(buildContentPane());
			this.setVisible(true);
		}
		private JPanel buildContentPane(){
			Sac s=new Sac();
			Joueur j1=new Joueur("Tom",1,s);
			ArrayList main=new ArrayList();
			main=j1.getPiece();
			int n=main.size();
			JPanel panel1 = new JPanel();
			panel1.setLayout(new FlowLayout());
			panel1.setBackground(Color.black);
			s.afficheSac();	
			JButton[] btnNewButton = new JButton[n];
			int k=0;
			int i,j=0;
			//distribution des pièces au joueur 1:
			for(int m=0;m<n;m++){
				PieceD p=(PieceD) main.get(m);
			 	btnNewButton[k]=new JButton();
				i=p.getG();
				j=p.getD();
				String iconfilePath = this.getClass().getClassLoader().getResource("Dice"+i+j+".png").getFile();
				btnNewButton[k].setIcon(new ImageIcon(iconfilePath));
				btnNewButton[k].setBorder(BorderFactory.createEmptyBorder());
				btnNewButton[k].setContentAreaFilled(false);
				btnNewButton[k].setFocusable(false);
				panel1.add(btnNewButton[k]); 
				btnNewButton[k].addMouseMotionListener(new MesEvenementsSouris());
				btnNewButton[k].addMouseListener(new MesEvenementsSouris()); 
				k++;
			}
		
			JButton tourner=new JButton("tourner piece");
			panel1.add(tourner,BorderLayout.NORTH);
			return panel1;
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
 
		  public void mouseReleased(MouseEvent e) {}
 
		  public void mouseEntered(MouseEvent e) {}
 
		  public void mouseExited(MouseEvent e) {}
		}
	
 
}
