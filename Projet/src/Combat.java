/**
 * @author Hardi Alexandre + NUEZ SORIANO, Diego
 */
public class Combat {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static EquipeGuerrier[] listeEquipe = new EquipeGuerrier[2]; 
	
	
	
	public static void main(String args[]){
		videEcran();
		
		System.out.println("*********************************");
		System.out.println("**          GLADIATOR          **");
		System.out.println("*********************************");
		
		System.out.println("\nBienvenu dans Gladiator !");
		
		pause();
		videEcran();
		
		menuPrincipal();
		
	}
	
	public static void menuPrincipal(){
		System.out.println("\n=== Menu Principal ===\n");
		
		System.out.println("1 - JOUER");
		System.out.println("2 - REGLES DU JEU");
		System.out.println("3 - QUITTER");
		
		System.out.print("\nFaites votre choix : ");
		int choix = Utilitaires.choixEntierEntre(1, 3);
		
		videEcran();
		
		switch (choix) {
		case 1:
			CreationEquipe();
			combatGuerrier();
			System.out.println("Fin du combat");
			menuPrincipal();
			break ;
		case 2:
			affichageRegles();
			break ;
		default:
			System.out.println("\n===== Fin du jeu =====\n");
			break;
		}
	}

	public static void CreationEquipe(){
		boolean[] championsChoisis = new boolean[10];
		Guerrier[] listeGuerrier = CreationListeGuerrier() ;
		
		System.out.print("\nJoueur 1 : choisissez le nom de votre equipe : ");
		String nom = scanner.next();
		EquipeGuerrier equipe1 = new EquipeGuerrier(nom);
		
		System.out.print("\n\nJoueur 2 : choisissez le nom de votre equipe : ");
		EquipeGuerrier equipe2 ;
		while (true){
			nom = scanner.next();
			if (!nom.equals(equipe1.getNom())){
				equipe2 = new EquipeGuerrier(nom);
				break;
			}
			System.out.print("Ce nom a déjà été pris ! Veuillez choisir un autre nom : ");
		}
		
		int choix ;
		for (int i = 0 ; i < 3 ; i++){
			afficherListeGuerrier(listeGuerrier, championsChoisis);
			
			choix = choixGuerrier(championsChoisis, equipe1) ;
			
			equipe1.ajouterGuerrier(listeGuerrier[choix]);
			championsChoisis[choix] = true ;
			
			afficherListeGuerrier(listeGuerrier, championsChoisis);
			
			choix = choixGuerrier(championsChoisis, equipe2) ;
			
			equipe2.ajouterGuerrier(listeGuerrier[choix]);
			championsChoisis[choix] = true ;
		}	
		System.out.println("\n" + equipe1 + "\n\n\n" + equipe2);
		
		listeEquipe[0] = equipe1;
		listeEquipe[1] = equipe2;
		
		videEcran();
		
		System.out.println("\nQue le combat commence !");
		pause();
		videEcran();
	}
	
