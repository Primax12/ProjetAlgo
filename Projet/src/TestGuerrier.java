/**
 * @author Hardi Alexandre + NUEZ SORIANO, Diego
 */
public class TestGuerrier {
	
	public static void main (String[] args){
		
		System.out.println("===== TEST DE LA CLASSE GUERRIER ==== \n");
		
		// TEST DU CONSTRUCTEUR
		try{
			System.out.println("\n=== TEST DU CONSTRUCTEUR ===\n");
			//Guerrier g1 = new Guerrier(null, 100);
			//Guerrier g2 = new Guerrier("", 100);
			//Guerrier g3 = new Guerrier("test", 0);
			//Guerrier g4 = new Guerrier("test", -10);
			//Guerrier g5	= new Guerrier("test", 100);
			System.out.println("\n=== Test du constructeur Ok ===\n");
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage() + "\nTest Ko");
		}
		
		
		try{
			System.out.println("\n=== TEST DE SUBIRDEGATS ===\n");
			Guerrier g1 = new Guerrier("test", 100);
			//g1.subirDegats(-10);
			//g1.subirDegats(0);
			g1.subirDegats(10);
			System.out.println("\n=== Test de subirDegats Ok ===\n");
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage() + "\nTest Ko");
		}
		
		try{
			System.out.println("\n=== TEST DE DONNERPRIVILEGE ===\n");
			Guerrier g1 = new Guerrier("test", 100);
			//g1.donnerPrivilege(-1);
			g1.donnerPrivilege(0);
			g1.donnerPrivilege(0);
			//g1.donnerPrivilege(5);
			//g1.donnerPrivilege(6);
			System.out.println("\n=== Test de donnerPrivilege Ok ===\n");
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage() + "\nTest Ko");
		}
		
		try{
			System.out.println("\n=== TEST DE RETIREPRIVILEGE ===\n");
			Guerrier g1 = new Guerrier("test", 100);
			g1.donnerPrivilege(1);
			g1.donnerPrivilege(3);
			//g1.retirePrivilege(-1);
			g1.retirePrivilege(0);
			g1.retirePrivilege(1);
			g1.retirePrivilege(5);
			//g1.retirePrivilege(6);
			System.out.println("\n=== Test de retirePrivilege Ok ===\n");
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage() + "\nTest Ko");
		}
		
		try{
			System.out.println("\n=== TEST DE VOLERPRIVILEGE ===\n");
			Guerrier g1 = new Guerrier("test1", 100);
			g1.donnerPrivilege(1);
			g1.donnerPrivilege(3);
			System.out.println(g1);
			// test 1 voler à null.
			//g1.volerPrivilege(null);
			
			//test 2 voler à un guerrier qui possède les mêmes priv.
			//Guerrier g2 = g1 ;
			//g1.volerPrivilege(g2);
			
			// Voler un privilege qu'il ne possede pas.
			//Guerrier g3 = new Guerrier("test3", 100);
			//g3.donnerPrivilege(0);
			//g1.volerPrivilege(g3);
			
			// Vol d'un privilege alors que le guerrier les possedes tous
			//Guerrier g4 = new Guerruer("test4",100);
			//g4.donnerPrivilege(0);
			//g4.donnerPrivilege(1);
			//g4.donnerPrivilege(2);
			//g4.donnerPrivilege(3);
			//g4.donnerPrivilege(4);
			//g4.donnerPrivilege(5);
			//g4.volerPrivilege(g1);
			//System.out.println(g4);
			
			// Vol à un Guerrier qui possede tous les privileges
			//Guerrier g5 = new Guerrier("test5",100);
			//g5.donnerPrivilege(0);
			//g5.donnerPrivilege(1);
			//g5.donnerPrivilege(2);
			//g5.donnerPrivilege(3);
			//g5.donnerPrivilege(4);
			//g5.donnerPrivilege(5);
			//g1.volerPrivilege(g5);
			
			System.out.println(g1);
			
			System.out.println("\n=== Test de volerPrivilege Ok ===\n");
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage() + "\nTest Ko");
		}
		
		try{
			System.out.println("\n=== TEST DE POSSEDE ===\n");
			Guerrier g1 = new Guerrier("test", 100);
			// Test sur un guerrier qui ne possede pas de priv à un indice neg
			//g1.possede(-1);
			
			// Idem mais à un indice correct
			System.out.println("Test 1\ngot : " + g1.possede(0) + " Expected : false");
			
			// Test a un indice ou il possede le priv.
			g1.donnerPrivilege(0);
			System.out.println("Test 2\ngot : " + g1.possede(0) + " Expected : true");

			// Test a l'indice 6
			//g1.possede(6);
			System.out.println("\n=== Test de possede Ok ===\n");
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage() + "\nTest Ko");
		}
		
		try{
			System.out.println("\n=== TEST DE POSSEDETOUS ===\n");
			Guerrier g1 = new Guerrier("test", 100);
			//int[] liste = null ;
			// Test Avec null
			//g1.possedeTous(liste);
			
			// GuerrierPossede rien
			int[] liste2 = {0};
			System.out.println("Test 1\ngot : " + g1.possedeTous(liste2) + " Expected : false");
			
			// Test a un indice ou il possede le priv.
			int[] liste3 = {0,1,2,3,4,5};
			System.out.println("Test 2\ngot : " + g1.possedeTous(liste3) + " Expected : false");

			// Test avec liste vide
			int[] liste4 = {};
			System.out.println("Test 3\ngot : " + g1.possedeTous(liste4) + " Expected : true");
			
			g1.donnerPrivilege(0);
			g1.donnerPrivilege(3);
			g1.donnerPrivilege(4);
			
			// Test avec des priv et liste3
			System.out.println("Test 4\ngot : " + g1.possedeTous(liste3) + " Expected : false");
			
			// Test avec des priv et liste2
			System.out.println("Test 5\ngot : " + g1.possedeTous(liste2) + " Expected : true");

			// Test avec liste complete des privileges possedes
			int[] liste5 = {0,3,4};
			System.out.println("Test 6\ngot : " + g1.possedeTous(liste5) + " Expected : true");

			// Test avec liste contenant valeure trop grande
			int[] liste6 = {6};
			g1.possedeTous(liste6);
			System.out.println("\n=== Test de possedeTous Ok ===\n");

		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage() + "\nTest Ko");
		}
		
		try{
			System.out.println("\n=== TEST DE POSSEDEAUCUN ===\n");
			Guerrier g1 = new Guerrier("test", 100);
			//int[] liste = null ;
			// Test Avec null
			//g1.possedeTous(liste);
			
			// GuerrierPossede rien
			int[] liste2 = {0};
			System.out.println("Test 1\ngot : " + g1.possedeAucun(liste2) + " Expected : true");
			
			// Test a un indice ou il possede le priv.
			int[] liste3 = {0,1,2,3,4,5};
			System.out.println("Test 2\ngot : " + g1.possedeAucun(liste3) + " Expected : true");

			// Test avec liste vide
			int[] liste4 = {};
			System.out.println("Test 3\ngot : " + g1.possedeAucun(liste4) + " Expected : true");
			
			g1.donnerPrivilege(0);
			g1.donnerPrivilege(3);
			g1.donnerPrivilege(4);
			
			// Test avec des priv et liste3
			System.out.println("Test 4\ngot : " + g1.possedeAucun(liste3) + " Expected : false");
			
			// Test avec des priv et liste2
			System.out.println("Test 5\ngot : " + g1.possedeAucun(liste2) + " Expected : false");

			// Test avec liste complete des privileges possedes
			int[] liste5 = {1,2,5};
			System.out.println("Test 6\ngot : " + g1.possedeAucun(liste5) + " Expected : true");

			// Test avec liste contenant valeure trop grande
			int[] liste6 = {6};
			g1.possedeAucun(liste6);
			System.out.println("\n=== Test de possedeAucun Ok ===\n");

		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage() + "\nTest Ko");
		}
	}
}



