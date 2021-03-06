package yoan.game.framework.modules.game.model;

import yoan.game.framework.util.math.Rectangle;
import yoan.game.framework.util.math.Vector2;

/**
 * Représente un élément du jeu
 * @author yoan
 */
public class GameObject {
	/** Coordonnées du centre de l'objet dans le monde */
	public final Vector2 position;
	/** Limites physiques de l'objet */
	public final Rectangle bounds;

	/**
	 * Constructeur avec paramètre
	 * @param x : Abcisse du centre de l'objet
	 * @param y : Ordonnée du centre de l'objet
	 * @param width : largeur de sa bounding box
	 * @param height : hauteur de sa bounding box
	 */
	public GameObject(float x, float y, float width, float height){
		this.position= new Vector2(x, y);
		this.bounds= new Rectangle(x - width / 2, y - height / 2, width, height);
	}
}
