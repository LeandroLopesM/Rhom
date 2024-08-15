package com.pessoa.utils;

import java.time.LocalDate;

import javax.management.RuntimeErrorException;

import com.pessoa.PessoaFísica;
import com.pessoa.PessoaJurídica;


public final class DevUtils {
	
	public enum ClassT {
		P_FIS,
		P_JUR,
		END
	}
	
	
	public static Object getDefault( ClassT t ) throws EstadoInválido {
		switch( t ) {
			case P_FIS: {
				return new PessoaFísica( "John Doe", LocalDate.parse("2000-01-01"), "11122233344", "Nowhere Ave.", "Null blvd.", 123, "BlankVille", "BLANK", "11111222" );
			} 
			case END: {
				try {
				   return new Endereço( "Nowhere Ave.", "Null blvd.", 123, "BlankVille", "BLANK", "11111222" );
				} catch (EstadoInválido e) {
				   e.printStackTrace();
				}

			} 
			case P_JUR: {
				return new PessoaJurídica( "John Doe", LocalDate.parse("2000-01-01"), "11222333444455", "Null Inc.", "Nowhere Ave.", "Null blvd.", 123, "BlankVille", "BLANK", "11111222" );
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
								   Utils.formatCEP(p.getEndereço().getCEP()),
								   Utils.formatCPF(p.getCpf()) );
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
					    NomeFantasia = "%s",
					    CNPJ = %s
					};
					""".formatted( p.getClass().getSimpleName(),
								   p.getNome(),
								   p.getNascimento(),
								   p.getEndereço().getRua(),
								   p.getEndereço().getBairro(),
								   p.getEndereço().getNúmero(),
								   p.getEndereço().getCidade(),
								   p.getEndereço().getEstado(),
								   Utils.formatCEP(p.getEndereço().getCEP()),
								   p.getNomeFantasia(),
								   Utils.formatCNPJ(p.getCnpj()));
		}
		else {
			return null;
		}
	}
}
