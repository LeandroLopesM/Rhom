package com;
import com.pessoa.utils.DevUtils;
import com.pessoa.utils.DevUtils.ClassT;

import com.pessoa.PessoaFísica;
import com.pessoa.PessoaJurídica;
import com.pessoa.utils.Endereço;
import com.pessoa.utils.EstadoInválido;

public class Principal {
   public Principal() {
      PessoaFísica pf = (PessoaFísica) DevUtils.getDefault(ClassT.P_FIS); 
   }

   public static void main(String[] args) {
      try {
         new Principal();
      } catch (EstadoInválido e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
}
