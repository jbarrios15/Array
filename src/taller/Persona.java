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

/**
 *
 * @author JapiB
 */
    public class Persona {
    private String nombre;
    private String Apellido;
    private String documento;
    private String fecha_nacimiento;
    private String tel;
    ArrayList<Masa_corporal> historialmasa=new ArrayList();

    public Persona(String nombre, String Apellido, String documento, String fecha_nacimiento, String tel) {
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.documento = documento;
        this.fecha_nacimiento = fecha_nacimiento;
        this.tel = tel;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    
    
    public String getNombre() {
    return nombre;
    }
    
    public void setNombre(String nombre) {
    this.nombre = nombre;
    }
    
    public String getfecha_nacimiento() {
    return fecha_nacimiento;
    }
    
    public void setfecha_nacimiento(String edad) {
    this.fecha_nacimiento= edad;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    
    
    
    public String toString(){
    String a="Persona registrada: \n"
            + "Nombre: "+nombre+" "+Apellido+", "+fecha_nacimiento+" años y telefono, "+tel;
            
    return a;
    
    }
    }