	/** ==== LISTE DES PRIVILEGES ====
	 * 0 - Une chance sur 8 de faire un coup critique
	 * 1 - Les coups portes feront plus de degats. (les bornes du de sont plus grandes
	 * 2 - Possede un bouclier qui encaisse 25% des degats
	 * 3 - Resiste à la derniere attaque
	 * 4 - Soin : +5PV par tour
	 * 5 - Empoisonne son adversaire (-5PV par tour)
	 */
	public static Guerrier[] CreationListeGuerrier(){
		Guerrier[] listeGuerrier  = new Guerrier[10];
		int indice = 0 ;
		
		// Création des 10 champions
		Guerrier guerrier1 = new Guerrier("Link", 100) ;
		guerrier1.donnerPrivilege(2);
		listeGuerrier[indice] = guerrier1 ;
		indice++ ;
		
		Guerrier guerrier2 = new Guerrier("Ganondorf", 160) ;
		guerrier2.donnerPrivilege(1);
		listeGuerrier[indice] = guerrier2 ;
		indice++ ;
		
		Guerrier guerrier3 = new Guerrier("Zelda", 90) ;
		guerrier3.donnerPrivilege(4);
		listeGuerrier[indice] = guerrier3 ;
		indice++ ;
		
		Guerrier guerrier4 = new Guerrier("SkullKid", 110) ;
		guerrier4.donnerPrivilege(5);
		listeGuerrier[indice] = guerrier4 ;
		indice++ ;
		
		Guerrier guerrier5 = new Guerrier("Impa", 150) ;
		guerrier5.donnerPrivilege(3) ;
		listeGuerrier[indice] = guerrier5 ;
		indice++ ;
		
		Guerrier guerrier6 = new Guerrier("Xanto", 120) ;
		guerrier6.donnerPrivilege(0) ;
		listeGuerrier[indice] = guerrier6 ;
		indice++ ;
		
		Guerrier guerrier7 = new Guerrier("Samus", 90) ;
		guerrier7.donnerPrivilege(2) ;
		listeGuerrier[indice] = guerrier7 ;
		indice++ ;
		
		Guerrier guerrier8 = new Guerrier("Mario", 100) ;
		guerrier8.donnerPrivilege(5) ;
		listeGuerrier[indice] = guerrier8 ;
		indice++ ;
		
		Guerrier guerrier9 = new Guerrier("Luigi", 110) ;
		guerrier9.donnerPrivilege(3);
		listeGuerrier[indice] = guerrier9 ;
		indice++ ;
		
		Guerrier guerrier0 = new Guerrier("Ganon", 200) ;
		listeGuerrier[indice] = guerrier0 ;
		indice++ ;
		
		return listeGuerrier ;
	}
	
	public static void affichageRegles(){
		System.out.println("\n\t==== REGLES DU JEU ==== \n");
		
		System.out.println("Creez votre equipe de 3 combattants et affrontez vos amis dans un combat a  mort!");
		System.out.println("\nApres avoir choisi le nom de votre equipe, choisissez 3 champions a  tour de role");
		System.out.println("parmi les 10 qui vous sont proposes. Ensuite, le combat commence !\n");
		
		System.out.println("Chaque combattant possede un privilege au debut du jeu, cependant un combattant");
		System.out.println("peut gagner le/les privilege/s de son adversaire en tuant celui-ci! \n");
		
		System.out.println("Pendant le combat, vous pouvez consulter la liste de vos champion a tout moment");
		System.out.println("Vous pouvez egalement changer de champion pendant le combat, mais le changement");
		System.out.println("compte pour un tour. (/!\\ le changement ne soigne pas votre champion.)");
		System.out.println("Les degats que vos champions vont infliger sont proportionnels a leurs PV !");

		System.out.println("Vous perdez lorsque tous vos champions sont morts! \n");
		
		menuPrincipal();
	}
	
	public static void videEcran(){
		for(int i=0; i<40; i++){
			System.out.println("");
		}
	}
	
	public static void pause(){
		System.out.println("Appuyez sur entre");
		scanner.nextLine();
	}
	
	public static int choixGuerrier(boolean[] championsChoisis, EquipeGuerrier equipe){
		int choix ;
		while (true){
			System.out.print("\nEquipe : " + equipe.getNom() + " Choisissez un champion : ");
			choix = Utilitaires.choixEntierEntre(0, 9);
			if (championsChoisis[choix])
				System.out.println("\nCe choix n'est pas valable !\n");
			else
				break;
			}
		return choix ;
	}
	
	public static void afficherListeGuerrier(Guerrier[] listeGuerrier, boolean[] championsChoisis){
		System.out.println("\n=== LISTE DES GUERRIERS ===\n");
		for (int j = 0 ; j < listeGuerrier.length ; j++){
			if (!championsChoisis[j])
				System.out.println(j + " - " + listeGuerrier[j] + "\n");
		}
	}
	
	public static void afficherEquipe(EquipeGuerrier equipe){
		System.out.println("\n=== LISTE DES GUERRIERS ===\n");
		for (int i = 0 ; i < equipe.getNbreGuerrier() ; i++){
			System.out.println(i + " - " + equipe.getGuerrier(i) + "\n");
		}
	}
	
	public static void combatGuerrier(){
		Guerrier[] combattants = new Guerrier[2];
		
		int tour = 0;
		
	
		combattants[0] = choisirCombatant(0);
		videEcran();
		combattants[1] = choisirCombatant(1);
		videEcran();
		
		while (!combatFini()){
			System.out.println("\nTour de " + combattants[tour].getNom()+"\n");
			System.out.println(combattants[0] + "\n" + combattants[1]);
			choixAction(tour, combattants);
			tour = (tour+1)%2;
		}
	}
	
