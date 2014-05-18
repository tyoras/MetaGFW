package yoan.game.framework.util.math;

import yoan.game.framework.util.math.shape.CircleShape;

/**
 * Représentation et gestion d'un cercle
 * @author yoan
 */
public class Circle implements CircleShape {
	/** Centre du cercle */
	public final Vector2 center = new Vector2();
	/** Rayon du cercle */
	public float radius;
	
	/**
	 * Constcuteur avec paramètres
	 * @param x
	 * @param y
	 * @param radius
	 */
	public Circle(float x, float y, float radius) {
		this.center.set(x,y);
		this.radius = radius;
	}

	@Override
	public float getRadius(){
		return radius;
	}
}