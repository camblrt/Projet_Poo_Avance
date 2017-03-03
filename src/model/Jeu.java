package model;

import java.util.LinkedList;
import java.util.List;

import tools.ChessPiecesFactory;

public class Jeu {
	
	public List<Pieces> pieces = null;
	public boolean CapturePossible=false;
	Couleur couleur;
	
	public Jeu(Couleur couleur)
	{
		this.couleur=couleur;
		pieces= ChessPiecesFactory.newPieces(couleur);

	}


	@Override
	public String toString() {
		return "Jeu :\n [pieces=\n" + pieces + "]";
	}
	
	private Pieces findPiece(int x, int y)
	{
		Pieces fausse=null;
	
		for(Pieces p : pieces)
		{
			if(p.getX()==x && p.getY()==y)
			{
				return p;
	
			}
			System.out.println("Pas de pièce, impossible de la retourner (findPiece dans Jeu.java");
			return fausse;//sert a rien on l'appelle qu'apres isPieceHere mais au cas ou
		}
		return fausse;
	}
	
	public boolean isPieceHere(int x,int y)
	{
		Pieces p=null;
		p=findPiece(x,y);
		if(p==null)
		{
			return false;
		}	
		
		return true;
	}
	
	public boolean isMoveOk(int xInit,int yInit,int xFinal,int yFinal)
	{
		Pieces p=null;
		if(isPieceHere(xInit,yInit)==true)
		{
			p=findPiece(xInit,yInit);
			if(p.isMoveOk(xFinal, yFinal)==true)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else 
		{
			return false;
		}
		
		
	}
	public Couleur getPieceColor(int x,int y)
	{
		Pieces p=null;
		Couleur retour=null;
		if(isPieceHere(x,y)==true)
		{
			p=findPiece(x,y);
			retour=p.getCouleur();
			return retour;
		}
		return retour;
	}
	public boolean isPawnPromotion(int xFinal,int yFinal)
	{
		if(this.getPieceColor(xFinal,yFinal)==Couleur.BLANC)
		{
			return true;//TODO
		}
	}
	public boolean move(int xInit,int yInit,int xFinal,int yFinal)
	{
		Pieces p=null;
		if(isPieceHere(xInit,yInit)==true)
		{
			p=findPiece(xInit,yInit);

			if(isMoveOk(xInit,yInit, yFinal, yFinal)==true)
			{
				p.move(xFinal,yFinal);
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
	}
	
//test ordi val
	
	public String getPieceType(int x,int y)
	{
		Pieces p=null;
		String nomPiece=null;
		if(isPieceHere(x,y)==true)
		{
			p=findPiece(x,y);
			nomPiece=p.getClass().getSimpleName();
		}
		return nomPiece;
	}
	


	public Coord getKingCoord()
	{
		Coord retour = new Coord(-1,-1);

		for(Pieces p : pieces)
		{
			if (p.getClass().getSimpleName().equals("Roi")==true)
			{
				retour.x=p.getX();
				retour.y=p.getY();
				return retour;
			}
		}
		System.out.println("Problème fct Coord getKingCoord() dans Jeu");
		return retour;
	}
	/**
	* @return une vue de la liste des pièces en cours
	* ne donnant que des accès en lecture sur des PieceIHM
	* (type piece + couleur + liste de coordonnées)
	*/
	public List<PieceIHM> getPiecesIHM(){
		PieceIHM newPieceIHM = null;
		List<PieceIHM> list = new LinkedList<PieceIHM>();
		
			for (Pieces piece : pieces){
				boolean existe = false;
				// si le type de piece existe déjà dans la liste de PieceIHM
				// ajout des coordonnées de la pièce dans la liste de Coord de ce type
				// si elle est toujours en jeu (x et y != -1)
				for ( PieceIHM pieceIHM : list){
					if ((pieceIHM.getTypePiece()).equals(piece.getClass().getSimpleName())){
					existe = true;
						if (piece.getX() != -1){
						pieceIHM.add(new Coord(piece.getX(), piece.getY()));
						}
					}
				}
					// sinon, création d'une nouvelle PieceIHM si la pièce est toujours en jeu
					if (! existe) {
						if (piece.getX() != -1){
						newPieceIHM = new PieceIHM(piece.getClass().getSimpleName(),
						piece.getCouleur());
						newPieceIHM.add(new Coord(piece.getX(), piece.getY()));
						list.add(newPieceIHM);
						}
					}
			}
		return list;
	}
	public static void main(String[] args) {
	
		Jeu J1= new Jeu(Couleur.BLANC);
		Jeu J2 = new Jeu(Couleur.NOIR);
//		System.out.println(blanc);
//		System.out.println(noir);
		//Test de la fonction findPiece
				/*Pieces P= null;
				P=J1.findPiece(0,7);
				System.out.println(P);*/
				
				// Test fonction getKingCoord()
				//System.out.println(J1.getKingCoord());
				
				//Test fonction get PieceColor 
				//System.out.println(J1.getPieceColor(7, 0));
				
				//Test de la fonction getPiecesIHM()
				//System.out.println(J1.getPiecesIHM());
				
				//Test de la fonction getPieceType(int x, int y)
				//System.out.println(J1.getPieceType(0,7));
				
				//Test de la fonction isMoveOk ()
				/*System.out.println(J1.isMoveOk(0, 7, 1, 8));
				System.out.println(J1.isMoveOk(0, 7, 8, 7));*/
				
				//Test fonction isPieceHere (x,y)
				/*System.out.println(J1.isPieceHere(0, 7));
				System.out.println(J1.isPieceHere(0, 0));*/
				
				//Test fonction move
				/*boolean t=J1.move(0,7,5,7);
				System.out.println(J1);
				t=J1.move(0,7,8,9);
				System.out.println(J1);*/


		
	}
	
	

}
