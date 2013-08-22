package yoan.game.framework.modules.graphics;


/**
 * Classe permettant de compter le nombre de Frame Par Seconde
 * @author yoan
 */
public abstract class FPSCounter {
	/** Temps au début du dernier calcul */
	private long startTime= System.nanoTime();
	/** Nombre de frame compté durant la seconde */
	protected int frames= 0;

	/**
	 * Affiche le nombre de fois où cette fonction est appelée par seconde
	 */
	public void logFrame() {
    	frames++;
    	//s'il s'est écoulé plus d'une seconde depuis le dernier appel
    	if(System.nanoTime() - startTime >= 1000000000) {
    		trace();
        	//on réinitialise le calcul
        	frames = 0;
        	startTime = System.nanoTime();
    	}
	}
	
	/**
	 * Ecrit une trace indiquant le nombre de FPS
	 */
	protected abstract void trace();
}