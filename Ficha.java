
public class Ficha {
	private int posX;
	private int posY;
	private boolean fijaOMovil;
	private static char[][] ficha;
	
	
	public int getPosX() {
		return posX;
	}
	public char[][] getFicha() {
		return ficha;
	}
	public int getPosY() {
		return posY;
	}
	public boolean isFijaOMovil() {
		return fijaOMovil;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public void setFijaOMovil(boolean fijaOMovil) {
		this.fijaOMovil = fijaOMovil;
	}
    
	public static void setFicha(char[][] ficha) {
		Ficha.ficha = ficha;
	}
	
	//TIPO DE FICHAS...
	
	public char[][] fichaT(){
		char[][] ficha = {{'*','*','*'},
                          {' ',' ',' '},
                          {'*',' ','*'}};
		return ficha;
	}
	public char[][] fichaEsquina(){
		char[][] ficha = {{'*','*','*'},
                          {'*',' ',' '},
                          {'*',' ','*'}};
		return ficha;
	}
	public char[][] fichaRecta(){
		char[][] ficha = {{'*','*','*'},
                          {' ',' ',' '},
                          {'*','*','*'}};
		return ficha;
	}
	
}
