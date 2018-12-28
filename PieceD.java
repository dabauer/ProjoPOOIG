/**
* Classe pour les pieces domino normal
*/

public class PieceD extends Piece {

  private int [] valeur = new int [2];
  private Connexion [] connexions = new Connexion [2];

  public PieceD (int val1, int val2) {
    this.valeur[0] = val1;
    this.valeur[1] = val2;
    connexions [0] = new Connexion (val1,this);
    connexions [1] = new Connexion (val2,this);
  }

}
