package yoan.game.framework.modules.screen;

import yoan.game.framework.modules.game.Game;

/**
 * Représentation des écrans du jeu
 * @author yoan
 */
public abstract class Screen {
	/** le jeu au quel appartient l'écran */
	protected final Game game;
	
	/**
	 * Constructeur paramétré
	 * @param game : le jeu au quel appartient l'écran
	 */
	public Screen(Game game) {
		this.game = game;
	}
	
	/**
	 * Met à jour les données de l'écran
	 * @param deltaTime : temps écoulé depuis le dernier update
	 */
	public abstract void update(float deltaTime);
	
	/**
	 * transmet les données de l'écran à l'affichage
	 * @param deltaTime : temps écoulé depuis le dernier affichage
	 */
	public abstract void present(float deltaTime);
	
	/**
	 * Met l'écran en pause
	 */
	public abstract void pause();
	
	/**
	 * Retire la pause
	 */
	public abstract void resume();
	
	/**
	 * Signale que l'écran est désormais inutilisé
	 */
	public abstract void dispose();
}