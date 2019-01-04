package domino.pieces;

public class SacP extends Sac {

  public SacP (int x, int y) {
    super();
    int [][] tmp = new int[x*2+1][x*2+1];
    int n = 0;
    for (int i = 0; i < tmp.length; i++) {
      for (int j = 0; j < tmp.length; j++) {
        if (i == 0 || j == 0 || i == tmp.length - 1 || j == tmp.length - 1) tmp[i][j] = -1;
        else {
          tmp[i][j] = n++;
        }
      }
    }
    n = 0;
    for (int i = 1; i < tmp.length; i = i + 2) {
      for (int j = 1; j < tmp.length; j = j + 2) {
        this.ajouterPiece(new PieceP(++n,tmp[i][j+1],tmp[i-1][j],tmp[i][j-1],tmp[i+1][j]));
      }
    }
  }

}
