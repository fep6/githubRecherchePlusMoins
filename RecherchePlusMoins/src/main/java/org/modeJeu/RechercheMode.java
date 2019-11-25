package org.modeJeu;

import org.entrees.CombinaisonSecrete;
import org.principal.ComparatifAffichageTest;

public abstract class RechercheMode {
	
	protected int[][] tableauJeuMode1;
	protected int[] combinaisonOrdi;
	protected int[][] tableauJeuMode2;
	protected int[] combinaisonJoueur;
	protected CombinaisonSecrete cs;
/** Comparatif entre int[][] tableauJeu et int[] combinaison
 * @see ComparatifAffichageTest
 */
	protected ComparatifAffichageTest cat1;
	protected ComparatifAffichageTest cat2;
	protected String[][] tableauReponseJoueur;
/**
 * Sortie du while de chaque doRechercheMode()
 */
	protected boolean boleenSiGagne;
	protected int coup;
	protected int tourRestant;
	protected boolean jeuEnCours;
	protected int[] dichoPlus;
	protected int[] dichoMoins;
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
	 */
	public String getCAT1Verdict(){
		return cat1.getVerdict();
	}
	/**
	 * Pour tracage Log4j fin de partie du modes 1 & 3 
	 */
	public String getCAT1StringTableauJeu(int coup) {
		return cat1.getStringTableauJeu(coup);
	}
	/**
	 * Pour tracage Log4j fin de partie du modes 2 & 3
	 */
	public String getCAT2Verdict(){
		return cat2.getVerdict();
	}
	/**
	 * Pour tracage Log4j fin de partie du mode 2
	 */
	public String getCAT2StringTableauJeu(int coup) {
		return cat2.getStringTableauJeu(coup);
	}
	/**
	 * retourne le nombre de coups max de la partie pour Log4j
	 */
	public int getCoupMaxPartie() {
		CoupMaxPartie = Math.max(cat1.getCoupMaxPartie(),cat2.getCoupMaxPartie() );
		return CoupMaxPartie;
	}
}
