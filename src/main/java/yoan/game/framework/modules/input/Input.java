package yoan.game.framework.modules.input;

import java.util.List;

/**
 * Gestion des entrées du jeu
 * @author yoan
 */
public interface Input {
	
	/**
	 * Evenement du clavier concernant une touche
	 * @author yoan
	 */
	public static class KeyEvent {
		/** touche pressée */
		public static final int KEY_DOWN = 0;
		/** touche libérée */
		public static final int KEY_UP = 1;

		/** type de l'évenement */
		public int type;
		/** code de la touche concernée */
		public int keyCode;
		/** charater correspondant à la touche concernée */
		public char keyChar;
	}

	/**
	 * Evenement du touchscreen concernant un pointeur
	 * @author yoan
	 */
	public static class TouchEvent {
		/** écran touché */
		public static final int TOUCH_DOWN = 0;
		/** écran libéré */
		public static final int TOUCH_UP = 1;
		/** déplacement du pointeur */
		public static final int TOUCH_DRAGGED = 2;

		/** type de l'évenement */
		public int type;
		/** coordonnées */
		public int x,y;
		/** le ointeur concerné */
		public int pointer;
	}

	/**
	 * Indique si la touche demandée est pressé
	 * @param keyCode : la touche demandée
	 * @return true si touche pressée, false sinon
	 */
	public boolean isKeyPressed(int keyCode);
	
	/**
	 * Indique si le pointeur demandé touche l'écran
	 * @param pointer : le pointeur demandé
	 * @return true si écran touché par le pointeur, false sinon
	 */
	public boolean isTouchDown(int pointer);

	/**
	 * Donne l'abscisse du point de contact du pointeur demandé
	 * @param pointer : le pointeur demandé
	 * @return l'abscisse du point de contact du pointeur
	 */
	public int getTouchX(int pointer);

	/**
	 * Donne l'ordonnée du point de contact du pointeur demandé
	 * @param pointer : le pointeur demandé
	 * @return l'ordonnée du point de contact du pointeur
	 */
	public int getTouchY(int pointer);

	/**
	 * Donne l'accélération sur l'axe X
	 * @return l'accélation sur X
	 */
	public float getAccelX();

	/**
	 * Donne l'accélération sur l'axe Y
	 * @return l'accélation sur Y
	 */
	public float getAccelY();

	/**
	 * Donne l'accélération sur l'axe Z
	 * @return l'accélation sur Z
	 */
	public float getAccelZ();

	/**
	 * Récupère les derniers évenements du clavier
	 * @return liste ordonnée d'évenement du clavier
	 */
	public List<KeyEvent> getKeyEvents();

	/**
	 * Récupère les derniers évenements du touchscreen
	 * @return liste ordonnée d'évenement du touchscreen
	 */
	public List<TouchEvent> getTouchEvents();
}