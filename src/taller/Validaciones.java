/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import javax.swing.JOptionPane;

/**
 *
 * @author JapiB
 */
public class Validaciones {
    
   public String validarDocumento(String documento) {
       
       int op=0;
       
        do{
           try {
            Integer.parseInt(documento);
            op=1;
        } catch (Exception e) {
            op=2;
        }
        }while(op==1);
        
        return documento;
    }

   public String validarNombre(int per){
       String na="";
       int ep=0;
       
       na=JOptionPane.showInputDialog("Ingrese el nombre de la persona numero: "+per);
      if(na.isEmpty()){
          JOptionPane.showMessageDialog(null, "Campo vacio \n"
                       + "Verifique al ingresar");
          this.validarNombre(per);
      }else{
        for (int i = 0; i < na.length(); i++){
                    
			char caracter = na.toUpperCase().charAt(i);
			int valorASCII = (int)caracter;
			if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90 )){
                              JOptionPane.showMessageDialog(null, "Error al ingresar nombre \n"
                                      + "Verifique al digitar ");
                               this.validarNombre(per);
                             }
                        
		}
        
         }
       return na;
       
   }
   public String validarApellido(int per){
       String na="";
       int ep=0;
       
       na=JOptionPane.showInputDialog("Ingrese el apellido de la persona numero: "+per);
      if(na.isEmpty()){
           JOptionPane.showMessageDialog(null, "Campo vacio \n"
                       + "Verifique al ingresar");
           this.validarApellido(per);
      }else{
        for (int i = 0; i < na.length(); i++){
                    
			char caracter = na.toUpperCase().charAt(i);
			int valorASCII = (int)caracter;
			if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90 )){
                              JOptionPane.showMessageDialog(null, "Error al ingresar apellido \n"
                                      + "Verifique al digitar ");
                               validarApellido(per);
                             }else{
                            return na;
                        }
                        
		}
      
       }
       return na;
   }
   
   public boolean PreguntarSiDeseaAgregarPersona(){
        
          int up=JOptionPane.showConfirmDialog(null, "¿Desea seguir agregando?", "Agregar persona"
                    + "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
           if(up==0){
                return true;
           }
       return false;
   }
   
   public double alturaPersona(double alt){
       int pas=0;
        double alttotal=0;
        do{
            
        try {
        
        double altmetros=alt/100;
        alttotal=altmetros*altmetros;
            pas=2;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar la altura \n"
                    + "\n"
                    + "Verifique e intente de nuevo");
                     pas=1;
        }
        
        }while(pas==1);
        System.out.println("fin");
        return alttotal;
     
        }
   
   public double pesoPersona(){
       int pas=0;
        double peso=0;
        do{
            
        
        try {
        peso=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso de la persona\n"
                + "\n"
                + "*Recuerde que tiene que ser en KILOGRAMOS*"));
            pas=2;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar el peso \n"
                    + "\n"
                    + "Verifique e intente de nuevo");
                     pas=1;
        }
        
        }while(pas==1);
        
        return peso;
    }
   
   //verificar con profesor
   
//   public double ingresarNumeroDouble(){
//       double evaluarIMC=0;
//        try {
//           evaluarIMC=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la masa corporal"));  
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error al ingresar la masa corporal \n"
//                    + "\n"
//                    + "Verifique a  digitar");
//            this.ingresarNumeroDouble();
//        }
//        return evaluarIMC;
//    }
   
//   
//   public String Validardocumento(int per,int size,Object docu){
//       int pr=0;
//       String rr;
//       do{
//           rr=JOptionPane.showInputDialog("Escribe el documento de la persona numero: "+per);
//           for (int i = 0; i < control.arrayObjetos.size(); i++) {
//               if(control.arrayObjetos.get(i).getDocumento().equals(rr)){
//                   JOptionPane.showMessageDialog(null, "Documento de identidad ya ha sido registrado.");
//                   pr=2;
//               }else{
//	try {
//		Integer.parseInt(rr);
//		pr=1;
//	} catch (NumberFormatException nfe){
//            JOptionPane.showMessageDialog(null, "error");
//		pr=2;
//	}
//        }
//           }
//         }while(pr==2);
//       
//       return rr;
//       
//   }
   
   
    public String Validartelefono(int per){
       int pr=0;
       String rr;
       
       do{
           rr=JOptionPane.showInputDialog("Escribe telefono de la persona numero: "+per);
           
	try {
		Integer.parseInt(rr);
                   if(rr.length()<7){
               JOptionPane.showMessageDialog(null, "El numero de telefono debe tener mas de 6 digitos");
               pr=2;
               }else{
		pr=1;
               } 
                
	} catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "error");
		pr=2;
	}
           
         }while(pr==2);
        
       return rr;
       
   }
    
}
