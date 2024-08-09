package com.pessoa.utils;

import java.time.LocalDate;

import com.pessoa.PessoaFísica;
import com.pessoa.PessoaJurídica;


public final class DevUtils {
	
	public enum ClassT {
		P_FIS,
		P_JUR,
		END
	}
	
	
	public static Object getDefault( ClassT t ) {
		switch( t ) {
			case P_FIS: {
				return new PessoaFísica( "John Doe", LocalDate.parse("2000-01-01"), "11122233344", (Endereço) getDefault(ClassT.END) );
			} 
			case END: {
				return new Endereço( "Nowhere Ave.", "Null blvd.", 123, "BlankVille", "BLANK", "11111222" );
			} 
			case P_JUR: {
				return new PessoaJurídica( "John Doe", LocalDate.parse("2000-01-01"), "11222333444455", "Null Inc.", (Endereço)getDefault(ClassT.END) );
			} 
			default: return null;
				
		}
	}
	
	
	
	public static String stringize( Object o ) {
		if( o instanceof PessoaFísica ) {
			PessoaFísica p = (PessoaFísica) o;
			return  """
					%s = {
					    Pessoa = {
					        Nome = "%s",
					        Nascimento = %s,  
					        Endereço = {
					            Rua = "%s",
					            Bairro = "%s",
					            Número = %d,
					            Cidade = %s,
					            Estado = %s,
					            CEP = %s
					        }
					    },
					    CPF = %s
					};
					""".formatted( p.getClass().getSimpleName(),
								   p.getNome(),
								   p.getNascimento(),
								   p.getEndereço().getRua(),
								   p.getEndereço().getBairro(),
								   p.getEndereço().getNúmero(),
								   p.getEndereço().getCidade(),
								   p.getEndereço().getEstado(),
								   p.getEndereço().getCEP(),
								   p.getCpf() );
		}
		else if( o instanceof PessoaJurídica  ) {
			PessoaJurídica p = (PessoaJurídica) o;
			return  """
					%s = {
					    Pessoa = {
					        Nome = "%s",
					        Nascimento = %s,  
					        Endereço = {
					            Rua = "%s",
					            Bairro = "%s",
					            Número = %d,
					            Cidade = %s,
					            Estado = %s,
					            CEP = %s
					        }
					    },
					    NomeFalso = "%s",
					    CPF = %s
					};
					""".formatted( p.getClass().getSimpleName(),
								   p.getNome(),
								   p.getNascimento(),
								   p.getEndereço().getRua(),
								   p.getEndereço().getBairro(),
								   p.getEndereço().getNúmero(),
								   p.getEndereço().getCidade(),
								   p.getEndereço().getEstado(),
								   p.getEndereço().getCEP(),
								   p.getNomeFantasia(),
								   p.getCnpj());
		}
		else {
			return null;
		}
	}
}
