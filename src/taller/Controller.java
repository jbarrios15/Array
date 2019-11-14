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

    
    public int per =0;
   
    public Controller() {
       
    }
    

    
    ArrayList <Persona> arrayObjetos=new ArrayList();
    Validaciones vali=new Validaciones();
    
    private double alkk=0;
    private String dia="";
    
    
    
    public void cargarMenu(){

        try {
             seleccionarOpcion(Integer.parseInt(JOptionPane.showInputDialog("Bienven"
                + "ido a SofBarr\n"
                + "\n"
                + "Elija la opcion del 1 al 6 \n"
                + "---------------\n"
                + "1. Registrar persona\n"
                + "2. Mostrar personas\n"
                + "3. Eliminar todas las personas registradas\n"
                + "4. Verificar cuantas personas estan registradas\n"
                + "5. Agregar y ver masa corporal\n"
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
        this.cargarMenu();
        break;
        case 2:
             this.mostrarArray();
             this.cargarMenu();
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
            try{
            
             per=per+1;    
            int n=0;
            String nombre;
             String apellido;
             String fecha;
     
             do{
                nombre=vali.validarNombre(per);
             apellido=vali.validarApellido(per);
            
             String documento=Validardocumento(per);         
            do{
            fecha=(JOptionPane.showInputDialog("Escribe fecha de nacimiento de la persona "+per)); 
            }while(validarfecha(fecha));
             JOptionPane.showMessageDialog(null,"Usted tiene una edad de:"+GetEdad(fecha));
             
            String tel=vali.Validartelefono(per);
                
            
            arrayObjetos.add(new Persona(nombre,apellido,documento,fecha,tel));
           
                System.out.println(per);
            JOptionPane.showMessageDialog(null, "Persona registrada con exito.");
            
            }while(vali.PreguntarSiDeseaAgregarPersona()==true );
           
                }catch(Exception ie){
                JOptionPane.showMessageDialog(null, "Error al registrar la persona, intente nuevamente");
                per--;
                this.llenarArray();
                
            }
            
            
            
}    
        
   
 
    public void mostrarArray(){
        if(verificar_si_hay_datos()){
           for (int i=0;i<arrayObjetos.size();i++){
            JOptionPane.showMessageDialog(null, arrayObjetos.get(i)); 
            
        } 
        }
      
    }
     
    
    public void eliminarDatosPersonas(){
        
        for (int i=0;i<arrayObjetos.size();i++){
            arrayObjetos.remove(i);
        }
             per=0;
       this.cargarMenu();  
    }
    
    public boolean verificar_si_hay_datos(){
        if(arrayObjetos.size()==0){
            JOptionPane.showMessageDialog(null, "No hay personas registradas en el vector");
            return false;
            
        }else{
            JOptionPane.showMessageDialog(null, "hay "+per+" personas registradas en el vector");
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
        
        if(arrayObjetos.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay personas registradas");
            menuIMC();
               }else{
            String opuuu=JOptionPane.showInputDialog("Ingrese el numero de documento de la persona  que desea agregar historial de IMC \n"
                    + "Si no lo conoce puede ver las personas registradas \n y su numero de documento en la segunda opcion \n"
                    + "de el menú anterior.");
            for (int j = 0; j < arrayObjetos.size(); j++) {
                if(arrayObjetos.get(j).getDocumento().equals(opuuu)){
                    JOptionPane.showMessageDialog(null, "Persona encontrada con exito");
                    submenudehistorial(j);
                
                }
                JOptionPane.showMessageDialog(null, "La persona no se ha encontrado");
            }
             
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
                     + "4. Cerrar todo\n"
                     + "5. Salr"
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
                llenarArray();
                menuIMC();
            break;
            case 2:
              mostrarArray();
              menuIMC();
            break;
            case 3:
                HistorialMasaCorporal();
            break;
            case 4: 
               cargarMenu();         
            break;  
            case 5:
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
        int ru=0;
        
        try {
        double alt=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la altura de la persona\n"
                + "\n"
                + "*Recuerde que tiene que ser en centimetros*"));
        alm=alt/100;
         altu_2=alm*alm;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar la altura \n"
                    + "\n"
                    + "Verifique e intente de nuevo");
                     this.alturaPersona();
        }
        
        return altu_2;
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
    
    public void submenudehistorial(int u){
       
        opcionsubmenuhistorial(Integer.parseInt(JOptionPane.showInputDialog("Hola, "
                + ""+arrayObjetos.get(u).getNombre()+" "+arrayObjetos.get(u).getApellido()+"\n"
                + "Eliga una opcion: \n"
                + "\n"
                + "1. Registrar historial IMC\n"
                + "2. imprimir historial IMC\n"
                + "3. Retroceder\n"
                + "4. Salir")),u);
        
    }
    public void opcionsubmenuhistorial(int op,int u){
       
        switch(op){
            case 1:
             registrarhistorial(u);
            break;
            case 2:
                mostrarhistorial(u);
            break;    
            case 3:
               menuIMC();
               break;
            case 4:
                confirmarCerrarTodo();
             break;
        }
        
    }
    
    
    public void registrarhistorial(int u){
            
            JOptionPane.showMessageDialog(null, "Ingrese peso y altura de la persona : \n"
                        + arrayObjetos.get(u));
            String mes=opcionmes();
//                String mes=JOptionPane.showInputDialog("Ingrese el mes ");
                
               double peso=vali.pesoPersona();
               
               double alt=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la altura de la persona\n"
                + "\n"
                + "*Recuerde que tiene que ser en CENTIMETROS*"));
               double altura=vali.alturaPersona(alt);
//                double altura=Double.parseDouble(JOptionPane.showInputDialog("Ingrese altura de la persona "));
//                double alturametros=altura/100;
//                double alt=alturametros*alturametros; 
                double imc=peso/altura;
                JOptionPane.showMessageDialog(null, imc);
                 String t=evaluarIMC(imc);
                arrayObjetos.get(u).historialmasa.add(new Masa_corporal(mes, alt, peso, imc, t));
                JOptionPane.showMessageDialog(null, "Historial registrado con exito");
        submenudehistorial(u);
       
    }
    public void mostrarhistorial(int up){
        if(arrayObjetos.get(up).historialmasa.isEmpty()){
            JOptionPane.showMessageDialog(null, "La persona "+arrayObjetos.get(up).getNombre()+" "+" "
                    + arrayObjetos.get(up).getApellido()+"\n con numero documento: "+arrayObjetos.get(up).getDocumento()+"\n"
                            + "No tiene registrado ningun historial.");
        }else{
           for (int j = 0; j < arrayObjetos.get(up).historialmasa.size(); j++) { 
            JOptionPane.showMessageDialog(null, arrayObjetos.get(up).historialmasa.get(j));
            
        } 
        } 
        submenudehistorial(up);
        
    }
    
    
   public String Validardocumento(int per){
       int pr=0;
       String rr;
       
       
           rr=JOptionPane.showInputDialog("Escribe el documento de la persona numero: "+per);
           if(rr.isEmpty()){
               JOptionPane.showMessageDialog(null, "Campo vacio \n"
                       + "Verifique al ingresar");
           }else{
               
           for (int i = 0; i < arrayObjetos.size(); i++) {
               if(arrayObjetos.get(i).getDocumento().equals(rr)){
                   JOptionPane.showMessageDialog(null, "El documento de identidad ya ha sido registrado.");
                   this.Validardocumento(per);
               }else{
	try {
		Integer.parseInt(rr);
		
	} catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Error al ingresar el documento de identidad \n"
                    + "Verifique al ingresar.");
		this.Validardocumento(per);
	}
        }
           }
         
       }
         
       return rr;
       
   }
    
    public String menuopciondemes(){
        int t=Integer.parseInt(JOptionPane.showInputDialog("Digite el mes\n"
                + "\n"
                + "1. Enero\n"
                + "2. Febrero"
                + "3. Marzo\n"
                + "4. Abril"
                + "5. Mayo\n"
                + "6. Junio\n"
                + "7, Julio\n"
                + "8. Agosto\n"
                + "9. Septiembre\n"
                + "10. Octubre\n"
                + "11. Noviembre\n"
                + "12. Diciembre"));
//        opcionmes(t);
        return "";
    }
    public String opcionmes(){
        String mes="";
        int t=Integer.parseInt(JOptionPane.showInputDialog("Digite el mes\n"
                + "\n"
                + "1. Enero\n"
                + "2. Febrero"
                + "3. Marzo\n"
                + "4. Abril"
                + "5. Mayo\n"
                + "6. Junio\n"
                + "7, Julio\n"
                + "8. Agosto\n"
                + "9. Septiembre\n"
                + "10. Octubre\n"
                + "11. Noviembre\n"
                + "12. Diciembre"));
        switch(t){
            case 1:
                mes="Enero";
            break;
            case 2:
                 mes="Febrero";
            break;
            case 3:
                 mes="Marzo";
            break;
            case 4:
                 mes="Abril";
            break;
            case 5:
                 mes="Mayo";
            break;
            case 6:
                 mes="Junio";
            break;
            case 7:
                 mes="Julio";
            break;
            case 8:
                 mes="Agosto";
            break;
            case 9:
                 mes="Septiembre";
            break;   
            case 10:
                mes="Octubre";
            break;
            case 11:
                mes="Noviembre";
            break;
            case 12:
                mes="Diciembre";
            break;
            default:
                JOptionPane.showMessageDialog(null, "Error al seleccionar un mes \n"
                + "\n"
                + "Recuerde elegir del 1 al 12");
                menuopciondemes();
        }
        return mes;
        
    }
    
    
    
//    public boolean validarNombre_apellido(String re){
//       
//    }
    
//    JOptionPane.showMessageDialog(null, "Ingrese peso y altura de la persona: \n"
//                        + arrayObjetos.get(i));
//                String mes=JOptionPane.showInputDialog("Ingrese el mes ");
//                double peso=Double.parseDouble(JOptionPane.showInputDialog("Ingrese peso de la persona "));
//                double altura=Double.parseDouble(JOptionPane.showInputDialog("Ingrese altura de la persona "));
//                double alt=altura*altura;
//                 double imc=peso/alt;
//                 String t=evaluarIMC(imc);
//                arrayObjetos.get(i).historialmasa.add(new Masa_corporal(mes, altura, peso, imc, t));
    
 }

