/**
 * 
 */
package biblio.metier.personnes;

import java.util.ArrayList;
import java.util.Date;

import biblio.metier.BiblioException;
import biblio.metier.ouvrages.EmpruntEnCours;

/**
 * @author Ak.vin / ManuL
 *
 */
public class Utilisateur extends Personne 
{

	private int idUtilisateur;
	private String pwd;
	private String pseudonyme;
	private ArrayList<EmpruntEnCours> empruntEnCours;
	
	/**
	 * Constructeur avec tous les paramètres.
	 * @param nom Le nom de l'utilisateur.
	 * @param prenom Le préom de l'utilisateur.
	 * @param dateNaissance La date de naissance de l'utilisateur.
	 * @param sexe Le sexe de l'utilisateur.
	 * @param idUtilisateur L'ID de l'utilisateur.
	 * @param pwd Le mot de passe de l'utilisateur.
	 * @param pseudonyme Le pseudonyme de l'utilisateur.
	 */
	public Utilisateur(String nom, String prenom, Date dateNaissance, String sexe
			, int idUtilisateur, String pwd, String pseudonyme) 
	{
		super(nom,prenom,dateNaissance,sexe);
		this.idUtilisateur = idUtilisateur;
		this.pwd = pwd;
		this.pseudonyme = pseudonyme;
		this.empruntEnCours = new ArrayList<EmpruntEnCours>();
	}

	/**
	 * Accesseur sur l'ID de l'utilisateur.
	 * @return idUtilisateur L'ID de l'Utilisateur.
	 */
	public int getIdUtilisateur() 
	{
		return idUtilisateur;
	}

	/**
	 * Mutateur sur l'ID de l'utilisateur.
	 * @param idUtilisateur L'ID de l'utilisateur.
	 */
	public void setIdUtilisateur(int idUtilisateur) 
	{
		this.idUtilisateur = idUtilisateur;
	}

	/**
	 * Accesseur sur le mot de passe de l'utilisateur.
	 * @return pwd Le mot de passe de l'utilisateur.
	 */
	public String getPwd() 
	{
		return pwd;
	}

	/**
	 * Mutateur sur le mot de passe de l'utilisateur.
	 * @param pwd Le mot de passe de l'utilisateur.
	 */
	public void setPwd(String pwd) 
	{
		this.pwd = pwd;
	}

	/**
	 * Accesseur sur le pseudonyme de l'utilisateur.
	 * @return pseudonyme Le pseudonyme de l'utilisateur.
	 */
	public String getPseudonyme() 
	{
		return pseudonyme;
	}

	/**
	 * Mutateur sur le pseudonyme de l'utlisateur.
	 * @param pseudonyme Le pseudonyme de l'utilisateur.
	 */
	public void setPseudonyme(String pseudonyme) 
	{
		this.pseudonyme = pseudonyme;
	}

	
	/**
	 * Méthode getEmpruntEnCours() permet d'obtenir l'emprunt en cours d'un utilisateur.
	 * @return empruntEnCours L'emprunt en cours d'un utilisaeur.
	 */
	public ArrayList<EmpruntEnCours> getEmpruntEnCours() 
	{
		return empruntEnCours;
	}

	/**
	 * Mutateur sur l'emprunt en cours.
	 * @param empruntEnCours l(emprunt en cours de l'utilisateur.
	 */
	public void setEmpruntEnCours(ArrayList<EmpruntEnCours> empruntEnCours) 
	{
		this.empruntEnCours = empruntEnCours;
	}

	@Override
	public String toString() 
	{
		return "Utilisateur [nom  : " + this.getNom() + ", prénom : " + this.getPrenom()
				+ ", idUtilisateur : " + this.idUtilisateur + ", pseudonyme : " + this.pseudonyme + "]";
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (o==this)
			return true;
		if (o instanceof Utilisateur) 
		{
			Utilisateur u = (Utilisateur) o;
			if (!this.getNom().equals(u.getNom())) 
			{
				return false;
			}
			if (!this.getPrenom().equals(u.getPrenom())) 
			{
				return false;
			}
			if (this.idUtilisateur!=u.idUtilisateur) 
			{
				return false;
			}
			if (!this.pseudonyme.equals(u.pseudonyme)) 
			{
				return false;
			}
			return true;			
		}
		return false;
	}
	
	public int hashCode() 
	{
		int hash = 3;
		hash = hash * 5 + this.getNom().hashCode();
		hash = hash * 7 + this.getPrenom().hashCode();
		hash = hash * 11 + this.idUtilisateur;
		hash = hash * 13 + this.pseudonyme.hashCode();
		return hash;
	}
	
	/**
	 * Méthode getNbEmpruntEnCours() permet d'obtenir le nombre d'meprunt en cours d'un utilisateur.
	 * @return empruntEnCours.size() Le nombre d'emprunt en cours de l'utilsiateur.
	 */
	public int getNbEmpruntEnCours() 
	{
		if (this.empruntEnCours==null)
			return 0;
		return empruntEnCours.size();
	}

	/**
	 * Méthode isConditionsPretAcceptees() permet de vérifier la condition de prêt pour un utilisateur
	 * @return false faux si l'utilisateur ne peut emprunter un exemplaire.
	 */
	public boolean isConditionsPretAcceptees() throws BiblioException
	{
		return false;
	}
	
	/**
	 * Méthode addEmpruntEnCours() permet d'ajouter un emprunt en cours à un utilisateur.
	 * @param emp L'emprunt en cours ajouter à l'utilisateur.
	 */
	public void addEmpruntEnCours(EmpruntEnCours emp) throws BiblioException 
	{
		if (this.isConditionsPretAcceptees()) 
		{
			this.empruntEnCours.add(emp);
		}
	}
	
	/**
	 * Méthode removeEnpruntEnCours() permet d'enlever un emprunt 
	 * de la list des emprunt en cours d'un utilisateur.
	 * @param emp L'emprunt en cours enlever de la liste des emprunts de l'utilisateur.
	 */
	public void removeEmpruntEnCours(EmpruntEnCours emp) 
	{
		this.empruntEnCours.remove(emp);
	}

}
