package domino.pieces;

import java.util.Random;

public class Sac {

  private Piece [] sac;

  public Sac () {
    this.sac = new Piece [0];
  }

  public Piece [] getContenu () {
    return this.sac;
  }

  public int length () {
    return this.sac.length;
  }

  public void ajouterPiece (Piece p) {
    this.sac = p.addPieceToList(this.getContenu());
  }

  public void ajouterPiece (Piece [] list) {
    for (Piece p : list) {
      this.ajouterPiece(p);
    }
  }

  public void retirerPiece (Piece p) {
    Piece [] r = new Piece [0];
    for (Piece ps : this.sac) {
      if (!ps.equals(p)) r = ps.addPieceToList(r);
    }
    this.sac = r;
  }

  public void retirerPiece (int i) {
    this.retirerPiece(this.getPiece(i));
  }

  public Piece getPiece (int i) {
    Piece r = this.sac[i];
    this.retirerPiece(r);
    return r;
  }

  public Piece getPieceRand () {
    Random rand = new Random();
    return this.getPiece(rand.nextInt(this.length()));
  }

  public Piece [] getPieceRand (int n) {
    Piece [] r = new Piece [0];
    for (int i = 0; i < n; i++) {
      r = this.getPieceRand().addPieceToList(r);
    }
    return r;
  }

}
