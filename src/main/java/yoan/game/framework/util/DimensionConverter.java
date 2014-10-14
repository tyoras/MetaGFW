package yoan.game.framework.util;

/**
 * permet de convertir des dimensions réelles en dimension du jeu
 * @author yoan
 */
public class DimensionConverter {
	/** Taille d'un élément basique du jeu, soit l"équivalent d'un mètre */
	private int basicWorldElementSize = 0;
	
	/**
	 * 
	 * @param basicElementsize : la taille en pixel d'un mètre dans le jeu
	 */
	public DimensionConverter(int basicElementsize) { 
		Preconditions.checkArgument(basicElementsize > 0);
		basicWorldElementSize = basicElementsize;
	}
	
	/**
	 * Converti une taille en pixel en une taille in game
	 * @param sizeInPixel
	 * @return inGameSize
	 */
	public float pixelsToGameSize(float sizeInPixel) {
		return sizeInPixel / (float) basicWorldElementSize;
	}
	
	/**
	 * Converti une taille in game en une taille en pixel avec arrondi supérieur
	 * @param inGameSize
	 * @return sizeInPixel
	 */
	public int gameSizeToPixels(float inGameSize) {
		return (int) Math.floor(inGameSize * basicWorldElementSize);
	}
}