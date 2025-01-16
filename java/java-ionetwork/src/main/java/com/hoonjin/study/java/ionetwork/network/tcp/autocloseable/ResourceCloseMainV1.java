package com.hoonjin.study.java.ionetwork.network.tcp.autocloseable;

public class ResourceCloseMainV1 {

    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 처리");
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException 처리");
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CallException, CloseException {
        ResourceV1 resource1 = new ResourceV1("Resource1");
        ResourceV1 resource2 = new ResourceV1("Resource2");

        resource1.call();
        resource2.callEx();

        System.out.println("자원 정리"); // 호출 불가
        resource2.closeEx();
        resource1.closeEx();
    }
}
