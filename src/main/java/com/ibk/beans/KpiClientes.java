package com.ibk.beans;

public class KpiClientes {

  private  Double promEdad;
  private  Double desvEstandar;

  public KpiClientes(Double promEdad, Double desvEstandar) {
    this.promEdad = promEdad;
    this.desvEstandar = desvEstandar;
  }


 public void setPromEdad(Double  promEdad) {
     this.promEdad = promEdad;
  }
   public void setDesvEstandar(Double desvEstandar) {
     this.desvEstandar = desvEstandar;
  }
  public String promEdad() {
    return String.format( "%.2f", promEdad );
    
  }

  public String desvEstandar() {
    return String.format( "%.2f", desvEstandar );
     
  }
}