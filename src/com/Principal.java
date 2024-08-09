package com;
import com.pessoa.utils.DevUtils;
import com.pessoa.utils.DevUtils.ClassT;

import com.pessoa.PessoaFísica;
import com.pessoa.PessoaJurídica;
import com.pessoa.utils.Endereço;

public class Principal {
   public Principal() {
//	  PessoaFísica pf1 = new PessoaFísica("Johnathan IFPR", LocalDate.now(), "05225635409",
//								 new Endereço("IFPR Road", "Instituto Civil", 0x03, 
//									 		"Londrina", "Paraná", "78002310"));
//	  System.out.println(pf1);
	   
	   PessoaJurídica p = (PessoaJurídica) DevUtils.getDefault( ClassT.P_JUR );
	  System.out.println( DevUtils.stringize( p) );
   }

   public static void main(String[] args) {
      new Principal();
   }
}
