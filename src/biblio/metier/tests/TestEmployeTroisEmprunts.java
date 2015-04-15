package biblio.metier.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import biblio.dao.ExemplairesDao;
import biblio.dao.UtilisateursDao;
import biblio.metier.BiblioException;
import biblio.metier.ouvrages.EmpruntEnCours;
import biblio.metier.ouvrages.Exemplaire;
import biblio.metier.personnes.Utilisateur;

public class TestEmployeTroisEmprunts {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("---------------------------");
		System.out.println("TEST EMPLOYE TROIS EMPRUNTS");
		System.out.println("---------------------------");
		System.out.println();
		
		ExemplairesDao exdb = new ExemplairesDao();
		Exemplaire ex1 = exdb.findByKey(1);
		Exemplaire ex2 = exdb.findByKey(2);
		Exemplaire ex3 = exdb.findByKey(3);
		Exemplaire ex4 = exdb.findByKey(4);
		
		System.out.println("\n--------------------------------------------");
		System.out.println("Demande d'un exemplaire (id=1) aux Dao :");
		System.out.println("--------------------------------------------");
		System.out.println();
		
		System.out.println("idExemplaire demandé : " + ex1.getIdExemplaire());
		System.out.println(ex1);
		System.out.println("\n");
		
		System.out.println("\n--------------------------------------------");
		System.out.println("Demande d'un exemplaire (id=2) aux Dao :");
		System.out.println("\n--------------------------------------------");
		System.out.println();
		
		System.out.println("idExemplaire demandé : " + ex2.getIdExemplaire());
		System.out.println(ex2);
		System.out.println("\n");
		
		System.out.println("\n--------------------------------------------");
		System.out.println("Demande d'un exemplaire (id=3) aux Dao :");
		System.out.println("--------------------------------------------");
		System.out.println();
		
		System.out.println("idExemplaire demandé : " + ex3.getIdExemplaire());
		System.out.println(ex3);
		System.out.println("\n");
		
		System.out.println("\n--------------------------------------------");
		System.out.println("Demande d'un exemplaire (id=4) aux Dao :");
		System.out.println("--------------------------------------------");
		System.out.println();
		
		System.out.println("idExemplaire demandé : " + ex4.getIdExemplaire());
		System.out.println(ex4);
		System.out.println("\n");

		UtilisateursDao utdb = new UtilisateursDao();
		Utilisateur em1 = utdb.findByKey(666);
		
		System.out.println("\n--------------------------------------------");
		System.out.println("Demande d'un employé (id=666) aux Dao :");
		System.out.println("--------------------------------------------");
		System.out.println();
		
		System.out.println("idEmployé demandé : " + em1.getIdUtilisateur());
		System.out.println(em1);
		System.out.println();
		
		EmpruntEnCours emp1 = null;
		EmpruntEnCours emp2 = null;
		EmpruntEnCours emp3 = null;
		EmpruntEnCours emp4 = null;
				
		try {
			System.out.println("\n-----------------------------------");
			System.out.println("Création d'un emprunt en cours");
			System.out.println("-----------------------------------");
			System.out.println();
			
			System.out.println("Collection d'emprunt de l'employé avant la création : \n"+em1.getEmpruntEnCours());
			System.out.println("\nNombre d'emprunt en cours de l'employé : " + em1.getNbEmpruntEnCours());
			System.out.println();
			
			emp1 = new EmpruntEnCours(sdf.parse("07/04/2015"), ex1, em1);
			
			System.out.println("\n-----------------------------------");
			System.out.println("Emprunt en cours 1 :");
			System.out.println("-----------------------------------");
			System.out.println();
			
			System.out.println("Collection d'emprunt de l'employé après la création : \n"+em1.getEmpruntEnCours());
			System.out.println("\nNombre d'emprunt en cours de l'employé : " + em1.getNbEmpruntEnCours());
			System.out.println("\n");
			System.out.println("Emprunt en cours créé numéro 1 est : \n" + emp1);
			System.out.println();
			
			System.out.println("\n-----------------------------------");
			System.out.println("Création d'un emprunt en cours");
			System.out.println("-----------------------------------");
			System.out.println();
			
			emp2 = new EmpruntEnCours(sdf.parse("08/04/2015"), ex2, em1);
			
			System.out.println("\n-----------------------------------");
			System.out.println("Emprunt en cours 2 :");
			System.out.println("-----------------------------------");
			System.out.println();
			
			System.out.println("Collection d'emprunt de l'employé après la création : \n"+em1.getEmpruntEnCours());
			System.out.println("\nNombre d'emprunt en cours de l'employé : " + em1.getNbEmpruntEnCours());
			System.out.println("\n");
			System.out.println("Emprunt en cours créé numéro 2 est : \n" + emp2);
			System.out.println();
			
			System.out.println("\n-----------------------------------");
			System.out.println("Création d'un emprunt en cours");
			System.out.println("-----------------------------------");
			System.out.println();
			
			emp3 = new EmpruntEnCours(sdf.parse("10/04/2015"), ex3, em1);
			
			System.out.println("\n-----------------------------------");
			System.out.println("Emprunt en cours 3 :");
			System.out.println("-----------------------------------");
			System.out.println();
			
			System.out.println("Collection d'emprunt de l'employé après la création : \n"+em1.getEmpruntEnCours());
			System.out.println("\nNombre d'emprunt en cours de l'employé : " + em1.getNbEmpruntEnCours());
			System.out.println("\n");
			System.out.println("Emprunt en cours créé numéro 3 est : \n" + emp3);
			System.out.println();
			
		} catch (BiblioException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n--------------------------------------------------");
		System.out.println("Nombre d'emprunt en cours de l'employé : " + em1.getNbEmpruntEnCours());
		System.out.println("--------------------------------------------------");
		System.out.println();

		System.out.println("\n---------------------------------------------------------------");
		System.out.println("Tentative de création d'un quatrième emprunt pour l'employé.");
		System.out.println("---------------------------------------------------------------");
		System.out.println();

		try {
			emp4 = new EmpruntEnCours(sdf.parse("10/04/2015"), ex4, em1);
		} catch (BiblioException e) {
			System.out.println(e);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n------------------------");
		System.out.println("Emprunt en cours 4 :");
		System.out.println("------------------------");
		System.out.println();
		
		System.out.println("Collection d'emprunt de l'employé après la création : \n"+em1.getEmpruntEnCours());
		System.out.println("\nNombre d'emprunt en cours de l'employé : " + em1.getNbEmpruntEnCours());
		System.out.println("\n");
		System.out.println("Emprunt en cours créé numéro 4 est : \n" + emp4);
		System.out.println();
		
		System.out.println("\n--------------------------------------------------");
		System.out.println("Nombre d'emprunt en cours de l'employé : " + em1.getNbEmpruntEnCours());
		System.out.println("--------------------------------------------------");
	}

}
