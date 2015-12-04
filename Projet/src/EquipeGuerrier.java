import java.util.Arrays;

/**
 * @author Hardi Alexandre + NUEZ SORIANO, Diego
 */
public class EquipeGuerrier {
	private String nom;
	private Guerrier[] equipe;
	private int nbreGuerrier;
	
	EquipeGuerrier(String nom){
		this.nom = nom;
		this.nbreGuerrier = 0;
		this.equipe = new Guerrier[3];
		
	}
	
	public int nombreGuerriersEnJeu(){
		return this.nbreGuerrier;
	}
	
	public boolean estPresent(Guerrier guerrier){
		for (int i=0; i<this.nbreGuerrier; i++){
			if (this.equipe[i].equals(guerrier)) return true;
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

	@Override
	public String toString() {
		return "EquipeGuerrier [nom=" + nom + ", equipe=" + Arrays.toString(equipe) + "]";
	}
	

}
