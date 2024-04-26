
public class TableauJeuDeLaVie {

	private boolean[][] table;
	private int nbLignes;
	private int nbColonnes;

	public TableauJeuDeLaVie(int nbLignes, int nbColonnes) {
		table = new boolean[nbLignes][nbColonnes];
		this.nbLignes = nbLignes;
		this.nbColonnes = nbColonnes;
	}


	public void setXY(int x, int y, boolean enVie){
		table[x][y] = enVie;
	}


	public boolean getXY(int x, int y){
		return table[x][y];
	}


	public int nbVoisines(int x, int y){
		int nbVoisinesVivantes = 0;

		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (i >= 0 && i < table.length && j >= 0 && j < table[0].length) {
					if (!(i == x && j == y) && table[i][j]) {
						nbVoisinesVivantes++;
					}
				}
			}
		}

		return nbVoisinesVivantes;

	}

	private boolean enVieGenerationSuivante(int x, int y) {

		int nbVoisinesVivantes = nbVoisines(x, y);

		if (nbVoisinesVivantes  == 1 ) {
			return false;
		} else if (nbVoisinesVivantes == 2 ) {
			return true;
		} else if (nbVoisinesVivantes == 3 ) {
			return false;
		} else {
			return false;
		}
	}


	public void generationSuivante(){
		boolean[][] nouvelleGrille = new boolean[table.length][table[0].length];

		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				boolean celluleVivanteGenerationSuivante = enVieGenerationSuivante(i, j);

				nouvelleGrille[i][j] = celluleVivanteGenerationSuivante;
			}
		}
		table = nouvelleGrille;
	}

}