package com.pessoa.utils;

import java.util.Objects;

public class Endereço {
   private String rua;
   private String bairro;
   private int número;
   private String cidade;
   private String estado;
   private String CEP;
   
   public Endereço() { }
   public Endereço(String rua, String bairro, int número, String cidade, String estado, String cEP) {
      this.rua = rua;
      this.bairro = bairro;
      this.número = número;
      this.cidade = cidade;
      this.estado = estado;
      CEP = cEP;
   }
   
   public String getRua() {
      return rua;
   }
   public void setRua(String rua) {
      this.rua = rua;
   }
   public String getBairro() {
      return bairro;
   }
   public void setBairro(String bairro) {
      this.bairro = bairro;
   }
   public int getNúmero() {
      return número;
   }
   public void setNúmero(int número) {
      this.número = número;
   }
   public String getCidade() {
      return cidade;
   }
   public void setCidade(String cidade) {
      this.cidade = cidade;
   }
   public String getEstado() {
      return estado;
   }
   public void setEstado(String estado) {
      this.estado = estado;
   }
   public String getCEP() {
      return CEP;
   }
   public void setCEP(String cEP) {
      CEP = cEP;
   }
   
//   @Override
//   public String toString() {
//      return this.getClass().getCanonicalName() + " = [ " +
//            "rua: " + rua + ", " +
//            "bairro: " + bairro+ ", " +
//            "número: " + número+ ", " +
//            "cidade: " + cidade+ ", " +
//            "estado: " + estado+ ", " +
//            "cep: " + Utils.formatCEP(CEP) + "]";
//   }
   
   @Override
   public String toString() {
      return "{ " +
             "Rua = \"" + rua + "\", " +
             "Bairro = \"" + bairro+ "\", " +
             "Número = " + número+ ", " +
             "Cidade = " + cidade+ ", " +
             "Estado = " + estado+ ", " +
             "CEP = " + Utils.formatCEP(CEP) +
             " }";
   }
   
   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if( !( obj instanceof Endereço ) ) return false;
      
      Endereço other = (Endereço) obj;
      
      if ( !( Objects.equals(CEP, other.CEP) && Objects.equals(bairro, other.bairro)
            && Objects.equals(cidade, other.cidade) && Objects.equals(estado, other.estado) && número == other.número
            && Objects.equals(rua, other.rua) ) ) return false;
      
      return true;
   }
}
