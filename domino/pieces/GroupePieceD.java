package domino.pieces;

public class GroupePieceD extends GroupePiece {

  public GroupePieceD (Piece p) {
    super(p);
  }

  /**
  * Méthode pour ajouter une pièce sur le groupe de pièce, cette connexion se fait automatiquement car le seul cas où il n'y aura pas de choix certain (mêmes bouts) le choix ne changera rien.
  */
  public boolean ajouterPiece (PieceD p) {
    Connexion [] cos = this.getCoCorresLibres(p);
    if (cos.length == 1 || (cos.length == 2 && (p.getVal()[0] == p.getVal()[1] || cos[0] == cos[1]))) return this.ajouterPiece(p,this.getCoCorresLibres(p)[0]);
    return false;
  }

  public boolean ajouterPiece (Piece p) {
    if (p instanceof PieceD) return this.ajouterPiece((PieceD) p);
    return false;
  }

}
