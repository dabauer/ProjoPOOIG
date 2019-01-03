/**
* Classe pour les pièces de puzzle, ici un -1 désigne une connexion libre qui ne peut pas accepter de nouveau voisin (pour les bords)
*/

package domino.pieces;

public class PieceP extends Piece {

  private int valeur; //Pour identifier l'image
  private Connexion [] connexions = new Connexion [4];

  /**
  * Constructeur pour les pièces de puzzle
  * @param val un int qui identifiera l'image sur la pièce du puzzle
  * @param cos un tableau de ints avec les valeurs des connexions à faire
  */
  public PieceP (int val, int [] cos) {
    super(cos);
    this.valeur = val;
  }

  /**
  * Constructeur pour les pièces de puzzle
  * @param valeur un int qui indentifie l'image sur la pièce du puzzle.
  * @param co1-4 les valeurs des connexions pour chaque côté du puzzle
  */
  public PieceP (int valeur, int co1, int co2, int co3, int co4) {
    this(valeur,makeTab4(co1,co2,co3,co4));
  }

}
