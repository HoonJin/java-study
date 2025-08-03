package com.hoonjin.study.java.lambda.lambda1;

import com.hoonjin.study.java.lambda.Procedure;

public class InstanceMain {

    public static void main(String[] args) {
        Procedure procedure = new Procedure() {
            @Override
            public void run() {
                System.out.println("Hello!, lambda");
            }
        };
        System.out.println("procedure.getClass() = " + procedure.getClass());
        System.out.println("procedure.instance = " + procedure);

        Procedure procedure2 = () -> {
            System.out.println("Hello!, lambda");
        };
        System.out.println("procedure2.getClass() = " + procedure2.getClass());
        System.out.println("procedure2.instance = " + procedure2);

        // result
        //procedure.getClass() = class com.hoonjin.study.java.lambda.lambda1.InstanceMain$1
        //procedure = com.hoonjin.study.java.lambda.lambda1.InstanceMain$1@7344699f
        //procedure2.getClass() = class com.hoonjin.study.java.lambda.lambda1.InstanceMain$$Lambda/0x0000007001001000
        //procedure2 = com.hoonjin.study.java.lambda.lambda1.InstanceMain$$Lambda/0x0000007001001000@8bcc55f
    }
}
