package yoan.game.framework.modules.audio;

/**
 * Gestion de l'audio du jeu
 * @author yoan
 */
public interface Audio {
	
	/**
	 * Créer une music à partir d'un fichier
	 * @param filename : fichier à lire
	 * @return la music
	 */
	public Music newMusic(String filename);
	
	/**
	 * Créer un son à partir d'un fichier
	 * @param filename : fichier à lire
	 * @return le son
	 */
	public Sound newSound(String filename);
}