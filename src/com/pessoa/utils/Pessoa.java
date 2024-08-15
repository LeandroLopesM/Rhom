package com.pessoa.utils;
import java.time.LocalDate;

public abstract class Pessoa {
   protected String    nome;
   protected LocalDate nascimento;
   protected Endereço endereço;

   public Pessoa() {}
   public Pessoa(String nome, LocalDate nascimento,
                 String rua, String bairro, int número, String cidade,
                 String estado, String CEP) {
      this.nome       = nome;
      this.nascimento = nascimento;
      this.endereço = Endereço.create( rua, bairro, 
                                    número, cidade,
                                    estado, CEP );
   }
   
   
   public String getNome() { return nome; }
   public void setNome(String nome) { this.nome = nome; }

   public LocalDate getNascimento() {
      return nascimento;
   }
   public void setNascimento(LocalDate nascimento) {
      this.nascimento = nascimento;
   }
   
   public Endereço getEndereço() {
	      return endereço;
   }
   public void setEndereço(Endereço endereço) {
      this.endereço = endereço;
   }
   
   @Override
   public boolean equals(Object obj) {
      if(obj == null || !(obj instanceof Pessoa)) return false;
      if( this == obj ) return true;
      
      Pessoa p = (Pessoa) obj;
      
      if( !this.getNome().equals(p.nome) ) return false;
      if( !this.getNascimento().equals(p.nascimento) ) return false;
      
      return true;
   }
   
//   @Override
//   public String toString() {
//	   return this.getClass().getCanonicalName() + " = [ " + 
//			  "nome: " + this.nome + ", " + 
//			  "nascimento: " + Utils.formatDate(nascimento) + ", " + 
//			  this.endereço + " ]";
//			   
//   }
   
   @Override
   public String toString() {
	   return "{ " + 
			  "Nome = \"" + this.nome + "\", " + 
			  "Nascimento = " + Utils.formatDate(nascimento) + ", " + 
			  "Endereço = " + this.endereço.toString() +
			  " }";
			   
   }
}
