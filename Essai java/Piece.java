public class Piece{
	private int[]piece;
	private int déDroite;
	private int déGauche;
	private String position;
	public Piece(int i,int j,String p){
		déGauche=i;
		déDroite=j;
		piece=new int [2];
		piece[0]=i;
		piece[1]=j;
		position=p;
	}
	public int getGauche(){
		return this.déGauche;
	}
	public int getDroite(){
		return this.déDroite;
	}
	public String getPosition(){
		return this.position;
	}
	public String toString(){
		return déGauche+"|"+déDroite;
	}
}
	
	

