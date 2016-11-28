package BussinessLogic;

import GUI.GUILaberinto;

public class Laberinto {
    
    
    public static void main(String[] args) {
        
        if (args.length== 0){
            GUILaberinto.iniciarGUI();
        } else if (args[0].equals("text")){
            JavaLaberinto.iniciarUI();
        } else {
            GUILaberinto.iniciarGUI();
        }
        
    }
    
}
