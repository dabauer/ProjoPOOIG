package domino.pieces;

public class SacD extends Sac {



  public SacD () {
    super();
    Piece tmp;
    Piece [] a = new Piece[0];
    for (int i = 0; i < 7; i++) {
      for (int j = i; j < 7; j++) {
        a = (new PieceD(i,j)).addPieceToList(a);
      }
    }
    this.ajouterPiece(a);
  }

}
