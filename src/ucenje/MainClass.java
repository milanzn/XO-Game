package ucenje;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		
		Scanner s = new Scanner(System.in);
		
		int [][] matricaXO = new int[3][3];
		int indexReda;
		int indexKolone;
		int brojPoteza;
		int proizvodGlavneD;		//moglo je bez ovoga, malo sam se izigrao
		int proizvodSporedneD;		//moglo je bez ovoga, malo sam se izigrao
		int brojPobeda1 = 0;		
		int brojPobeda2 = 0;		
		int brojPartija = 1;		
		int opcija = 0;
		char znak;					
		boolean proveraPobednika; 	
		String imePrvogIgraca;		
		String imeDrugogIgraca;		
		String format = "Ime igraca: %-15s pobeda: %3d\n";	
		
		
		
		System.out.println("Igrica  XO, 3x3, Verzija 11-2020");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("UPUTSTVO:");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Znak prvog igraca je X, znak drugog igraca je O.");
		System.out.println("Za poziciju reda Vaseg znaka unositi vrednosti od 1 do 3. Nakon toga:");
		System.out.println("Za poziciju kolone Vaseg znaka unositi vrednosti od 1 do 3.");
		System.out.println("---------------------------------------------------------------------");
		
		System.out.println("Unesite ime prvog igraca:");
		
		imePrvogIgraca = s.next();
		
			
		System.out.println("Unesite ime drugog igraca:");
		
		imeDrugogIgraca = s.next();
		
		
		if (imePrvogIgraca.equalsIgnoreCase(imeDrugogIgraca)) {
			
			imeDrugogIgraca = imeDrugogIgraca + "-1";
			System.out.println("Ime drugog igraca je promenjeno u: " + imeDrugogIgraca);
		}
		
	
		
		do {	
			
			brojPoteza = 1;
			proveraPobednika = false;
			znak ='0';
			
			if (brojPartija > 1) {
				
				int broj = brojPobeda1;
				brojPobeda1 = brojPobeda2;
				brojPobeda2 = broj;
				
				String ime = imePrvogIgraca;
				imePrvogIgraca = imeDrugogIgraca;
				imeDrugogIgraca = ime;
				
			}
			
		for (int i = 0; i < matricaXO.length; i++) {
			
			for (int j = 0; j < matricaXO[i].length; j++) {
				
				matricaXO[i][j] = 0;
				
			}
			
		}
		
		
	
		do {
			
			proizvodGlavneD = 1;
			proizvodSporedneD = 1;
			
		do {	
		
		if (brojPoteza % 2 != 0) {
			
			System.out.println("Na potezu je prvi igrac: " + imePrvogIgraca + ".");
			
		} else 
			
			{
			System.out.println("Na potezu je drugi igrac: " + imeDrugogIgraca + ".");
			}
		
		
		
		System.out.println("Unesite poziciju reda za Vas znak:");
		
		indexReda = s.nextInt() -1; 
		
		System.out.println("Unesite poziciju kolone za Vas znak:");
			
		indexKolone = s.nextInt() -1; 
		
		
			
			if (matricaXO[indexReda][indexKolone] == 1 || matricaXO[indexReda][indexKolone] == 2) {
				
				if (matricaXO[indexReda][indexKolone] == 1) {
					
					znak = 'X';
					
				}
				
				else if (matricaXO[indexReda][indexKolone] == 2) {
					
					znak = 'O';
					
				}
				
				System.out.println("Na navedenoj poziciji je vec upisan znak: " + znak + "!" );
				
				// Stampanje Matrice nakon sto se utvrdi da je to polje vec zauzeto.
				// Matrica je prakticno prethodno odstampana ......., 
				// Ali ako se vise puta unesu pogresni indexi, onda matrica "pobegne" gore, pa da se ne bi skrolavalo...
				
				for (int i = 0; i < matricaXO.length; i++) {   
					
					System.out.println("-------------");
					System.out.print("|");
					
					for (int j = 0; j < matricaXO[i].length; j++) {
						
						if (matricaXO[i][j] == 1) {
							
							System.out.print(" X |");
						}
						
						else if (matricaXO[i][j] == 2) {
							
							System.out.print(" O |");
						}
						
						else System.out.print(" - |");
						
						
					}
					
					System.out.println();
					
				}
				
				System.out.println("-------------");
			
			System.out.println("Potrebno je da ponovo unesete poziciju Vaseg znaka.");
			System.out.println("---------------------------------------------------------------------");
			
			}			
		
		
		}
		 while (matricaXO[indexReda][indexKolone] != 0) ;
		
		
		// Upis vrednosti u odgovarajucu poziciju, prethodno je ispunjen uslov da je ta pozicija prazna, tj ==0.

		
				if (brojPoteza %2 !=0) {
				
				matricaXO[indexReda][indexKolone] = 1;
				
				}
				
				else matricaXO[indexReda][indexKolone] = 2;
			
				
				
		// Stampanje matrice, tj XO table, nakon odigranog poteza.
				
				
				for (int i = 0; i < matricaXO.length; i++) {	
					
					System.out.println("-------------");
					System.out.print("|");
					
					for (int j = 0; j < matricaXO[i].length; j++) {	
						
						if (matricaXO[i][j] == 1) {
							
							System.out.print(" X |");

						}
						
						else if (matricaXO[i][j] == 2) {
							
							System.out.print(" O |");
						}
						
						else System.out.print(" - |");
						
						
					}
					
					System.out.println();
					
				}
				
				System.out.println("-------------");
				
				
				// Provera da li postoji 3 ista "vezana" znaka.
				
				
				if (brojPoteza > 4) { // Najmanji broj poteza da postojao pobednik je 5.
				
				for(int i = 0; i < matricaXO.length; i ++) {	
										
					//if (matricaXO[i][0] * matricaXO[i][1]  *matricaXO[i][2] == Math.pow(matricaXO[indexReda][indexKolone], 3) |  matricaXO[0][i] * matricaXO[1][i] * matricaXO[2][i] == Math.pow(matricaXO[indexReda][indexKolone], 3)) { //daje isti rezultat.
					
					if (matricaXO[i][0] * matricaXO[i][1]  *matricaXO[i][2] == 1 | matricaXO[i][0] * matricaXO[i][1] * matricaXO[i][2] == 8 | matricaXO[0][i] * matricaXO[1][i] * matricaXO[2][i] == 1 | matricaXO[0][i] * matricaXO[1][i] * matricaXO[2][i] == 8) {
							 
						 proveraPobednika = true;
				
					
					 }
										 
					 proizvodGlavneD = proizvodGlavneD * matricaXO[i][i];
					 proizvodSporedneD = proizvodSporedneD * matricaXO[matricaXO.length - 1 - i][i];
					 
				}
				
				if (proizvodGlavneD == 1 | proizvodGlavneD == 8 | proizvodSporedneD == 1 | proizvodSporedneD == 8) {
					
					proveraPobednika = true;
					 
				}
				
				
				if (brojPoteza % 2 != 0 & proveraPobednika) {
					
					brojPobeda1 ++;
					System.out.println("Pobednik je " + imePrvogIgraca + ", cestitamo!!!");
					System.out.println("---------------------------------------------------------------------");
					System.out.printf(format, imePrvogIgraca , brojPobeda1);
					System.out.printf(format , imeDrugogIgraca , brojPobeda2);
					
				}
				
				else if (brojPoteza % 2 == 0 & proveraPobednika) {
					
					brojPobeda2 ++;
					System.out.println("Pobednik je " + imeDrugogIgraca + ", cestitamo!!!");
					System.out.println("---------------------------------------------------------------------");
					System.out.printf(format, imePrvogIgraca , brojPobeda1);
					System.out.printf(format , imeDrugogIgraca , brojPobeda2);
				}
				
				else if (brojPoteza == 9 & !proveraPobednika)
				{
					
					System.out.println("Kraj igre, nema pobednika, REMI!!!");
					
					if (brojPobeda1 > 0 | brojPobeda2 > 0) {
						
						System.out.println("---------------------------------------------------------------------");
						System.out.printf(format, imePrvogIgraca , brojPobeda1);
						System.out.printf(format , imeDrugogIgraca , brojPobeda2);
						
					}
				}
				}
				
				brojPoteza++;
				
				
			
		} while (brojPoteza < 10 & !proveraPobednika);
		
		brojPartija ++;
		
		
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Za ponovo unesite 1, za kraj 0.");
		System.out.println("---------------------------------------------------------------------");
		
		opcija = s.nextInt();
		
		} while (opcija == 1);
		
		s.close();
		
	
		}
		
		
	}
	
	

