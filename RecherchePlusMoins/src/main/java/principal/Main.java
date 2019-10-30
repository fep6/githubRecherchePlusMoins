package principal;


/**
 * 
 * @author fep
 *
 */

public class Main {
	public static void main(String[] args) {
		
//		System.out.println("args= "+ args[0] );
		Jeu j = new Jeu();
		
		// Prise en compte de l'argument de commande en ligne en admin (triche)
//		if (args[0].contentEquals("admin")) {
//			j.setExtAdmin();
//		}
		
		j.getTl4j().debutJeu();
		j.setJeu();
		j.doJeu();
		System.out.println("Fin définitive du jeu!");
		System.out.println("_________________________");
		j.getTl4j().finJeu();
   }
}


