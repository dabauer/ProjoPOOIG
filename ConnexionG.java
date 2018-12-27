public class ConnexionG extends Connexion {

	private final int [] valeur = new int [2]; //Ici 1 est la couleur, 2 est la forme

	public Connexion (int couleur, int forme, Piece parent) {
		this.valeur = {couleur, forme};
		this.parenet = parent;
	}

	@Override
	public int [] getVal () {
		return this.valeur;
	}

}
