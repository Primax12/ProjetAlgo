/**
 * @author Hardi Alexandre + NUEZ SORIANO, Diego
 */
public class Guerrier {
	
	//Un peu par ici aussi
	//Test de fetch
	
	private String nom  ;
	private int nbrePV  ;
	private int pvMax	;
	private boolean[] privilege ;
	private boolean poison ;
	private boolean dernierCoup ;
	private static final String[] LISTE_PRIVILEGE= {"Une chance sur 8 de faire un coup critique",
													"Les coups portés feront plus de dégats.", 
													"Possède un bouclier qui encaisse 25% des dégats",
													"Résiste à la dernière attaque",
													"Soin +1PV par tour.",
													"Empoisonne son adversaire (-1PV par tour)"} ;
	
	public Guerrier(String nom , int nbrePV){
		if (nom.equals("")) throw new IllegalArgumentException("Le nom ne peut pas être une chaîne de caractère vide.");
		if (nbrePV <= 0) throw new IllegalArgumentException("Le nombre de PV doit être strictement suppérieur à 0");
		this.nom = nom ;
		this.nbrePV = nbrePV ;
		this.pvMax  = nbrePV ; 
		this.privilege = new boolean[LISTE_PRIVILEGE.length];
	}

	public int getNbrePV() {
		return nbrePV;
	}

	public void setNbrePV(int nbrePV) {
		if (nbrePV <= 0) throw new IllegalArgumentException("Un guerrier ne peut pas avoir un nombre de point de vie négatif.");
		this.nbrePV = nbrePV;
	}

	public boolean isPoison() {
		return poison;
	}

	public void setPoison(boolean poison) {
		this.poison = poison;
	}

	public boolean isDernierCoup() {
		return dernierCoup;
	}

	public String getNom() {
		return nom;
	}
	
	/**
	 * Donne la force de frappe d'un combattant sur une échelle de 4(max) à 1(min).
	 * @return int correspondant à la force de frappe. (détermine le dé à jeter).
	 */
	public int donnerForceDeFrappe(){
		int forceFrappe = (this.nbrePV/this.pvMax)*100 ;
		return (forceFrappe-1)/25 + 1 ;
	}
	
	public boolean possede(int privRecherche){
		if (privRecherche >= privilege.length || privRecherche < 0)
			throw new IllegalArgumentException("Ce privilège n'existe pas");
		return privilege[privRecherche] ;
	}
	
	public boolean possedeTous(int[] privilegeRecherche){
		for (int i = 0 ; i < privilegeRecherche.length ; i++){
			if ((privilegeRecherche[i] >= privilege.length || privilegeRecherche[i] < 0))
				throw new IllegalArgumentException("Ce privilège n'existe pas");
			if (!privilege[privilegeRecherche[i]])
				return false ;
		}
		return true ;
	}
	
	public boolean possedeAucun(int[] privilegeRecherche){
		for (int i = 0 ; i < privilegeRecherche.length ; i++){
			if (privilegeRecherche[i] >= privilege.length || privilegeRecherche[i] < 0)
				throw new IllegalArgumentException("Ce privilège n'existe pas");
			if (privilege[privilegeRecherche[i]])
				return false ;
		}
		return true ;
	}
	
	/**
	 * @return true si le guerrier possède 0 privilèges, false sinon.
	 */
	public boolean possedeZeroPriv(){
		for (int i = 0 ; i < privilege.length ; i++){
			if (privilege[i])
				return false ;
		}
		return true ;
	}
	
	public boolean donnerPrivilege(int indice){
		if (indice >= privilege.length || indice < 0)
			throw new IllegalArgumentException("Ce privilège n'existe pas");
		if (!this.privilege[indice]){
			this.privilege[indice] = true ;
			return true ;
		}
		return false ;
	}
	
	public boolean retirePrivilege(int indice){
		if (indice >= privilege.length || indice < 0)
			throw new IllegalArgumentException("Ce privilège n'existe pas");
		if (this.privilege[indice]){
			this.privilege[indice] = false ;
			return true ;
		}
		return false ;
	}
	

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Guerrier other = (Guerrier) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	
	public int hashCode() {
		return  nom.hashCode();
	}
	
	public String toString(){
		String texte = new String();
		texte = this.nom + ":\n" +
				"\tVie\t : "	+ this.nbrePV + "/" + this.pvMax + " PV\n" +
				"\tForce\t : "	+ this.donnerForceDeFrappe() + "\n" +
				"\tPrivilèges : " ;
		
		if (this.possedeZeroPriv())
			texte += "\n\t\tAuncun" ;
		else{ 
			for (int i=0; i<this.privilege.length; i++){
				if (this.privilege[i])
					texte = texte + "\n\t\t"+ LISTE_PRIVILEGE[i];
			}
		}
		return texte;
	}	
}
