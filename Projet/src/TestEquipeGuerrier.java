/**
 * @author Hardi Alexandre + NUEZ SORIANO, Diego
 */
public class TestEquipeGuerrier {
	public static void main (String[] args){
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
