import java.util.*;
import java.math.*;
//package ProjoPOOIG.domino.jeu;
//import domino.pieces.PieceD;
//import ProjoPOOIG.domino.jeu;

public class Joueur{
	private String nom;
	private ArrayList<PieceD> main;
	private boolean situation=true; //true si joue encore false si perdu
	//private int nbPoints=0;
	private int indice; //numéro de tour du joueur
	public Joueur(String nom,int i,Sac s){
		this.nom=nom;
		indice=i;
		main=new ArrayList<PieceD>();
		service(s);
		//puis autres fonctions
		//ajouterPoint();
		//perdu();
		//remplir ou vider main 
	}
	public ArrayList<PieceD> service(Sac s){
		int [] t=new int[7];
		int n=-1;
		PieceD p;
		for(int i=0;i<7;i++){
			n=(int)(Math.random()*s.getNbPieces());
			t[i]=n;
			System.out.println(t[i]);
			p=s.distribuPiece(n);
			main.add(p);
			s.enleverPieceSac(n);
		}
		
		return main;
	}
	public PieceD piocher(Sac s){
		int n=-1;
		PieceD p;
		n=(int)(Math.random()*s.getNbPieces());
		
		p=s.distribuPiece(n);
		System.out.println(p.getG()+" "+p.getD());
		main.add(p);
		s.enleverPieceSac(n);
		return p;
	}
	public ArrayList<PieceD> getPiece(){
		return main;
	}
		
}

