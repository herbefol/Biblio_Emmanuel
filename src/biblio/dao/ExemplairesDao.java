package biblio.dao;

import java.util.Date;

import biblio.metier.ouvrages.EnumStatusExemplaire;
import biblio.metier.ouvrages.Exemplaire;

/**
 * Cette classe est une classe DAO permettant la connexion à la base de données contenant
 * les exemplaires de la bibliothèques. Elle permet de renvoyer un exemplaire à partir 
 * de son id.
 * Pour le moment, c'est un objet mock permettant de simuler la présence de la base de données.
 * @author Emmanuel & Kevin
 * @version 1.0
 */

public class ExemplairesDao {
	
	private static Exemplaire[] exemplaireDB = {
		new Exemplaire(1,new Date(),EnumStatusExemplaire.DISPONIBLE,"123"),
		new Exemplaire(2,new Date(),EnumStatusExemplaire.DISPONIBLE,"456"),
		new Exemplaire(3,new Date(),EnumStatusExemplaire.DISPONIBLE,"789"),
		new Exemplaire(4,new Date(),EnumStatusExemplaire.DISPONIBLE,"753"),
		new Exemplaire(5,new Date(),EnumStatusExemplaire.DISPONIBLE,"951"),
	};
	
	public Exemplaire findByKey(int id) {
		for (Exemplaire ex : exemplaireDB) {
			if (ex.getIdExemplaire()==id)
				return ex;
		}
		return null;
	}

}
