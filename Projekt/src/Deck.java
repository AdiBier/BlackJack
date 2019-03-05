
public class Deck {
	private int tab[];
	
	
	public Deck(){
		this.tab = new int [13];
		tab[0] = 11;
		for(int i=1;i<5;i++){
			tab[i]=10;
		}
		int d=9;
		for(int i=5;i<13;i++){
			tab[i]=d;
			d--;
		}
	}
	
	public int suma(int T[][]){
		int suma = 0 ;
		for(int i=0;i<13;i++){
			for(int j=0;j<4;j++){
				if(T[i][j]==1){
					suma=suma+tab[i];
				}
			}
		}
		return suma;
	}
	
//	public static void main(String[] args){
//		 Losowanie aLosowanie = new Losowanie();
//
//		 aLosowanie.losujGracz(2);
//		 aLosowanie.wypisz();
//		 
//		 Deck aDeck = new Deck();
//		 
//		 System.out.println("-------");
//		 
//		 System.out.println(aDeck.suma(aLosowanie.getGracz()));
//		 }
}
