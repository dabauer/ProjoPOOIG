/**
* Classe test pour rassembler tous les tests, une fois un test reussi, on ajoute le resultat et on met le test en commentaire
* Pour l'affichage du resultat on donne la methode testée, a: [le resultat attendu] r: [le resultat]
*/

import domino.pieces.*;
import domino.pieces.GroupePiece;
public class Test {


	public static void main (String [] args) {
		//testsPieceConnexion();
		//testsPieceD();
		//testsPieceP();
		testsGroupePiece();
	}

	public static void testsGroupePiece() {
		GroupePiece a = new GroupePiece(new PieceG(1,2,1,2));
		Piece aa = new PieceG(1,2,1,2);
		Connexion [] colibres = a.getCoCorresLibres(aa);
		System.out.println(colibres.length);
		//a.ajouterPiece(aa,colibres[0]);
		//System.out.println(a.getPieces().length);
	}

	public static void testsPieceConnexion() {
		System.out.println("=======PIECE&CONNEXION=====");
		Piece a = new Piece (1,2);
		Piece b = new Piece (1,2);

		/*
		Connexion a1 = new Connexion (1,a);
		Connexion a2 = new Connexion (1,a);
		Connexion [] al = new Connexion [0];


		//test toString connexion OK
		System.out.println("Test toString Connexion r:" + a1);
		*/
		//test toString piece OK
		System.out.println("Test toString Piece r:" + a);


		/*
		//test valCoEstEgal() OK
		Connexion c1 = new Connexion (1,a);
		Connexion c2 = new Connexion (1,b);
		Connexion c3 = new Connexion (2,a);
		System.out.println("Test valCoEstEgal() a:true false r:" + c1.valCoEstEgal(c2) + c1.valCoEstEgal(c3));
		//r: truefalse


		//test pour addCoToList() OK
		al = a1.addCoToList(al);
		al = a2.addCoToList(al);
		System.out.println("Test addCoToList, a:2 r:" + al.length); // r:2

		//test pour getCo(), getCo(int) OK
		System.out.println("Test getCo(), getCo(int) a:toString d'une co, r:" + a.getCo(0));
		// r:Connexion valeur:1 aNext:Non

		// test pour getCoLibres, getCoNonLibres, getNbCoLibres, getNbCoNonLibres,
		// aCoLibres, aCoNonLibres OK OK
		System.out.print("Test getCoLibres, getCoNonLibres, getNbCoLibres, getNbCoNonLibres, aCoLibres, aCoNonLibres a:true false r:");
		System.out.println("" + a.aCoLibres() + a.aCoNonLibres());
		// r:truefalse
		*/


		//ajouterPiece(Connexion, Connexion)
		a.ajouterPiece(a.getCo(0),b.getCo(0));
		System.out.print("Test ajouterPiece(conn,conn) a:truetrue r:");
		System.out.println("" + a.aCoLibres() + a.aCoNonLibres());
		// r:truetrue



		// test pour Connexion.getCoCorres() OK
		Piece c = new Piece (1,2);
		Piece d = new Piece (1,2);
		/*
		//c.ajouterPiece(c.getCo(1), d.getCo(0));
		Connexion [] list2 = c.getCo(1).getCoCorres(d);
		System.out.println("Test Connexoin.getCoCorres a:1 r:" + list2.length);
		//r:1

		//test pour Piece.getCoCorres(), addCoCorresToList() OK
		Connexion [][] list3 = c.getCoCorres(d);
		System.out.println("Test Piece.getCoCorres, addCoCorresToList a:2 r:" + list3.length);
		//r:2
		*/


		//test toutes ajouterPiece()
		Piece aa = new Piece(0,1);
		Piece ab = new Piece(1,2);
		Piece ac = new Piece(1,2);
		Piece ad = new Piece(3,3);
		Piece ae = new Piece(1,1);

		System.out.println("===TEST ajouterPiece====");
		System.out.println("deux piece sans rien en commun a:false r:" + aa.ajouterPiece(ad));
		//r:false

		//Faire que l'une des deux (les deux marchent)
		System.out.println("deux pieces avec des connexions en commun a:true r:" + aa.ajouterPiece(ab));
		//System.out.println("deux pieces avec des connexions en commun a:true r:" + ab.ajouterPiece(aa));
		//r:true

		System.out.println("deux piece dont la seule connexion possible n'est plus libre a:false false r:" + ab.ajouterPiece(ae) + aa.ajouterPiece(ae));
		//r:falsefalse

	}

