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
public class DominoFenetre extends JFrame{
		private int nbJoueur=2;
		private Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		private int hauteur = (int)tailleEcran.getHeight();
		private int largeur = (int)tailleEcran.getWidth();
		private int     xSourisClick;
		private int     ySourisClick;
		private Sac s=new Sac();
		private Joueur j1=new Joueur("Tom",1,s);
		private int k=0;
		private int[] tab={-1,-1};
		private ArrayList<PieceD> main=main=j1.getPiece();
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
			JPanel panel1 = new JPanel();
			
			panel1.setLayout(new FlowLayout());
			panel1.setBackground(Color.black);
			s.afficheSac();	
			JButton tourner=new JButton("tourner piece");
			panel1.add(tourner,BorderLayout.NORTH);
			JButton piocher=new JButton("pioche");
			panel1.add(piocher,BorderLayout.NORTH);
			piocher.addActionListener(new ActionListener(){  
           			 public void actionPerformed(ActionEvent e) {              
                			PieceD p=Pioche(j1);
					JButton b=new JButton("");
					int i,j;
					i=p.getG();
					j=p.getD();
					String iconfilePath = this.getClass().getClassLoader().getResource("Dice"+i+j+".png").getFile();
					b.setIcon(new ImageIcon(iconfilePath));
					b.setBorder(BorderFactory.createEmptyBorder());
					b.setContentAreaFilled(false);
					b.setFocusable(false);
					panel1.add(b);
					/*bizarre le joueur pioche bien une piece(voir message affiche dans le terminal)mais la nouvelle piece n'apparait pas*/
           			 }  
			
           		}); 
			afficheMain(panel1);
			
			return panel1;
		}
		public PieceD Pioche(Joueur j1){
					return j1.piocher(s);
				
			}
		
		public void afficheMain(JPanel panel1){
			main=j1.getPiece();	
			int i,j=0;
			int n=main.size();
			JButton[] btnNewButton = new JButton[28];
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
