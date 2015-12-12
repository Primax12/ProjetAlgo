/**
 * @author Hardi Alexandre + NUEZ SORIANO, Diego
 */
public class Utilitaires {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in); 

	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;

		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1))
								+ valeurMinimale;
		return resultat;
	}
	
	public static int choixEntierEntre(int borneMin, int borneMax){
		int choix = scanner.nextInt();
		while (choix < borneMin || choix > borneMax){
			System.out.print("Votre choix doit se situer entre " + borneMin + " et " + borneMax + " : ");
			choix = scanner.nextInt();
			scanner.nextLine();
		} 
		return choix ;
	}
}



