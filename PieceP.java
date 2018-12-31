/**
* Classe pour les pièces de puzzle
*/

public class PieceP extends Piece {

  private int valeur; //Pour identifier l'image
  private Connexion [] connexions = new Connexion [4];

  public PieceP (int val, int [] cos) {
    super(cos);
    this.valeur = val;
  }

  public PieceP (int valeur, int co1, int co2, int co3, int co4) {
    this(valeur,makeTab4(co1,co2,co3,co4));
  }
}
