
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
         public class MenuFenetre extends JFrame{ 
		private Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		private int hauteur = (int)tailleEcran.getHeight();
		private int largeur = (int)tailleEcran.getWidth();
		public MenuFenetre(){
		super();
		
		build();//On initialise notre fenêtre
		}
	
		private void build(){
		setTitle("Menu"); 
		setSize(hauteur,largeur); 
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(false); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setContentPane(buildContentPane());
	}
 		
            private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.white);
             JButton Domino = new JButton("Domino"); 
		Domino.setPreferredSize((new Dimension(hauteur/4,largeur/4))); 
             JButton DominoG = new JButton("Domino Gommettes"); 
		DominoG.setPreferredSize((new Dimension(hauteur/4,largeur/4)));  
             JButton Puzzle =new JButton("Puzzle");  
		Puzzle.setPreferredSize((new Dimension(hauteur/4,largeur/4))); 
	     JButton Saboteur = new JButton("Saboteur");
		Saboteur.setPreferredSize((new Dimension(hauteur/4,largeur/4))); 
             panel.add(Domino,BorderLayout.NORTH); panel.add(DominoG); panel.add(Puzzle);   panel.add(Saboteur); 
		  
	   
          
	 
	 
	Domino.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e) {              
             new DominoFenetre();  
         }  
        });  
        DominoG.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {              
                new DominoGFenetre();    
            }  
           });  
        Puzzle.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {              
                 new PuzzleFenetre(); 
            }  
           }); 
	 Saboteur.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {              
                new SaboteurFenetre(); 
            }  
           });  
	return panel;
     	} 
public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				MenuFenetre fenetre = new MenuFenetre();
				fenetre.setVisible(true);
			}
		});
	}
   }

