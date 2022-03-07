package principal;

/**
 * 
 * @author fep
 *
 */

	// essai push git 5

public class Main {
	public static void main(String[] args) {
		
  
		Jeu j = new Jeu();
		int nbreArg = args.length;
		// Prise en compte de l'argument de commande en ligne en admin (triche) (nbreArg est le nombre d'arguments dans la ligne de commande)
		for (nbreArg=0; nbreArg<args.length; nbreArg++) {
			System.out.print("argument :"+nbreArg);
			System.out.println("args= "+ args[nbreArg] );
			// Entrée en mode admin selon l'argument tapé lors de la commande du lancement du programme
			if (args[nbreArg].contentEquals("admin")) {
				j.setExtAdmin();
			}
		}	
	 	
		j.getTl4j().debutJeu();
		j.setJeu();
		j.doJeu();
		System.out.println("Fin définitive du jeu!");
		System.out.println("_________________________");
		j.getTl4j().finJeu();
   }
}


