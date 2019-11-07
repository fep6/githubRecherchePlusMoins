package entrees;



import java.util.Scanner;

import divers.GestionConformites;
import recherche.RechercheMode1;

/**
 * Entrées (int) du joueur, soit de la combinaison secrète (Mode1) ou de l'attaque (Mode2)
 * @author fep
 */
public class EntreesManuellesDuJeu {

	private GestionConformites gcEntreePions;
	/**
	 * Entree simple du joueur sous forme entière
	 */
	private int[] entreeIntDuJoueur;
	/**
	 * Entree simple du joueur sous forme String
	 */
	private String[] entreeStringDuJoueur;
	
	private String jeuEnCours;
	/**
	 * Pour recommencer le jeu (a la fin)
	 */
	private GestionConformites gcRecommenceJeu;
	private boolean testSiPionEntier;
	private String entreeString;
	private Scanner sc = new Scanner(System.in);
	
	public EntreesManuellesDuJeu(){
		gcRecommenceJeu = new GestionConformites();
	}
	/**
	 * Constructeur selon entrées des pions du joueur	
	 * @param pions
	 * @see CombinaisonSecrete
	 * @see RechercheMode1
	 */ 
	public EntreesManuellesDuJeu(int pions){
		entreeIntDuJoueur = new int[pions];
		entreeStringDuJoueur = new String[pions];
		entreeString="";
		gcEntreePions = new GestionConformites();
	}
	public void demandeRecommenceJeu() {
		System.out.println("Voulez-vous recommencer le jeu (oui/non)?");
		gcRecommenceJeu.gestionEntreeSiRecommence();
		jeuEnCours=gcRecommenceJeu.getReponseSiRecommence();
	}
	public void doEntreesManuellesDesPions(int pions) {
		System.out.println("Veuillez entrer votre proposition.  (Attention: " + pions + " pions à entrer)");
			entreeString = sc.nextLine();
			testNombreDePions(entreeString,pions);
			testSiPionsEntiers(entreeString,entreeIntDuJoueur, pions);
	}
	private void testNombreDePions(String entreeString,int pions) {
		if (entreeString.length()!=pions) {
			System.out.println("Votre entree est erronnée!");
			System.out.println("Merci de rentrer le bon nombre de pions. A savoir: " + pions + " chiffres (pions)");
			doEntreesManuellesDesPions(pions);
		}
	}
	private void testSiPionsEntiers(String entreeString,int[] entreeIntDuJoueur,int pions) {
		for (int pion=0;pion<pions;pion++) {
			
			entreeStringDuJoueur[pion]=Character.toString(entreeString.charAt(pion));
			testSiPionEntier=false;
			
			while (testSiPionEntier==false) {
				if (gcEntreePions.testEntreeSiEntierRegEx(pion, entreeStringDuJoueur)==false){
					System.out.println("Svp d'entrer "+ pions + " pions d'une valeur entre 0 et 9!");
					doEntreesManuellesDesPions(pions);
				} else {
					entreeIntDuJoueur[pion]=Character.getNumericValue(entreeString.charAt(pion));
					testSiPionEntier=true; 
				}
			}
		}
	}
	
/**
 * Retour de la touche du joueur
 * @param p
 * l'entrée du pion
 * @return
 * Retour de l'entrée clavier du joueur
 * @see CombinaisonSecrete.setCombinaisonSecreteJoueur(int pions)
 * Combinaison secrète du joueur (Mode2)
 * @see RechercheMode1.entreesJoueur(int coup, int[][] tableauJeu, int pions)
 * Jeu du joueur (Mode1)
 */
	public int getEntree(int p){
		return entreeIntDuJoueur[p];
	}
	public String getJeuEnCours() {
		return jeuEnCours;
	}
}
