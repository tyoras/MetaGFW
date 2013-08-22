package yoan.game.framework.modules.game.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Grille de répartition des objet du jeu dans le monde
 * @author yoan
 */
public class SpatialHashGrid {
	/** Grille contenant les objets dynamiques */
	private List<DynamicGameObject>[] dynamicCells;
	/** Grille contenant les objets statiques */
	private List<GameObject>[] staticCells;
	/** Nombre de case de la grille par ligne */
	private final int CELLS_PER_ROW;
	/** Nombre de case de la grille par colonne */
	private final int CELLS_PER_COL;
	/** Taille d'une case de la grille */
	private final float CELL_SIZE;
	
	//OPTIMISATION GC
	/** Tableau servant à contenir les 1 à 4 cases au quel apparient un objet */
	private int[] cellIds = new int[4];
	/** Liste de retour */
	private List<GameObject> foundObjects;
	
	/**
	 * Constructeur avec paramètre
	 * @param worldWidth : largeur du monde
	 * @param worldHeight : hauteur du monde
	 * @param cellSize : taille d'une case de la grille
	 */
	@SuppressWarnings("unchecked")
	public SpatialHashGrid(float worldWidth, float worldHeight, float cellSize){
		this.CELL_SIZE= cellSize;
		this.CELLS_PER_ROW= (int) Math.ceil(worldWidth / cellSize);
		this.CELLS_PER_COL= (int) Math.ceil(worldHeight / cellSize);
		int nbCells= CELLS_PER_ROW * CELLS_PER_COL;
		dynamicCells= new List[nbCells];
		staticCells= new List[nbCells];
		for(int i= 0; i < nbCells; i++){
			dynamicCells[i]= new ArrayList<DynamicGameObject>(10);
			staticCells[i]= new ArrayList<GameObject>(10);
		}
		foundObjects= new ArrayList<GameObject>(10);
	}

	/**
	 * Ajoute un objet statique dans la grille
	 * @param obj : objet statique à ajouter
	 */
	public void insertStaticObject(GameObject obj){
		int[] cellIds= getCellIds(obj);
		int i= 0;
		int cellId= -1;
		//insertion dans les listes de chacune des cases auxquelles l'objet appartient
		while(i <= 3 && (cellId= cellIds[i++]) != -1){
			staticCells[cellId].add(obj);
		}
	}

	/**
	 * Ajoute un objet dynamique dans la grille
	 * @param obj : objet dynamique à ajouter
	 */
	public void insertDynamicObject(DynamicGameObject obj){
		int[] cellIds= getCellIds(obj);
		int i= 0;
		int cellId= -1;
		//insertion dans les listes de chacune des cases auxquelles l'objet appartient
		while(i <= 3 && (cellId= cellIds[i++]) != -1){
			dynamicCells[cellId].add(obj);
		}
	}
	
	/**
	 * Retire un objet de la grille
	 * @param obj : objet à retirer
	 */
	public void removeObject(GameObject obj){
		int[] cellIds= getCellIds(obj);
		int i= 0;
		int cellId= -1;
		while(i <= 3 && (cellId= cellIds[i++]) != -1){
			dynamicCells[cellId].remove(obj);
			staticCells[cellId].remove(obj);
		}
	}
	
	/**
	 * Vide les listes d'objet dynamiques
	 */
	public void clearDynamicCells(){
		int len= dynamicCells.length;
		for(int i= 0; i < len; i++){
			dynamicCells[i].clear();
		}
	}
	
	/**
	 * Calcule les objets pouvant potentiellemnt entrer en collision
	 * @param obj
	 * @return
	 */
	public List<GameObject> getPotentialColliders(GameObject obj){
		foundObjects.clear();
		int[] cellIds= getCellIds(obj);
		int i= 0;
		int cellId= -1;
		while(i <= 3 && (cellId= cellIds[i++]) != -1){
			int len= dynamicCells[cellId].size();
			for(int j= 0; j < len; j++){
				DynamicGameObject collider= dynamicCells[cellId].get(j);
				if(!foundObjects.contains(collider)) foundObjects.add(collider);
			}
			len= staticCells[cellId].size();
			for(int j= 0; j < len; j++){
				GameObject collider= staticCells[cellId].get(j);
				if(!foundObjects.contains(collider)) foundObjects.add(collider);
			}
		}
		return foundObjects;
	}
	
