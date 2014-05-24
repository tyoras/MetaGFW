package yoan.game.framework.util.math;



/**
 * Représentation et gestion d'un vecteur 2D
 * @author yoan
 */
public class Vector2 {
	/** Constante pour passer d'un angle en degré à un angle en radian */
	public static float TO_RADIANS= (1 / 180.0f) * (float) Math.PI;
	/** Constante pour passer d'un angle en radian à un angle en degré */
	public static float TO_DEGREES= (1 / (float) Math.PI) * 180;
	/** Abscisse du vecteur */
	public float x;
	/** ordonnée du vecteur */
	public float y;
	
	/** Constructeur par défaut */
	public Vector2(){}

	/** 
	 * Constructeur par valeur
	 * @param x
	 * @param y
	 */
	public Vector2(float x, float y){
		this.x= x;
		this.y= y;
	}

	/** 
	 * Constrcuteur par copie
	 * @param other : vecteur à copier
	 */
	public Vector2(Vector2 other){
		this.x= other.x;
		this.y= other.y;
	}
	
	/**
	 * Duplique le vecteur
	 * @return la copie du vecteur
	 */
	public Vector2 cpy() {
		return new Vector2(x, y);
	}
	
	/**
	 * Valorise le vecteur
	 * @param x
	 * @param y
	 * @return vecteur
	 */
	public Vector2 set(float x, float y){
		this.x= x;
		this.y= y;
		return this;
	}

	/**
	 * Valorisation à partir des valeurs d'un autre vecteur
	 * @param other
	 * @return vecteur
	 */
	public Vector2 set(Vector2 other){
		this.x= other.x;
		this.y= other.y;
		return this;
	}
	
	/**
	 * Addition de vecteur
	 * @param x
	 * @param y
	 * @return vecteur mis à jour
	 */
	public Vector2 add(float x, float y){
		this.x+= x;
		this.y+= y;
		return this;
	}

	/**
	 * Addition de vecteur
	 * @param other
	 * @return vecteur mis à jour
	 */
	public Vector2 add(Vector2 other){
		this.x+= other.x;
		this.y+= other.y;
		return this;
	}

	/**
	 * Soustraction de vecteur
	 * @param x
	 * @param y
	 * @return vecteur mis à jour
	 */
	public Vector2 sub(float x, float y){
		this.x-= x;
		this.y-= y;
		return this;
	}

	/**
	 * Soustraction de vecteur
	 * @param other
	 * @return vecteur mis à jour
	 */
	public Vector2 sub(Vector2 other){
		this.x-= other.x;
		this.y-= other.y;
		return this;
	}
	
	/**
	 * Multiplication scalaire
	 * @param scalar
	 * @return vecteur mis à jour
	 */
	public Vector2 mul(float scalar) {
		this.x *= scalar;
		this.y *= scalar;
		return this;
	}
	
	/**
	 * Calcule la taille du vecteur
	 * @return taille du vecteur
	 */
	public float len(){
		return (float) Math.sqrt(x * x + y * y);
	}
	
	/**
	 * Normalisation du  vecteur
	 * @return vecteur mis à jour
	 */
	public Vector2 nor(){
		float len= len();
		if(len != 0){
			this.x/= len;
			this.y/= len;
		}
		return this;
	}
	
	/** 
	 * Calcule l'angle du vecteur avec l'axe X
	 * @return angle en degré [0,360]
	 */
	public float angle(){
		float angle= (float) Math.atan2(y, x) * TO_DEGREES;
		if(angle < 0) angle+= 360;
		return angle;
	}
	
	/**
	 * Rotation du vecteur
	 * @param angle : angle de rotation
	 * @return vecteur mis à jour
	 */
	public Vector2 rotate(float angle){
		float rad= angle * TO_RADIANS;
		float cos= (float) Math.cos(rad);
		float sin= (float) Math.sin(rad);
		float newX= this.x * cos - this.y * sin;
		float newY= this.x * sin + this.y * cos;
		this.x= newX;
		this.y= newY;
		return this;
	}
	
	/**
	 * Calcule la distance avec un autre vecteur
	 * @param other
	 * @return distance
	 */
	public float dist(Vector2 other){
		float distX= this.x - other.x;
		float distY= this.y - other.y;
		return (float) Math.sqrt(distX * distX + distY * distY);
	}

	/**
	 * Calcule la distance avec un autre vecteur
	 * @param x
	 * @param y
	 * @return distance
	 */
	public float dist(float x, float y){
		float distX= this.x - x;
		float distY= this.y - y;
		return (float) Math.sqrt(distX * distX + distY * distY);
	}
	
	/**
	 * Calcule la distance au carré avec un autre vecteur
	 * @param other
	 * @return distance
	 */
	public float distSquared(Vector2 other) {
		float distX = this.x - other.x;
		float distY = this.y - other.y;
		return distX * distX + distY * distY;
	}
	
	/**
	 * Calcule la distance au carré avec un autre vecteur
	 * @param x
	 * @param y
	 * @return distance
	 */
	public float distSquared(float x, float y){
		float distX= this.x - x;
		float distY= this.y - y;
		return distX * distX + distY * distY;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode(){
		final int prime= 31;
		int result= 1;
		result= prime * result + Float.floatToIntBits(x);
		result= prime * result + Float.floatToIntBits(y);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj){
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		Vector2 other= (Vector2) obj;
		if(Float.floatToIntBits(x) != Float.floatToIntBits(other.x)) return false;
		if(Float.floatToIntBits(y) != Float.floatToIntBits(other.y)) return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return "Vector2 [" + x + ", " + y + "]";
	}
	
	
}