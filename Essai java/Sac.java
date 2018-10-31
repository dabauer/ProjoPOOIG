import java.util.*;
public class Sac{
	private ArrayList<Piece> sac;
	private static int nbPieces=28;
	public Sac(){
		sac=new ArrayList<Piece>();
		remplirSac();
	}
	public void remplirSac(){ //fonction qui change en fonction du type de pièce
		Piece p;
		//int ref=0;
		for(int i=0;i<7;i++){
			for(int j=i;j<7;j++){
				p=new Piece(i,j,"");
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
	public Piece distribuPiece(int i){
		Piece p=sac.get(i);
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