	/**
	 * Calcule à quelle(s) case(s) appartient un objet
	 * @param obj 
	 * @return l'index des cases de l'objet
	 */
	public int[] getCellIds(GameObject obj){
		//calcul des coordonnées des coins de la bounding box dans la grille
		//coin inférieur gauche
		int x1= (int) Math.floor(obj.bounds.lowerLeft.x / CELL_SIZE);
		int y1= (int) Math.floor(obj.bounds.lowerLeft.y / CELL_SIZE);
		//coin supérieur droit
		int x2= (int) Math.floor((obj.bounds.lowerLeft.x + obj.bounds.width) / CELL_SIZE);
		int y2= (int) Math.floor((obj.bounds.lowerLeft.y + obj.bounds.height) / CELL_SIZE);

		//si l'objet est entierement compris dans une case
		if(x1 == x2 && y1 == y2){
			//si l'objet n'est pas en dehors du monde
			if(x1 >= 0 && x1 < CELLS_PER_ROW && y1 >= 0 && y1 < CELLS_PER_COL) {
				//calcul de l'ID à partir des coordonnées dans la grille
				cellIds[0]= x1 + y1 * CELLS_PER_ROW;
			} else {
				cellIds[0]= -1;
			}
			cellIds[1]= -1;
			cellIds[2]= -1;
			cellIds[3]= -1;
		//si l'objet est sur 2 cases l'une au dessus de l'autre
		}else if(x1 == x2){
			int i= 0;
			//si l'objet n'est pas en dehors du monde
			if(x1 >= 0 && x1 < CELLS_PER_ROW){
				if(y1 >= 0 && y1 < CELLS_PER_COL) 
					cellIds[i++]= x1 + y1 * CELLS_PER_ROW;
				if(y2 >= 0 && y2 < CELLS_PER_COL) 
					cellIds[i++]= x1 + y2 * CELLS_PER_ROW;
			}
			//les autres cases sont initialisées à -1
			while(i <= 3) cellIds[i++]= -1;
		//si l'objet est sur 2 cases consécutives
		}else if(y1 == y2){
			int i= 0;
			//si l'objet n'est pas en dehors du monde
			if(y1 >= 0 && y1 < CELLS_PER_COL){
				if(x1 >= 0 && x1 < CELLS_PER_ROW) 
					cellIds[i++]= x1 + y1 * CELLS_PER_ROW;
				if(x2 >= 0 && x2 < CELLS_PER_ROW) 
					cellIds[i++]= x2 + y1 * CELLS_PER_ROW;
			}
			//les autres cases sont initialisées à -1
			while(i <= 3) cellIds[i++]= -1;
		//si l'objet est sur quatres cases à la fois
		}else{
			int i= 0;
			int y1CellsPerRow= y1 * CELLS_PER_ROW;
			int y2CellsPerRow= y2 * CELLS_PER_ROW;
			if(x1 >= 0 && x1 < CELLS_PER_ROW && y1 >= 0 && y1 < CELLS_PER_COL) 
				cellIds[i++]= x1 + y1CellsPerRow;
			if(x2 >= 0 && x2 < CELLS_PER_ROW && y1 >= 0 && y1 < CELLS_PER_COL) 
				cellIds[i++]= x2 + y1CellsPerRow;
			if(x2 >= 0 && x2 < CELLS_PER_ROW && y2 >= 0 && y2 < CELLS_PER_COL) 
				cellIds[i++]= x2 + y2CellsPerRow;
			if(x1 >= 0 && x1 < CELLS_PER_ROW && y2 >= 0 && y2 < CELLS_PER_COL) 
				cellIds[i++]= x1 + y2CellsPerRow;
			
			while(i <= 3) cellIds[i++]= -1;
		}
		return cellIds;
	}
}