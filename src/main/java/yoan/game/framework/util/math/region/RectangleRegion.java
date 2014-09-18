package yoan.game.framework.util.math.region;

import static yoan.game.framework.util.Preconditions.*;
import yoan.game.framework.util.math.shape.RectangleShape;


/**
 * Représente une portion rectangulaire d'une zone plus vaste
 * x>yv
 * @author yoan
 */
public class RectangleRegion {
	/** Coordonées [0-1] du coin supérieur gauche dans la zone */
	public final float u1, v1;
	/** Coordonées [0-1] du coin inférieur droit dans la zone */
	public final float u2, v2;

	/**
	 * Constructeur par calcul
	 * @param area : zone dont la région est une portion
	 * @param x : abcisse en pixel du coin supérieur gauche dans la zone
	 * @param y : ordonnée en pixel du coin supérieur gauche dans la zone
	 * @param width : largeur de la région
	 * @param height : hauteur de la région
	 */
	public RectangleRegion(RectangleShape area, float x, float y, float width, float height){
		checkArgument(x >= 0 && x <= area.getWidth());
		checkArgument(y >= 0 && y <= area.getHeight());
		checkArgument(width >= 0 && width <= area.getWidth() - x);
		checkArgument(height >= 0 && height <= area.getHeight() - y, "height = " + height + " et area.height-y = "+(area.getHeight() -y));
		this.u1= x / area.getWidth();
		this.v1= y / area.getHeight();
		this.u2= this.u1 + width / area.getWidth();
		this.v2= this.v1 + height / area.getHeight();
	}
	
	/**
	 * Constructeur avec paramètres 
	 * @param u1 : coordonée [0-1] du coin supérieur gauche dans la zone
	 * @param v1 : coordonée [0-1] du coin supérieur gauche dans la zone
	 * @param u2 : coordonée [0-1] du coin inférieur droit dans la zone
	 * @param v2 : coordonée [0-1] du coin inférieur droit dans la zone
	 */
	public RectangleRegion(float u1, float v1, float u2, float v2) {
		checkArgument(u1 >= 0 && u1 <= 1);
		checkArgument(v1 >= 0 && v1 <= 1);
		checkArgument(u2 >= 0 && u2 <= 1);
		checkArgument(v2 >= 0 && v2 <= 1);
		this.u1 = u1;
		this.v1 = v1;
		this.u2 = u2;
		this.v2 = v2;
	}
}
