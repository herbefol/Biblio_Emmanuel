/**
 * 
 */
package biblio.metier.personnes;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

import biblio.metier.BiblioException;
import biblio.metier.ouvrages.EmpruntEnCours;

/**
 * @author Ak.vin / ManuL
 *
 */
public class Adherent extends Utilisateur
{
	
	private String telephone;
	private static int nbMaxPrets = 3;
	private static int dureeMaxPrets = 15;

	/**
	 * Constructeur avec tous les paramètres.
	 * @param nom Le nom de l'adhérent.
	 * @param prenom Le prénom de l'adhérent.
	 * @param dateNaissance La date de naissance de l'adhérent.
	 * @param sexe Le sexe de l'adhérent.
	 * @param idUtilisateur L'ID de l'utilisateur qui c'est référencé.
	 * @param pwd Le mot de passe de l'adhérent.
	 * @param pseudonyme Le pseudonyme de l'adhérent.
	 * @param telephone le numéro de téléphone de l'adhérent.
	 */
	public Adherent (String nom, String prenom, Date dateNaissance, String sexe, int idUtilisateur, 
			String pwd, String pseudonyme, String telephone) 
	{
		super(nom, prenom, dateNaissance, sexe, idUtilisateur, pwd, pseudonyme);
		this.telephone = telephone;
	}
	
	/**
	 * Accesseur sur le téléphone de l'adhérent.
	 * @return telephone Le numéro de téléphone de l'adhérent.
	 */
	public String getTelephone() 
	{
		return telephone;
	}

	/**
	 * Mutateur sur le téléphone de l'adhérent.
	 * @param telephone Le numéro de téléphone de l'adhérent.
	 */
	public void setTelephone(String telephone) 
	{
		this.telephone = telephone;
	}

	/**
	 * Accesseur sur le nombre max de prêts.
	 * @return nbMaxPrets le nombre max de prêts.
	 */
	public static int getNbMaxPrets() 
	{
		return nbMaxPrets;
	}

	/**
	 * Mutateur sur le nombre max de prêts.
	 * @return nbMaxPrets Le nombre max de prêts.
	 */
	public static void setNbMaxPrets(int nbMaxPrets) 
	{
		Adherent.nbMaxPrets = nbMaxPrets;
	}

	/**
	 * Accesseur sur la durée max d'un prêt.
	 * @return dureeMaxPrets La durée macimum pour un prêt.
	 */
	public static int getDureeMaxPrets() 
	{
		return dureeMaxPrets;
	}

	/**
	 * Mutateur sur la durée max d'un prêt.
	 * @return dureeMaxPrets La durée macimum pour un prêt.
	 */
	public static void setDureeMaxPrets(int dureeMaxPrets) 
	{
		Adherent.dureeMaxPrets = dureeMaxPrets;
	}

	@Override
	public String toString() 
	{
		return "Adhérent[Nom : " + this.getNom() + ", Prénom : " + this.getPrenom() + ", idUtilisateur : "
				+ this.getIdUtilisateur() + ", pseudonyme : " + this.getPseudonyme() + "]";
	}
	
	@Override
	public boolean equals(Object o) 
	{
		if (this==o) {
			return true;
		}
		if (o instanceof Adherent) {
			Adherent a = (Adherent) o;
			if (!this.getNom().equals(a.getNom())) {
				return false;
			}
			if (!this.getPrenom().equals(a.getPrenom())) {
				return false;
			}
			if (this.getIdUtilisateur()!=a.getIdUtilisateur()) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() 
	{
		int hash = 7;
		hash = hash * 11 + this.getNom().hashCode();
		hash = hash * 13 + this.getPrenom().hashCode();
		hash = hash * 17 + this.getIdUtilisateur();
		return hash;
	}
	
	@Override
	public boolean isConditionsPretAcceptees() throws BiblioException
	{
		if (this.getNbEmpruntEnCours()>=nbMaxPrets) 
		{
			throw new BiblioException("Impossible, cet adhérent a déjà atteint le nombre maximum d'emprunt.");
		}
		if (this.getNbRetards()!=0) 
		{
			throw new BiblioException("Impossible, cet adhérent a au moins un prêt en retard.");
		}
		return true;
	}
	
	/**
	 * Méthode getNbRetards() qui permet pour un même utilisateur 
	 * de calculer le nombre d'exemplaire emprunté qui sont en retard.
	 * @return nb Le nombre d'exemplaires empruntés en retards.
	 */
	public int getNbRetards() 
	{
		int nb = 0; //ArrayList<EmpruntEnCours> empruntEnRetard = new ArrayList<EmpruntEnCours>()
		Iterator<EmpruntEnCours> it = this.getEmpruntEnCours().iterator();
		while (it.hasNext()) 
		{
			EmpruntEnCours emp = it.next();
			GregorianCalendar calendrier = new GregorianCalendar();
			calendrier.add(GregorianCalendar.DAY_OF_YEAR, -(dureeMaxPrets+1));
			Date prêt = calendrier.getTime();
			if (prêt.after(emp.getDateEmprunt())) 
			{
				nb++; //empruntEnRetard.add(emp)
			}
		}
		return nb;
	}
	
	/** Méthode getRetards() qui permet d'obtenir l'exemplaire en retard pour d'un utilisateur.
	 * @return empruntEnRetard l'exemplaire en retard de l'utilisateur.
	 */
	public ArrayList<EmpruntEnCours> getRetards() 
	{
		ArrayList<EmpruntEnCours> empruntEnRetard = new ArrayList<EmpruntEnCours>();
		Iterator<EmpruntEnCours> it = this.getEmpruntEnCours().iterator();
		while (it.hasNext()) 
		{
			EmpruntEnCours emp = it.next();
			GregorianCalendar calendrier = new GregorianCalendar();
			calendrier.add(GregorianCalendar.DAY_OF_YEAR, -(dureeMaxPrets+1));
			Date prêt = calendrier.getTime();
			if (prêt.after(emp.getDateEmprunt())) 
			{
				empruntEnRetard.add(emp);
			}
		}
		return empruntEnRetard ;
	}
	
}
