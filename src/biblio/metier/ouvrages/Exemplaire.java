/**
 * 
 */
package biblio.metier.ouvrages;

import java.util.Date;

/**
 * @author Ak.vin / ManuL
 *
 */
public class Exemplaire 
{
	
	private int idExemplaire;
	private Date dateAchat;
	private EnumStatusExemplaire status;
	private String isbn;
	private EmpruntEnCours empruntEnCours;
	
	public Exemplaire(int idExemplaire, Date dateAchat, EnumStatusExemplaire status, String isbn) {
		this.idExemplaire = idExemplaire;
		this.dateAchat = dateAchat;
		this.status = status;
		this.isbn = isbn;
		this.empruntEnCours = null;
	}
	
	public int getIdExemplaire() {
		return idExemplaire;
	}
	
	public void setIdExemplaire(int idExemplaire) {
		this.idExemplaire = idExemplaire;
	}
	
	public Date getDateAchat() {
		return dateAchat;
	}
	
	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}
	
	public EnumStatusExemplaire getStatus() {
		return status;
	}
	
	public void setStatus(EnumStatusExemplaire status) {
		this.status = status;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public EmpruntEnCours getEmpruntEnCours() {
		return empruntEnCours;
	}
	
	public void setEmpruntEnCours(EmpruntEnCours empruntEnCours) {
		this.empruntEnCours = empruntEnCours;
	}
	
	
}
