package principal;

import entrees.EntreesConfigJeu;
import entrees.EntreesManuellesDuJeu;
import recherche.RechercheMode1;
import recherche.RechercheMode2;
import recherche.RechercheMode3;
import test.TraceLog4j;

public class Jeu {
	//Entrees du jeu
	private EntreesConfigJeu ecj;
	// Tracabilite
	private static TraceLog4j tl4j;
	// Gestion mode admin

	// Déroulé normal
	private RechercheMode1 rm1;
	private RechercheMode2 rm2;
	private RechercheMode3 rm3;
	/** 
	 * Nombre de coups dans la partie (/tl4j)
	 */
	private int coupMaxPartie;
	/**
	 * Gestion en cours de la partie 
	 */
	private EntreesManuellesDuJeu emjJeuEnCours;
	private boolean jeuEnCours;
	// Manche du jeu
	private static int manche=0;
	// prise en compte admin via commande en ligne
	private boolean extAdmin;
	
	public Jeu() {
		tl4j = new TraceLog4j();
		ecj = new EntreesConfigJeu();
	}
	
	 void setJeu() {
			manche++;
			System.out.println("_________________________________________________________________________________");
			System.out.println("Début de la manche: "+ manche);
			ecj.entreesFichierConfigJeu(extAdmin);
			ecj.setModeJeu();
			
			// gestion tracabilite par log4j
			tl4j.recapTracageDebutDeJeu(ecj);
			
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
				rm1.doRechercheMode(ecj.getModeJeu(),ecj.getNCoups(),ecj.getNPions(),ecj.getAdmin());
				coupMaxPartie=rm1.getCoupMaxPartie();
			}
			else if ( ecj.getModeJeu()==2) {
				rm2.doRechercheMode(ecj.getModeJeu(),ecj.getNCoups(),ecj.getNPions(),ecj.getAdmin());
				coupMaxPartie=rm2.getCoupMaxPartie();
			}
			else {
				rm3.doRechercheMode(ecj.getModeJeu(),ecj.getNCoups(),ecj.getNPions(),ecj.getAdmin());
				coupMaxPartie=rm3.getCoupMaxPartie();
			}
			//Traitement traçabilité	
			tl4j.recapTracageFinDeJeu(ecj, rm1, rm2, rm3, coupMaxPartie);

			System.out.println("Fin de la manche: "+ manche);
			System.out.println("_________________________________________________________________________________");
			emjJeuEnCours.demandeRecommenceJeu();
			
			if (emjJeuEnCours.getJeuEnCours().equals("non")) {
				jeuEnCours=false;
			}
			else {
				tl4j = new TraceLog4j();
				Jeu j = new Jeu();
				j.setJeu();
				j.doJeu();
				jeuEnCours=false;
			}
		}
	}
	/**
	 * Validation de l'entree d'admin en ligne de commande
	 */
	void setExtAdmin(){
		extAdmin=true;
	}
	
	
	/**
	 * @return l'instance de TraceLog4j
	 * @see EntreeConfigJeu
	 * @see GestionExceptionEntreesGlobales
	 */
	public static TraceLog4j getTl4j() {
		return tl4j;
	}
}
	

