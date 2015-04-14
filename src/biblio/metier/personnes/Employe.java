/**
 * 
 */
package biblio.metier.personnes;

import java.util.Date;

/**
 * Cette classe  regroupe les trois catégories d'employés pouvant utiliser le système en tant
 * que "professionnel" : Bibliothécaire, Gestionnaire de fonds et Responsable. Cette classe n'a 
 * pas de limitation pour les emprunts.
 * @author Ak.vin / ManuL
 * @version 1.0
 */
public class Employe extends Utilisateur
{

	private String codeMatricule;
	private EnumCategorieEmploye categorieEmploye;
	
	/**
	 * Constructeur avec tous les paramètres.
	 * @param nom Le nom de l'employé.
	 * @param prenom Le prénom de l'employé.
	 * @param dateNaissance La date de naissance de l'employé.
	 * @param sexe Le sexe de l'employé.
	 * @param idUtilisateur L'ID utlisateur de l'employé.
	 * @param pwd Le mot de passe de l'employé.
	 * @param pseudonyme Le pseudonyme de l'employé.
	 * @param codeMatricule Le code matricule de l'employé.
	 * @param categorieEmploye La catégorie de l'employé.
	 */
	public Employe(String nom, String prenom, Date dateNaissance, String sexe, int idUtilisateur, 
			String pwd, String pseudonyme, String codeMatricule, EnumCategorieEmploye categorieEmploye) 
	{
		super(nom, prenom, dateNaissance, sexe, idUtilisateur, pwd, pseudonyme);
		this.codeMatricule = codeMatricule;
		this.categorieEmploye = categorieEmploye;
	}
	
	/**
	 * Accesseur sur le code Matricule de l'employé.
	 * @return codeMatricule Le code matricule de l'employé.
	 */
	public String getCodeMatricule() 
	{
		return codeMatricule;
	}
	
	/**
	 * Mutateur sur le code matricule de l'employé.
	 * @param codeMatricule Le code matricule de l'employé.
	 */
	public void setCodeMatricule(String codeMatricule) 
	{
		this.codeMatricule = codeMatricule;
	}
	
	/**
	 * Accesseur sur la catégorie de l'employé.
	 * @return categorieEmploye La catégorie de l'employé.
	 */
	public EnumCategorieEmploye getCategorieEmploye()
	{
		return categorieEmploye;
	}
	
	/**
	 * Mutateur sur la catégorie de l'employé.
	 * @param categorieEmploye La catégorie de l'employé.
	 */
	public void setCategorieEmploye(EnumCategorieEmploye categorieEmploye) 
	{
		this.categorieEmploye = categorieEmploye;
	}
	
	@Override
	public String toString() 
	{
		return "Employé[Nom : " + this.getNom() + ", Prénom : " + this.getPrenom()
				+ ", idUtilisateur : " + this.getIdUtilisateur() + ", CodeMatricule : " + this.codeMatricule
				+ ", Catégorie : " + this.categorieEmploye + "]";
	}
	
	@Override
	public boolean equals(Object o) 
	{
		if (this==o) 
		{
			return true;
		}
		if (o instanceof Employe) 
		{
			Employe e = (Employe) o;
			if (this.getIdUtilisateur()!=e.getIdUtilisateur()) 
			{
				return false;
			}
			if (!this.codeMatricule.equals(e.codeMatricule)) 
			{
				return false;
			}
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() 
	{
		int hash = 5;
		hash = hash * 7 + this.getIdUtilisateur();
		hash = hash * 11 + this.codeMatricule.hashCode();
		return hash;
	}
	
	@Override
	public boolean isConditionsPretAcceptees()
	{
		return true;
	}
	

	
}
