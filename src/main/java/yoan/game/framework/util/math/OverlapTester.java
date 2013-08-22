package yoan.game.framework.util.math;

/**
 * Helper permettant d'éffectuer des tests de chevauchements entre des formes
 * @author yoan
 */
public class OverlapTester {
	/**
	 * Vérifie si deux cercles se chevauchent
	 * @param c1 
	 * @param c2
	 * @return true si chevauchement
	 */
	public static boolean overlapCircles(Circle c1, Circle c2) {
		//on récupère la distance entre les centres au carré
		float distance = c1.center.distSquared(c2.center);
		float radiusSum = c1.radius + c2.radius;
		//et on la compare à la somme des rayons au carré
		return distance <= radiusSum * radiusSum;
	}

	/**
	 * Vérifie si deux rectangles se chevauchent
	 * @param r1 
	 * @param r2
	 * @return true si chevauchement
	 */
	public static boolean overlapRectangles(Rectangle r1, Rectangle r2){
		return r1.lowerLeft.x < r2.lowerLeft.x + r2.width		//coin inférieur gauche 1 à gauche du coin inférieur droit 2
			&& r1.lowerLeft.x + r1.width > r2.lowerLeft.x		//coin inférieur gauche 2 à gauche du coin inférieur droit 1 
			&& r1.lowerLeft.y < r2.lowerLeft.y + r2.height 		//coin inférieur gauche 1 au dessous du coin supérieur gauche 2
			&& r1.lowerLeft.y + r1.height > r2.lowerLeft.y;		//coin inférieur gauche 2 au dessous du coin supérieur gauche 1
	}

	/**
	 * Vérifie si un cercle et un rectangle se chevauchent
	 * @param c 
	 * @param r
	 * @return true si chevauchement
	 */
	public static boolean overlapCircleRectangle(Circle c, Rectangle r){
		//on cherche le côté du rectangle le plus proche du centre du cercle sur l'axe X 
		float closestX= c.center.x;
		if(c.center.x < r.lowerLeft.x){
			closestX= r.lowerLeft.x;
		}else if(c.center.x > r.lowerLeft.x + r.width){
			closestX= r.lowerLeft.x + r.width;
		}
		//on cherche le côté du rectangle le plus proche du centre du cercle sur l'axe Y 
		float closestY= c.center.y;
		if(c.center.y < r.lowerLeft.y){
			closestY= r.lowerLeft.y;
		}else if(c.center.y > r.lowerLeft.y + r.height){
			closestY= r.lowerLeft.y + r.height;
		}
		//chevauchement si le point obtenu est dans le cercle
		return c.center.distSquared(closestX, closestY) < c.radius * c.radius;
	}

	/**
	 * Vérifie si un point est contenu dans un cercle
	 * @param c
	 * @param p
	 * @return true si chevauchement
	 */
	public static boolean pointInCircle(Circle c, Vector2 p){
		//chevauchement si distance depuis le centre < rayon
		return c.center.distSquared(p) < c.radius * c.radius;
	}

	/**
	 * Vérifie si un point est contenu dans un cercle
	 * @param c
	 * @param x
	 * @param y
	 * @return true si chevauchement
	 */
	public static boolean pointInCircle(Circle c, float x, float y){
		//chevauchement si distance depuis le centre < rayon
		return c.center.distSquared(x, y) < c.radius * c.radius;
	}

	/**
	 * Vérifie si un point est contenu dans un rectangle
	 * @param r
	 * @param p
	 * @return true si chevauchement
	 */
	public static boolean pointInRectangle(Rectangle r, Vector2 p){
		return r.lowerLeft.x <= p.x 
			&& r.lowerLeft.x + r.width >= p.x
			&& r.lowerLeft.y <= p.y 
			&& r.lowerLeft.y + r.height >= p.y;
	}

	/**
	 * Vérifie si un point est contenu dans un rectangle
	 * @param r
	 * @param x
	 * @param y
	 * @return true si chevauchement
	 */
	public static boolean pointInRectangle(Rectangle r, float x, float y){
		return r.lowerLeft.x <= x 
			&& r.lowerLeft.x + r.width >= x
			&& r.lowerLeft.y <= y 
			&& r.lowerLeft.y + r.height >= y;
	}
}