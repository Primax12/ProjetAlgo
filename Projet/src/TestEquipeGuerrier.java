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
		
		try{
			System.out.println("\n=== TEST DU TABLEGUERRIERSANSPRIVILEGE ===\n");
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
			
			Guerrier[] verif1 = new Guerrier[1];
			verif1[0] = g2;
			Guerrier[] verif2 = eg1.tableGuerrierSansPrivileges(priv);
			
			if (verif1.equals(verif2)) System.out.println("\nTest Ko");
			System.out.println("\n=== Test du tableGuerrierSansPrivileges Ok ===\n");
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage() + "\nTest Ko");
		}
		
		try{
			System.out.println("\n=== TEST DU TABLEGUERRIERSELONFORCE ===\n");
			EquipeGuerrier eg1 = new EquipeGuerrier("EquipeTest1", 2);
			Guerrier g1 = new Guerrier("g1", 100);
			Guerrier g2 = new Guerrier("g2", 100);
			Guerrier g3 = new Guerrier("g3", 100);
			g1.subirDegats(10);
			g3.subirDegats(50);
			
			eg1.ajouterGuerrier(g1);
			eg1.ajouterGuerrier(g2);
			eg1.ajouterGuerrier(g3);
			
			Guerrier[] table = new Guerrier[2];
			table[0] = g2;
			table[1] = g1;
			
			Guerrier[] verif = eg1.tableGuerrierSelonForce(4);
			
			if (table.equals(verif)) System.out.println("\nTest Ko");
			System.out.println("\n=== Test du tableGuerrierSelonForce Ok ===\n");
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage() + "\nTest Ko");
		}
		
		
	}
}
