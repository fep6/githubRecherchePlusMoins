package org.principal;

import org.entrees.EntreesConfigJeu;
import org.entrees.EntreesManuellesDuJeu;
import org.entrees.GestionConformites;
import org.recherche.RechercheMode1;
import org.recherche.RechercheMode2;
import org.recherche.RechercheMode3;
import org.sorties.AffichageConsole;
import org.sorties.TraceLog4j;

public class Manche {
	private AffichageConsole acJ;
	//Entrees du jeu
	private EntreesConfigJeu ecj;
	// Tracabilite
	private static TraceLog4j tl4j;

	// Déroulé normal
	private RechercheMode1 rm1;
	private RechercheMode2 rm2;
	private RechercheMode3 rm3;
	/** 
	 * Nombre de coups dans la partie (/TraceLog4j)
	 */
	private int coupMaxPartie;
	private EntreesManuellesDuJeu emjJeuEnCours;
	private boolean jeuEnCours;
	private static int manche=0;
	/**
	 *  prise en compte admin via commande en ligne
	 */
	private static boolean extAdmin;
	/**
	 *  Commande en ligne du traçage log4j
	 */
	private static boolean trace; 
	/**
	 * Variable des arguments passés en ligne de commande pour recommencer le jeu (/trace de log4j)
	 */
	private static String[] argsLigneCommande=null;
	
	public Manche() {
		acJ=new AffichageConsole();
		trace=false;
		ecj = new EntreesConfigJeu();
		tl4j = new TraceLog4j();
	}
	void debutJeu(String[] argsLigneCommande) {
	
		// Nombre d'arguments dans la ligne de commande (sert juste à l'affichage)
		int nbreArg = argsLigneCommande.length;
		
		// Prise en compte de l'argument de commande en ligne en admin (triche) (nbreArg est le nombre d'arguments dans la ligne de commande)
		for (nbreArg=0; nbreArg<argsLigneCommande.length; nbreArg++) {
			if (argsLigneCommande[nbreArg].contentEquals("-admin")) {
				acJ.argumentLigneAdmin(nbreArg);
				setAdminCommande();
			}
			if (argsLigneCommande[nbreArg].contentEquals("-trace")) {
				acJ.argumentTraceAdmin(nbreArg);
				tl4j.setDebutManche(manche);
				trace=true;	
			}
		}
	}
	
	 void setJeu() {
			manche++;
			acJ.debutManche(manche);
			ecj.entreesFichierConfigJeu(extAdmin);
			ecj.setModeJeu();
			
			// gestion tracabilite par log4j
			if (trace==true) {
				tl4j.recapTracageDebutDeJeu(ecj);
			}
			
			rm1 = new RechercheMode1(ecj.getNCoups(),ecj.getNPions());
			rm2 = new RechercheMode2(ecj.getNCoups(),ecj.getNPions());
			rm3 = new RechercheMode3(ecj.getNCoups(),ecj.getNPions());
			
			//Gestion si le jeu n'est pas completement termine
			jeuEnCours=true;
			emjJeuEnCours = new EntreesManuellesDuJeu();
	 }
	void doJeu(){
		while (jeuEnCours==true) {
			ecj.affichageRecapitulatifConfigJeu();
			if (ecj.getModeJeu()==1) {
				rm1.doRechercheMode(ecj.getModeJeu(),ecj.getNCoups(),ecj.getNPions(),ecj.getAdmin()||extAdmin);
				if (ecj.getAdmin()==true){
					setAdminConfig();
				}
				coupMaxPartie=rm1.getCoupMaxPartie();
			}
			else if ( ecj.getModeJeu()==2) {
				rm2.doRechercheMode(ecj.getModeJeu(),ecj.getNCoups(),ecj.getNPions(),ecj.getAdmin()||extAdmin);
				coupMaxPartie=rm2.getCoupMaxPartie();
			}
			else {
				rm3.doRechercheMode(ecj.getModeJeu(),ecj.getNCoups(),ecj.getNPions(),ecj.getAdmin()||extAdmin);
				coupMaxPartie=rm3.getCoupMaxPartie();
			}
			//Traitement traçabilité
			if (trace==true) {
				tl4j.recapTracageFinDeJeu(ecj, rm1, rm2, rm3, coupMaxPartie);
			}
			acJ.finManche((int)(manche+1));
			emjJeuEnCours.demandeRecommenceJeu();
			
			if (emjJeuEnCours.getJeuEnCours().equals("non")) {
				jeuEnCours=false;
			}
			else {
				tl4j = new TraceLog4j();
				Manche j = new Manche();
				
				System.out.println("TEST : Manche recommence : Trace ="+trace);
				j.debutJeu(argsLigneCommande);
				j.setJeu();
				j.doJeu();
				jeuEnCours=false;
			}
		}
	}
	void finJeu() {
		acJ.finJeu();
		if (trace==true) {
			getTl4j().finJeu();
		}
	}
	/**
	 * pour log4j quand le jeu recommence
	 * @see Main
	 */
	void setArgsCommandeJeu(String[] args){
		tl4j.debutJeu();
		argsLigneCommande=args;
	}
	/**
	 * Validation de l'entree d'admin du fichier de configuration
	 * @see config.properties
	 */
	void setAdminConfig(){
		extAdmin=true;
		tl4j.setAdminConfig();
	}
	/**
	 * Validation de l'entree d'admin par ligne de commande
	 */
	void setAdminCommande() {
		tl4j.setAdminCommande();
	}
	/**
	 * @return l'instance de TraceLog4j
	 * @see EntreeConfigJeu
	 * @see GestionConformites
	 */
	public static TraceLog4j getTl4j() {
		return tl4j;
	}
}
	

