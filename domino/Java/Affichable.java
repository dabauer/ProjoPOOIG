/**
* Interface pour avoir les tableaux nécessaires à l'affichage du plateau
*/

//package ProjoPOOIG.domino.pieces;
//import ProjoPOOIG.domino.pieces.*;
public interface Affichable {

  /**
  * Méthode qui renvoie un tableau de tableau de pièces qui peut être utilisé pour l'affichage
  * @return un tableau de tableau de Pièces qui répresente le plateau actuel.
  */
  public Piece [][] getPlateau ();

  /**
  * Méthode qui renvoie un tableau de tableau de ints qui peut être utilisé pour l'affichage textuel
  * @return un tableau de tableau de int qui répresente le plateau actuel.
  */
  public int [][] getValeurs ();

  /**
  * Méthode qui renvoie un tableau de tableau de pièces qui peut être utilisé pour l'affichage, formaté pour avoir une largeur maximale.
  * @param largeur un int qui limite la largeur du tableau pour pouvoir être affiché dans une fenêtre de la taille correspondante.
  * @return un tableau de tableau de Pièces qui répresente le plateau actuel.
  */
  public Piece [][] getPlateau(int largeur);

  /**
  * Méthode qui renvoie un tableau de tableau de ints qui peut être utilisé pour l'affichage textuel, formaté pour avoir une largeur maximale.
  * @param largeur un int qui limite la largeur du tableau pour pouvoir être affiché dans une fenêtre de la taille correspondante.
  * @return un tableau de tableau de ints qui répresente le plateau actuel.
  */
  public int [][] getValeurs (int largeur);
}

