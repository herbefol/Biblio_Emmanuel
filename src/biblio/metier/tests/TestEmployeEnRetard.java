package biblio.metier.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import biblio.dao.ExemplairesDao;
import biblio.dao.UtilisateursDao;
import biblio.metier.BiblioException;
import biblio.metier.ouvrages.EmpruntEnCours;
import biblio.metier.ouvrages.Exemplaire;
import biblio.metier.personnes.Utilisateur;

public class TestEmployeEnRetard {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("----------------------");
		System.out.println("TEST EMPLOYE EN RETARD");
		System.out.println("----------------------");
		System.out.println("\n");

		
		ExemplairesDao exdb = new ExemplairesDao();
		Exemplaire ex1 = exdb.findByKey(1);
		Exemplaire ex2 = exdb.findByKey(2);
		
		System.out.println("\n--------------------------------------------");
		System.out.println("Demande d'un exemplaire (id=1) aux Dao :");
		System.out.println("--------------------------------------------");
		System.out.println();
		
		System.out.println("idExemplaire demandé : " + ex1.getIdExemplaire());
		System.out.println(ex1);
		System.out.println("\n");
		
		System.out.println("\n--------------------------------------------");
		System.out.println("Demande d'un exemplaire (id=2) aux Dao :");
		System.out.println("--------------------------------------------");
		System.out.println();
		
		System.out.println("idExemplaire demandé : " + ex2.getIdExemplaire());
		System.out.println(ex2);
		System.out.println("\n");
		
		UtilisateursDao utdb = new UtilisateursDao();
		Utilisateur em1 = utdb.findByKey(666);
		
		System.out.println("\n--------------------------------------------");
		System.out.println("Demande d'un employé (id=666) aux Dao :");
		System.out.println("--------------------------------------------");
		System.out.println();
		
		System.out.println("idEmployé demandé : " + em1.getIdUtilisateur());
		System.out.println(em1);
		System.out.println("\n");
		

		EmpruntEnCours emp1=null;
		
		System.out.println("\n---------------------------------------------------------");
		System.out.println("Création d'un emprunt en cours avec une date en retard");
		System.out.println("---------------------------------------------------------");
		System.out.println();

		System.out.println("Collection d'emprunt de l'employé avant la création : "+em1.getEmpruntEnCours()+"\n");
		
		try {
			emp1 = new EmpruntEnCours(sdf.parse("25/03/2015"), ex1, em1);
		} catch (BiblioException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n-----------------------------");
		System.out.println("Emprunt en cours 1 :");
		System.out.println("-----------------------------");
		System.out.println();
		
		System.out.println("Collection d'emprunt de l'employé après la création : \n\n"+em1.getEmpruntEnCours());
		System.out.println("\nNombre d'emprunt en cours de l'employé : " + em1.getNbEmpruntEnCours());
		System.out.println("\nEmprunt en cours créé numéro 1 est : \n" + emp1);
		System.out.println();
		
		System.out.println("\n---------------------------------------------------------");
		System.out.println("Tentative de création d'un deuxième emprunt en cours");
		System.out.println("---------------------------------------------------------");
		System.out.println();
		
		System.out.println("Collection d'emprunt de l'employé avant la création : \n\n"+em1.getEmpruntEnCours()+"\n");
		
		EmpruntEnCours emp2 = null;
		
		System.out.println("\n-----------------------------");
		System.out.println("Emprunt en cours 2 :");
		System.out.println("-----------------------------");
		System.out.println();
		
		try {
			emp2 = new EmpruntEnCours(sdf.parse("10/04/2015"), ex2, em1);
		} catch (BiblioException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("Collection d'emprunt de l'employé après la création : \n\n"+em1.getEmpruntEnCours());
		System.out.println("\nEmprunt en cours créé numéro 2 est : \n" + emp2);
		System.out.println();
		
		System.out.println("\n----------------------------------------------");
		System.out.println("Nombre d'emprunt en cours de l'employé : "+em1.getNbEmpruntEnCours());
		System.out.println("----------------------------------------------");

	}

}
