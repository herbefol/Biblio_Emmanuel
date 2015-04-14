package biblio.metier.ouvrages;

import java.text.SimpleDateFormat;
import java.util.Date;

import biblio.metier.personnes.Utilisateur;

/**
 * @author A.Kvin / ManuL
 *
 */
public class EmpruntArchive {
	
	private Date dateRestitutionEff;
	private Date dateEmprunt;
	private Exemplaire exemplaire;
	private Utilisateur emprunteur;
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	
	/**
	 * Constructeur avec tous les paramètres.
	 * @param dateRestitutionEff
	 * @param dateEmprunt
	 * @param exemplaire
	 * @param emprunteur
	 */
	public EmpruntArchive(Date dateRestitutionEff, Date dateEmprunt, Exemplaire exemplaire, Utilisateur emprunteur) {
		this.dateRestitutionEff = dateRestitutionEff;
		this.dateEmprunt = dateEmprunt;
		this.exemplaire = exemplaire;
		this.emprunteur = emprunteur;
	}

	/**
	 * Accesseur sur la date de restitution de l'exemplaire.
	 * @return dateRestutionEff La date de restitution de l'exemplaire.
	 */
	public Date getDateRestitutionEff() {
		return dateRestitutionEff;
	}

	/**
	 * Mutateur sur la date de restitution de l'exemplaire.
	 * @param dateRestitutionEff la date de restitution effective de l'exemplaire.
	 */
	public void setDateRestitutionEff(Date dateRestitutionEff) {
		this.dateRestitutionEff = dateRestitutionEff;
	}

	/**
	 * Accesseur sur la date d'emprunt de l'exemplaire.
	 * @return dateEmprunt La date d'emprunt de l'exemplaire.
	 */
	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	/**
	 * Mutateur sur la date d'emprunt de l'exemplaire.
	 * @param dateEmprunt La date d'emprunt de l'exemplaire.
	 */
	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	/**
	 * Accesseur sur l'exemplaire.
	 * @return exemplaire L'exemplaire.
	 */
	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	/**
	 * Mutateur sur l'exemplaire.
	 * @param exemplaire L'exemplaire.
	 */
	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}

	/**
	 * Accesseur sur l'utilisateur qui emprunte l'exemplaire.
	 * @return emprunteur L'utilisateur qui emprunte l'exemplaire.
	 */
	public Utilisateur getEmprunteur() {
		return emprunteur;
	}

	/**
	 * Mutateur sur l'utilisateur qui emprunte l'exemplaire.
	 * @param emprunteur L'utilisateur qui emprunte l'exemplaire.
	 */
	public void setEmprunteur(Utilisateur emprunteur) {
		this.emprunteur = emprunteur;
	}

	
	@Override
	public String toString() 
	{
		return "EmpruntArchive \n[dateRestitutionEff : " 	+ sdf.format(dateRestitutionEff)
							+ "\ndateEmprunt() : " 		+ sdf.format(dateEmprunt)
							+ "\nexemplaire() : " 		+ getExemplaire() 
							+ "\nemprunteur() : "		+ getEmprunteur() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateEmprunt == null) ? 0 : dateEmprunt.hashCode());
		result = prime * result
				+ ((emprunteur == null) ? 0 : emprunteur.hashCode());
		result = prime * result
				+ ((exemplaire == null) ? 0 : exemplaire.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpruntArchive other = (EmpruntArchive) obj;
		if (dateEmprunt == null) {
			if (other.dateEmprunt != null)
				return false;
		} else if (!dateEmprunt.equals(other.dateEmprunt))
			return false;
		if (emprunteur == null) {
			if (other.emprunteur != null)
				return false;
		} else if (!emprunteur.equals(other.emprunteur))
			return false;
		if (exemplaire == null) {
			if (other.exemplaire != null)
				return false;
		} else if (!exemplaire.equals(other.exemplaire))
			return false;
		return true;
	}
	
	
	
}
