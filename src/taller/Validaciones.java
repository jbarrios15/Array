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
       do{
       na=JOptionPane.showInputDialog("Ingrese el nombre de la persona numero: "+per);
      
        for (int i = 0; i < na.length(); i++){
                    
			char caracter = na.toUpperCase().charAt(i);
			int valorASCII = (int)caracter;
			if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90 )){
                              JOptionPane.showMessageDialog(null, "Error al ingresar nombre \n"
                                      + "Verifique al digitar ");
                              ep=1;  
                             }else{
                            ep=2;
                        }
                        
		}
        
        }while(ep==1);
       return na;
   }
   public String validarApellido(int per){
       String na="";
       int ep=0;
       
       na=JOptionPane.showInputDialog("Ingrese el apellido de la persona numero: "+per);
      
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
