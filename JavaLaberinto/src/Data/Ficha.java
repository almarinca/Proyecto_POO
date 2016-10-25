/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author alejomarin
 */
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
        
        public String toString(){
            String imprimir = "";
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    imprimir = imprimir + ficha[i][j];
                }
                imprimir = imprimir + "\n";
            }
            return imprimir;
        }
	
	//TIPO DE FICHAS...
        char a = 1;
	
	public char[][] fichaT(){
		char[][] ficha = {{a,a,a},
                          {' ',' ',' '},
                          {a,' ',a}};
		return ficha;
	}
	public char[][] fichaEsquina(){
		char[][] ficha = {{a,a,a},
                          {a,' ',' '},
                          {a,' ',a}};
		return ficha;
	}
	public char[][] fichaRecta(){
		char[][] ficha = {{a,a,a},
                          {' ',' ',' '},
                          {a,a,a}};
		return ficha;
	}	
}
