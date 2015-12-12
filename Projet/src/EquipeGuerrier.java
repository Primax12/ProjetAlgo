/**
 * @author Hardi Alexandre + NUEZ SORIANO, Diego
 */
public class EquipeGuerrier {
	private String nom;
	private Guerrier[] equipe;
	private int nbreGuerrier;
	private int nbreMaxGuerrier ;
	
	
	public EquipeGuerrier(String nom, int nbreMaxGuerrier){
		if (nom.equals(""))
			throw new IllegalArgumentException("Le nom ne peut pas vide.");
		this.nom = nom;
		this.nbreGuerrier = 0;
		this.nbreMaxGuerrier = nbreMaxGuerrier ;
		this.equipe = new Guerrier[this.nbreMaxGuerrier];
	}
	
	public EquipeGuerrier(String nom){
		this(nom, 3) ;
	}
	
	public String getNom(){
		return this.nom ;
	}
	
	public Guerrier getGuerrier(int i){
		return this.equipe[i];
	}
	
	public int getNbreGuerrier(){
		return nbreGuerrier;
	}
	
	/**
	 * Renseigne sur l'indice du guerrier dans la liste de l'equipe.
	 * @return  int l'indice dans la liste, -1 s'il n'y est pas.
	 */
	public int donnerIndice(Guerrier guerrier){
		if (guerrier == null) 
			throw new IllegalArgumentException("Un guerrier ne peut pas etre null");
		for (int i=0; i<this.nbreGuerrier; i++){
			if (this.equipe[i].equals(guerrier)) 
				return i;
		}
		return -1 ;
	}
	
	public int nombreGuerriersEnJeu(){
		return this.nbreGuerrier;
	}
		
	public boolean estPresent(Guerrier guerrier){
		if (guerrier == null) throw new IllegalArgumentException("Un guerrier ne peut pas etre null");
		for (int i=0; i<this.nbreGuerrier; i++){
			if (this.equipe[i].equals(guerrier)) 
				return true;
		}
		return false;
	}
	
	public boolean ajouterGuerrier(Guerrier guerrier){
		if (this.estPresent(guerrier) || this.nbreGuerrier == this.equipe.length)
			return false;
		if (guerrier == null) throw new IllegalArgumentException("Un guerrier ne peut pas etre null");
		if (this.estPresent(guerrier) || this.nbreGuerrier == this.equipe.length) return false;

		int i  = this.nbreGuerrier;
		this.nbreGuerrier++ ;
		while (i > 0){
			if (this.equipe[i-1].getNom().compareTo(guerrier.getNom()) < 0){
				this.equipe[i] = guerrier ;
				return true ;
			}
			else
				this.equipe[i] = this.equipe[i-1] ;
			i-- ;
		}
		this.equipe[0] = guerrier ; 
		return true ;
	}
	
	public boolean mourir(Guerrier guerrier){
		if (guerrier == null) throw new IllegalArgumentException("Un guerrier ne peut pas etre null");
		int indice = donnerIndice(guerrier) ;
		if (indice == -1)
			return false ;
		for (int i = indice ; i < nbreGuerrier-1 ; i++){
			equipe[i] = equipe[i+1] ;
		}
		nbreGuerrier-- ;
		return true;
	}
	
	public Guerrier[] tableGuerrierAvecPrivileges(int[] privileges){
		Guerrier[] temp = new Guerrier[equipe.length];
		int taille = 0 ;
		for (int i = 0 ; i < this.nbreGuerrier ; i++){
			if (equipe[i].possedeTous(privileges)){
				temp[taille] = equipe[i];
				taille++;
			}
		}
		Guerrier[] GuerrierAvecPriv = new Guerrier[taille];
		for (int j = 0 ; j < taille ; j++){
			GuerrierAvecPriv[j] = temp[j];			
		}
		return GuerrierAvecPriv;
	}
	
	public Guerrier[] tableGuerrierSansPrivileges(int[] privileges){
		Guerrier[] temp = new Guerrier[equipe.length];
		int taille = 0 ;
		for (int i = 0 ; i < this.nbreGuerrier ; i++){
			boolean possede = false ;
			for (int j = 0 ; i < privileges.length; i++){
				if (!equipe[i].possede(privileges[j])){
					possede = true;
					break ;
				}
				
			}
			if (!possede){
				temp[taille] = equipe[i];
				taille++;
			}
		}
		Guerrier[] GuerrierSansPriv = new Guerrier[taille];
		for (int j = 0 ; j < taille ; j++){
			GuerrierSansPriv[j] = temp[j];			
		}
		return GuerrierSansPriv;
	}
	
	public Guerrier[] tableGuerrierSelonForce (int force){
		if (force>4 || force<0) throw new IllegalArgumentException();
		Guerrier[] listeTemp = new Guerrier[this.nbreGuerrier] ;
		int tailleTable = 0 ;
		for (int i = 0; i < this.nbreGuerrier; i++){
			if (this.equipe[i].donnerForceDeFrappe() == force){
				listeTemp[tailleTable] = equipe[i] ;
				tailleTable++;
			}
		}
		Guerrier[] tableSelonForce = new Guerrier[tailleTable];
		for (int i = 0 ; i < tailleTable ; i++){
			tableSelonForce[i] = listeTemp[i] ;
		}
		triPV(tableSelonForce, 0, tailleTable-1);
		return tableSelonForce ;
	}
	
	private void triPV(Guerrier[] liste, int deb, int fin){
		if (fin > deb){
			int indicePivot = partition(liste, deb, fin);
			triPV(liste, deb, indicePivot-1);
			triPV(liste, indicePivot+1, fin);
		}
	}
	
	private int partition(Guerrier[] liste, int deb, int fin){
		Guerrier pivot = liste[deb];
		int indicePivot = deb ;
		int i = deb+1 ;
		while(i <= fin){
			if (liste[i].getNbrePV() >= pivot.getNbrePV())
				i++ ;
			else if (liste[i].getNbrePV() < pivot.getNbrePV()){
				liste[indicePivot] = liste[i];
				liste[i] = liste[indicePivot+1];
				i++;
				indicePivot++ ;
			}
		}
		liste[indicePivot] = pivot ;
		return indicePivot ;
	}
	
	public Guerrier selectionner(int indice){
		if (indice<0 || indice>nbreGuerrier - 1)
			throw new IllegalArgumentException("Ce combatant n'existe pas ou est mort") ;
		
		return equipe[indice];
	}

	public String toString() {
		String txt = ("Equipe " + this.nom + "\n");
		for (int i = 0 ; i < this.nbreGuerrier ; i++){
			txt += "\t" + equipe[i] + "\n\n";
		}
		return txt ;
	}
}

}
