# githubRecherchePlusMoins

Projet 3  : Jeu «  Recherche + ou -  »



Il s'agit d'un jeu où vous challengez l'ordinateur.

1/ Règles du jeu

Le défenseur crée une combinaison secrète.
L'attaquant doit la retrouver, par divers coups successifs.

Pour ce faire, il existe trois mode  :
Mode 1  : L'ordinateur est défenseur, le joueur est attaquant.
Mode 2  : Le joueur défend, l'ordinateur attaque
Mode 3  : A tour de rôle, l'ordinateur ou le joueur attaquent, et défend sa combinaison .

2/ Compilation

   Dans la console, dans le repertoire du projet:
   	mvn package

   ou sous Eclipse avec Maven d'installé:
   -> click droit sur le projet
   -> Run as / build... : Ajouter 'package' dans 'Goals'

	Le fichier RecherchePlusMoins-0.0.1-SNAPSHOT.jar doit apparaitre dans le sous dossier Target.

3/ Execution du jeu

   Options:
   Dans le dossier IO, existe le fichier config.properties.
   Il est ouvrable via le bloc note de Windows (click droit, 'ouvrir avec', bloc note).
   Il définit le nombre de pions, et le nombre de coups de la partie.


   3.1 Mode simple
   tapez dans la console, dans la racine du dossier
	java -jar RecherchePlusMoins-0.0.1-SNAPSHOT.jar


   3.2 Mode triche
   'Admin' autorise un mode 'triche' où est affiché la combinaison de l'ordinateur, pendant le jeu.
   tapez dans la console, dans la racine du dossier
	java -jar RecherchePlusMoins-0.0.1-SNAPSHOT.jar -admin



   3.3 Mode 'tracé'

   Vous avez la possibilité d'enregistrer le jeu dans logs\myLogs.log 
   Pour ce faire, tapez dans la console, dans la racine du dossier
   	java -jar RecherchePlusMoins-0.0.1-SNAPSHOT.jar -trace
   Il est aussi ouvrable via le bloc note de Windows (click droit, 'ouvrir avec', bloc note).

4/ Prérequis

   Vous devez avoir la Java Runtime Environnement installée sur votre ordinateur.
   Pour savoir si c'est le cas, allez dans la console de Windows 10 (tapez 'cmd' dans la recherche de la barre de menu). 
   Ensuite, tapez 'java'. Une liste d'options doit apparaître.

   Si ce n'est pas le cas, rendez-vous sur le site, et téléchargez la JRE  :
	https://www.java.com/fr/download/








