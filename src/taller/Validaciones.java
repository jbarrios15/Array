/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

/**
 *
 * @author JapiB
 */
public class Validaciones {
    
   public String validardocumento(String documento) {
       
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


    
    
}
