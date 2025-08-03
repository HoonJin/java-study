package com.hoonjin.study.java.lambda.lambda1;

import com.hoonjin.study.java.lambda.Procedure;

public class ProcedureMain1 {

    public static void main(String[] args) {
        Procedure procedure = new Procedure() {
            @Override
            public void run() {
                System.out.println("Hello!, lambda");
            }
        };

        procedure.run();
    }
}
