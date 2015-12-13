/**
 * @author Hardi Alexandre + NUEZ SORIANO, Diego
 */
public class Guerrier {
	
	private String nom  ;
	private int nbrePV  ;
	private int pvMax	;
	private boolean[] privilege ;
	private boolean poison ;
	private boolean dernierCoup ;
	private static final String[] LISTE_PRIVILEGE= 
								  {"Une chance sur 8 de faire un coup critique",
								   "Les coups portes feront plus de degats.", 
								   "Possede un bouclier qui encaisse 25% des degats",
								   "Resiste a  la derniere attaque",
								   "Soin : +5PV par tour.",
								   "Empoisonne son adversaire (-5PV par tour)"} ;
	
	public Guerrier(String nom , int nbrePV){
		if (nom == null)
			throw new IllegalArgumentException("le nom ne peut pas etre null.");
		if (nom.equals(""))
			throw new IllegalArgumentException("Le nom ne peut pas etre vide.");
		if (nbrePV <= 0)
			throw new IllegalArgumentException("Le nombre de PV doit etre supperieur a  0");
		this.nom = nom ;
		this.nbrePV = nbrePV ;
		this.pvMax  = nbrePV ; 
		this.dernierCoup = false;
		this.privilege = new boolean[LISTE_PRIVILEGE.length];
	}

	public int getNbrePV() {
		return nbrePV;
	}
	
	public int getNbrePvMax(){
		return this.pvMax;
	}

	public void setNbrePV(int nbrePV) {
		if (nbrePV <= 0)
			throw new IllegalArgumentException("Un nombre de PV negatif n'est pas possible.");
		this.nbrePV = nbrePV;
	}
	
	public void subirDegats(int degats){
		if (degats < 0)
			throw new IllegalArgumentException("Les degats subis doivent etre superieur a zero");
		this.nbrePV = this.nbrePV-degats;
		if (this.nbrePV<0) this.nbrePV=0;
		
	}
	
	public void ajouterPV (int nbrePV){
		if (nbrePV < 0)
			throw new IllegalArgumentException("On ne peut ajouter un nombre de PV négatif.");
		if (this.nbrePV + nbrePV <= this.pvMax)
			this.nbrePV = this.nbrePV + nbrePV;
		else
			this.nbrePV = this.pvMax ;
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
	
	public void setDernierCoup(boolean bool){
		this.dernierCoup = bool;
	}

	public String getNom() {
		return nom;
	}
	
	/**
	 * Donne la force de frappe d'un combattant sur une echelle de 4(max) a  1(min).
	 * @return int correspondant a  la force de frappe. (determine le de a  jeter).
	 */
	public int donnerForceDeFrappe(){
		double forceFrappe = ((double)this.nbrePV/(double)this.pvMax)*100 ;
		return (int)(forceFrappe-1)/25 + 1 ;
	}
	
	public boolean donnerPrivilege(int indice){
		if (indice >= privilege.length || indice < 0)
			throw new IllegalArgumentException("Ce privilege n'existe pas");
		if (!this.privilege[indice]){
			this.privilege[indice] = true ;
			return true ;
		}
		return false ;
	}
	
	public boolean retirePrivilege(int indice){
		if (indice >= privilege.length || indice < 0)
			throw new IllegalArgumentException("Ce privilege n'existe pas");
		if (this.privilege[indice]){
			this.privilege[indice] = false ;
			return true ;
		}
		return false ;
	}
	
	public void volerPrivilege(Guerrier adversaire){
		if (adversaire == null) throw new IllegalArgumentException("");
		for (int i = 0; i < this.privilege.length; i++){
			if (adversaire.privilege[i])
				this.privilege[i] = true ;
		}
	}
	
	/**
	 * Renseigne si un guerrier possede le privilege passe en parametre.
	 * @return bool true si le possede, si non fasle.
	 */
	public boolean possede(int privRecherche){
		if (privRecherche >= privilege.length || privRecherche < 0)
			throw new IllegalArgumentException("Ce privilege n'existe pas");
		return privilege[privRecherche] ;
	}
	
	/**
	 * Renseigne si le guerrier possede les privileges passes en parametre.
	 * @return  bool true si le possede, si non fasle.
	 */
	public boolean possedeTous(int[] privilegeRecherche){
		if (privilegeRecherche == null)
			throw new IllegalArgumentException("Le parametre ne peut pas etre null");
		for (int i = 0 ; i < privilegeRecherche.length ; i++){
			if ((privilegeRecherche[i] >= privilege.length || privilegeRecherche[i] < 0))
				throw new IllegalArgumentException("Ce privilege n'existe pas");
			if (!privilege[privilegeRecherche[i]])
				return false ;
		}
		return true ;
	}
	
	/**
	 * Renseigne si le guerrier ne possede aucun des privileges passes en parametre.
	 * @return  bool true si ne les possede pas, si non fasle.
	 */
	public boolean possedeAucun(int[] privilegeRecherche){
		if (privilegeRecherche == null)
			throw new IllegalArgumentException("Le parametre ne peut pas etre null");
		for (int i = 0 ; i < privilegeRecherche.length ; i++){
			if (privilegeRecherche[i] >= privilege.length || privilegeRecherche[i] < 0)
				throw new IllegalArgumentException("Ce privilege n'existe pas");
			if (privilege[privilegeRecherche[i]])
				return false ;
		}
		return true ;
	}
	
	/**
	 * @return true si le guerrier possede 0 privileges, false sinon.
	 */
	public boolean possedeZeroPriv(){
		for (int i = 0 ; i < privilege.length ; i++){
			if (privilege[i])
				return false ;
		}
		return true ;
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
				"\tPrivileges : " ;
		
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
