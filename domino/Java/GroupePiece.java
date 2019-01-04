/**
* Classe qui gère les groupes de pièces dans le respect des règles du jeu voulu.
*/

//package ProjoPOOIG.domino.pieces;
//import ProjoPOOIG.domino.pieces.*;
public class GroupePiece implements Jouable {

  private Piece racine;

  public GroupePiece (Piece racine) {
    this.racine = racine;
  }

  public Piece getRacine () {
    return this.racine;
  }

  public boolean contientCo (Connexion c) {
    for (Piece p : this.getPieces()) {
      if (p.contientCo(c)) return true;
    }
    return false;
  }

//============ Implementation de Jouable =================================

  public Piece [] getPieces () {
    return this.racine.getPiecesRec();
  }

  public Connexion [] getCoLibres() {
    Piece [] pieces = this.getPieces();
    Connexion [] r = new Connexion[0];
    for (Piece p : pieces) {
      for (Connexion c : p.getCoLibres()) {
        r = c.addCoToList(r);
      }
    }
    return r.length > 0 ? r : null;
  }

  public Connexion [] getCoCorresLibres (Connexion c) {
    Connexion [] coli = this.getCoLibres();
    if (coli != null && coli.length > 0) {
      Connexion [] r = new Connexion [0];
      for (Connexion cl : coli) {
        if (cl.valCoEstEgal(c)) r = cl.addCoToList(r);
      }
      return r;
    }
    return null;
  }

  public Connexion [] getCoCorresLibres (Piece p) {
    Connexion [] coli = this.getCoLibres();
    Connexion [] r = new Connexion [0];
    if (coli != null && coli.length > 0) {
      for (Connexion c : p.getCo()) {
        for (Connexion cl : coli) {
          if (cl.valCoEstEgal(c) && !cl.isInList(r)) r = cl.addCoToList(r);
        }
      }
    }
    return r.length > 0 ? r : null;
  }

  public boolean ajouterPiece(Piece p, Connexion c) {
    if (c.estLibre() && this.contientCo(c)) return c.ajouterPiece(p);
    return false;
  }

}
