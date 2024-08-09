package com.pessoa;
import java.time.LocalDate;
import com.pessoa.utils.*;

public class PessoaFísica extends Pessoa {
   private String cpf;

   public PessoaFísica() { super(); }
   public PessoaFísica(String nome, LocalDate nascimento, String cpf,  Endereço endereço) {
      super(nome,nascimento, endereço);
      
      this.cpf = cpf;
   }

   public String getCpf() { return cpf; }
   public void setCpf(String cpf) { this.cpf = cpf; }
   
   @Override
   public String toString() {
      return this.getClass().getSimpleName() + " = {" +
    		  " Core = " + super.toString() + ", " + 
    		  "CPF = " + Utils.formatCPF(cpf) +
    		  " }";
   }
   
   @Override
   public boolean equals(Object obj) {
      if(obj == null || !(obj instanceof PessoaFísica)) return false;
      if( this == obj ) return true;
      
      PessoaFísica p = (PessoaFísica) obj;
      
      if( !( super.equals(p) &&  
             this.getCpf().equals(p.cpf) ) ) return false;
      
      
      return true;
   }
}
