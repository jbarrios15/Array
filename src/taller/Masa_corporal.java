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
public class Masa_corporal{
    
    public String mes;
    public double altura;
    public double peso;
    public double imc;
    public String diagnostico;

    public Masa_corporal(String mes, double altura, double peso, double imc, String diagnostico) {
        this.mes = mes;
        this.altura = altura;
        this.peso = peso;
        this.imc = imc;
        this.diagnostico = diagnostico;
    }
            
    

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    

   
    

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

 public String toString(){
    String a="El hiostorial de la persona es: \n"
            + "Mes: "+mes+"\n"
            + "Peso: "+peso+" Kg\n"
            + "Altura: "+altura+" Cm \n"
            + "Indice de masa corporal :"+imc+"\n"
            + "Diagnostico: "+ diagnostico;
            
    return a;
    
    }
    
    
    
    

    
    
    
}
