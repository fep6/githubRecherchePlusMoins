package org.sorties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.entrees.EntreesConfigJeu;
import org.modeJeu.RechercheMode1;
import org.modeJeu.RechercheMode2;
import org.modeJeu.RechercheMode3;



public class TraceLog4j {
	
	private final Logger logger = LogManager.getLogger();
	/**
	 * variables admin du fichier config.properties
	 */
	private static boolean adminConfig =false;
	private String stringAdminConfig="";
	/**
	 * variables admin de la commande 
	 */
	private static boolean adminCommande =false;
	private String stringAdminCommande="";
	public void recapTracageDebutDeJeu(EntreesConfigJeu ecj) {

		gestionEntreesAdmin();
		logger.info("Récapitulatif des entrées du jeu:" + "\n Mode de la partie : " + ecj.getModeJeu() +
				"\n Nombre de coups maximums: "+ ecj.getNCoups() +
			"\n Nombre de pions maximums: " + ecj.getNPions() + 
			"\n Le fichier de configuration du jeu indique :" + stringAdminConfig + "!"+
			"\n" + stringAdminCommande);
	}
	public void recapTracageFinDeJeu(EntreesConfigJeu ecj, RechercheMode1 rm1, RechercheMode2 rm2, 
			RechercheMode3 rm3, int coupMaxPartie ) {
		if (ecj.getModeJeu()==1) {
			logger.info("Fin de la manche. Verdict:" + rm1.getCAT1Verdict());
			impressionTableauDuJeu(ecj, rm1, coupMaxPartie);
		}
		else if (ecj.getModeJeu()==2) {
			logger.info("Fin de la manche. Verdict:" + rm2.getCAT2Verdict());
			impressionTableauDuJeu(ecj, rm2, coupMaxPartie);
		}
		else {
			logger.info("Fin de la manche. Verdict du mode 1:" + rm3.getCAT1Verdict());
			logger.info("Verdict du mode 2:" + rm3.getCAT2Verdict());
			impressionTableauDuJeu(ecj, rm3, coupMaxPartie);
		}

		logger.info("________________________________________");
	}
	public void traceAdminLigneCommande() {
		logger.info("Argument 'trace' a été passé en ligne de commande!");
	}
	/**
	 * Precision sur les entrees des commande admin (config.properties ou ligne de commande)
	 */
	private void gestionEntreesAdmin() {
		if (adminConfig==true) {
			stringAdminConfig= "ADMIN";
		} else {
			stringAdminConfig= "normal";
		}
		if (adminCommande==true) {
			stringAdminCommande="Le mode administrateur a été demandé en ligne de commande!";
		} 
	}
	private void impressionTableauDuJeu(EntreesConfigJeu ecj, RechercheMode1 rm1, int coupsMaxPartie) {
		logger.info("Selon les combinaisons :" );
		for (int coup=0; coup<=coupsMaxPartie; coup++) {
				logger.trace(rm1.getCAT1StringTableauJeu(coup));
		}
	}
	private void impressionTableauDuJeu(EntreesConfigJeu ecj, RechercheMode2 rm2, int coupsMaxPartie) {
		logger.info("Selon les combinaisons :" );
		for (int coup=0; coup<=coupsMaxPartie; coup++) {
				logger.trace(rm2.getCAT2StringTableauJeu(coup));
		}
	}
	private void impressionTableauDuJeu(EntreesConfigJeu ecj, RechercheMode3 rm3, int coupsMaxPartie) {
		logger.info("Selon les combinaisons :" );
		for (int coup=0; coup<=coupsMaxPartie; coup++) {
			logger.trace("prop. joueur: "+rm3.getCAT1StringTableauJeu(coup));
			logger.trace("prop.  ordi.: "+rm3.getCAT2StringTableauJeu(coup));
		}
	}
	// Divers Log4j
	public void setMessageDebug(String str) {
		logger.debug("Debugage: "+ str); 	
	}
	void setMessageInfo(String str) {
		logger.info("Information: "+ str);
	}
	/**
	 * @see GestionExeptionEntreesGlobales
	 * @param str
	 * retour attendu du message
	 */
	public void setMessageWarning(String str) {
		logger.warn("Attention: "+ str);
	}
	void setMessageError(String str) {
		logger.error("Erreur: "+ str);
	}
	/**
	 * @see GestionExeptionEntreesGlobales
	 * @param str
	 * retour attendu du message
	 */
	public void setMessageFatal(String str) {
		logger.fatal("Erreur Fatale: "+ str);
	}
	public void debutJeu(){
		logger.info("________________Début du Jeu!");
	}
	public void setDebutManche(int manche) {
		logger.info("Début de la manche "+(int)(manche+1)+ " !");
	}
	public void finJeu() {
		logger.info("________________Fin du Jeu!");
	}
	/**
	 * 
	 */
	public void setAdminConfig() {
		adminConfig=true;
	}
	public void setAdminCommande() {
		adminCommande=true;
	}
	
// Pour memoire	
//	logger.trace("Message");
//	logger.debug("This Will Be Printed On Debug");
//	logger.info("This Will Be Printed On Info");
//	logger.warn("This Will Be Printed On Warn");
//	logger.error("This Will Be Printed On Error");
//	logger.fatal("This Will Be Printed On Fatal");
//
//	logger.info("Appending string: {}.", "Hello, World");
}

