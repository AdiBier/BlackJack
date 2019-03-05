import java.nio.charset.MalformedInputException;
import java.util.Random;

public class Losowanie {
	private int Los[][];
	private int Gracz[][];
	private int Krukier[][];

	public Losowanie() {
		this.Los = new int[13][4];
		this.Gracz = new int[13][4];
		this.Krukier = new int[13][4];
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				this.Los[i][j] = 0;
				this.Gracz[i][j] = 0;
				this.Krukier[i][j] = 0;
			}
		}
	}

	public void przypisz(int a, int b) {
		Los[a][b] = 1;
	}

	public void losujGracz(int n) {
		Random random = new Random();
		int a, b;
		for (int i = 0; i < n; i++) {
			a = random.nextInt(13);
			b = random.nextInt(4);
			if (Los[a][b] == 1 ) {
				while (Los[a][b] != 0) {
					a = random.nextInt();
					b = random.nextInt();
				}
			}
			Gracz[a][b] = 1; 
			przypisz(a, b);
		}
	}

	public void losujKrukier(int n) {
		Random random = new Random();
		int a, b;
		for (int i = 0; i < n; i++) {
			a = random.nextInt(13);
			b = random.nextInt(4);
			if (Los[a][b] == 1) {
				while (Los[a][b] != 0) {
					a = random.nextInt();
					b = random.nextInt();
				}
			}
			Krukier[a][b] = 1;
			przypisz(a, b);
		}
	}

	public int[][] getLos() {
		return Los;
	}

	public void setLos(int[][] los) {
		Los = los;
	}

public int[][] getGracz() {
		return Gracz;
	}

	public void setGracz(int[][] gracz) {
		Gracz = gracz;
	}

	public int[][] getKrukier() {
		return Krukier;
	}

	public void setKrukier(int[][] krukier) {
		Krukier = krukier;
	}

public void wypisz(){
for(int i=0;i<13;i++){
for(int j=0;j<4;j++){
System.out.print(Los[i][j]+" ");
}
System.out.println();
 }
}

public static void main(String[] args){
 Losowanie aLosowanie = new Losowanie();

 aLosowanie.losujGracz(2);
 aLosowanie.wypisz();
 System.out.println("-----------");
aLosowanie.losujKrukier(2);
aLosowanie.wypisz();

aLosowanie.losujGracz(1);
System.out.println("-----------");
aLosowanie.wypisz();
 }
}
