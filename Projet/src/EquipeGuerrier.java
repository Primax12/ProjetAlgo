/**
 * @author Hardi Alexandre + NUEZ SORIANO, Diego
 */
public class EquipeGuerrier {
	private String nom;
	private Guerrier[] equipe;
	private int nbreGuerrier;
	private int nbreMaxGuerrier ;
	//Changements ici et la pouf pouf pouf
	
	public EquipeGuerrier(String nom, int nbreMaxGuerrier){
		if (nom.equals("")) throw new IllegalArgumentException("Le nom ne peut pas être une chaîne de caractère vide.");
		this.nom = nom;
		this.nbreGuerrier = 0;
		this.nbreMaxGuerrier = nbreMaxGuerrier ;
		this.equipe = new Guerrier[nbreMaxGuerrier];
	}
	
	public EquipeGuerrier(String nom){
		this(nom, 3) ;
	}
	
	public int donnerIndice(Guerrier guerrier){
		if (guerrier == null) throw new IllegalArgumentException("Un guerrier ne peut pas être null");
		for (int i=0; i<this.nbreGuerrier; i++){
			if (this.equipe[i].equals(guerrier)) 
				return i;
		}
		return -1 ;
	}
	
	public String getNom(){
		return this.nom ;
	}
	
	public int nombreGuerriersEnJeu(){
		return this.nbreGuerrier;
	}
	
	
	public boolean estPresent(Guerrier guerrier){
		for (int i=0; i<this.nbreGuerrier; i++){
			if (this.equipe[i].equals(guerrier)) 
				return true;
		}
		return false;
	}
	
	public boolean ajouterGuerrier(Guerrier guerrier){
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
		int indice = donnerIndice(guerrier) ;
		if (indice == -1)
			return false ;
		for (int i = indice ; i < nbreGuerrier-1 ; i++){
			equipe[i] = equipe[i+1] ;
		}
		nbreGuerrier-- ;
		return true;
	}
	
	public Guerrier[] tableGuerrierSelonForce (int force){
		if (force>4) throw new IllegalArgumentException();
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

	public String toString() {
		String txt = ("Equipe " + this.nom + "\n");
		for (int i = 0 ; i < this.nbreGuerrier ; i++){
			txt += "\t" + equipe[i] + "\n\n";
		}
		return txt ;
	}
	

}
