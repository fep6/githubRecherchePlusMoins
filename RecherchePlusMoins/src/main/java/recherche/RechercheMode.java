package recherche;

import divers.ComparatifAffichageTest;
import entrees.CombinaisonSecrete;
import principal.Jeu;

public abstract class RechercheMode {
	
	protected int[][] tableauJeuMode1;
	/**
	 * tableau défense pour mode 1 (joueur)
	 */
	protected int[] combinaisonOrdi;
	/**
	 * Tableau de l'attaquant Mode2
	 * @see RechercheMode2
	 * @see RechercheMode3
	 */
	protected int[][] tableauJeuMode2;
	/**
	 * tableau défense pour mode 2 (ordinateur)
	 */
	protected int[] combinaisonJoueur;
/** Entrée de la combinaison secrète du joueur ou de l'ordinateur selon le mode du jeu
 * @see CombinaisonSecrete.doCombinaisonSecrete(modeJeu,pions,admin)
 */
	protected CombinaisonSecrete cs;
/** Comparatif entre int[][] tableauJeu et int[] combinaison
 * @see ComparatifAffichageTest
 */
	protected ComparatifAffichageTest cat1;
/** Comparatif entre int[][] tableauJeu et int[] combinaison
 * @see ComparatifAffichageTest
 */
	protected ComparatifAffichageTest cat2;
/**
 * Indique la réponse du joueur (en défense)
 */
	protected String[][] tableauReponseJoueur;
/**
 * Sortie du while de chaque doRechercheMode()
 */
	protected boolean boleenSiGagne;
/**
 * Indique le N° de coup en cours
 */
	protected int coup;
/**
 * Indique le nombre de tour qu'il reste
 */
	protected int tourRestant;
/**
 * Indique si le jeu n'est pas terminé
 */
	protected boolean jeuEnCours;
/**
 * Sert à la recherche dichotomique
 */
	protected int[] dichoPlus;
/**
 * Sert à la recherche dichotomique
 */ 
	protected int[] dichoMoins;
/**
 * Sert à la recherche dichotomique
 */ 
	protected int dichoMax;
/**
 * Remonté coup max partie pour log4j
 */
protected int CoupMaxPartie;

	
	
	RechercheMode(int coups, int pions) {

		tableauJeuMode1 = new int[coups][pions];
		combinaisonOrdi = new int [pions];
		cs = new CombinaisonSecrete(pions);
	    cat1 = new ComparatifAffichageTest(coups, pions);
	    cat2 = new ComparatifAffichageTest(coups, pions);
	    tableauJeuMode2 = new int[coups][pions];
	    combinaisonJoueur  = new int [pions];
	    coup = 0;
	    tourRestant = coups;
	    jeuEnCours=true;	
		tableauReponseJoueur  = new String[coups] [pions];		
		dichoMax = 10;		
		dichoPlus = new int [pions] ;
		dichoMoins = new int [pions] ;
		jeuEnCours= true;
		// Reinitialisation des verdicts quand le jeu recommence
		cat1.setVerdict("");
		cat2.setVerdict("");
	}
	
	/**
	 * Pour tracage Log4j fin de partie du modes 1 & 3
	 * @return
	 * verdict
	 * @see
	 * rm1&rm3.recapTracageFinDeJeu()
	 */
	public String getCAT1Verdict(){
		return cat1.getVerdict();
	}
	/**
	 * Pour tracage Log4j fin de partie du modes 1 & 3
	 * @return
	 * tableau de jeu 
	 * @see
	 * rm1&rm3 .recapTracageFinDeJeu()
	 * 
	 */
	public String getCAT1StringTableauJeu(int coup) {
		return cat1.getStringTableauJeu(coup);
	}
	/**
	 * Pour tracage Log4j fin de partie du modes 2 & 3
	 * @return
	 * verdict 
	 * @see
	 * rm2&rm3.recapTracageFinDeJeu()
	 */
	public String getCAT2Verdict(){
		return cat2.getVerdict();
	}
	/**
	 * Pour tracage Log4j fin de partie du mode 2
	 * @return
	 * tableau de jeu 
	 * @see
	 * Jeu.recapTracageFinDeJeu()
	 */
	public String getCAT2StringTableauJeu(int coup) {
		return cat2.getStringTableauJeu(coup);
	}
	/**
	 * retourne le nombre de coups max de la partie pour Log4j
	 * @see Jeu
	 */
	public int getCoupMaxPartie() {
		CoupMaxPartie = Math.max(cat1.getCoupMaxPartie(),cat2.getCoupMaxPartie() );
		return CoupMaxPartie;
	}
}
