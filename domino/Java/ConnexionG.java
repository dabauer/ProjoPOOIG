public class ConnexionG extends Connexion {

	private final int [] valeur = new int [2]; //Ici 1 est la couleur, 2 est la forme
	private final Piece parent;

	public ConnexionG (int couleur, int forme, Piece parent) {
		this.valeur[0] = couleur;
		this.valeur[1] = forme;
		this.parent = parent;
	}
	/*@Override
	public int [] getVal () {
		return this.valeur;
	}*/

}
