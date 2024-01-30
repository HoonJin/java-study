package com.hoonjin.study.java.basic.access.a;

public class AccessInnerMain {

    public static void main(String[] args) {
        AccessData data = new AccessData();

        // public access ok
        data.publicField = 1;
        data.publicMethod();

        // default access ok
        data.defaultField = 2;
        data.defaultMethod();

        // private access fail
        //data.privateField = 3;
        //data.privateMethod();

        data.innerAccess();
    }
}
