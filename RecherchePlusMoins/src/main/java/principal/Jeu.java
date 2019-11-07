package principal;

import divers.TraceLog4j;
import entrees.EntreesConfigJeu;
import entrees.EntreesManuellesDuJeu;
import recherche.RechercheMode1;
import recherche.RechercheMode2;
import recherche.RechercheMode3;

public class Jeu {
	//Entrees du jeu
	private EntreesConfigJeu ecj;
	// Tracabilite
	private static TraceLog4j tl4j;

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
	private static boolean extAdmin;
	
	private int nbreArg;
	
	public Jeu() {

		ecj = new EntreesConfigJeu();
	}
	void debutJeu(String[] args) {
		int nbreArg = args.length;
		// Prise en compte de l'argument de commande en ligne en admin (triche) (nbreArg est le nombre d'arguments dans la ligne de commande)
		for (nbreArg=0; nbreArg<args.length; nbreArg++) {
			System.out.print("L'argument 'admin' est le "+nbreArg+1+" argument de la commande en ligne!");
				System.out.println("args= "+ args[nbreArg] );
				if (args[nbreArg].contentEquals("admin")) {
					setAdminCommande();
				}
			}	
		getTl4j().debutJeu();
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
				
				
				rm1.doRechercheMode(ecj.getModeJeu(),ecj.getNCoups(),ecj.getNPions(),ecj.getAdmin()||extAdmin);
				System.out.println("TEST: ecj.getAdmin()=" +ecj.getAdmin());
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
	void finJeu() {
		System.out.println("Fin définitive du jeu!");
		System.out.println("_________________________");
		getTl4j().finJeu();
	}
	/**
	 * Validation de l'entree d'admin du fichier de configuration
	 * @see config.properties
	 */
	void setAdminConfig(){
		extAdmin=true;
		tl4j.setAdminConfig();
	}
	void setAdminCommande() {
		// commandeAdmin=true;
		tl4j.setAdminCommande();
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
	

