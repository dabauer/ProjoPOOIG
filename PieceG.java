/**
* Classe pour les pièces du domino gomettes
*/

public class PieceG extends Piece {

  private Connexion [] connexions = new Connexion [6];
  private int [] valeur = new int [6];

  public PieceG (int c1, int f1, int c2, int f2) {
    super(c1,f1,c2,f2);
  }
}
