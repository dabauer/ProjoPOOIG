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
import javax.swing.BoxLayout;
public class DominoFenetre extends JFrame{
		private GroupePieceD gp;
		private PieceD [] selected=new PieceD[2];
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
		private ArrayList<PieceD> main=j1.getPiece();
		public DominoFenetre(){
			super();
			setTitle("Domino");
			setSize(largeur,hauteur); 
			setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
			setResizable(false); 
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
				//setContentPane(buildContentPane());
			
		/*}
		private JPanel buildContentPane(){*/
			
			JPanel panel1 = new JPanel();
			
			 panel1.setLayout(new BoxLayout(panel1, BoxLayout.LINE_AXIS));
			panel1.setBackground(Color.black);
			s.afficheSac();	
			JButton tourner=new JButton("tourner piece");
			panel1.add(tourner,BorderLayout.NORTH);
			JButton piocher=new JButton("pioche");
			panel1.add(piocher,BorderLayout.NORTH);
			
			afficheMain(panel1);
			JButton b=pioche(piocher);
			panel1.add(b);
			
			JPanel panel2 = new JPanel();

  		  //Idem pour cette ligne

 		   panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
			panel2.setBackground(new Color(255,255,255));
  		  //panel2.add(new JButton("Bouton 2"));
			racine(panel2);
  		  // juste pour vérifier si ça marche panel2.add(new JButton("Bouton 3"));
			if(selected[0]!=null && selected[1]!=null){
				if(selected[0].peuventSeConnecter(selected[1])) {
					gp.ajouterPiece(selected[0]);
					j1.Poser(selected[0]);
					afficheGroupePiece(panel2);
				}
				else{
				JLabel erreur=new JLabel("erreur mauvaise connexion");
				panel2.add(erreur);
				afficheGroupePiece(panel2);}
			}
			JPanel b3 = new JPanel();
   			 //On positionne maintenant ces trois lignes en colonne
   			 b3.setLayout(new BoxLayout(b3, BoxLayout.PAGE_AXIS));
   			 b3.add(panel1);
   			 b3.add(panel2);
			this.getContentPane().add(b3);

    			this.setVisible(true);
		}
		//pioche du joueur
		public PieceD Pioche(Joueur j1){
					return j1.piocher(s);
				
			}
		//methode qui permet de poser la première pièce
		public void racine(JPanel pan){
			int n=-1;
			PieceD p;
			n=(int)(Math.random()*s.getNbPieces());
			JButton btnNewButton =new JButton();	
			p=s.distribuPiece(n);
			int i=p.getG();
			int j=p.getD();
			String iconfilePath = this.getClass().getClassLoader().getResource("Dice"+i+j+".png").getFile();
			btnNewButton.setIcon(new ImageIcon(iconfilePath));
			btnNewButton.setBorder(BorderFactory.createEmptyBorder());
			pan.add(btnNewButton);
			btnNewButton=event(btnNewButton,p);
			gp=new GroupePieceD(p);
			s.enleverPieceSac(n);
			
		}
		//réactualise le plateau
		public void afficheGroupePiece(JPanel pan){
			Piece[] pieces=gp.getPieces ();
			int i,j;
			int m=0;
			JButton b[]=new JButton[28];
			for(int k=0;k<pieces.length;k++){
				PieceD p=(PieceD) pieces[k];
				b[m]=new JButton();
				i=p.getG();
				j=p.getD();
				String iconfilePath = this.getClass().getClassLoader().getResource("Dice"+i+j+".png").getFile();
				b[m].setIcon(new ImageIcon(iconfilePath));
				b[m].setBorder(BorderFactory.createEmptyBorder());
				b[m].setContentAreaFilled(false);
				b[m].setFocusable(false);
				b[m].setPreferredSize((new Dimension(hauteur/8,largeur/28))); 
				 pan.add(b[m]);
				m++;
				}
		}
				
		//evenement quand le bouton pioche est pressé
		public JButton pioche(JButton c){
			JButton b=new JButton();
			c.addActionListener(new ActionListener(){  
           			 public void actionPerformed(ActionEvent e) 					{              
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
				}
			});
			return b;
		}
		//affiche les dominos qu'a le joueur
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
				btnNewButton[k].setPreferredSize((new Dimension(hauteur/8,largeur/28))); 
				 panel1.add(btnNewButton[k]);
				btnNewButton[k]=event(btnNewButton[k],p);
				
				//btnNewButton[k].addMouseMotionListener(new MesEvenementsSouris());
				//btnNewButton[k].addMouseListener(new MesEvenementsSouris()); 
				k++;
			}
		}
		//met en vert les pieces selectionnées
		public JButton event (JButton b,PieceD p){
			b.addActionListener(new ActionListener(){  
           			 public void actionPerformed(ActionEvent e) {     
					b.setBorder(BorderFactory.createLineBorder(Color.GREEN));
					if(selected[0]==null)
						selected[0]=p;
					else
						selected[1]=p;
				}
				});
			return b;
		}
		/*public class MesEvenementsSouris implements MouseMotionListener, MouseListener {
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
		}*/
	
 
}
