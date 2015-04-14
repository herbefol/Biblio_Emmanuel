package biblio.metier;

/**
 * Cette classe contient l'exception métier BiblioException. C'est elle qui permet au système
 * de gérer les exceptions dans les cas d'utilisation.
 * @author Ak.vin / ManuL
 * @version 1.0
 */
public class BiblioException extends Exception {
	
	public BiblioException () {
	}
	
	public BiblioException(String message) {
		super(message);
	}

}