	public static Guerrier choisirCombatant(int tour){
		System.out.println("Equipe "+listeEquipe[tour].getNom()+" Choissisez votre combattant: ");
		afficherEquipe(listeEquipe[tour]);
		
		System.out.print("Faites votre choix : ");
		int choix = Utilitaires.choixEntierEntre(0, listeEquipe[tour].getNbreGuerrier()-1, "Ce combattant est mort! ");
				
		return listeEquipe[tour].selectionner(choix);
	}
	
	public static boolean combatFini(){
		if (listeEquipe[0].getNbreGuerrier() == 0) return true;
		if (listeEquipe[1].getNbreGuerrier() == 0) return true;
		return false;
	}
	
	public static void choixAction(int tour, Guerrier[] combattants){
		System.out.println("1 - ATTAQUER");
		System.out.println("2 - CHANGER COMBATTANT");
		System.out.println("3 - VOIR EQUIPE");
		
		System.out.print("\nFaites votre choix : ");
		int choix = Utilitaires.choixEntierEntre(1, 3);
		
		
		switch (choix) {
		case 1:
			attaque(tour, combattants);
			videEcran();
			break ;
		case 2:
			combattants[tour] = choisirCombatant(tour);
			videEcran();
			break ;
		default:
			afficherEquipe(listeEquipe[tour]);
			pause();
			videEcran();
			choixAction(tour, combattants);
			break;
		}
	}
	
	public static void attaque(int tour, Guerrier[] combattants){
		Guerrier attaquant = combattants[tour], defenseur = combattants[(tour+1)%2];
		int force = attaquant.donnerForceDeFrappe();
		int degats = Utilitaires.unEntierAuHasardEntre(force*6, force*8);
		
		for (int i=0; i<6; i++){
			if (attaquant.possede(i)){
				switch (i){
				case 0:
					if (Utilitaires.unEntierAuHasardEntre(1, 8)==1){
						degats = degats + (degats/2);
						System.out.println("Coup critique!\n");
					}
					break;
				case 1:
					degats = degats + degats/10;
					System.out.println(attaquant.getNom()+" frappe fort!\n");
					break;
				case 4:
					attaquant.ajouterPV(5);
					System.out.println(attaquant.getNom()+" se soigne\n");
					break;
				case 5:
					if (!defenseur.isPoison()){
						defenseur.setPoison(true);
						System.out.println(attaquant.getNom()+" empoisonne "+defenseur.getNom() + "\n");
					}
					break;
				}
			}
			if (defenseur.possede(i)){
				switch (i){
				case 2:
					degats = degats - degats/4;
					System.out.println(defenseur.getNom()+" se protege avec son bouclier\n");
					break;
				case 3:
					if (!defenseur.isDernierCoup() && degats>defenseur.getNbrePV()){
						degats = 0;
						defenseur.setDernierCoup(true);
						System.out.println(defenseur.getNom()+" esquive son coup fatal!\n");
					}
					break;
				}
			}
		}
		
		System.out.println(attaquant.getNom()+" inflige "+degats+" degats a "+defenseur.getNom());
		
		if (defenseur.isPoison()){
			degats = degats+5;
			System.out.println(defenseur.getNom()+" subit les effet du poison\n");
		}
		
		defenseur.subirDegats(degats);
		
		if (defenseur.getNbrePV() == 0){
			listeEquipe[(tour+1)%2].mourir(defenseur);
			System.out.println(defenseur.getNom()+" est mort!");
			attaquant.volerPrivilege(defenseur);
			System.out.println("\n" + attaquant.getNom() + " vole tous les privileges de " + defenseur.getNom() + "\n");
			
			pause();
			videEcran();
			
			if (!combatFini())
				combattants[(tour+1)%2] = choisirCombatant((tour+1)%2);			
			else
				System.out.println("==== La victoire est pour L'equipe " + listeEquipe[tour].getNom() + "====\n ==== Félicitations !====");
				pause();
				videEcran();

		}
		else{
			pause();
		}
	}
}