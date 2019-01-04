package domino.pieces;

public class GroupePieceP extends GroupePiece {

  public GroupePieceP (Piece p) {
    super(p);
  }

  public boolean ajouterPiece (Piece p) {
    Connexion [] r = this.getCoCorresLibres(p);
    if (r != null && r.length > 0) return this.ajouterPiece(p,r[0]);
    return false;
  }

}
