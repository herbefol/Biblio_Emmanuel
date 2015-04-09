/**
 * 
 */
package biblio.metier.personnes;

import java.util.ArrayList;
import java.util.Date;

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
	
	public Utilisateur(String nom, String prenom, Date dateNaissance, String sexe, int idUtilisateur, String pwd, String pseudonyme) {
		super(nom,prenom,dateNaissance,sexe);
		this.idUtilisateur = idUtilisateur;
		this.pwd = pwd;
		this.pseudonyme = pseudonyme;
	}
	
/*	public Utilisateur(int idUtilisateur, String pwd, String pseudonyme) 
	{
		this.idUtilisateur = idUtilisateur;
		this.pwd = pwd;
		this.pseudonyme = pseudonyme;
	}
	
	public Utilisateur(int idUtilisateur, String pwd)
	{
		
	}
	
	public Utilisateur(int idUtilisateur)
	{
		
	}
	
	public Utilisateur()
	{
			}
*/	
	/**
	 * @return l'ID de l'
	 * Utilisateur
	 */
	public int getIdUtilisateur() 
	{
		return idUtilisateur;
	}

	/**
	 * @param idUtilisateur l'ID de l'utilisateur à mettre
	 */
	public void setIdUtilisateur(int idUtilisateur) 
	{
		this.idUtilisateur = idUtilisateur;
	}

	/**
	 * @return le pwd
	 */
	public String getPwd() 
	{
		return pwd;
	}

	/**
	 * @param pwd le mot de passe a mettre
	 */
	public void setPwd(String pwd) 
	{
		this.pwd = pwd;
	}

	/**
	 * @return le pseudonyme
	 */
	public String getPseudonyme() 
	{
		return pseudonyme;
	}

	/**
	 * @param pseudonyme le pseudonyme a mettre
	 */
	public void setPseudonyme(String pseudonyme) 
	{
		this.pseudonyme = pseudonyme;
	}

	
	public ArrayList<EmpruntEnCours> getEmpruntEnCours() {
		return empruntEnCours;
	}

	public void setEmpruntEnCours(ArrayList<EmpruntEnCours> empruntEnCours) {
		this.empruntEnCours = empruntEnCours;
	}

	@Override
	public String toString() 
	{
		return "Utilisateur [idUtilisateur :" 		+ idUtilisateur 
								  + ", pwd=" 		+ pwd
								  + ", pseudonyme=" + pseudonyme + "]";
	}

	public int getNbEmpruntEnCours() {
		return empruntEnCours.size();
	}

	public boolean isConditionsPretAcceptees(){
		return true;
	}
	

}
