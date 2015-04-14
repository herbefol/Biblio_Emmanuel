package biblio.metier.ouvrages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

import biblio.metier.BiblioException;
import biblio.metier.personnes.Utilisateur;
import biblio.metier.personnes.Adherent;

/**
 * Cette classe regroupe les emprunts actuellement en cours. Chaque emprunt est relié à
 * l'exemplaire emprunté et à l'utilisateur concerné.
 * @author A.Kvin / ManuL
 * @version 1.0
 */
public class EmpruntEnCours 
{
	
	private Date dateEmprunt;
	private Exemplaire exemplaire;
	private Utilisateur emprunteur;
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	
	/**
	 * Constructeur avec tous les paramètres.
	 * @param dateEmprunt
	 * @param exemplaire
	 * @param emprunteur
	 * @throws BiblioException
	 */
	public EmpruntEnCours(Date dateEmprunt, Exemplaire exemplaire, Utilisateur emprunteur) throws BiblioException 
	{
		this.dateEmprunt = dateEmprunt;
		this.exemplaire = exemplaire;
		this.emprunteur = emprunteur;
		emprunteur.addEmpruntEnCours(this);
		exemplaire.setEmpruntEnCours(this);
		exemplaire.setStatus(EnumStatusExemplaire.PRETE);
	}
	
	/**Accesseur sur la date Emprunt
	 * @return dateEmprunt La date emprunt d'un exemplaire.
	 */
	public Date getDateEmprunt() 
	{
		return dateEmprunt;
	}
	
	/**Mutateur sur la date Emprunt
	 * @return dateEmprunt La date emprunt d'un exemplaire.
	 */
	public void setDateEmprunt(Date dateEmprunt) 
	{
		this.dateEmprunt = dateEmprunt;
	}
	
	/**Accesseur sur l'exemplaire.
	 * @return exemplaire L'exemplaire.
	 */
	public Exemplaire getExemplaire() 
	{
		return exemplaire;
	}
	
	/**
	 * Mutateur sur l'exemplaire.
	 * @param exemplaire L'exemplaire.
	 */
	public void setExemplaire(Exemplaire exemplaire) 
	{
		this.exemplaire = exemplaire;
	}
	
	/**
	 * Accesseur sur l'utilisateur qui emprunte.
	 * @return emprunteur L'utilisateur qui emprunte.
	 */
	public Utilisateur getEmprunteur() 
	{
		return emprunteur;
	}
	
	/**
	 * Mutateur sur l'utilisateur qui emprunte.
	 * @param emprunteur L'utilisateur qui emprunte.
	 */
	public void setEmprunteur(Utilisateur emprunteur) 
	{
		this.emprunteur = emprunteur;
	}

	@Override
	public String toString() 
	{
		return "EmpruntEnCours \n[dateEmprunt : "		+ sdf.format(dateEmprunt)
							+ "\nexemplaire : " 		+ getExemplaire() 
							+ "\nemprunteur : "		+ getEmprunteur() + "]";
	}

	@Override
	public int hashCode() 
	{
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
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpruntEnCours other = (EmpruntEnCours) obj;
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

	/**
	 * Méthode retourExemplaire(dateRetour) pour gérer les retours et archivé le prêt.
	 * @param dateRetour La date de retour de l'exemplaire.
	 * @return EmpruntArchive l'archive de l'emprunt retourné.
	 */
	public EmpruntArchive retourExemplaire(Date dateRetour)
	{
		emprunteur.removeEmpruntEnCours(this);
		exemplaire.setEmpruntEnCours(null);
		exemplaire.setStatus(EnumStatusExemplaire.DISPONIBLE);
		return new EmpruntArchive(dateRetour,this.dateEmprunt,this.exemplaire,this.emprunteur);
	}
	
	/*public boolean isEnRetards() throws BiblioException
	{
		int dureeMaxPrets = 15;
			GregorianCalendar calendrier = new GregorianCalendar();
			calendrier.add(GregorianCalendar.DAY_OF_YEAR, -(dureeMaxPrets+1));
			Date prêt = calendrier.getTime();
				if (prêt.after(this.dateEmprunt)) 
				{
					throw new BiblioException("Impossible d'ajouter un emprunt, cet adhérent a au moins un prêt en retard.");
				}
			return true;
	}*/
}

			
			
