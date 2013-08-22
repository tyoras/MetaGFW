package yoan.game.framework.modules.fileio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Gestion des fichiers du jeu
 * @author yoan
 */
public interface FileIO {
	
	/**
	 * Lecture d'un asset
	 * @param fileName : nom du fichier à lire
	 * @return InputStream
	 * @throws IOException : en cas de problème
	 */
	public InputStream readAsset(String fileName) throws IOException;
	
	/**
	 * Lecture d'un fichier
	 * @param fileName : nom du fichier à lire
	 * @return InputStream
	 * @throws IOException : en cas de problème
	 */
	public InputStream readFile(String fileName) throws IOException;
	
	/**
	 * Ecriture dans un fichier
	 * @param fileName : nom du fichier à écrire
	 * @return OutputStream
	 * @throws IOException : en cas de problème
	 */
	public OutputStream writeFile(String fileName) throws IOException;
}
