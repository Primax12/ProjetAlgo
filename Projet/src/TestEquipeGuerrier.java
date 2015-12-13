/**
 * @author Hardi Alexandre + NUEZ SORIANO, Diego
 */
public class TestEquipeGuerrier {
	public static void main (String[] args){
		
		System.out.println("===== TEST DE LA CLASSE EQUIPEGUERRIER ==== \n");
		
		// TEST DU CONSTRUCTEUR
		try{
			System.out.println("\n=== TEST DU CONSTRUCTEUR ===\n");
			EquipeGuerrier eg1 = new EquipeGuerrier("EquipeTest1");
			EquipeGuerrier eg2 = new EquipeGuerrier("EquipeTest2", 5);
			System.out.println("\n=== Test du constructeur Ok ===\n");
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage() + "\nTest Ko");
		}
		
		try{
			System.out.println("\n=== TEST DU AJOUTERGUERRIER ===\n");
			EquipeGuerrier eg1 = new EquipeGuerrier("EquipeTest1", 1);
			
			Guerrier g1 = new Guerrier("g1", 100);
			Guerrier g2 = new Guerrier("g2", 100);
			if (!eg1.ajouterGuerrier(g1)) System.out.println("\nTest Ko");
			if (eg1.ajouterGuerrier(g1)) System.out.println("\nTest Ko");
			if (eg1.ajouterGuerrier(g2)) System.out.println("\nTest Ko");
			if (eg1.getNbreGuerrier() != 1) System.out.println("\nTest Ko");
			System.out.println("\n=== Test du ajouterGuerrier Ok ===\n");
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage() + "\nTest Ko");
		}
		
		try{
			System.out.println("\n=== TEST DU GETGUERRIER ===\n");
			EquipeGuerrier eg1 = new EquipeGuerrier("EquipeTest1", 2);
			Guerrier g1 = new Guerrier("g1", 100);
			Guerrier g2 = new Guerrier("g2", 100);
			eg1.ajouterGuerrier(g1);
			eg1.ajouterGuerrier(g2);
			if (g1 != eg1.getGuerrier(0)) System.out.println("\nTest Ko");
			if (g2 != eg1.getGuerrier(1)) System.out.println("\nTest Ko");
			System.out.println("\n=== Test du getGuerrier Ok ===\n");
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage() + "\nTest Ko");
		}
		
		try{
			System.out.println("\n=== TEST DU DONNERINDICE ===\n");
			EquipeGuerrier eg1 = new EquipeGuerrier("EquipeTest1", 2);
			Guerrier g1 = new Guerrier("g1", 100);
			Guerrier g2 = new Guerrier("g2", 100);
			eg1.ajouterGuerrier(g1);
			eg1.ajouterGuerrier(g2);
			if (eg1.donnerIndice(g1) != 0) System.out.println("\nTest Ko");
			if (eg1.donnerIndice(g2) != 1) System.out.println("\nTest Ko");
			System.out.println("\n=== Test du donnerIndice Ok ===\n");
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage() + "\nTest Ko");
		}
		
		try{
			System.out.println("\n=== TEST DU ESTPRESENT ===\n");
			EquipeGuerrier eg1 = new EquipeGuerrier("EquipeTest1", 2);
			Guerrier g1 = new Guerrier("g1", 100);
			Guerrier g2 = new Guerrier("g2", 100);
			eg1.ajouterGuerrier(g1);
			if (eg1.getNbreGuerrier() != 1) System.out.println("\nTest Ko");
			if (eg1.estPresent(g2) == true) System.out.println("\nTest Ko");
			System.out.println("\n=== Test du estPresent Ok ===\n");
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage() + "\nTest Ko");
		}
		
		try{
			System.out.println("\n=== TEST DU MOURRIR ===\n");
			EquipeGuerrier eg1 = new EquipeGuerrier("EquipeTest1", 2);
			Guerrier g1 = new Guerrier("g1", 100);
			Guerrier g2 = new Guerrier("g2", 100);
			eg1.ajouterGuerrier(g1);
			eg1.ajouterGuerrier(g2);
			eg1.mourir(g1);
			if (eg1.estPresent(g1) == true) System.out.println("\nTest Ko");
			//System.out.println(eg1.getGuerrier(0));
			if (eg1.getGuerrier(0) != g2) System.out.println("\nTest Ko");
			System.out.println("\n=== Test du mourrir Ok ===\n");
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage() + "\nTest Ko");
		}
		
		try{
			//Ca bug encore, je sais pas pourquoi
			System.out.println("\n=== TEST DU TABLEGUERRIERAVECPRIVILEGES ===\n");
			EquipeGuerrier eg1 = new EquipeGuerrier("EquipeTest1", 2);
			Guerrier g1 = new Guerrier("g1", 100);
			g1.donnerPrivilege(0);
			g1.donnerPrivilege(4);
			g1.donnerPrivilege(5);
			Guerrier g2 = new Guerrier("g2", 100);
			g2.donnerPrivilege(0);
			g2.donnerPrivilege(5);
			Guerrier g3 = new Guerrier("g3", 100);
			g3.donnerPrivilege(4);
			g3.donnerPrivilege(5);
			
			eg1.ajouterGuerrier(g1);
			eg1.ajouterGuerrier(g2);
			eg1.ajouterGuerrier(g3);
			
			int[] priv = new int[2];
			priv[0] = 4;
			priv[1] = 5;
			
			Guerrier[] verif1 = new Guerrier[2];
			verif1[0] = g1;
			verif1[1] = g3;
			Guerrier[] verif2 = eg1.tableGuerrierAvecPrivileges(priv);
			
			if (verif1.equals(verif2)) System.out.println("\nTest Ko");
			System.out.println("\n=== Test du tableGuerrierAvecPrivileges Ok ===\n");
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage() + "\nTest Ko");
		}
		
		
		/*
		Guerrier g1 = new Guerrier("g1", 100);
		Guerrier g2 = new Guerrier("g2", 100);

		Guerrier g3 = new Guerrier("g3", 100);
		
		g1.setNbrePV(20);
		g2.setNbrePV(23);
		
		EquipeGuerrier e1 = new EquipeGuerrier("BernTeam");
		e1.ajouterGuerrier(g1);
		e1.ajouterGuerrier(g2);
		e1.ajouterGuerrier(g3);
		
		//System.out.println(e1);
		
		Guerrier[] liste = e1.tableGuerrierSelonForce(1);
		
		for (int i = 0 ; i < liste.length; i++){
			System.out.println(liste[i]);
		}
		
		g1.donnerPrivilege(1);
		g1.donnerPrivilege(2);
		
		g2.donnerPrivilege(1);
		g2.donnerPrivilege(2);
		g2.donnerPrivilege(3);
		
		g3.donnerPrivilege(0);
		g3.donnerPrivilege(2);
		g3.donnerPrivilege(3);

		System.out.println("\n\n\n====================================\n\n\n");
		int[] liste2 = {1,2};
		Guerrier[] listeAvecPriv = e1.tableGuerrierAvecPrivileges(liste2);
		
		for (int i = 0 ; i < listeAvecPriv.length; i++){
			System.out.println(listeAvecPriv[i]);
		}
		
		//g1.donnerPrivilege(1);
		//g1.donnerPrivilege(4);
		//int[] x = {1,4};
		//int[] y = {1,3};
		//int[] z = {0,2};
		//System.out.println(g1.possedeAucun(x));
		//System.out.println(g1.possedeAucun(y));
		//System.out.println(g1.possedeAucun(z));
		//System.out.println(g1.possede(1));
		//System.out.println(g1.possede(3));
	
	
		//System.out.println(g1.retirePrivilege(1));
		/**	
		 System.out.println(g1);
	
		
		
		System.out.println(g1.equals(g2));
		
		Guerrier g3 = new Guerrier("Bernard", 100, 50);
		
		System.out.println(g1.equals(g3));
		 * */
	}
}
