/**
* Une interface pour permettre de communiquer avec la partie logique du jeu, à ce niveau on a le respect des règles.
*/

package domino.pieces;
import domino.pieces.*;
public interface Jouable {

  /**
  * Méthode qui renvoie toutes les pièces d'un groupe
  * @return un tableau avec toutes les pièces d'un groupe
  */
  public Piece [] getPieces();

  /**
  * Méthode qui trouve toutes les connexions libres d'un groupe de pièces.
  * @return toutes les connexions qui sont disponibles sur le groupe de pièces
  */
  //public Connexions[] getCoLibres();

  /**
  * Ajoute une pièce à la connexion voulue sur le plateau.
  * @param p La pièce à ajouter
  * @param c la connexion à laquelle ajouter p.
  * @return true si lajout à été fait
  */
  //public boolean ajouterPiece(Piece p, Connexion c);

}
