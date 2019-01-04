package domino.lanceurs;
import domino.pieces.*;
public class Joueur {

  private String nom;
  private Piece [] main;

  public Joueur (String nom) {
    this.nom = nom;
    this.main = new Piece [0];
  }

  public String getNom () {
    return this.nom;
  }

  public Piece [] getMain () {
    return this.main;
  }

  public int getNbPieces () {
    return this.main.length;
  }

  public void retirerPiece (Piece p) {
    Piece [] r = new Piece [0];
    for (Piece pp : this.main) {
      if (!p.equals(pp)) r = p.addPieceToList(r);
    }
    return r;
  }

  public void ajouterPiece (Piece p) {
    this.main = p.addPieceToList(this.main);
  }

  public void ajouterPiece (Piece [] list) {
    for (Piece p : list) {
      this.ajouterPiece(p);
    }
  }

}
