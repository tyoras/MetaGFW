package yoan.game.framework.modules.graphics;

/**
 * Gestion des graphismes du jeu
 * @author yoan
 */
public interface Graphics {
	/** Enum des formats des pixels d'une image dans le framebuffer */
	public static enum PixmapFormat {
		/** Alpha(8 bits) Red(8 bits) Green (8 bits) Blue (8 bits) */ 
		ARGB8888,
		/** Alpha(4 bits) Red(4 bits) Green (4 bits) Blue (4 bits) */ 
		ARGB4444, 
		/** Red(5 bits) Green (6 bits) Blue (5 bits) */ 
		RGB565
	}
	
	/**
	 * Charge une image au format donné à partir d'un fichier
	 * @param fileName : le fichier image
	 * @param format : le format de l'image créée
	 * @return l'image chargée 
	 */
	public Pixmap newPixmap(String fileName, PixmapFormat format);
	
	/**
	 * Remplit le framebuffer avec la couleur donnée
	 * @param color
	 */
	public void clear(int color);
	
	/**
	 * Fixe la couleur d'un pixel
	 * @param x : abcisse du pixel
	 * @param y : ordonnée du pixel
	 * @param color : la couleur à appliquer au pixel
	 */
	public void drawPixel(int x, int y, int color);
	
	/**
	 * Dessine un ligne partant du pixel (x,y) jusqu'au pixel (x2,y2)
	 * @param x : abcisse du pixel de départ
	 * @param y : ordonnée du pixel de départ
	 * @param x : abcisse du pixel d'arrivée
	 * @param y : ordonnée du pixel d'arrivée
	 * @param color : couleur de la ligne
	 */
	public void drawLine(int x, int y, int x2, int y2, int color);
	
	/**
	 * Dessine un rectange avec le coin supérieur gauche au pixel (x,y)
	 * @param x : abcisse du coin supérieur gauche du rectangle
	 * @param y : ordonnée du coin supérieur gauche du rectangle
	 * @param width : largeur du rectangle
	 * @param height : hauteur du rectangle
	 * @param color : couleur du rectangle
	 */
	public void drawRect(int x, int y, int width, int height, int color);
	
	/**
	 * Dessine une partie d'une image avec le coin supérieur gauche au pixel (x,y)
	 * @param pixmap : image à dessiner
	 * @param x : abcisse du coin supérieur gauche de l'image dessinée
	 * @param y : ordonnée du coin supérieur gauche de l'image dessinée
	 * @param srcX : abcisse du coin supérieur gauche de la partie de l'image à dessiner
	 * @param srcY : ordonnée du coin supérieur gauche de la partie de l'image à dessiner
	 * @param srcWidth : largeur du morceau de l'image à dessiner
	 * @param srcHeight : hauteur du morceau de l'image à dessiner
	 */
	public void drawPixmap(Pixmap pixmap, int x, int y, int srcX, int srcY,int srcWidth, int srcHeight);
	
	/**
	 * Dessine une image avec le coin supérieur gauche au pixel (x,y)
	 * @param pixmap : image à dessiner
	 * @param x : abcisse du coin supérieur gauche de l'image dessinée
	 * @param y : ordonnée du coin supérieur gauche de l'image dessinée
	 */
	public void drawPixmap(Pixmap pixmap, int x, int y);
	
	/**
	 * Donne la largeur de l'écran
	 * @return largeur en pixel
	 */
	public int getWidth();
	
	/**
	 * Donne la hauteur de l'écran
	 * @return hauteur en pixel
	 */
	public int getHeight();
}
