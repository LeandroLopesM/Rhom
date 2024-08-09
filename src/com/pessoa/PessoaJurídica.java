package com.pessoa;
import java.time.LocalDate;
import com.pessoa.utils.*;

public class PessoaJurídica extends Pessoa {
   private String cnpj;
   private String nomeFantasia;

   public PessoaJurídica() { super(); }
   public PessoaJurídica(String nome, LocalDate nascimento, String cnpj, String nomeFantasia, Endereço endereço) {
      super(nome,nascimento, endereço);
      this.cnpj         = cnpj;
      this.nomeFantasia = nomeFantasia;
   }

   public String getCnpj() { return cnpj; }
   public void setCnpj(String cnpj) { this.cnpj = cnpj; }

   public String getNomeFantasia() {
      return nomeFantasia;
   }
   public void setNomeFantasia(String nomeFantasia) {
      this.nomeFantasia = nomeFantasia;
   }
   
   @Override
   public String toString() {
	   return this.getClass().getSimpleName() + " = {" +
	    		  " Core = \"" + super.toString() + "\", " +
	    		  "CNPJ = " + Utils.formatCNPJ(cnpj) + ", " +
	    		  "NomeFantasia = \"" + nomeFantasia + "\", " +
	    		  "}";       
   }
   
   @Override
   public boolean equals(Object obj) {
      if(obj == null || !(obj instanceof PessoaJurídica)) return false;
      if( this == obj ) return true;
      
      PessoaJurídica p = (PessoaJurídica) obj;
      
      if( !( super.equals(p) && 
             this.nomeFantasia.equals( p.nomeFantasia ) && 
             this.getCnpj().equals(p.cnpj) ) ) return false;
      
      
      return true;
   }
}
