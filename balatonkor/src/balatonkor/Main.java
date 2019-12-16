package balatonkor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;


public class Main {

	static List<VersenyAllomasok> allomasokTarolo;
	static Scanner be = new Scanner(System.in);
	
	public static void main(String[] args) {		
		allomasokTarolo = new ArrayList<>();
		beolvas();
		System.out.println("2/1 részfeladat: Teljesítve, a fájl beolvasva.");
		System.out.println("2/2 részfeladat: A helyszínek száma: " + allomasokTarolo.size() +" db.");
		System.out.println("2/3 részfeladat: A versenysorozat teljes hossza: "+ teljesKm()+" km.");
		System.out.println("2/4 részfeladat:");
		System.out.println("Adjon meg egy (balatoni) városnevet: "); balatoniVaros(be.next());
		System.out.println("A leghosszabb versenytávot adó település:" + leghosszabb());
		System.out.println("2/6 részfeladat: Az első szakaszok átlagos hossz: "+atlagHossz()+" km.");
		try {
			fileIras();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("2/7 részfeladat: A fájl létrehozva.");
		
		
		
	}
	
	private static void beolvas() {
		
	try {
		List<String> sorok =  Files.readAllLines(Paths.get("kerekpar.csv"));
		
		if (sorok.size()>20) {
			System.out.println("A file -ba több mint 20 sor van.");
		}else {
			for (String sor : sorok.subList(1, sorok.size())) {
				String[] adat = sor.split(";");
				allomasokTarolo.add(new VersenyAllomasok(
						adat[0], 
						Integer.parseInt(adat[1]), 
						Integer.parseInt(adat[2]), 
						Integer.parseInt(adat[3])));
			}
		}
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	private static int teljesKm() {
		int sumKm = 0;
		
		for (VersenyAllomasok versenyAllomasok : allomasokTarolo) {
			
			sumKm += versenyAllomasok.getElsoSzakasz();
			sumKm += versenyAllomasok.getMasodikSzakasz();
			sumKm += versenyAllomasok.getHarmadikSzakasz();
			
		}
		
		
		return sumKm;
	}
	
	private static void balatoniVaros(String varosnev) {
		Boolean talalat = false;
		
		
		for (VersenyAllomasok versenyAllomasok : allomasokTarolo) {
			
			
			if(versenyAllomasok.getVaros().equals(varosnev)) {
				
				talalat = true;
				System.out.println("Az adott város versenyszakaszai: "+
						versenyAllomasok.getElsoSzakasz()+" km, "+
						versenyAllomasok.getMasodikSzakasz()+" km és "+
						versenyAllomasok.getHarmadikSzakasz()+" km.");
				
				break;
			}
		}
		
		
		if (!talalat) {
			System.out.println("Ez a város nem szerepel a verseny állomásai között!");
		}
		
	}
	
	private static String leghosszabb() {
		
		VersenyAllomasok legh = null;
		int max = Integer.MIN_VALUE;
		
		
		for (VersenyAllomasok versenyAllomasok : allomasokTarolo) {
			
			int hossz = versenyAllomasok.getElsoSzakasz() + versenyAllomasok.getMasodikSzakasz() + versenyAllomasok.getHarmadikSzakasz();
			
			if (hossz > max) {
				max = hossz;
				legh = versenyAllomasok;
			}
			
		}
		
		return legh.getVaros();
	}
	
	private static double atlagHossz() {
		
		double atlag = 0;
		
		for (VersenyAllomasok versenyAllomasok : allomasokTarolo) {
			
			atlag += versenyAllomasok.getElsoSzakasz();
		}
		
		return atlag / allomasokTarolo.size();
	}
	
		
	private static void fileIras() throws IOException {
		
		BufferedWriter kiir = new BufferedWriter(new FileWriter(new File("statisztika.txt")));
		
		for (VersenyAllomasok x : allomasokTarolo) {			
			kiir.write(x.getVaros()+"\n");			
		}		
		
		kiir.close();
	}
	
	
	
}
