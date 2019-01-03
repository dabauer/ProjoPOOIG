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
			k++;
			
		}
		//panel1.addMouseListener(new MouseAdapter() {  
           /* public void mouseClicked(MouseEvent e) {              
                btnNewButton.show(panel, e.getX(), e.getY());  
            }                 
         });  */
		
		return panel1;
		}
}
