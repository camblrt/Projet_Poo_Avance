package controler.controlerLocal;

import model.Coord;
import model.Couleur;
import model.Pieces;
import model.observable.ChessGame;
import controler.AbstractChessGameControler;
import model.AbstractPiece;

/**
 * Ce controleur local précise comment empêcher un
 *         joueur à qui ce n'est pas le tour de jouer, de déplacer une image
 *         de pièce sur le damier
 */
public class ChessGameControler extends AbstractChessGameControler {

	/**
	 * 
	 */
	public Pieces p = null;

	/**
	 * @param chessGame
	 */
	public ChessGameControler(ChessGame chessGame) {
		super(chessGame);
	}

	protected Couleur getColorCurrentPlayer() {
		return this.chessGame.getColorCurrentPlayer();
	}

	protected Couleur getPieceColor(Coord initCoord) {
		return this.chessGame.getPieceColor(initCoord.x, initCoord.y);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controler.AbstractChessGameControler#isPlayerOK(model.Coord)
	 * 
	 * cette méthode vérifie que la couleur de la pièce que l'utilisateur
	 * tente de déplacer est bien celle du jeu courant la vue se servira de
	 * cette information pour empêcher tout déplacement sur le damier
	 */
	@Override
	public boolean isPlayerOK(Coord initCoord) {

		// int x=initCoord.x;
		// int y=initCoord.y;
		//
		//
		// if (chessGame.getColorCurrentPlayer()==chessGame.getPieceColor(x,y))
		// {
		// System.out.println("Bon joueur\n");
		// System.out.println("Couleur jeu courant :
		// "+chessGame.getColorCurrentPlayer()+ " Couleur des pièces en cours :
		// "+chessGame.getPieceColor(x,y));
		//
		// return true;
		// }
		// else
		// {
		// System.out.println("Mauvais joueur\n");
		// System.out.println("Couleur jeu courant :
		// "+chessGame.getColorCurrentPlayer()+ " Couleur des pièces en cours :
		// "+chessGame.getPieceColor(x,y));
		//
		//
		// return false;
		// }
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p == null) ? 0 : p.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChessGameControler other = (ChessGameControler) obj;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controler.AbstractChessGameControler#endMove(model.Coord,
	 * model.Coord, java.lang.String)
	 * 
	 * Pas d'action supplémentaire dans un contrôleur local en fin de move
	 */
	@Override
	protected void endMove(Coord initCoord, Coord finalCoord, String promotionType) {

	}

}
