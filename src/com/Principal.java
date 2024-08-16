package com;
import com.pessoa.utils.DevUtils;
import com.pessoa.utils.DevUtils.ClassT;

import com.pessoa.*;

public class Principal {
    public Principal() {
        PessoaFísica pf = (PessoaFísica)DevUtils.getDefault(ClassT.P_FIS);
        System.out.println( pf );
    }

    public static void main(String[] args) {
        new Principal();
    }
}
