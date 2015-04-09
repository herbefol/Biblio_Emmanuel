/**
 * 
 */
package biblio.metier.personnes;

import java.util.Date;

/**
 * @author Ak.vin / ManuL
 *
 */
public class Adherent extends Utilisateur
{
	
	private String telephone;
	private static int nbMaxPrets = 3;
	private static int dureeMaxPrets = 15;

	public Adherent (String nom, String prenom, Date dateNaissance, String sexe, int idUtilisateur, 
			String pwd, String pseudonyme, String telephone) {
		super(nom, prenom, dateNaissance, sexe, idUtilisateur, pwd, pseudonyme);
		this.telephone = telephone;
	}
	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public static int getNbMaxPrets() {
		return nbMaxPrets;
	}

	public static void setNbMaxPrets(int nbMaxPrets) {
		Adherent.nbMaxPrets = nbMaxPrets;
	}

	public static int getDureeMaxPrets() {
		return dureeMaxPrets;
	}

	public static void setDureeMaxPrets(int dureeMaxPrets) {
		Adherent.dureeMaxPrets = dureeMaxPrets;
	}

	@Override
	public boolean isConditionsPretAcceptees(){
		return true;
	}
	
	public int getNbRetards() {
		return 0;
	}

}
