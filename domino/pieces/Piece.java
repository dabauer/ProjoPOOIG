/**
* classe parente pour toutes les pieces
*	N'a que l'attribut avec un tableau de connexions de taille n, ainsi toutes les sous-classes pourront implémenter les méthodes de la sur-classe.
* Il faudra seulement overrider les méthodes ajouterPiece pour prendre en compte les règles des différentes variantes.
*/

package domino.pieces;

public class Piece {

	private Connexion [] connexions;

	/**
	* Constructeur pour les pieces à partir d'un tableau de Integer
	*	@param vals, tableau de ints chaque élément de ce tableau sera ajouté comme une connexion.
	*/
	public Piece (int [] vals) {
		this.connexions = new Connexion [vals.length];
		for (int i = 0; i < vals.length; i++) {
			this.connexions[i] = new Connexion(vals[i],this);
		}
	}

	/**
	*	Constructeur pour des pièces avec deux connexoins
	*	@param val1 int pour la première connexion
	* @param val2 int pour la seconde connexion
	*/
	public Piece (int val1, int val2) {
		this(makeTab2(val1,val2));
	}

	/**
	* Constructeur pour les pièces gommettes avec 6 connexions.
	*	@param c1, int pour la couleur d'un côté du domino.
	* @param f1, int pour la forme d'un côté du domino.
	*	@param c2, int pour la couleur du seconde côté.
	*	@param f2, int pour la forme du second côté.
	*/
	public Piece (int c1, int f1, int c2, int f2) {
		this.connexions = new Connexion [6];
		for (int i = 0; i < 6; i++) {
			if (i == 0 || i == 1 || i == 5) this.connexions [i] = new Connexion (c1,f1,this);
			if (i == 2 || i == 3 || i == 4) this.connexions [i] = new Connexion (c2,f2,this);
		}
	}

	/**
	*	Méthode statique pour créer le int qui designera uniquement un ensemble de couleur et de forme avec la forme couleur0000forme.
	*	Cette forme (c0000f) permet d'avoir un nombre à priori infini de combinaisons couleur et forme.
	*	@param couleur un int qui désigne la couleur du domino.
	*	@param forme un int qui désigne la forme du domino.
	*	@return un int de la forme couleur0000forme.
	*/
	public static int makeIntG (int couleur, int forme) {
		return Integer.parseInt(couleur + "0000" + forme);
	}

	/**
	*	Méthode statique qui renvoie un tableau de int avec 2 valeurs
	*	@param val1 int premier membre de la liste
	*	@param val2 int deuxième membre de la liste
	*	@return un tableau de ints de longeur 2.
	*/
	public static int [] makeTab2 (int val1, int val2) {
		int [] r = {val1,val2};
		return r;
	}

	/**
	*	Méthode statique qui renvoie une tableau de int avec 4 valeurs
	*	@param val1 int premier membre de la liste
	*	@param val2 int deuxième membre de la liste
	*	@param val3 int troisième membre de la liste
	*	@param val4 int quatrième membre de la liste
	*	@return un tableau de ints de longeur 4.
	*/
	public static int [] makeTab4 (int val1, int val2, int val3, int val4) {
		int [] r = {val1,val2,val3,val4};
		return r;
	}

	/**
	* Renvoie les connexions d'une pièce.
	* @return les connexions de la piece
	*/
	public Connexion [] getCo () {
		return this.connexions;
	}

	/**
	* Renvoie la connexion à la position pos de la pièce.
	* @param pos la position de la connexion voulue
	* @return la connexion de la piece à la position pos
	*/
	public Connexion getCo (int pos) {
		return this.connexions[pos];
	}

//Première partie pour les connexions

	/**
	* Classe interne pour les connexions
	*/
	public class Connexion {

	//Ici les deux premiers attributs peuvent être finaux
		private final int valeur;
		private final Piece parent;
		private Connexion next;


