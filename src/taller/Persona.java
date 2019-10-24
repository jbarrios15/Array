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
    public class Persona {
    private String nombre;
    private String Apellido;
    private int edad;
    private String tel;

    public Persona(String nombre, String Apellido, int edad, String tel) {
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.edad = edad;
        this.tel = tel;
    }
    
    
    
    public String getNombre() {
    return nombre;
    }
    
    public void setNombre(String nombre) {
    this.nombre = nombre;
    }
    
    public int getEdad() {
    return edad;
    }
    
    public void setEdad(int edad) {
    this.edad = edad;
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
    
    
    
    public String toString(){
    String a="Persona registrada: \n"
            + "Nombre: "+nombre+" "+Apellido+", "+edad+" años y telefono, "+tel;
    return a;
    
    }
    }
