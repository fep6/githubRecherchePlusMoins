package org.principal;

import org.affichage.AffichageConsole;

public class ComparatifAffichageTest {
	
	private AffichageConsole acCat;
	private String pVerdict;
	private int[][] pTableauJeu;
	private String[][] pTableauReponse;
	private String[] stringTableauJeu;
	private int[] pCombinaison;
	private boolean pBooleenSiGagne;
	private int pModeEnCours;
	/**
	 *  Définit le nombre de coup la partie
	 */
	private int pCoupMax;
	
	
	public ComparatifAffichageTest (int coups, int pions){
		acCat = new AffichageConsole();
		pVerdict = new String();
		pTableauJeu= new int [coups][pions];
		pTableauReponse= new String[coups][pions];
		pCombinaison= new int [pions];
		stringTableauJeu= new String [pions];
	}
	public void doComparatifAffichageTest (int[][] tableauJeu, int[] combinaison, boolean boleenSiGagne, 
			int coup, int tourRestant, int pions) {
		pBooleenSiGagne=boleenSiGagne;
		for (int pion=0; pion<pions;pion++) {
			pTableauJeu[coup][pion]= tableauJeu [coup][pion];
			pCombinaison[pion]= combinaison[pion];
		}
		comparatifCombinaisonSecrete(coup, pions);
		affichageEtTest(tourRestant,coup, pions);
		miseEnFormeTracage(pions);
	}
	/**
	 * Mise en forme du tableauJeu par coup pour log4j
	 * @param pions
	 * Nombre de pions maximum
	 */
	public void miseEnFormeTracage(int pions) {
		for (int coup=0;coup<pCoupMax;coup++) {
			for (int pion=0;pion<pions;pion++) {
				if (pion==0) {
					stringTableauJeu[coup]=Integer.toString(pTableauJeu[coup][pion]);
				} else {
					stringTableauJeu[coup]=stringTableauJeu[coup]+ Integer.toString(pTableauJeu[coup][pion]);
				}
			}
		}
	}
	private void comparatifCombinaisonSecrete(int coup, int pions){
		for (int pion=0; pion<pions; pion++) {
			if ( pTableauJeu[coup][pion]==pCombinaison[pion] ) {
				pTableauReponse[coup][pion]="=";
			}
			if ( pTableauJeu[coup][pion]<pCombinaison[pion] ) {
				pTableauReponse[coup][pion]="+";
				pBooleenSiGagne = false;
			}
			if ( pTableauJeu[coup][pion]>pCombinaison[pion] ) {
				pTableauReponse[coup][pion]="-";
				pBooleenSiGagne = false;
			}
		}
	}
	private void affichageEtTest(int tourRestant, int coup, int pions) {
		if (pModeEnCours==1) {
			acCat.reponseMode1();
		} else if (pModeEnCours==2) {
			acCat.reponseMode2();
		} else {
			acCat.erreurModeEnCours();
		}
		for (int pion=0; pion<pions; pion++) {
			System.out.print(pTableauReponse[coup][pion]);
		}
		System.out.println("");
		if (tourRestant == 1 && !pBooleenSiGagne && pModeEnCours==1) {
			pVerdict = acCat.joueurPerd();
			pCoupMax=coup;
		}
		else if (pBooleenSiGagne==true && pModeEnCours==1) {
			pVerdict = acCat.joueurGagne();;
			pCoupMax=coup;
		}
		else if (tourRestant == 1 && !pBooleenSiGagne && pModeEnCours==2) {
			pVerdict = acCat.ordiPerd();
			pCoupMax=coup;
		}
		else if (pBooleenSiGagne==true && pModeEnCours==2) {
			pVerdict = acCat.ordiGagne();
			pCoupMax=coup;
		} else { 
			pVerdict = acCat.jeuEnCours();
			pCoupMax=coup;;
			pCoupMax=coup;
		}
	}
	public void affichageRecapitulatif(int tourRestant, int coup, int coups){
			tourRestant = coups-coup;
			acCat.coupsRestants(tourRestant);
	}
	/**
	 * @see traceLog4.java 
	 */
	public void setModeEnCours1() {
		pModeEnCours=1;
	}
	public void setModeEnCours2() {
		pModeEnCours=2;
	}
	/**
	 * pour log4j
	 * @return le tableau de la defense (char + - = )
	 */
	public String getTableauReponse(int coup,int pion) {
		return pTableauReponse [coup][pion];
	}
	/**
	 * @return le tableau de l'attaque sous forme de String (log4j)
	 */
	public String getStringTableauJeu(int coup) {
		return stringTableauJeu[coup];
	}
	/**
	 * initialise le verdict quand le jeu recommence
	 * @see RechercheMode(int coups, int pions)
	 */
	public void setVerdict(String verdict) {
		pVerdict = verdict;
	}
	/**
	 * Retourne le verdict en cours
	 * @return
	 */
	public String getVerdict(){
		return pVerdict;
	}
	public int getCoupMaxPartie() {
		return pCoupMax;
	}
}

