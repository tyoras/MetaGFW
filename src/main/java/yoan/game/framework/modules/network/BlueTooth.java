package yoan.game.framework.modules.network;


/**
 * 
 * @author yoan
 */
public interface BlueTooth {
	
	/**
     * Prépare l'utilisation du Bluetooth
     */
    public void setupBlueTooth();
    
	/**
     * Indique si le Bluetooth est en cours d'utilisation
     */
	public boolean isRunning();
	

    /**
     * Lance la recherche et le choix de l'appareil
     */
    public void searchDevice();
    
    /**
     * Fournit le nom d device connecté s'il y en a un, null sinon
     * @return String
     */
    public String getConnectedDeviceName();
    	
	/**
     * Effectue la connexion avec un appareil donnée par son adresse MAC
     * @param macAdress : adresse MAC sur laquelle on veut se connecter
     */
    public void connectDevice(String macAdress);
    
	/**
     * Arret de l'utilisation du BlueTooth
     */
	public void stop();
}