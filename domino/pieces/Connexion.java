/**
* Classe interne pour les connexions
*/
package domino.pieces;

public class Connexion {

//Ici les deux premiers attributs peuvent être finaux
	private final int valeur;
	private final Piece parent;
	private Connexion next;


	/**
	* Constructeur pour les connexions avec une valeur unique
	*	@param valeur int pour la valeur de la connexions
	* @param parent Piece a laquelle se refere la connexions
	*/
	public Connexion (int valeur, Piece parent) {
		this.parent = parent;
		this.valeur = valeur;
	}

	/**
	* Constructeur pour les connexions des gomettes, crée un int avec la valeur de la couleur et de la forme séparé par quatres 0.
	* Ainsi on peut reutiliser toutes les méthodes de la classe Connexion sans aucun problème d'héritage.
	* @param couleur est un int qui représente la couleur (on pourra utiliser la representation en base 10 de la couleur pour simplifier l'affichage)
	* @param forme est un int qui représente la forme sur le domino.
	*/
	public Connexion (int couleur, int forme, Piece parent) {
		this(Piece.makeIntG(couleur,forme),parent);
	}

	/**
	* Méthode qui renvoie un String décrivant la connexion
	*/
	public String toString () {
		return "Connexion valeur:" + this.valeur + " aNext:" + (this.estLibre() ? "Non" : "Oui");
	}

	/**
	* Renvoie la valeur associée à une connexion.
	* @return la valeur de la connexion
	*/
	public int getVal () {
		return this.valeur;
	}

	/**
	* Renvoie la pièce parente à laquelle la connexion appartient.
	* @return la piece parente de la connexion.
	*/
	public Piece getPar () {
		return this.parent;
	}

	/**
	* Renvoie la connexion voisine d'une connexion.
	*	@return la connexion voisine
	*/
	public Connexion getNext () {
		return this.next;
	}

	/**
	* Ajoute une connexion comme voisine à la connexion.
	* @param next une connexion qui sera ajouté à la connexion
	*/
	public void setNext (Connexion next) {
		this.next = next;
	}

	/**
	* Méthode qui renvoie true si la connexion peut accepter une nouvelle connexion
	* Accommode PieceP les pièces pour le puzzle qui peuvent avoir des conneixons sans voisins désignés par un -1
	* @return true si la connexion peut accepter une nouvelle connexion
	*/
	public boolean estLibre () {
		//Premier if pour accommoder PieceP les pièces pour le puzzle qui peuvent avoir des conneixons sans voisins désignés par un -1
		if (this.parent instanceof PieceP) return (this.next == null && this.valeur != -1);
		return (this.next == null);
	}

	/**
	* Méthode qui renvoie true si la connexion a une pièce suivante
	*/
	public boolean hasNext() {
		return this.next != null;
	}

	/**
	* Compare la connexion this à co2.
	* @param co2 la deuxieme connexion
	*/
	public boolean valCoEstEgal (Connexion co2) {
		return (this.getVal() == co2.getVal());
	}

	/**
	* Ajoute deux connexion unes à unes, en vérifiant que c'est possible :
	* -Les deux sont libres
	* -Elles ont la même valeur
	* -Elles ne sont sur la même pièce
	* @param co2 la deuxieme connexion
	*/
	public boolean ajouterCo (Connexion co2) {
		/*System.out.println(this.valCoEstEgal(co2));
		System.out.println(this.estLibre());
		System.out.println(co2.estLibre());
		System.out.println(!this.getPar().equals(co2.getPar()));
		*/if (this.valCoEstEgal(co2) && this.estLibre() && co2.estLibre() && !this.getPar().equals(co2.getPar()) ) {
			this.setNext(co2);
			co2.setNext(this);
			return true;
		}
		return false;
	}

	/**
	* Methode qui ajoute une connexion à la liste de connexions donnée en paramètre.
	* @param list une liste de connexions à laquelle on va ajouter la connexion.
	*/
	public Connexion [] addCoToList (Connexion [] list) {
		Connexion [] r = new Connexion [list.length + 1];
		for (int i = 0; i < list.length; i++) {
			r[i] = list[i];
		}
		r[list.length] = this;
		return r;
	}

	/**
	* Methode qui renvoie une liste de connexions avec les connexions correspondantes à la connexion this
	* @param tab un tableau de connexions
	*	@return une liste des connexions correspondantes à this.
	*/
	public Connexion [] getCoCorres (Connexion [] tab) {
		Connexion [] r = new Connexion [0];
		for (Connexion co : tab) {
			if (this.valCoEstEgal(co)) r = co.addCoToList(r);
		}
		if (r.length > 0) return r;
		return null;
	}

	/**
	* Methode qui renvoie une liste de connexions avec les connexions correspondantes à la connexion this
	* @param p2 une pièce.
	*	@return une liste des connexions correspondantes à this.
	*/
	public Connexion [] getCoCorres (Piece p2) {
		return this.getCoCorres(p2.getCo());
	}

  public boolean ajouterPiece(Piece p) {
    return this.getPar().ajouterPiece(p);
  }

  public boolean isInList (Connexion [] list) {
    for (Connexion c : list) {
      if (c.equals(this)) return true;
    }
    return false;
  }

}
