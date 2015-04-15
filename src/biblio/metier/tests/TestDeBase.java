package biblio.metier.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import biblio.dao.ExemplairesDao;
import biblio.dao.UtilisateursDao;
import biblio.metier.BiblioException;
import biblio.metier.ouvrages.EmpruntEnCours;
import biblio.metier.ouvrages.Exemplaire;
import biblio.metier.personnes.Utilisateur;

public class TestDeBase {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		ExemplairesDao exdb = new ExemplairesDao();
		Exemplaire ex1 = exdb.findByKey(1);
		Exemplaire ex2 = exdb.findByKey(2);
		
		System.out.println("------------");
		System.out.println("TEST DE BASE");
		System.out.println("------------");
		System.out.println();
		
		System.out.println("\n--------------------------------------------");
		System.out.println("Demande d'Exemplaire 1 (id=1) aux Dao :");
		System.out.println("--------------------------------------------");
		System.out.println();
		
		System.out.println("idExemplaire demandé : " + ex1.getIdExemplaire());
		System.out.println(ex1);
		System.out.println();
		
		System.out.println("\n--------------------------------------------");
		System.out.println("Demande d'Exemplaire 2 (id=2) aux Dao :");
		System.out.println("--------------------------------------------");
		System.out.println();
		
		System.out.println("idExemplaire demandé : " + ex2.getIdExemplaire());
		System.out.println(ex2);
		System.out.println();
		
		UtilisateursDao utdb = new UtilisateursDao();
		Utilisateur ad1 = utdb.findByKey(123);
		
		System.out.println("\n--------------------------------------------");
		System.out.println("Demande d'un adhérent (id=123) aux Dao :");
		System.out.println("--------------------------------------------");
		System.out.println();
		
		System.out.println("idUtilisateur demandé : " + ad1.getIdUtilisateur());
		System.out.println(ad1);
		System.out.println();
		
		Utilisateur em1 = utdb.findByKey(666);
		
		System.out.println("\n--------------------------------------------");
		System.out.println("Demande d'un employé (id=666) aux Dao :");
		System.out.println("--------------------------------------------");
		System.out.println();
		
		System.out.println("idEmployé demandé : " + em1.getIdUtilisateur());
		System.out.println(em1);
		System.out.println();

		System.out.println("\n------------------------------------------------------");
		System.out.println("Création d'un emprunt en cours pour un adhérent :");
		System.out.println("------------------------------------------------------");
		System.out.println();
		
		System.out.println("Collection d'emprunt de l'adhérent avant la création : "+ad1.getEmpruntEnCours()+"\n");
		EmpruntEnCours emp1=null;
		
		try {
			emp1 = new EmpruntEnCours(sdf.parse("07/04/2015"), ex1, ad1);
		} catch (BiblioException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("Collection d'emprunt de l'adhérent après la création : \n"+emp1);
		System.out.println();
		
		System.out.println("\n------------------------------------------------------");
		System.out.println("Création d'un emprunt en cours pour un employé :");
		System.out.println("------------------------------------------------------");
		System.out.println();
		
		System.out.println("Collection d'emprunt de l'employé avant la création : "+em1.getEmpruntEnCours()+"\n");
		EmpruntEnCours emp2 = null;
		
		try {
			emp2 = new EmpruntEnCours(sdf.parse("08/04/2015"), ex2, em1);
		} catch (BiblioException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("Collection d'emprunt de l'employé après la création : \n"+emp2);
		System.out.println();
	}

}
