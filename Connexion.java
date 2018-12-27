public class Connexion {

//Ici les deux premiers attributs peuvent être finaux 
	private final int valeur;
	private final Piece parent;
	private Connexion next;

	public Connexion (int valeur, Piece parent) {
		this.valeur = valeur;
		this.parent = parent;
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
			co1.setNext(co2);
			co2.setNext(co1);
			return true;
		}
		return false;
	}

}