	public static void testsPieceD() {
		System.out.println("===========PIECED========");

		Piece a = new PieceD (1,2);
		Piece b = new PieceD (1,2);

		/*
		Connexion a1 = new Connexion (1,a);
		Connexion a2 = new Connexion (1,a);
		Connexion [] al = new Connexion [0];


		//test toString connexion OK
		System.out.println("Test toString Connexion r:" + a1);
		*/
		//test toString piece OK
		System.out.println(a.getCo(0));
		System.out.println("Test toString Piece r:" + a);


		/*
		//test valCoEstEgal() OK
		Connexion c1 = new Connexion (1,a);
		Connexion c2 = new Connexion (1,b);
		Connexion c3 = new Connexion (2,a);
		System.out.println("Test valCoEstEgal() a:true false r:" + c1.valCoEstEgal(c2) + c1.valCoEstEgal(c3));
		//r: truefalse


		//test pour addCoToList() OK
		al = a1.addCoToList(al);
		al = a2.addCoToList(al);
		System.out.println("Test addCoToList, a:2 r:" + al.length); // r:2

		//test pour getCo(), getCo(int) OK
		System.out.println("Test getCo(), getCo(int) a:toString d'une co, r:" + a.getCo(0));
		// r:Connexion valeur:1 aNext:Non
		*/
		// test pour getCoLibres, getCoNonLibres, getNbCoLibres, getNbCoNonLibres,
		// aCoLibres, aCoNonLibres OK OK
		System.out.print("Test getCoLibres, getCoNonLibres, getNbCoLibres, getNbCoNonLibres, aCoLibres, aCoNonLibres a:true false r:");
		System.out.println("" + a.aCoLibres() + a.aCoNonLibres());
		// r:truefalse


		System.out.println("===");


		//ajouterPiece(Connexion, Connexion)
		System.out.println(a.getCo(0) + " " + b.getCo(0));
		System.out.println(a.ajouterPiece(a.getCo(0),b.getCo(0)));
		System.out.print("Test ajouterPiece(conn,conn) a:truetrue r:");
		System.out.println("" + a.aCoLibres() + a.aCoNonLibres());
		// r:truetrue


		// test pour Connexion.getCoCorres() OK
		Piece c = new PieceD (1,2);
		Piece d = new PieceD (1,2);
		/*
		//c.ajouterPiece(c.getCo(1), d.getCo(0));
		Connexion [] list2 = c.getCo(1).getCoCorres(d);
		System.out.println("Test Connexoin.getCoCorres a:1 r:" + list2.length);
		//r:1

		//test pour Piece.getCoCorres(), addCoCorresToList() OK
		Connexion [][] list3 = c.getCoCorres(d);
		System.out.println("Test Piece.getCoCorres, addCoCorresToList a:2 r:" + list3.length);
		//r:2
		*/

		//test toutes ajouterPiece()
		Piece aa = new PieceD(0,1);
		Piece ab = new PieceD(1,2);
		Piece ac = new PieceD(1,2);
		Piece ad = new PieceD(3,3);
		Piece ae = new PieceD(1,1);

		System.out.println("===TEST ajouterPiece====");

		System.out.println(aa.getCo(0) + "" + aa.getCo(1));
		System.out.println(aa + "" + ad);

		System.out.println("deux piece sans rien en commun a:false r:" + aa.ajouterPiece(ad));
		//r:false

		//Faire que l'une des deux (les deux marchent)
		System.out.println("deux pieces avec des connexions en commun a:true r:" + aa.ajouterPiece(ab));
		//System.out.println("deux pieces avec des connexions en commun a:true r:" + ab.ajouterPiece(aa));
		//r:true

		System.out.println("deux piece dont la seule connexion possible n'est plus libre a:false false r:" + ab.ajouterPiece(ae) + aa.ajouterPiece(ae));
		//r:falsefalse

	}

