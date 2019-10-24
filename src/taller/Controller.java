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

    
    public int n =0;
   
    public Controller() {
        this.cargarMenu();
        
    }
    
    Persona arrayObjetos[]=new Persona[2];
    
    
    
    
    public void cargarMenu(){

        
        seleccionarOpcion(Integer.parseInt(JOptionPane.showInputDialog("Bienvenido a SofBarr\n"
                + "\n"
                + "Elija la opcion del 1 al 5 \n"
                + "---------------\n"
                + "1. Crear y llenar array\n"
                + "2. Mostrar array\n"
                + "3. Eliminar todas las personas registradas\n"
                + "4. Verificar cuantas personas estan registradas\n"
                + "5. Salir\n"
                + "")));

    }
    public void seleccionarOpcion(int op){
        
        try{
        switch(op) {    
        case 1:
        this.llenarArray();
        break;
        case 2:
             this.mostrarArray();
        break;
        case 3:
            this.eliminarDatosPersonas();
        break;
        case 4:
        this.verificar_si_hay_datos(n);
        this.cargarMenu();
        break;
        case 5:
//            AgregarNuevaPersona();
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
        
            try{
                for (int i=0;i<arrayObjetos.length;i++){
             int per=i+1;       
            String nombre=JOptionPane.showInputDialog("Escribe los nombres de persona "+per);
            String apellido=JOptionPane.showInputDialog("Escribe los apellidos de la persona "+per);
             int edad=Integer.parseInt(JOptionPane.showInputDialog("Escribe la edad de la persona "+per));
             String tel=JOptionPane.showInputDialog("Escribe el telelefono de la persona "+per);
            
            arrayObjetos[i]=new Persona(nombre,apellido,edad,tel);
            
            JOptionPane.showMessageDialog(null,arrayObjetos[i]);
            n+=1;
               
            }
                }catch(Exception ie){
                JOptionPane.showMessageDialog(null, "Error al registrar la persona, intente nuevamente");
                this.llenarArray();
            }
            
            this.cargarMenu();
            
}    
        
   
 
    public void mostrarArray(){
        if(verificar_si_hay_datos(n)){
           for (int i=0;i<arrayObjetos.length;i++){
            JOptionPane.showMessageDialog(null, arrayObjetos[i]); 
            
        } 
        }
       
        this.cargarMenu();
    }
     
    
    public void eliminarDatosPersonas(){
        
        for (int i=0;i<arrayObjetos.length;i++){
            arrayObjetos[i]=null;
 
        }
             n=0;
             
    }
    
    public boolean verificar_si_hay_datos(int n){
        if(n==0){
            JOptionPane.showMessageDialog(null, "No hay personas registradas en el vector");
            return false;
            
        }else{
            System.out.println("hay "+n+" personas registradas en el vector");
            return true;
        }
       
        
   }
    
//    public void AgregarNuevaPersona(){
//        Persona tem[] = new Persona[arrayObjetos.length + 1];
//
//        for (int i = 0; i < arrayObjetos.length; i++){
//            tem[i] = arrayObjetos[i];
//            }
//        arrayObjetos = tem;
//        
//        System.out.println(arrayObjetos.length);
//        
//        r=arrayObjetos.length;
//        System.out.println("hola6");
//        this.llenarArray();
//        
//    }
//    
    
    
    
 }

