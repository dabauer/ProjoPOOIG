/**
* classe parente pour toutes les pieces
*/

public class Piece {

	private Connexion [] connexions;

	/**
	* Constructeur pour les pieces test
	* @return une piece avec 2 connexions
	*/
	public Piece () {
		Connexion co1 = new Connexion(1,this);
		Connexion co2 = new Connexion(2,this);
		this.connexions = new Connexion [2];
		this.connexions [0] = co1;
		this.connexions [1] = co2;
	}

//Première partie pour les connexions

	/**
	* @param list : la liste des connexions à laquelle on veut ajouter co.
	* @param co : la connexion à ajouter.
	* @return une liste des connexions de list avec co ajouté à la fin.
	*/
	public static Connexion [] addCoToList (Connexion [] list, Connexion co) {
		return co.addCoToList(list);
	}

	public String toString () {
		String r = "";
		r+= "Piece avec " + this.connexions.length + " connexions dont " + this.getNbCoLibres() + " libres.";
		return r;
	}

	/**
	* @return les connexions de la piece
	*/
	public Connexion [] getCo () {
		return this.connexions;
	}

	/**
	* @param pos la position de la connexion voulue
	* @return la connexion de la piece à la position pos
	*/
		public Connexion getCo (int pos) {
			return this.connexions[pos];
	}

	/**
	* @return les connexions libres d'une piece
	*/
	public Connexion [] getCoLibres () {
		Connexion [] r = new Connexion [0];
		for (Connexion c : this.getCo()) {
			if (c.estLibre()) r = addCoToList(r,c);
		}
		return r;
	}

	/**
	* @return les connexions non libres d'une piece
	*/
	public Connexion [] getCoNonLibres () {
		Connexion [] r = new Connexion [0];
		for (Connexion c : this.getCo()) {
			if (!c.estLibre()) r = addCoToList(r,c);
		}
		return r;
	}


	/**
	* @return le nombre de connexions libres
	*/
	public int getNbCoLibres () {
		return this.getCoLibres().length;
	}

	/**
	* @return le nombre de connexions non libres
	*/
	public int getNbCoNonLibres () {
		return this.getCoNonLibres().length;
	}

	/**
	* @return true s'il y a des connexions non libres
	*/
	public boolean aCoNonLibres () {
		if (this.getNbCoNonLibres () > 0) return true;
		return false;
	}

	/**
	* @return true s'il y a des connexions libres
	*/
	public boolean aCoLibres () {
		if (this.getNbCoLibres () > 0) return true;
		return false;
	}

	//a finir
	public boolean compareCoLibres (Piece p2) {
		if (this.aCoLibres() && p2.aCoLibres()) {
			for (Connexion coP1 : this.getCoLibres()) {
				for (Connexion coP2 : p2.getCoLibres()) {

				}
			}
		}
		return false
	}

//Deuxieme partie pour les pieces

	/**
	* Ajoute deux pieces ensemble automatiquement, en recherchant s'il est possible de le faire automatiquement
	* @param p2 la deuxieme piece
	*/
	public boolean ajouterPiece (Piece p2) {
		if (this.aCoLibres() && p2.aCoLibres())
	}

	/**
	* Ajouter deux pieces ensemble en choississant les deux connexions
	* @param co1 La connexion de la premiere pièce.
	* @param co2 La connexion de la deuxième pièce.
	* @return true si les pièces ont étés ajoutées ou false si les pièces n'ont pas étés ajoutés
	*/
	public boolean ajouterPiece (Connexion co1, Connexion co2) {
		co1.setNext(co2);
		co2.setNext(co1);
		return true;
	}

}
