package biblio.metier.ouvrages;

import java.util.Date;

import biblio.metier.personnes.Utilisateur;

public class EmpruntArchive {
	
	private Date dateRestitutionEff;
	private Date dateEmprunt;
	private Exemplaire exemplaire;
	private Utilisateur emprunteur;

	public EmpruntArchive(Date dateRestitutionEff, Date dateEmprunt, Exemplaire exemplaire, Utilisateur emprunteur) {
		this.dateRestitutionEff = dateRestitutionEff;
		this.dateEmprunt = dateEmprunt;
		this.exemplaire = exemplaire;
		this.emprunteur = emprunteur;
	}

	public Date getDateRestitutionEff() {
		return dateRestitutionEff;
	}

	public void setDateRestitutionEff(Date dateRestitutionEff) {
		this.dateRestitutionEff = dateRestitutionEff;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}

	public Utilisateur getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Utilisateur emprunteur) {
		this.emprunteur = emprunteur;
	}
	
}
