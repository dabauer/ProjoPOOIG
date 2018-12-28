/**
* Classe test pour rassembler tous les tests, une fois un test reussi, on ajoute le resultat et on met le test en commentaire
* Pour l'affichage du resultat on donne la methode testée, a: [le resultat attendu] r: [le resultat]
*/
public class Test {


	public static void main (String [] args) {
		//testsPieceConnexion();
		testsPieceD();
	}

	public static void testsPieceConnexion() {
		Piece a = new Piece ();
		Piece b = new Piece ();

		Connexion a1 = new Connexion (1,a);
		Connexion a2 = new Connexion (1,a);
		Connexion [] al = new Connexion [0];

		/*
		//test toString connexion OK
		System.out.println("Test toString Connexion r:" + a1);

		//test toString piece OK
		System.out.println("Test toString Piece r:" + a);
		*/

		//test pour addCoToList() OK
		al = a1.addCoToList(al);
		al = a2.addCoToList(al);
		System.out.println("Test addCoToList, a:2 r:" + al.length); // r:2

		//test pour getCo(), getCo(int) OK
		System.out.println("Test getCo(), getCo(int) a:toString d'une co, r:" + a.getCo(0));

		// test pour getCoLibres, getCoNonLibres, getNbCoLibres, getNbCoNonLibres,
		// aCoLibres, aCoNonLibres OK OK
		System.out.print("Test getCoLibres, getCoNonLibres, getNbCoLibres, getNbCoNonLibres, aCoLibres, aCoNonLibres a:true false r:");
		System.out.println("" + a.aCoLibres() + a.aCoNonLibres());
		//ajouterPiece(Connexion, Connexion)
		a.ajouterPiece(a.getCo(1),b.getCo(0));
		System.out.print("Test ajouterPiece(conn,conn) a:truetrue r:");
		System.out.println("" + a.aCoLibres() + a.aCoNonLibres());
	}

	public static void testsPieceD() {
		Piece a = new PieceD (1,2);
		Piece b = new PieceD (1,2);

		Connexion a1 = new Connexion (1,a);
		Connexion a2 = new Connexion (1,a);
		Connexion [] al = new Connexion [0];

		/*
		//test toString connexion OK
		System.out.println("Test toString Connexion r:" + a1);

		//test toString piece OK
		System.out.println("Test toString Piece r:" + a);
		*/

		//test pour addCoToList() OK
		al = a1.addCoToList(al);
		al = a2.addCoToList(al);
		System.out.println("Test addCoToList, a:2 r:" + al.length); // r:2

		//test pour getCo(), getCo(int) OK
		System.out.println("Test getCo(), getCo(int) a:toString d'une co, r:" + a.getCo(0));

		// test pour getCoLibres, getCoNonLibres, getNbCoLibres, getNbCoNonLibres,
		// aCoLibres, aCoNonLibres OK OK
		System.out.print("Test getCoLibres, getCoNonLibres, getNbCoLibres, getNbCoNonLibres, aCoLibres, aCoNonLibres a:true false r:");
		System.out.println("" + a.aCoLibres() + a.aCoNonLibres());
		//ajouterPiece(Connexion, Connexion)
		a.ajouterPiece(a.getCo(1),b.getCo(0));
		System.out.print("Test ajouterPiece(conn,conn) a:truetrue r:");
		System.out.println("" + a.aCoLibres() + a.aCoNonLibres());
	}

}
