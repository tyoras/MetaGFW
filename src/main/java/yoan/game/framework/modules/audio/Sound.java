package yoan.game.framework.modules.audio;

/**
 * Gestion des sons (audio entierement en mémoire)
 * @author yoan
 */
public interface Sound {
	
	/**
	 * Lit le son à un volume donné
	 * @param volume [0 (silence); 1 (volume max)]
	 */
	public void play(float volume);

	/**
	 * Libère la mémoire prise par le son 
	 */
	public void dispose();
}
