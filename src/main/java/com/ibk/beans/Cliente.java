package com.ibk.beans;

import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.text.ParseException;  
import java.util.Calendar;

public class Cliente {

  private  String  nombres;
  private  String  apellidos;
  private  Integer edad;
  private  String  fecNacimiento;
  private  String  fecMuerte;

  public Cliente(String nombres, String apellidos, Integer edad, String fecNacimiento) {
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.edad = edad;
    this.fecNacimiento = fecNacimiento;

  }

  public String nombres() {
    return nombres;
  }

  public String apellidos() {
    return apellidos;
  }

  public Integer edad() {
    return edad;
  }

  public String fecNacimiento() {
    return fecNacimiento;
  }

  public String fecMuerte() {

     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd"); 
     
     try {  
            Date date = formatter.parse(fecNacimiento);

            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.YEAR, 80);

            Date newDate = cal.getTime();
            this.fecMuerte= formatter.format(newDate);
            System.out.println("Fecha muerte: "+ fecMuerte);   
          } 
          catch (ParseException e) {
              e.printStackTrace();
          }  


    return fecMuerte;
  }

}