		/**
		* Constructeur pour les connexions avec une valeur unique
		*	@param valeur int pour la valeur de la connexions
		* @param parent Piece a laquelle se refere la connexions
		*/
		public Connexion (int valeur, Piece parent) {
			this.parent = parent;
			this.valeur = valeur;
		}

		/**
		* Constructeur pour les connexions des gomettes, crée un int avec la valeur de la couleur et de la forme séparé par quatres 0.
		* Ainsi on peut reutiliser toutes les méthodes de la classe Connexion sans aucun problème d'héritage.
		* @param couleur est un int qui représente la couleur (on pourra utiliser la representation en base 10 de la couleur pour simplifier l'affichage)
		* @param forme est un int qui représente la forme sur le domino.
		*/
		public Connexion (int couleur, int forme, Piece parent) {
			this(makeIntG(couleur,forme),parent);
		}

		/**
		* Méthode qui renvoie un String décrivant la connexion
		*/
		public String toString () {
			return "Connexion valeur:" + this.valeur + " aNext:" + (this.estLibre() ? "Non" : "Oui");
		}

		/**
		* Renvoie la valeur associée à une connexion.
		* @return la valeur de la connexion
		*/
		public int getVal () {
			return this.valeur;
		}

		/**
		* Renvoie la pièce parente à laquelle la connexion appartient.
		* @return la piece parente de la connexion.
		*/
		public Piece getPar () {
			return this.parent;
		}

		/**
		* Renvoie la connexion voisine d'une connexion.
		*	@return la connexion voisine
		*/
		public Connexion getNext () {
			return this.next;
		}

		/**
		* Ajoute une connexion comme voisine à la connexion.
		* @param next une connexion qui sera ajouté à la connexion
		*/
		public void setNext (Connexion next) {
			this.next = next;
		}

		/**
		* Méthode qui renvoie true si la connexion peut accepter une nouvelle connexion
		* Accommode PieceP les pièces pour le puzzle qui peuvent avoir des conneixons sans voisins désignés par un -1
		* @return true si la connexion peut accepter une nouvelle connexion
		*/
		public boolean estLibre () {
			//Premier if pour accommoder PieceP les pièces pour le puzzle qui peuvent avoir des conneixons sans voisins désignés par un -1
			if (this.parent instanceof PieceP) return (this.next == null && this.valeur != -1);
			return (this.next == null);
		}

		/**
		* Compare la connexion this à co2.
		* @param co2 la deuxieme connexion
		*/
		public boolean valCoEstEgal (Connexion co2) {
			return (this.getVal() == co2.getVal());
		}

		/**
		* Ajoute deux connexion unes à unes, en vérifiant que c'est possible :
		* -Les deux sont libres
		* -Elles ont la même valeur
		* -Elles ne sont sur la même pièce
		* @param co2 la deuxieme connexion
		*/
		public boolean ajouterCo (Connexion co2) {
			/*System.out.println(this.valCoEstEgal(co2));
			System.out.println(this.estLibre());
			System.out.println(co2.estLibre());
			System.out.println(!this.getPar().equals(co2.getPar()));
			*/if (this.valCoEstEgal(co2) && this.estLibre() && co2.estLibre() && !this.getPar().equals(co2.getPar()) ) {
				this.setNext(co2);
				co2.setNext(this);
				return true;
			}
			return false;
		}

		/**
		* Methode qui ajoute une connexion à la liste de connexions donnée en paramètre.
		* @param list une liste de connexions à laquelle on va ajouter la connexion.
		*/
		public Connexion [] addCoToList (Connexion [] list) {
			Connexion [] r = new Connexion [list.length + 1];
			for (int i = 0; i < list.length; i++) {
				r[i] = list[i];
			}
			r[list.length] = this;
			return r;
		}

		/**
		* Methode qui renvoie une liste de connexions avec les connexions correspondantes à la connexion this
		* @param tab un tableau de connexions
		*	@return une liste des connexions correspondantes à this.
		*/
		public Connexion [] getCoCorres (Connexion [] tab) {
			Connexion [] r = new Connexion [0];
			for (Connexion co : tab) {
				if (this.valCoEstEgal(co)) r = co.addCoToList(r);
			}
			if (r.length > 0) return r;
			return null;
		}

