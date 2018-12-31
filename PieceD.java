/**
* Classe pour les pieces domino normal
*/

public class PieceD extends Piece {

  private int [] valeur = new int [2];
  private Connexion [] connexions = new Connexion [2];

  /**
  * Un constructeur qui prends en entée un tbaleua de int de taille 2 et construit une pièce pour les dominos normaux
  * @param val un tableau de int de taille 2 avec les valeurs des deux côtés d'un domino normal.
  */
  public PieceD (int [] val) {
    super(val);
    valeur[0] = val[0];
    valeur[1] = val[1];
  }

  /**
  * Un constructeur qui prends en entrée deux ints pour créer un domino normal avec ces deux valeurs
  * @param val1 un int pour la première valeur d'un domino normal.
  * @param val2 un int pour la deuxième valeur d'un domino normal.
  */
  public PieceD (int val1, int val2) {
    this(makeTab2(val1,val2));
  }

}
