public class Connexion {

//Ici les deux premiers attributs peuvent être finaux
	private final int valeur;
	private final Piece parent;
	private Connexion next;

	public Connexion (int valeur, Piece parent) {
		this.valeur = valeur;
		this.parent = parent;
	}

	public String toString () {
		return "Connexion valeur:" + this.valeur + " aNext:" + (this.next != null ? "Oui" : "Non");
	}

	public int getVal () {
		return this.valeur;
	}

	public Piece getPar () {
		return this.parent;
	}

	public Connexion getNext () {
		return this.next;
	}

	public void setNext (Connexion next) {
		this.next = next;
	}

	/**
	* @return true si la connexion a une connexion next, false sinon
	*/
	public boolean estLibre () {
		return (this.next == null);
	}

	/**
	* Compare la connexion this à co2.
	* @param co2 la deuxieme connexion
	*/
	public boolean compareCo (Connexion co2) {
		if (this.getVal() == co2.getVal()) return true;
		return false;
	}

	/**
	* Ajoute deux connexion unes à unes
	* @param co2 la deuxieme connexion
	*/
	public boolean ajouterCo (Connexion co2) {
		if (this.compareCo(co2) && this.estLibre() && co2.estLibre()) {
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
			if (this.compareCo(co)) r = co.addCoToList(r);
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
}
