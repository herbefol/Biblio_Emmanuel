package biblio.metier.personnes;

import java.util.Date;

/**
 * @author Kévin
 *
 */
public class Personne 
{
	
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String sexe;
	
	/**
	 * Constructeur avec tous les paramètres.
	 * @param nom d'une personne.
	 * @param prenom d'une personne.
	 * @param dateNaissance d'une personne.
	 * @param sexe d'une personne.
	 */
	public Personne(String nom, String prenom, Date dateNaissance, String sexe) 
	{
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
	}
	
	/**
	 * Accesseur sur le nom de la personne.
	 * @return nom Le nom de la personne.
	 */
	public String getNom() 
	{
		return nom;
	}
	
	/**
	 * Mutateur sur le nom de la personne.
	 * @param nom Le nom de la personne.
	 */
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	
	/**
	 * Accesseur sur le prénom de la personne.
	 * @return prenom Le prénom de la personne.
	 */
	public String getPrenom() 
	{
		return prenom;
	}
	
	/**
	 * Mutateur sur le prénom de la personne. 
	 * @param prenom Le prénom de la personne.
	 */
	public void setPrenom(String prenom) 
	{
		this.prenom = prenom;
	}
	
	/**
	 * Accesseur sur la date de naissance de la personne.
	 * @return dateNaissance La date de naissance.
	 */
	public Date getDateNaissance() 
	{
		return dateNaissance;
	}
	
	/**
	 * Mutateur sur la date de naissance de la personne.
	 * @param dateNaissance La date de naissance de la personne.
	 */
	public void setDateNaissance(Date dateNaissance) 
	{
		this.dateNaissance = dateNaissance;
	}
	
	/**
	 * Accesseur sur le sexe de la personne.
	 * @return sexe Le sexe de la personne.
	 */
	public String getSexe() 
	{
		return sexe;
	}
	
	/**
	 * Mutateur sur le sexe de la personne.
	 * @param sexe Le sexe de la personne.
	 */
	public void setSexe(String sexe) 
	{
		this.sexe = sexe;
	}
	
	@Override
	public String toString() 
	{
		return "Personne [nom : "+ this.nom + ", prénom : " + this.prenom
				+ ", date de naissance : " + this.dateNaissance + "]"; 
	}
	
	@Override
	public boolean equals(Object o) 
	{
		if (o==this)
			return true;
		if (o instanceof Personne) 
		{
			Personne p = (Personne) o;
			if (!this.nom.equals(p.nom)) 
			{
				return false;
			}
			if (!this.prenom.equals(p.prenom)) 
			{
				return false;
			}
			if(this.dateNaissance!=p.dateNaissance) 
			{
				if(!this.dateNaissance.equals(p.dateNaissance)) 
				{
					return false;
				}
			}
			if (!this.sexe.equals(p.sexe)) 
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
		int hash = 1;
		hash = hash * 3 + this.nom.hashCode();
		hash = hash * 5 + this.prenom.hashCode();
		hash = hash * 7 + this.dateNaissance.hashCode();
		hash = hash * 11 + this.sexe.hashCode();
		return hash;
	}

}
