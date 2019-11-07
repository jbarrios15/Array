/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author estudiante
 */
public class Controller {

    
    public int n =0;
   
    public Controller() {
       
    }
    
//    Persona arrayObjetos[]=new Persona[2];
    
    ArrayList <Persona> arrayObjetos=new ArrayList();
    ArrayList<Masa_corporal> historialmasa=new ArrayList();
    
    private double alkk=0;
    private String dia="";
    
    
    
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
        this.verificar_si_hay_datos();
        this.cargarMenu();
        break;
        case 5:
           menuIMC();
        break;
        case 6:
            this.confirmarCerrarTodo();
            this.cargarMenu();
         break;
        case 7:
          
           
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
        int i=0;
            try{
            int upp=0;
            do{
             int per=i+1; 
            String nombre=JOptionPane.showInputDialog("Escribe los nombres de persona "+per);
            String apellido=JOptionPane.showInputDialog("Escribe los apellidos de la persona "+per);
            String r;
            
            do{
            r=(JOptionPane.showInputDialog("Escribe fecha de nacimiento de la persona "+per)); 
            }while(validarfecha(r));
            
             JOptionPane.showMessageDialog(null, GetEdad(r));
            String tel=JOptionPane.showInputDialog("Escribe el telelefono de la persona "+per);
            
            
            arrayObjetos.add(new Persona(nombre,apellido,r,tel));
            
            
             
            
            n+=1;
            
            
            int up=JOptionPane.showConfirmDialog(null, "¿Desea seguir agregando?", "Agregar persona"
                    + "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(up==0){
                    upp=1;
                }
                    
            }while(upp==1 );
//            }
                }catch(Exception ie){
                JOptionPane.showMessageDialog(null, "Error al registrar la persona, intente nuevamente");
                this.llenarArray();
            }
            
            this.cargarMenu();
            
}    
        
   
 
    public void mostrarArray(){
        if(verificar_si_hay_datos()){
           for (int i=0;i<arrayObjetos.size();i++){
            JOptionPane.showMessageDialog(null, arrayObjetos.get(i)); 
            
        } 
        }
       
        this.cargarMenu();
    }
     
    
    public void eliminarDatosPersonas(){
        
        for (int i=0;i<arrayObjetos.size();i++){
            arrayObjetos.set(i, null);
        }
             n=0;
       this.cargarMenu();  
    }
    
    public boolean verificar_si_hay_datos(){
        if(arrayObjetos.size()==0){
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
    
    public void  HistorialMasaCorporal(){
        int i=0;
        if(verificar_si_hay_datos()){
            int op=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la persona que desea agregar historial de IMC \n"
                    + "Si no conoce el numero puede ver las personas registradas y su numero en la segunda opcion \n"
                    + "de el menú anterior."));
            
            do{
                JOptionPane.showMessageDialog(null, "Ingrese peso y altura de la persona: \n"
                        + arrayObjetos.get(i));
                String mes=JOptionPane.showInputDialog("Ingrese el mes ");
                double peso=Double.parseDouble(JOptionPane.showInputDialog("Ingrese peso de la persona "));
                double altura=Double.parseDouble(JOptionPane.showInputDialog("Ingrese altura de la persona "));
                double alt=altura*altura;
                 double imc=peso/alt;
                 String t=evaluarIMC(imc);
//                  Masa_corporal e = new Masa_corporal(mes, altura, peso, imc, t);
//                 e.setAltura(altura);
//                 e.setMes(mes);
//                 e.setImc(imc);
//                 e.setPeso(peso);
//                 e.setDiagnostico(t);
                 
                 arrayObjetos.set(, e)
                 historialmasa.add(historialmasa.get(i));
                 historialmasa.set(arrayObjetos.get(i), e);
                 arrayObjetos.
                i++;
            }while(i==arrayObjetos.size());
            
    }
        
        
        
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
                     + "1. Crear persona \n"
                     + "2. Imprimir personas\n"
                     + "3. historial clinico\n"
                     + "4. Cerrar todo"
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
                
            break;
            case 2:
              mostrarArray();
            break;
            case 3:
                HistorialMasaCorporal();
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

   public String evaluarIMC (double imc){
       String t="";
      if(imc<18.5){
          JOptionPane.showMessageDialog(null, "Peso inferior al normal");
          t="Peso inferior al normal";
      }else{
          if(imc>18.5 && imc<24.9){
              JOptionPane.showMessageDialog(null, "Normal");
              t="Normal";
          }else{
              if(imc>25.0 && imc<29.9){
                 JOptionPane.showMessageDialog(null, "Peso superior al normal");
                 t="Peso superior al normal";
              }else {
                  if(imc>30.0){
                      JOptionPane.showMessageDialog(null, "obesidad");
                      t="obesidad";
                  }
              }
          }
      }
      return t;
//      this.menuIMC();
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
    
    public void preguntasidesearegistrarhistorial(){
        
    }
    
//    public boolean validarNombre_apellido(String re){
//        for (int i = 0; i < re.length(); i++)
//		{
//			char caracter = re.toUpperCase().charAt(i);
//			int valorASCII = (int)caracter;
//			if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90))
//				return false; //Se ha encontrado un caracter que no es letra
//		}
//        
//    }
    
    
 }

