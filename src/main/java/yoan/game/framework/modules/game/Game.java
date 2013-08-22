package yoan.game.framework.modules.game;

import yoan.game.framework.modules.audio.Audio;
import yoan.game.framework.modules.fileio.FileIO;
import yoan.game.framework.modules.graphics.Graphics;
import yoan.game.framework.modules.input.Input;
import yoan.game.framework.modules.network.BlueTooth;
import yoan.game.framework.modules.screen.Screen;

/**
 * gestion des composants du jeu
 * @author yoan
 */
public interface Game {
	
	/**
	 * Récupération de la gestion des entrées
	 * @return Input
	 */
	public Input getInput();
	 
	/**
	 * Récupération de la gestion des fichiers
	 * @return FileIO
	 */
	public FileIO getFileIO();
	 
	/**
	 * Récupération de la gestion des graphismes
	 * @return Graphics
	 */
	public Graphics getGraphics();
	 
	/**
	 * Récupération de la gestion de l'audio
	 * @return Audio
	 */
	public Audio getAudio();
	
	/**
	 * Récupération de la gestion du BlueTooth
	 * @return Audio
	 */
	public BlueTooth getBlueTooth();
	
	/**
	 * Définit l'écran courant
	 * @param screen 
	 */
	public void setScreen(Screen screen);
	 
	/**
	 * Récupère l'écran courant
	 * @return Screen
	 */
	public Screen getCurrentScreen();
	 
	/**
	 * Récupère l'écran de démarrage
	 * @return Screen
	 */
	public Screen getStartScreen();
}
