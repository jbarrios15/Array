/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import javax.swing.JOptionPane;

/**
 *
 * @author estudiante
 */
public class Controller {

    public Controller() {
        this.cargarMenu();
    }
    
    
    public void cargarMenu(){        
        seleccionarOpcion(Integer.parseInt(JOptionPane.showInputDialog("Bienvenido a SofBarr\n"
                + "\n"
                + "Elija la opcion del 1 al 4 \n"
                + "---------------\n"
                + "1. Crear y llenar array\n"
                + "2. Mostrar array\n"
                + "3. Salir\n"
                + "")));
    }
    public void seleccionarOpcion(int op){
        
        try{
        switch(op) {    
        case 1:
            
        break;
        case 2:
        
        break;
        case 3:
         System.exit(0);
        break;
        default: JOptionPane.showMessageDialog(null, "Error al seleccionar, intente nuevamente");
        this.cargarMenu();
        
     }  
        }catch(Exception ie){
            System.out.println("hola");
            this.cargarMenu();
        }
    }
    public void llenarArray(){
        
    }
 
    public void mostrarArray(){
        
    }
      
    
    
}
