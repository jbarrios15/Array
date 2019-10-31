/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
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
    private double alkk=0;
    
    
    
    public void cargarMenu(){

        try {
             seleccionarOpcion(Integer.parseInt(JOptionPane.showInputDialog("Bienven"
                + "ido a SofBarr\n"
                + "\n"
                + "Elija la opcion del 1 al 6 \n"
                + "---------------\n"
                + "1. Crear y llenar array\n"
                + "2. Mostrar array\n"
                + "3. Eliminar todas las personas registradas\n"
                + "4. Verificar cuantas personas estan registradas\n"
                + "5. Calcular masa corporal\n"
                + "6. Salir\n")));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar una opcion \n"
                    + "\n"
                    + " Verifique al digitar");
            this.cargarMenu();
        }
       

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
           menuIMC();
        break;
        case 6:
            this.confirmarCerrarTodo();
            this.cargarMenu();
         break;
        default: JOptionPane.showMessageDialog(null, "Error al seleccionar la opcion \n"
                + "\n"
                + "Recuerde elegir del 1 al 7");
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
            int p=0;
            String r;
            
            do{
            r=(JOptionPane.showInputDialog("Escribe fecha de nacimiento de la persona "+per)); 
            }while(validarfecha(r));
            
             JOptionPane.showMessageDialog(null, GetEdad(r));
            String tel=JOptionPane.showInputDialog("Escribe el telelefono de la persona "+per);
            arrayObjetos[i]=new Persona(nombre,apellido,r,tel);
            
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
       this.cargarMenu();  
    }
    
    public boolean verificar_si_hay_datos(int n){
        if(n==0){
            JOptionPane.showMessageDialog(null, "No hay personas registradas en el vector");
            return false;
            
        }else{
            JOptionPane.showMessageDialog(null, "hay "+n+" personas registradas en el vector");
            return true;
        }
       
        
   }
    
    public int GetEdad(String fe){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        LocalDate fechaNac = LocalDate.parse(fe, fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora); 
        return periodo.getYears();
    }
    
    public boolean validarfecha(String fe){ 
        try{
            
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        LocalDate fechaNac = LocalDate.parse(fe, fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora); 
        periodo.getYears();
        return false;
        
        }catch(Exception ie){
            JOptionPane.showMessageDialog(null, "Recuerde usar correctamente el formato:\n"
                    + "dd/MM/yyyy\n"
                    + "Tenga en cuenta usar Slash= ``/´´ para separar");
            return true;
            
        }
        
    }
    
    public void  masacorporal(){
        double altu=alturaPersona();
        double peso=pesoPersona();
        double Imc=peso/altu;
        JOptionPane.showMessageDialog(null, Imc);
        this.menuIMC();
    }
    
    public void menuIMC(){
    JOptionPane.showMessageDialog(null, "Para calcular la masa corporal debe ingresar: \n"
                + "Peso en Kg= kilogramos \n"
                + "Altura en metros");
    
     try {
             opcionIMC(Integer.parseInt(JOptionPane.showInputDialog("Sel"
                     + "Seleccione que desea ingresar\n"
                     + "\n"
                     + "1. Calcular la masa corporal\n"
                     + "2. PesoEvaluar su masa corporal\n"
                     + "3. Retroceder\n"
                     + "5. Cerrar todo"
                     + "\n")));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar una opcion \n"
                    + "\n"
                    + " Verifique al ingresar");
            this.cargarMenu();
        }
    
    }
    
    public void opcionIMC(int op){
        switch(op){
            case 1:
                masacorporal();
            break;
            case 2:
               ingresarNumeroDouble();
            break;
            case 3:
                this.cargarMenu();
            break;
            case 4: 
                this.confirmarCerrarTodo();
                this.menuIMC();
            break;  
            default:
                JOptionPane.showMessageDialog(null, "Error al seleccionar la opcion \n"
                + "\n"
                + "Recuerde elegir del 1 al 4");
        }
    }
    
    public void confirmarCerrarTodo(){
        int up=JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea salir?", "Confi"
                        + "rmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(up==0){
                    System.exit(0);
                }
    }
    public double alturaPersona(){
        double altu_2=0,alm=0;
        try {
        double alt=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la altura de la persona\n"
                + "\n"
                + "*Recuerde que tiene que ser en centimetros*"));
        alm=alt/100;
         altu_2=alm*alm;
         
         return altu_2;
         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar la altura \n"
                    + "\n"
                    + "Verifique e intente de nuevo");
                     this.alturaPersona();
        }
        return 55;
        }
    
    public double pesoPersona(){
       double peso=0;
        try {
        peso=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso de la persona\n"
                + "\n"
                + "*Recuerde que tiene que ser en Kilogramos*"));
            return peso;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar el peso \n"
                    + "\n"
                    + "Verifique e intente de nuevo");
                     this.pesoPersona();
        }
        return 56;
    }

   public void evaluarIMC (double imc){
       
      if(imc<18.5){
          JOptionPane.showMessageDialog(null, "Peso inferior al normal");
      }else{
          if(imc>18.5 && imc<24.9){
              JOptionPane.showMessageDialog(null, "Normal");
          }else{
              if(imc>25.0 && imc<29.9){
                 JOptionPane.showMessageDialog(null, "Peso superior al normal"); 
              }else {
                  if(imc>30.0){
                      JOptionPane.showMessageDialog(null, "obesidadl");
                  }
              }
          }
      }
      this.menuIMC();
   }
    
    public void ingresarNumeroDouble(){
        try {
          evaluarIMC(Double.parseDouble(JOptionPane.showInputDialog("Ingrese la masa corporal")));  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar la masa corporal \n"
                    + "\n"
                    + "Verifique al digitar");
            this.ingresarNumeroDouble();
        }
        
    }
    
    
    
    
    
 }

