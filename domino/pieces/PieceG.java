/**
* Classe pour les pièces du domino gomettes
*/

package domino.pieces;

public class PieceG extends Piece {

  private Connexion [] connexions = new Connexion [6];
  private int [] valeur = new int [6];

  /**
	* Constructeur pour les pièces gommettes avec 6 connexions.
	*	@param c1, int pour la couleur d'un côté du domino.
	* @param f1, int pour la forme d'un côté du domino.
	*	@param c2, int pour la couleur du seconde côté.
	*	@param f2, int pour la forme du second côté.
	*/
  public PieceG (int c1, int f1, int c2, int f2) {
    super(c1,f1,c2,f2);
  }
}
