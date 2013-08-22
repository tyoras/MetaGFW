package yoan.game.framework.modules.game.model;

import yoan.game.framework.util.math.Vector2;

/**
 * Représente un élément du jeu pouvant se déplacer
 * @author yoan
 */
public class DynamicGameObject extends GameObject {
	/** Vitesse actuelle de l'objet */
	public final Vector2 velocity;
	/** Accélération actuelle de l'objet */
	public final Vector2 accel;
	
	/**
	 * Constructeur avec paramètre
	 * @param x : Abcisse du centre de l'objet
	 * @param y : Ordonnée du centre de l'objet
	 * @param width : largeur de sa bounding box
	 * @param height : hauteur de sa bounding box
	 */
	public DynamicGameObject(float x, float y, float width, float height){
		super(x, y, width, height);
		velocity = new Vector2();
		accel = new Vector2();
	}
}