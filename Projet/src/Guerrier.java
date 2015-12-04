/**
 * @author Hardi Alexandre + NUEZ SORIANO, Diego
 */
public class Guerrier {
	
	private String nom  ;
	private int nbrePV  ;
	private boolean[] privilege ;
	private boolean poison ;
	private boolean dernierCoup ;
	private static final String[] LISTE_PRIVILEGE= {"Attaque toujours en premier",
													"Les coups portés feront plus de dégâts.", 
													"Possède un bouclier qui encaisse 75% des dégâts",
													"Résiste à la dernière attaque",
													"Soin +1PV par tour.",
													"Empoisonne sont adversaire (-1PV par tour)"} ;
	
	public Guerrier(String nom , int nbrePV, int attaque){
		this.nom = nom ;
		this.nbrePV = nbrePV ;
		this.privilege = new boolean[5];
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
	
	public int donnerForceDeFrappe(){
		return nbrePV/25 ;
	}
	
	public boolean possede(int privRecherche){
		return privilege[privRecherche] ;
	}
	
	public boolean possedeTous(int[] privilegeRecherche){
		for (int i = 0 ; i < privilegeRecherche.length ; i++){
			if (!privilege[privilegeRecherche[i]])
				return false ;
		}
		return true ;
	}
	
	public boolean possedeAucun(int[] privilegeRecherche){
		for (int i = 0 ; i < privilegeRecherche.length ; i++){
			if (privilege[privilegeRecherche[i]])
				return false ;
		}
		return true ;
	}
	
	public boolean donnerPrivilege(int indice){
		if (!this.privilege[indice]){
			this.privilege[indice] = true ;
			return true ;
		}
		return false ;
	}
	
	public boolean retirePrivilege(int indice){
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
				"\tVie\t : "	  + this.nbrePV  + "\n" +
				"\tPrivilèges : " ;
		
		for (int i=0; i<this.privilege.length; i++){
			if (this.privilege[i]){
				texte = texte + "\n\t\t"+ LISTE_PRIVILEGE[i];
			}
		}
		return texte;
	}	
}
