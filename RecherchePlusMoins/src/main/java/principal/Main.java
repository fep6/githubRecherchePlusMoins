package principal;

/**
 * 
 * @author fep
 *
 */

public class Main {
	
	private static boolean commandeAdmin;
	
	public static void main(String[] args) {
		
		
		/**
		 * Prévient l'écrasement de la variable args lors du recommencement du jeu
		 */
		commandeAdmin=false;
		
		 
		 /**
		  * Déroulé normal
		  */
		Jeu j = new Jeu();
		int nbreArg = args.length;
		// Prise en compte de l'argument de commande en ligne en admin (triche) (nbreArg est le nombre d'arguments dans la ligne de commande)
		for (nbreArg=0; nbreArg<args.length; nbreArg++) {
			System.out.print("L'argument 'admin' est le "+nbreArg+1+" argument de la commande en ligne!");
				System.out.println("args= "+ args[nbreArg] );
				if (args[nbreArg].contentEquals("admin")) {
					commandeAdmin=true;
					j.setExtAdmin();
				}
			}	
		
		j.getTl4j().debutJeu();
		j.setJeu(commandeAdmin);
		j.doJeu(commandeAdmin);
		System.out.println("Fin définitive du jeu!");
		System.out.println("_________________________");
		j.getTl4j().finJeu();
   }
}