		/**
		* Methode qui renvoie une liste de connexions avec les connexions correspondantes à la connexion this
		* @param p2 une pièce.
		*	@return une liste des connexions correspondantes à this.
		*/
		public Connexion [] getCoCorres (Piece p2) {
			return this.getCoCorres(p2.getCo());
		}
	}

	/**
	*	Ajoute une connexion à une liste de connexions
	* @param list : la liste des connexions à laquelle on veut ajouter co.
	* @param co : la connexion à ajouter.
	* @return une liste des connexions de list avec co ajouté à la fin.
	*/
	public static Connexion [] addCoToList (Connexion [] list, Connexion co) {
		return co.addCoToList(list);
	}

	/**
	* Renvoie un String qui décrit une pièce
	*/
	public String toString () {
		String r = "";
		r+= "Piece avec " + this.connexions.length + " connexions dont " + this.getNbCoLibres() + " libres. valdescos:";
		for (Connexion c : this.connexions) {
			r+= c.getVal() + " " + c.estLibre() + ",";
		}
		return r + "\n";
	}

	/**
	* Renvoie une liste avec les connexions libres d'une pièce
	* @return les connexions libres d'une piece
	*/
	public Connexion [] getCoLibres () {
		Connexion [] r = new Connexion [0];
		Connexion [] tmp = this.getCo();
		if (tmp != null) {
			for (Connexion c : tmp) {
				if (c.estLibre()) r = addCoToList(r,c);
			}
		}
		if (r.length > 0) return r;
		return null;
	}

	/**
	* Renvoie une liste avec les connexions non libres d'une pièce.
	* @return les connexions non libres d'une piece
	*/
	public Connexion [] getCoNonLibres () {
		Connexion [] r = new Connexion [0];
		for (Connexion c : this.getCo()) {
			if (!c.estLibre()) r = addCoToList(r,c);
		}
		return r;
	}


	/**
	* Renvoie le nombre de connexions libres d'une pièce.
	* @return le nombre de connexions libres
	*/
	public int getNbCoLibres () {
		return this.getCoLibres().length;
	}

	/**
	* Renvoie le nombre de connexions non libres d'une pièce.
	* @return le nombre de connexions non libres
	*/
	public int getNbCoNonLibres () {
		return this.getCoNonLibres().length;
	}

	/**
	* Renvoie true s'il y a des connexions non libres.
	* @return true s'il y a des connexions non libres
	*/
	public boolean aCoNonLibres () {
		return (this.getNbCoNonLibres () > 0);
	}

	/**
	* Renvoie true s'il y a des connexions libres
	* @return true s'il y a des connexions libres
	*/
	public boolean aCoLibres () {
		return (this.getNbCoLibres () > 0);
	}

	/**
	* Methode statique pour ajouter à une liste, une liste de paires de connexions correspondantes
	* @param list une liste de liste de connexoins correspondantes
	* @param co1 premiere connexion à ajouter.
	*	@param co2 connexion correspondante à co1 à ajouter
	*	@return une liste de liste de paires de connexions correspondantes
	*/
	public static Connexion [][] addCoCorresToList (Connexion [][] list, Connexion co1, Connexion co2) {
		Connexion [][] r = new Connexion [list.length + 1][2];
		for (int i = 0; i < list.length; i++) {
			r[i][0] = list[i][0];
			r[i][1] = list[i][1];
		}
		r[list.length][0] = co1;
		r[list.length][1] = co2;
		return r;
	}

	/**
	* Methode statique pour ajouter à une liste, une liste de paires de connexions correspondantes
	* @param list une liste de liste de connexoins correspondantes
	* @param co liste avec les deux connexions à ajouter.
	*	@return une liste de liste de paires de connexions correspondantes
	*/
	public static Connexion [][] addCoCorresToList (Connexion [][] list, Connexion [] co) {
		return addCoCorresToList(list,co[0],co[1]);
	}

