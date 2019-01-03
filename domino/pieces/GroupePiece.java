/**
* Classe qui gère les groupes de pièces dans le respect des règles du jeu voulu.
*/

package domino.pieces;
import domino.pieces.*;
public class GroupePiece /* implements Affichable, Jouable*/ {

  private Piece racine;

  public GroupePiece (Piece racine) {
    this.racine = racine;
  }

  public Piece getRacine () {
    return this.racine;
  }

//============ Implementation de Jouable =================================


  public Piece [] getPieces () {
    return this.racine.getPiecesRec();
  }



}
