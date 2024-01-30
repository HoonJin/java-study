package com.hoonjin.study.java.basic.access.b;

import com.hoonjin.study.java.basic.access.a.AccessData;

public class AccessOuterMain {

    public static void main(String[] args) {
        AccessData data = new AccessData();

        // public access ok
        data.publicField = 1;
        data.publicMethod();

        // default access fail
        //data.defaultField = 2;
        //data.defaultMethod();

        // private access fail
        //data.privateField = 3;
        //data.privateMethod();

        data.innerAccess();
    }
}
