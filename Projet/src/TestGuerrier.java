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
			Guerrier g5	= new Guerrier("test", 100);
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
	}
}



