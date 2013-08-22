package yoan.game.framework.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Structure de donnée permettant de réutiliser les instances des éléments inutilsés
 * @author yoan
 */
public class Pool<T> {
	/**
	 * Factory d'élément du Pool
	 * @author yoan
	 */
	public interface PoolObjectFactory<T> {
		public T createObject();
	}
	
	/** liste des instances non utilisées */
	private final List<T> freeObjects;
	/** Factory d'élement */
	private final PoolObjectFactory<T> factory;
	/** Nombre d'élément maximum contenu dans le Pool */
	private final int maxSize;
	
	/**
	 * Constructeur
	 * @param factory : factory d'élement
	 * @param maxSize : nombre d'élément maximum contenu dans le Pool
	 */
	public Pool(PoolObjectFactory<T> factory, int maxSize){
		this.factory= factory;
		this.maxSize= maxSize;
		this.freeObjects= new ArrayList<T>(maxSize);
	}
	
	/**
	 * Ajoute un nouvel élément au pool
	 * @return le nouvel élément
	 */
	public T newObject(){
		return freeObjects.isEmpty() ? 
				factory.createObject() 
			  : freeObjects.remove(freeObjects.size() - 1);
	}
	
	/**
	 * Indique qu'un élément n'est plus utilisé
	 * @param object
	 */
	public void free(T object){
		//s'il y a trop d'instance libre dans le pool, l'élément dera détruit par le GC
		if(freeObjects.size() < maxSize) freeObjects.add(object);
	}
}