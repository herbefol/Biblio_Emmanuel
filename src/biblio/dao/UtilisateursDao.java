package biblio.dao;

import java.util.Date;

import biblio.metier.personnes.Adherent;
import biblio.metier.personnes.Employe;
import biblio.metier.personnes.EnumCategorieEmploye;
import biblio.metier.personnes.Utilisateur;

/**
 * Cette classe est une classe DAO permettant de faire la connexion avec la base de données
 * contenant tous les utilisateurs du système. Elle permet de renvoyer un utilisateur à partir
 * de son id.
 * C'est pour l'instant un objet mock simulant l'accès à la base de données.
 * @author Emmanuel & Kevin
 * @version 1.0
 */

public class UtilisateursDao {
	
	private static Utilisateur[] utilisateurDB = {
		new Utilisateur("Dupont","Jean",new Date(),"masculin",555,"Sésame","DJ"),
		new Employe("Martin","Marie", new Date(),"féminin",666,"Abracadabra","2M","Mat123",EnumCategorieEmploye.BIBLIOTHECAIRE),
		new Adherent("Lajoie", "Suzanne", new Date(), "féminin", 123, "azerty", "LS", "1234567890")
	};
	
	public Utilisateur findByKey(int id) {
		for (Utilisateur ut : utilisateurDB) {
			if (ut.getIdUtilisateur()==id) {
				return ut;
			}
		}
		return null;
	}

}
