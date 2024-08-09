package com.pessoa.utils;

import java.time.LocalDate;

import com.pessoa.PessoaFísica;
import com.pessoa.PessoaJurídica;

public final class DevUtils {
	static enum ClassT {
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
	
	public static String parseBadJSON( String json ) {
		StringBuilder back = new StringBuilder(json);
//		int index = back.indexOf(",");
//		int incount = 0;
//	    while (index != -1) {
//	        back.replace(index, index + ",".length(), ",\n\t");
//	        index += ",\n".length(); // Move to the end of the replacement
//	        index = back.indexOf(",", index);
//	    }
	    
	    int i = 0;
	    int id = 0;
	    for( char c : json.toCharArray() ) {
	    	if( c == ',' ) {
	    		i++;
	    		back.insert(i, "\n");
	    		int e = id;    		
	    		
	    		while(e != 0) {
	    			back.insert(i, "\t");
	    			i++;
	    			e--;
	    		}
	    	}
	    	if( c == '{' ) id++;
	    	if( c == '}' ) id--;
	    		
	    	
	    	i++;
	    }
		
		return back.toString();
	}
}
