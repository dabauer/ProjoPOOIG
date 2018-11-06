public abstract class Piece {
  
  private int deDroite;
  private int deGauche;
  //Je mets une liste ici pour pouvoir changer facilement le nombre de connexions, pour 4 connexions la premiere pièce serait la connexion de droite la seconde la connexion du haut et ainsi de suite (sens trigo rpz)
  private Piece [] connexions; 
  
  public Piece (int d, int g) {
    this.deDroite = d;
    this.deGauche = g;
    this.connexions = new Piece [4];
  }
  
  public String toString() {
    return "|" + this.deGauche + "|" + this.deDroite + "|";
  }
  
  public abstract boolean ajouterPiece(Piece piece);
}