	public static void testsPieceP() {
		System.out.println("===========PIECEP========");

		Piece a = new PieceP (1,1,2,1,2);
		Piece b = new PieceP (1,1,2,1,2);

		/*
		Connexion a1 = new Connexion (1,a);
		Connexion a2 = new Connexion (1,a);
		Connexion [] al = new Connexion [0];


		//test toString connexion OK
		System.out.println("Test toString Connexion r:" + a1);
		*/
		//test toString piece OK
		System.out.println(a.getCo(0));
		System.out.println("Test toString Piece r:" + a);


		/*
		//test valCoEstEgal() OK
		Connexion c1 = new Connexion (1,a);
		Connexion c2 = new Connexion (1,b);
		Connexion c3 = new Connexion (2,a);
		System.out.println("Test valCoEstEgal() a:true false r:" + c1.valCoEstEgal(c2) + c1.valCoEstEgal(c3));
		//r: truefalse


		//test pour addCoToList() OK
		al = a1.addCoToList(al);
		al = a2.addCoToList(al);
		System.out.println("Test addCoToList, a:2 r:" + al.length); // r:2
		*/
		//test pour getCo(), getCo(int) OK
		System.out.println("Test getCo(), getCo(int) a:toString d'une co, r:" + a.getCo(0));
		// r:Connexion valeur:1 aNext:Non

		// test pour getCoLibres, getCoNonLibres, getNbCoLibres, getNbCoNonLibres,
		// aCoLibres, aCoNonLibres OK OK
		System.out.print("Test getCoLibres, getCoNonLibres, getNbCoLibres, getNbCoNonLibres, aCoLibres, aCoNonLibres a:true false r:");
		System.out.println("" + a.aCoLibres() + a.aCoNonLibres());
		// r:truefalse
		System.out.println("===");


		//ajouterPiece(Connexion, Connexion)
		System.out.println(a.getCo(0) + " " + b.getCo(0));
		System.out.println(a.ajouterPiece(a.getCo(0),b.getCo(0)));
		System.out.print("Test ajouterPiece(conn,conn) a:truetrue r:");
		System.out.println("" + a.aCoLibres() + a.aCoNonLibres());
		// r:truetrue


		// test pour Connexion.getCoCorres() OK
		Piece c = new PieceP (1,1,2,1,2);
		Piece d = new PieceP (1,1,2,1,2);
		/*
		//c.ajouterPiece(c.getCo(1), d.getCo(0));
		Connexion [] list2 = c.getCo(1).getCoCorres(d);
		System.out.println("Test Connexoin.getCoCorres a:2 r:" + list2.length);
		//r:2

		//test pour Piece.getCoCorres(), addCoCorresToList() OK
		Connexion [][] list3 = c.getCoCorres(d);
		System.out.println("Test Piece.getCoCorres, addCoCorresToList a:8 r:" + list3.length);
		//r:8
		*/

		//test toutes ajouterPiece() les int > 10 sont pour "boucher" certaines connexoins
		Piece aa = new PieceP(1,10,1,10,10);
		Piece ab = new PieceP(1,1,2,11,11);
		Piece ac = new PieceP(1,1,2,12,12);
		Piece ad = new PieceP(1,3,3,3,3);
		Piece ae = new PieceP(1,1,1,1,1);

		System.out.println("===TEST ajouterPiece====");

		System.out.println("deux fois la meme piece a:false r:" + aa.ajouterPiece(aa));
		//r:
		System.out.println("deux piece sans rien en commun a:false r:" + aa.ajouterPiece(ad));
		//r:

		//Faire que l'une des deux (les deux marchent)
		System.out.println("deux pieces avec des connexions en commun a:true r:" + aa.ajouterPiece(ab));
		//System.out.println("deux pieces avec des connexions en commun a:true r:" + ab.ajouterPiece(aa));
		//r:true

		System.out.println("deux piece dont la seule connexion possible n'est plus libre a:false false r:" + ab.ajouterPiece(ae) + aa.ajouterPiece(ae));
		//r:falsefalse

		//test pour les pièces du bord
		PieceP pa = new PieceP(1,1,-1,-1,4);
		PieceP pb = new PieceP(2,-1,-1,1,2);
		PieceP pc = new PieceP(3,-1,2,3,-1);
		PieceP pd = new PieceP(4,3,4,-1,-1);
		PieceP pt = new PieceP(5,1,2,3,4);
		PieceP ps = new PieceP(6,-1,-1,-1,-1);
		System.out.print("test piecep pour le bord a:truetruetruetrue r:" + pa.ajouterPiece(pb));
		System.out.print(pc.ajouterPiece(pd));
		System.out.print(pb.ajouterPiece(pc));
		System.out.println(pd.ajouterPiece(pa));

		System.out.println("test pour les bords a:falsefalsefalsefalse r:" + pt.ajouterPiece(pa) + pt.ajouterPiece(pb) + pt.ajouterPiece(pc) + pt.ajouterPiece(pd));
		System.out.println("test pour connexions -1 a: falseX4 r:" +  ps.ajouterPiece(pa) + ps.ajouterPiece(pb) + ps.ajouterPiece(pc) + ps.ajouterPiece(pd));

	}

}
