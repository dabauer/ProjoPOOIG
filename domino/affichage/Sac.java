import java.util.*;


import domino.piece.*;

package domino.affichage;


public class Sac{
	private ArrayList<PieceD> sac;
	private static int nbPieces=28;
	public Sac(){
		sac=new ArrayList<PieceD>();
		remplirSac();
	}
	public void remplirSac(){
		PieceD p;
		//int ref=0;
		for(int i=0;i<7;i++){
			for(int j=i;j<7;j++){
				p=new PieceD(i,j);
				sac.add(p);
				//ref++;
				//System.out.println(ref+" "+i+"|"+j);
			}
		}
	}
	public int getNbPieces(){
		return nbPieces;
	}

	public void enleverPieceSac(int i){
		nbPieces--;
		sac.remove(i);
	}
	public PieceD distribuPiece(int i){
		PieceD p=sac.get(i);
		return p;
	}
	public void afficheSac(){
		int ref=0;
		for(int i=0;i<sac.size();i++){
			ref++;
			System.out.println(ref+" "+sac.get(i));
		}
	}
}
