package com.pessoa.utils;

import java.util.Objects;

final class Endereço {
   private String rua;
   private String bairro;
   private int número;
   private String cidade;
   private String estado;
   private String CEP;
   
   private Endereço() { }
   private Endereço(String rua, String bairro, int número, String cidade,
                   String estado, String CEP) throws EstadoInválido {
      if( estado.length() != 2 ) throw new EstadoInválido(estado + " não é reconhecido como estado válido.");
      this.rua = rua;
      this.bairro = bairro;
      this.número = número;
      this.cidade = cidade;
      this.estado = estado;
      this.CEP = CEP;
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
   
   protected static Endereço create( String rua, String bairro, int número, String cidade,
         String estado, String CEP ) {
      try {
         return new Endereço( rua, bairro, 
               número, cidade,
               estado, CEP );
      } catch (EstadoInválido e) {
         System.err.println("Estado inválido");
         return null;
      }
   } 
   
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
