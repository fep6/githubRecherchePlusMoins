package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import entrees.EntreesConfigJeu;
import recherche.RechercheMode1;
import recherche.RechercheMode2;
import recherche.RechercheMode3;



public class TraceLog4j {
	
	private final Logger logger = LogManager.getLogger();
	
	/**
	 * Traçage TraceLog4j
	 * @param ecj
	 * parametres des entrees du jeu
	 */
	public void recapTracageDebutDeJeu(EntreesConfigJeu ecj) {
		logger.info("\n Début du jeu -> Récapitulatif des entrées du jeu:" + "\n Mode de la partie : " + ecj.getModeJeu() +
				"\n Nombre de coups maximums: "+ ecj.getNCoups() +
			"\n Nombre de pions maximums: " + ecj.getNPions() );
	}
	/**
	 * @param ecj
	 * instanciation faite en Jeu.java 
	 * @param rm1
	 * instanciation faite en Jeu.java 
	 * @param rm2
	 * instanciation faite en Jeu.java 
	 */
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
	void impressionTableauDuJeu(EntreesConfigJeu ecj, RechercheMode1 rm1, int coupsMaxPartie) {
		logger.info("Selon les combinaisons :" );
		for (int coup=0; coup<=coupsMaxPartie; coup++) {
				logger.trace(rm1.getCAT1StringTableauJeu(coup));
		}
	}
	void impressionTableauDuJeu(EntreesConfigJeu ecj, RechercheMode2 rm2, int coupsMaxPartie) {
		logger.info("Selon les combinaisons :" );
		for (int coup=0; coup<=coupsMaxPartie; coup++) {
				logger.trace(rm2.getCAT2StringTableauJeu(coup));
		}
	}
	void impressionTableauDuJeu(EntreesConfigJeu ecj, RechercheMode3 rm3, int coupsMaxPartie) {
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
	public void finJeu() {
		logger.info("________________Fin du Jeu!");
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
