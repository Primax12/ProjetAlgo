/**
 * @author Hardi Alexandre + NUEZ SORIANO, Diego
 */
public class TestEquipeGuerrier {
	public static void main (String[] args){
		Guerrier g1 = new Guerrier("Bernard", 100);
		Guerrier g2 = new Guerrier("Aernardo", 100);

		Guerrier g3 = new Guerrier("Airnardo", 100);
		
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
	
	
		System.out.println(g1.retirePrivilege(1));
		/**	
		 System.out.println(g1);
	
		
		
		System.out.println(g1.equals(g2));
		
		Guerrier g3 = new Guerrier("Bernard", 100, 50);
		
		System.out.println(g1.equals(g3));
		 * */
	}
}
