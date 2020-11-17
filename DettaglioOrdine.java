package Entity;

import java.util.*;

public class DettaglioOrdine{
	
	//DConstructor
	public DettaglioOrdine(){
		
	}
	
	public DettaglioOrdine(int idOrdine,int nT, int nC, int nM){
		IDOrdine=idOrdine;
		numTrenini=nT;
		numCavalli=nC;
		numMusicali=nM;
	}
	
	private int numTrenini;
	
	private int numCavalli;
	
	private int numMusicali;
	
	private int IDOrdine;
	
	//Implemento solo quello che mi serve
	
	public int getNumTrenini() {
		return numTrenini;
	}
	
	public int getNumCavalli() {
		return numCavalli;
	}
	
	public int getNumMusicali() {
		return numMusicali;
	}
}