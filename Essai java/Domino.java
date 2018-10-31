public class Domino{
	public static void main(String[]args){
		Sac s=new Sac();
		s.afficheSac();
		Joueur j1=new Joueur("Tom",1,s);
		j1.affiche();
		//s.afficheSac();
		System.out.println("****************************");
		Joueur j2=new Joueur("John",2,s);
		j2.affiche();
		System.out.println("pieces restantes dans le sac:");
		s.afficheSac();
	}
	
}