	/**
	*	Methode qui renvoie une liste de liste de paires de connexions correspondantes aux connections d'une piece.
	*	@param tab est un tableau de connexions dont on veut garder celles qui correspondent à celles d'une pièce.
	*	@return une liste de liste de paires de connexions correspondantes aux connexions d'une Piece.
	*/
	public Connexion [][] getCoCorres (Connexion [] tab) {
		Connexion [][] r = new Connexion[0][2];
		Connexion [] tmp;
		for (Connexion coP1 : this.getCo()) {
			tmp = coP1.getCoCorres(tab);
			if (tmp != null) {
				for (int i = 0; i < tmp.length; i++) {
					r = addCoCorresToList(r,coP1,tmp[i]);
				}
			}
		}
		if (r.length > 0) return r;
		return null;
	}

	/**
	*	Methode qui renvoie une liste de liste de paires de connexions correspondantes aux connections d'une piece.
	*	@param p2 est une piece dont on veut garder les connexions qui correspondent à celles d'une pièce.
	*	@return une liste de liste de paires de connexions correspondantes aux connexions d'une Piece.
	*/
	public Connexion [][] getCoCorres (Piece p2) {
		return this.getCoCorres(p2.getCo());
	}

	/**
	*	Méthode qui renvoie les connexions correspondantes de deux pièces
	*	@param p2 la pièce dont les connexions seront comparées à celles de this
	*	@return un tableau de tableau de connexions avec deux connexions correspondantes par ligne.
	*/
	public Connexion [][] getCoCorresLibres (Piece p2) {
		Connexion [][] r = new Connexion [0][2];
		Connexion [][] tmp = this.getCoCorres(p2);
		if (tmp != null) {
			for (Connexion [] cos : tmp) {
				if (cos[0].estLibre() && cos[1].estLibre()) r = addCoCorresToList(r,cos);
			}
		}
		if (r.length > 0) return r;
		return null;
	}

	/**
	*	Méthode qui renvoie un boolean pour dire si une pièce contient une connexion.
	*	@param c une connexion a rechercher dans les connexions d'une pièce.
	*	@return true si la connexion c appartient bien a this
	*/
	public boolean contientCo (Connexion c) {
		for (Connexion co : this.getCo()) {
			if (c.equals(co)) return true;
		}
		return false;
	}


//Deuxieme partie pour les pieces

	/**
	* Ajouter deux pieces ensemble en choississant les deux connexions
	* @param co1 La connexion de la premiere pièce.
	* @param co2 La connexion de la deuxième pièce.
	* @return true si les pièces ont étés ajoutées ou false si les pièces n'ont pas étés ajoutés
	*/
	public boolean ajouterPiece (Connexion co1, Connexion co2) {
		return co1.ajouterCo(co2);
	}

	/**
	* Ajoute deux pieces ensemble automatiquement, en recherchant s'il est possible de le faire automatiquement
	*	Normalement s'il y a plusieurs possibilités ce n'est pas important de choisir la bonne connexoin
	*	@param c1 la connexion voulue
	* @param p2 la deuxieme piece
	*/
	public boolean ajouterPiece (Connexion c1, Piece p2) {
		if (this.contientCo(c1) && p2.aCoLibres()) {
			Connexion [] tmp = c1.getCoCorres(p2.getCoLibres());
			return this.ajouterPiece(c1,tmp[0]);
		}
		return false;
	}

	/**
	*	Ajoute deux pieces ensemble automatiquement, en effecutant la première liaison qui fonctionne si elle existe.
	* @param p2 la pièce que l'on veut coller à la pièce this.
	*/
	public boolean ajouterPiece (Piece p2) {
		Connexion [][] tmp = this.getCoCorresLibres(p2);
		if (tmp != null) return this.ajouterPiece(tmp[0][0], tmp [0][1]);
		return false;
	}


}
