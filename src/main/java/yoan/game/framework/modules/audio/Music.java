package yoan.game.framework.modules.audio;

/**
 * Gestion des musics (audio streamé)
 * @author yoan
 */
public interface Music {
	
	/**
	 * Lecture de la music
	 */
	public void play();
	
	/**
	 * Arret de la lecture
	 */
	public void stop();
	 
	/**
	 * Pause de la lecture
	 */
	public void pause();
	
	/**
	 * Active/Désactive la mise en boucle
	 * @param looping : indique si la music est lue en boucle
	 */
	public void setLooping(boolean looping);
	
	/**
	 * Change le volume de lecture
	 * @param volume [0 (silence); 1 (volume max)]
	 */
	public void setVolume(float volume);
	
	/**
	 * Indique si la music est en court de lecture
	 * @return boolean
	 */
	public boolean isPlaying();
	 
	/**
	 * Indique si la music est arrếtée
	 * @return boolean
	 */
	public boolean isStopped();
	
	/**
	 * Indique si la music est lue en boucle
	 * @return boolean
	 */
	public boolean isLooping();
	 
	/**
	 * Ferme le stream de lecture
	 */
	public void dispose();
}
