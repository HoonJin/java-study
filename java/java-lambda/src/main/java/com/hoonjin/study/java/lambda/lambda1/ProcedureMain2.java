package com.hoonjin.study.java.lambda.lambda1;

import com.hoonjin.study.java.lambda.Procedure;

public class ProcedureMain2 {

    public static void main(String[] args) {
        Procedure procedure = () -> {
            System.out.println("Hello!, lambda");
        };

        procedure.run();
    }
}
