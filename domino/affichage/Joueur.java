import java.util.*;
import java.math.*;

//import domino.pieces.PieceD;


public class Joueur{
	private String nom;
	private ArrayList<Piece> main;
	private boolean situation=true; //true si joue encore false si perdu
	//private int nbPoints=0;
	private int indice; //numéro de tour du joueur
	public Joueur(String nom,int i,Sac s){
		this.nom=nom;
		indice=i;
		main=new ArrayList<Piece>();
		service(s);
		//puis autres fonctions
		//ajouterPoint();
		//perdu();
		//remplir ou vider main 
	}
	public ArrayList<Piece> service(Sac s){
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
	public ArrayList<Piece> getPiece(){
		return main;
	}
		
}

