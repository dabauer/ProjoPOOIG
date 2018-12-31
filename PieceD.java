/**
* Classe pour les pieces domino normal
*/

public class PieceD extends Piece {

  private int [] valeur = new int [2];
  private Connexion [] connexions = new Connexion [2];

  public PieceD (int [] val) {
    super(val);
    valeur[0] = val[0];
    valeur[1] = val[1];
  }

  public PieceD (int val1, int val2) {
    this(makeTab2(val1,val2));
  }

}
