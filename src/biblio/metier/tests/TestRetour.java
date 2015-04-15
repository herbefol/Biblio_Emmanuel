package biblio.metier.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import biblio.dao.ExemplairesDao;
import biblio.dao.UtilisateursDao;
import biblio.metier.BiblioException;
import biblio.metier.ouvrages.EmpruntArchive;
import biblio.metier.ouvrages.EmpruntEnCours;
import biblio.metier.ouvrages.Exemplaire;
import biblio.metier.personnes.Utilisateur;

public class TestRetour {

	public static void main(String[] args) {
		
		System.out.println("\n------------------------------------------------------");
		System.out.println("		   TEST RETOUR");
		System.out.println("------------------------------------------------------");
		System.out.println("\n");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		ExemplairesDao exdb = new ExemplairesDao();
		Exemplaire ex1 = exdb.findByKey(1);
		
		System.out.println("\n-----------------------------------------------");
		System.out.println("	AFFICHAGE EXEMPLAIRE 1");
		System.out.println("-----------------------------------------------");
		System.out.println();
		
		System.out.println("idExemplaire " + ex1.getIdExemplaire() + " :\n"+ex1);
		System.out.println("\n");
	
		UtilisateursDao utdb = new UtilisateursDao();
		Utilisateur ad1 = utdb.findByKey(123);
		
		System.out.println("\n---------------------------------------");
		System.out.println("	AFFICHAGE ADHERENT 1");
		System.out.println("---------------------------------------");
		System.out.println();
		
		System.out.println("idUtilisateur " + ad1.getIdUtilisateur() + " :\n"+ad1);
		System.out.println();
		
		System.out.println("Collection d'emprunt de l'adhérent avant la création :\n"+ad1.getEmpruntEnCours());
		System.out.println("\nNombre d'emprunt en cours de l'adhérent : " + ad1.getNbEmpruntEnCours()+"\n");
		EmpruntEnCours emp1 = null;
		
		try {
			emp1 = new EmpruntEnCours(sdf.parse("10/04/2015"), ex1, ad1);
		} catch (BiblioException e) {
			System.out.println(e);
		} catch (ParseException e) {
			System.out.println(e);
		}
		
		System.out.println("\n--------------------------------------------------------");
		System.out.println("	CREATION D UN EMPRUNT POUR L'ADHERENT 1");
		System.out.println("--------------------------------------------------------");
		System.out.println();
		
		System.out.println("Collection d'emprunt de l'adhérent après la création : \n"+ad1.getEmpruntEnCours());
		System.out.println("\nNombre d'emprunt en cours de l'adhérent : " + ad1.getNbEmpruntEnCours());
		System.out.println("\n");
		
		System.out.println("\n\n----------------------------------------------");
		System.out.println("	AFFICHAGE EMPRUNT EN COURS 1");
		System.out.println("----------------------------------------------");
		System.out.println();
		
		System.out.println("Emprunt en cours créé numéro 1 est : \n" + emp1);
		System.out.println();
		
		System.out.println("\n----------------------------------------------");
		System.out.println("	AFFICHAGE STATUT EXEMPLAIRE 1");
		System.out.println("----------------------------------------------");
		System.out.println();
		
		System.out.println("Statut de exemplaire 1 : "+ex1.getStatus());
		System.out.println("\n");
		
		System.out.println("\n----------------------------------------------");
		System.out.println("	AFFICHAGE COLLECTION ADHERENT 1");
		System.out.println("----------------------------------------------");
		System.out.println();
		
		System.out.println("Collection d'emprunt de l'adhérent :\n"+ad1.getEmpruntEnCours());
		System.out.println("\nNombre d'emprunt en cours de l'adhérent : " + ad1.getNbEmpruntEnCours());
		System.out.println("\n");
		
		System.out.println("\n-------------------------------------------");
		System.out.println("	RETOUR DE L'EXEMPLAIRE");
		System.out.println("-------------------------------------------");
		System.out.println();
		
		EmpruntArchive ea1= null;
		
		try {
			ea1 = ex1.getEmpruntEnCours().retourExemplaire(sdf.parse("11/04/2015"));
			emp1.setEmprunteur(null);
			emp1.setExemplaire(null);
			emp1 = null;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\n------------------------------------------------");
		System.out.println("	L'EXEMPLAIRE PASSE A dISPONIBLE");
		System.out.println("------------------------------------------------");
		System.out.println();
		
		System.out.println("Statut de exemplaire 1 : "+ex1.getStatus());
		System.out.println("\n");
		
		System.out.println("\n----------------------------------------------------");
		System.out.println("	LA COLLECTION DE L'ADHERENT DIMINUE");
		System.out.println("----------------------------------------------------");
		System.out.println();
		
		System.out.println("Collection d'emprunt de l'adhérent après retour : "+ad1.getEmpruntEnCours());
		System.out.println("\nNombre d'emprunt en cours de l'adhérent : " + ad1.getNbEmpruntEnCours());
		System.out.println("\n");
		
		System.out.println("\n----------------------------------------------");
		System.out.println("	L'EMPRUNT ARCHIVE EST CREE");
		System.out.println("----------------------------------------------");
		System.out.println();
		
		System.out.println("Emprunt archivé :\n"+ea1);
		System.out.println("\n");
		
		System.out.println("\n-------------------------------------------------------");
		System.out.println("	L'EMPRUNT EN COURS EST GARBAGE COLLECTE");
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		System.out.println("Collection d'emprunt de l'adhérent après le retour : "+ad1.getEmpruntEnCours());
		System.out.println("\nNombre d'emprunt en cours de l'adhérent : " + ad1.getNbEmpruntEnCours());
		System.out.println("\n");
		System.out.println("Emprunt en cours : "+emp1);	
		
		/*for (int i=0; i <= 50000; i++)
		{
			Utilisateur u = new Utilisateur(null,null,null,null,i,null,null);
			System.out.println("boucle");
		}*/
	}
}
