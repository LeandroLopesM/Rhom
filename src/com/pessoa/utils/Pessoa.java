package com.pessoa.utils;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Pessoa {
   protected String    nome;
   protected LocalDate nascimento;
   protected Endereço endereço;

   public Pessoa() {}
   public Pessoa(String nome, LocalDate nascimento) {
      this.nome       = nome;
      this.nascimento = nascimento;
   }
   
   
   public String getNome() { return nome; }
   public void setNome(String nome) { this.nome = nome; }

   public LocalDate getNascimento() {
      return nascimento;
   }
   public void setNascimento(LocalDate nascimento) {
      this.nascimento = nascimento;
   }
   
   public Object setEndereço( String rua, String bairro, int número, String cidade, String estado, String CEP ) {
       try {
           this.endereço = new Endereço( rua, bairro, número, cidade, estado, CEP );
       } catch( EstadoInválido e ) {
           throw new RuntimeException("Estado inválido fallthrough");
       }
       
       // Retorna objeto para poder fazer interface com Pessoa(Física/Jurídica), eles overriding essa função para permitir correntes
       // ex. -> new PessoaFísica(...).setEndereço(...);
       return null;
   }
   
   public Endereço getEndereço() { return this.endereço; }
   
   @Override
   public boolean equals(Object obj) {
      if(obj == null || !(obj instanceof Pessoa)) return false;
      if( this == obj ) return true;
      
      Pessoa p = (Pessoa) obj;
      
      if( !this.getNome().equals(p.nome) ) return false;
      if( !this.getNascimento().equals(p.nascimento) ) return false;
      
      return true;
   }
   
   @Override
   public String toString() {
       return "{ " + 
              "Nome = \"" + this.nome + "\", " + 
              "Nascimento = " + Utils.formatDate(nascimento) + ", " + 
              "Endereço = " + this.endereço.toString() +
              " }";
               
   }
   
   public static class Endereço {
      private String rua;
      private String bairro;
      private int número;
      private String cidade;
      private String estado;
      private String CEP;
      
      private Endereço() { }
      private Endereço(String rua, String bairro, int número, String cidade, String estado, String CEP) throws EstadoInválido {
         if( estado.length() != 2 ) throw new EstadoInválido(estado + " não é reconhecido como estado válido.");
         this.rua = rua;
         this.bairro = bairro;
         this.número = número;
         this.cidade = cidade;
         this.estado = estado;
         this.CEP = CEP;
      }
      
      // GETTERS
      public void setBairro(String bairro)  { this.bairro = bairro; }
      public void setCidade(String cidade)     { this.cidade = cidade; }
      public void setEstado(String estado)     { this.estado = estado; }
      public void setCEP(String CEP)         { this.CEP = CEP; }
      public void setRua(String rua)         { this.rua = rua; }
      public void setNúmero(int número)     { this.número = número; }
      
      // SETTERS
      public String getBairro() { return bairro; }
      public String getCidade() { return cidade; }
      public String getEstado() { return estado; }
      public String getCEP()     { return CEP; }
      public String getRua()     { return rua; }
      public int getNúmero()     { return número; }
      
      
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
}
