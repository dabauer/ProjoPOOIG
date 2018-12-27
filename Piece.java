/**
* classe abstraite pour toutes les pieces 
*/

public class Piece {

	private Connexion [] connexions;

//Première partie pour les connexions

	public Connexion [] addCoToList (Connexion [] list, Connexion co) {
		Connexion [] r = new Connexion [list.length + 1];
		for (int i = 0; i < list.length; i++) {
			r[i] = list[i];
		}
		r[r.length - 1] = co;
		return r;
	}

	/**
	* @return les connexions de la piece
	*/
	public Connexion [] getCo ();

	/**
	* Renvoie le nombre de connexions libres
	*/
	public int getNbCoLibre () {
		int coL = 0;
		for (Connexion c : this.getCo()) {
			if (c.estLibre()) coL++; 
		}
		return coL;
	}

	/**
	* Renvoie true s'il y a des connexions libres
	*/
	public boolean coLibres () {
		if (this.getNbCoLibres > 0) return true;
		return false;
	}

	/**
	* Renvoie les connexions libres d'une piece
	*/
	public Connexion [] getCoLibres () {
		Connexion [] r = new Connexion [0];
		for (Connexion c : this.getCo()) {
			if (c.estLibre()) addCoToList(r,c);
		}
		return r;
	}

	public Connexion [] getCoNonLibres () {
		Connexion [] r = new Connexion [0];
		for (Connexion c : this.getCo()) {
			if (!c.estLibre()) addCoToList(r,c);
		}
		return r;
	}

//Deuxieme partie pour les pieces

	/**
	* Ajoute deux pieces ensemble automatiquement, en recherchant s'il est possible de le faire automatiquement
	* @param p2 la deuxieme piece
	*/
	public boolean ajouterPiece (Piece p2) ;

	/**
	* Ajouter deux pieces ensemble en choississant les deux connexions
	* @param co1 La connexion de la premiere pièce.
	* @param p2 La deuxieme pièce.
	* @param co2 La connexion de la deuxième pièce.
	* @return true si les pièces ont étés ajoutées ou false si les pièces n'ont pas étés ajoutés
	*/
	public boolean ajouterPiece (Connexion co1, Piece p2, Connexion co2);

}
