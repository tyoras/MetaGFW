package yoan.game.framework.util.math.shape;

/**
 * Représente une forme rectangulaire
 * @author yoan
 */
public interface RectangleShape extends Shape {
	
	/**
	 * Récupère la largeur du rectangle
	 * @return largeur d'un côté du rectangle
	 */
	public float getWidth();
	
	/**
	 * Récupère la hauteur du rectangle
	 * @return hauteur d'un côté du rectangle
	 */
	public float getHeight();
}
