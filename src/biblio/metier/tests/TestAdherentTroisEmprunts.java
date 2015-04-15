package biblio.metier.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import biblio.dao.ExemplairesDao;
import biblio.dao.UtilisateursDao;
import biblio.metier.BiblioException;
import biblio.metier.ouvrages.EmpruntEnCours;
import biblio.metier.ouvrages.Exemplaire;
import biblio.metier.personnes.Utilisateur;

public class TestAdherentTroisEmprunts {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("----------------------------");
		System.out.println("TEST ADHERENT TROIS EMPRUNTS");
		System.out.println("----------------------------");
		System.out.println("\n");
		
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
		
		System.out.println("\n------------------------------------------------");
		System.out.println("Demande d'un exemplaire (id=2) aux Dao :");
		System.out.println("------------------------------------------------");
		System.out.println();
		
		System.out.println("idExemplaire demandé : " + ex2.getIdExemplaire());
		System.out.println(ex2);
		System.out.println("\n");
		
		System.out.println("\n------------------------------------------------");
		System.out.println("Demande d'un exemplaire (id=3) aux Dao :");
		System.out.println("------------------------------------------------");
		System.out.println();
		
		System.out.println("idExemplaire demandé : " + ex3.getIdExemplaire());
		System.out.println(ex3);
		System.out.println("\n");
		
		System.out.println("\n------------------------------------------------");
		System.out.println("Demande d'un exemplaire (id=4) aux Dao :");
		System.out.println("------------------------------------------------");
		System.out.println();
		
		System.out.println("idExemplaire demandé : " + ex4.getIdExemplaire());
		System.out.println(ex4);
		System.out.println("\n");

		UtilisateursDao utdb = new UtilisateursDao();
		Utilisateur ad1 = utdb.findByKey(123);
		
		System.out.println("\n------------------------------------------------");
		System.out.println("Demande d'un adhérent (id=123) aux Dao :");
		System.out.println("------------------------------------------------");
		System.out.println();
		
		System.out.println("idUtilisateur demandé : " + ad1.getIdUtilisateur());
		System.out.println(ad1);
		System.out.println("\n");

		EmpruntEnCours emp1 = null;
		EmpruntEnCours emp2 = null;
		EmpruntEnCours emp3 = null;
		EmpruntEnCours emp4 = null;
				
		try {
			System.out.println("\n------------------------------------------------");
			System.out.println("Création d'emprunt en cours");
			System.out.println("------------------------------------------------");
			System.out.println();
			
			System.out.println("Collection d'emprunt de l'adhérent avant la création : "+ad1.getEmpruntEnCours()+"\n");
			
			emp1 = new EmpruntEnCours(sdf.parse("07/04/2015"), ex1, ad1);
			
			System.out.println("Collection d'emprunt de l'adhérent après la création : \n"+ad1.getEmpruntEnCours());
			System.out.println("\nNombre d'emprunt en cours de l'adhérent : " + ad1.getNbEmpruntEnCours());
			System.out.println("\n");
			System.out.println("Emprunt en cours créé numéro 1 est : \n" + emp1);
			System.out.println();
			
			System.out.println("\n------------------------------------------------");
			System.out.println("Création d'un deuxième emprunt en cours");
			System.out.println("------------------------------------------------");
			System.out.println();
			
			emp2 = new EmpruntEnCours(sdf.parse("08/04/2015"), ex2, ad1);
			
			System.out.println("Collection d'emprunt de l'adhérent après la création : \n"+ad1.getEmpruntEnCours());
			System.out.println("\nNombre d'emprunt en cours de l'adhérent : " + ad1.getNbEmpruntEnCours());
			System.out.println("\n");
			System.out.println("Emprunt en cours créé numéro 2 est : \n" + emp2);
			System.out.println();
			
			System.out.println("\n------------------------------------------------");
			System.out.println("Création d'un troisième emprunt en cours");
			System.out.println("------------------------------------------------");
			System.out.println();
			
			emp3 = new EmpruntEnCours(sdf.parse("10/04/2015"), ex3, ad1);
			
			System.out.println("Collection d'emprunt de l'adhérent après la création : \n"+ad1.getEmpruntEnCours());
			System.out.println("\nNombre d'emprunt en cours de l'adhérent : " + ad1.getNbEmpruntEnCours());
			System.out.println("\n");
			System.out.println("Emprunt en cours créé numéro 3 est : \n" + emp3);
			System.out.println();
			
		} 
		catch (BiblioException e) 
		{
			e.printStackTrace();
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println("\n---------------------------------------------------");
		System.out.println("Nombre d'emprunt en cours de l'adhérent : " + ad1.getNbEmpruntEnCours());
		System.out.println("---------------------------------------------------");
		System.out.println();
		
		System.out.println("\n---------------------------------------------------------------");
		System.out.println("Tentative de création d'un quatrième emprunt pour l'adhérent.");
		System.out.println("---------------------------------------------------------------");
		System.out.println("\n");
		try 
		{
			emp4 = new EmpruntEnCours(sdf.parse("10/04/2015"), ex4, ad1);
		} 
		catch (BiblioException e) 
		{
			System.out.println(e);
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		System.out.println("\nCollection d'emprunt de l'adhérent après la création : \n"+ad1.getEmpruntEnCours());
		System.out.println("\nNombre d'emprunt en cours de l'adhérent : " + ad1.getNbEmpruntEnCours());
		System.out.println("\n");
		System.out.println("Etat du quatrième emprunt en cours :\n"+emp4);
		System.out.println();
		System.out.println("Emprunt en cours créé numéro 4 est : \n" + emp4);
		System.out.println("\n");
		System.out.println("Nombre d'emprunt en cours de l'adhérent : " + ad1.getNbEmpruntEnCours());
	}
}
