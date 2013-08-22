package yoan.game.framework.modules.graphics;

import yoan.game.framework.modules.graphics.Graphics.PixmapFormat;

/**
 * Gestion d'une image dans le framebuffer
 * @author yoan
 */
public interface Pixmap {

	/**
	 * Donne la largeur de l'image
	 * @return largeur en pixel
	 */
	public int getWidth();
	
	/**
	 * Donne la hauteur de l'image
	 * @return hauteur en pixel
	 */
	public int getHeight();
	
	/**
	 * Donne le format de l'image dans le framebuffer
	 * @return format d'image
	 */
	public PixmapFormat getFormat();
	 
	/**
	 * Libére la mémoire de l'image
	 */
	public void dispose();
}
