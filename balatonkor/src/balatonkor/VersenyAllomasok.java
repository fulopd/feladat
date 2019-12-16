package balatonkor;

public class VersenyAllomasok {

	private String varos;
	private int elsoSzakasz;
	private int masodikSzakasz;
	private int harmadikSzakasz;
	
	public VersenyAllomasok(String varos, int elsoSzakasz, int masodikSzakasz, int harmadikSzakasz) {
		super();
		this.varos = varos;
		this.elsoSzakasz = elsoSzakasz;
		this.masodikSzakasz = masodikSzakasz;
		this.harmadikSzakasz = harmadikSzakasz;
	}

	
	public VersenyAllomasok() {
		
	}
	
	public String getVaros() {
		return varos;
	}

	public void setVaros(String varos) {
		this.varos = varos;
	}

	public int getElsoSzakasz() {
		return elsoSzakasz;
	}

	public void setElsoSzakasz(int elsoSzakasz) {
		this.elsoSzakasz = elsoSzakasz;
	}

	public int getMasodikSzakasz() {
		return masodikSzakasz;
	}

	public void setMasodikSzakasz(int masodikSzakasz) {
		this.masodikSzakasz = masodikSzakasz;
	}

	public int getHarmadikSzakasz() {
		return harmadikSzakasz;
	}

	public void setHarmadikSzakasz(int harmadikSzakasz) {
		this.harmadikSzakasz = harmadikSzakasz;
	}
	
	
	
	
}
