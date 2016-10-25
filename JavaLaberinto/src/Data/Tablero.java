
public class Tablero {
	//ATRIBUTOS	
	private Ficha[][] tablero;	
	
	
	public Tablero(){
		Ficha ficha = new Ficha(); 
		ficha.setFicha(ficha.fichaRecta());		
		
		Ficha ficha1 = new Ficha(); 
		ficha1.setFicha(ficha1.fichaT());		
		
		Ficha ficha2 = new Ficha();
		ficha2.setFicha(ficha2.fichaEsquina());		
	}
	//METODOS
	public Ficha[][] getTablero() {
		return tablero;
	}

	public void setTablero(Ficha[][] tablero) {
		this.tablero = tablero;
	}	
	
}

