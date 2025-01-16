package com.hoonjin.study.java.ionetwork.network.tcp.autocloseable;

public class ResourceCloseMainV2 {

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
        ResourceV1 resource1 = null;
        ResourceV1 resource2 = null;

        try {
            resource1 = new ResourceV1("Resource1");
            resource2 = new ResourceV1("Resource2");

            resource1.call();
            resource2.callEx();
        } catch (CallException e) {
            System.out.println("e = " + e);
            throw e;
        } finally {
            System.out.println("자원 정리"); // 호출 불가
            if (resource2 != null) {
                resource2.closeEx(); // 여기서 예외가 터지면 resource1.closeEx(); 가 호출되지 않는다.
            }
            if (resource1 != null) {
                resource1.closeEx();
            }
        }
    }
}
