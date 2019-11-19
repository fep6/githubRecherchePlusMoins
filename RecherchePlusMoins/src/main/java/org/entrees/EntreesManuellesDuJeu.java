package org.entrees;



import java.util.Scanner;

import org.affichage.AffichageConsole;
import org.divers.GestionConformites;
import org.recherche.RechercheMode1;

/**
 * Entrées (int) du joueur, soit de la combinaison secrète (Mode1) ou de l'attaque (Mode2)
 * @author fep
 */
public class EntreesManuellesDuJeu {
	
	private AffichageConsole acEmdj;
	private GestionConformites gcEntreePions;
	private int[] entreeIntDuJoueur;
	private String[] entreeStringDuJoueur;
	private String jeuEnCours;
	private GestionConformites gcRecommenceJeu;
	private boolean testSiPionEntier;
	private String entreeString;
	private Scanner sc;
	
	public EntreesManuellesDuJeu(){
		acEmdj = new AffichageConsole();
		gcRecommenceJeu = new GestionConformites();
		sc = new Scanner(System.in);
	}
	public EntreesManuellesDuJeu(int pions){
		entreeIntDuJoueur = new int[pions];
		entreeStringDuJoueur = new String[pions];
		entreeString="";
		gcEntreePions = new GestionConformites();
	}
	public void demandeRecommenceJeu() {
		acEmdj.questionRecommenceJeu();
		gcRecommenceJeu.gestionEntreeSiRecommence();
		jeuEnCours=gcRecommenceJeu.getReponseSiRecommence();
	}
	public void doEntreesManuellesDesPions(int pions) {
		
		System.out.println("TEST : pions ="+pions);
		
//		acEmdj.entreeProposition(pions);

		System.out.println("TEST : Veuillez entrer votre proposition.  (Attention: " + pions + " pions à entrer)");
		
		
		entreeString = sc.nextLine();
		testNombreDePions(entreeString,pions);
		testSiPionsEntiers(entreeString,entreeIntDuJoueur, pions);
	}
	private void testNombreDePions(String entreeString,int pions) {
		if (entreeString.length()!=pions) {
			acEmdj.entreesEronneesNombrePions(pions);
			doEntreesManuellesDesPions(pions);
		}
	}
	private void testSiPionsEntiers(String entreeString,int[] entreeIntDuJoueur,int pions) {
		for (int pion=0;pion<pions;pion++) {
			
			entreeStringDuJoueur[pion]=Character.toString(entreeString.charAt(pion));
			testSiPionEntier=false;
			
			while (testSiPionEntier==false) {
				if (gcEntreePions.testEntreeSiEntierRegEx(pion, entreeStringDuJoueur)==false){
					acEmdj.entreesEronneesValeurPions(pions);
					doEntreesManuellesDesPions(pions);
				} else {
					entreeIntDuJoueur[pion]=Character.getNumericValue(entreeString.charAt(pion));
					testSiPionEntier=true; 
				}
			}
		}
	}
	/**
	 * @see RechercheMode1
	 * @see CombinaisonSecrete
	 * @param p
	 * @return
	 */
	public int getEntree(int p){
		return entreeIntDuJoueur[p];
	}
	public String getJeuEnCours() {
		return jeuEnCours;
	}
}
