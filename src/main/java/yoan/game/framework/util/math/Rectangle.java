package yoan.game.framework.util.math;

/**
 * Représentation et gestion d'un rectangle
 * @author yoan
 */
public class Rectangle {
	/** Coin inférieur gauche */
	public final Vector2 lowerLeft;
	/** largeur du rectangle */
	public float width;
	/** Hauteur du rectangle */
	public float height;
	
	/**
	 * Constcuteur avec paramètres
	 * @param x : abcisse du coin inférieur gauche
	 * @param y : ordonnée du coin inférieur gauche
	 * @param width
	 * @param height
	 */
	public Rectangle(float x, float y, float width, float height){
		this.lowerLeft= new Vector2(x, y);
		this.width= width;
		this.height= height;
	}
}