/**
 * @author Hardi Alexandre + NUEZ SORIANO, Diego
 */
public class TestGuerrier {
	public static void main (String[] args){
		
		System.out.println("===== TEST DE LA CLASSE GUERRIER ==== \n");
		
		System.out.println("Creation de 3 combatants et affichage de leurs caracteristiques.\n");
		Guerrier g1 = new Guerrier("PikaClou", 150);
		Guerrier g2 = new Guerrier("FrappeFort", 180);
		Guerrier g3 = new Guerrier("Blorky", 90);
		
		System.out.println(g1 + "\n" + g2 + "\n" + g3);
		
		System.out.println("\n\nDont de privileges aux guerriers : \n");
		
		g1.donnerPrivilege(0) ;
		g1.donnerPrivilege(5);
		
		g2.donnerPrivilege(3) ;
		g2.donnerPrivilege(4) ;
		
		g3.donnerPrivilege(2) ;
		g3.donnerPrivilege(1) ;
		
		System.out.println(g1 + "\n" + g2 + "\n" + g3);
		
		System.out.println("\n\nRetrait de privileges aux guerriers : \n");
		
		g1.retirePrivilege(3) ;
		
		g2.retirePrivilege(4) ;
		
		g3.retirePrivilege(1) ;

		System.out.println(g1 + "\n" + g2 + "\n" + g3);
		
		System.out.println("\n\nTest des Méthodes sur les privileges.\n");
		System.out.println("Tes de la methode possede");
		
		System.out.println("Le Guerrier 1 possede le privilege 0 : "+g1.possede(0) + " Excepcted : true")  ;
		System.out.println("Le Guerrier 1 possede le privilege 1 : "+g1.possede(1) + " Excepcted : false") ;
		
		System.out.println("\t----------\n");
		
		System.out.println("\nTes de la methode possedeTous\n");
		
		int[] liste = {3,4} ;
		System.out.println("Le Guerrier 2 possede les privileges 3 et 4 : "+g2.possedeTous(liste) + " Excepcted : false") ;
		g2.donnerPrivilege(4);
		System.out.println("Dont du 3e privilege au Guerrier 2...");
		System.out.println("Le Guerrier 2 possede les privileges 3 et 4 : "+g2.possedeTous(liste) + " Excepcted : true") ;
		
		System.out.println("\n\nTest de la methode donnerForceFrappe\n");
		
		System.out.println(g1);
		System.out.println("\nRetrait de 2 PV à PikaClou\n");
		g1.setNbrePV((g1.getNbrePV())-149);
		System.out.println(g1);
		
		System.out.println(g3);
		
		g3.setNbrePV(1);
		System.out.println("\nIl ne reste que 1PV à Blorky\n");
		System.out.println(g3);

		
	}
}

