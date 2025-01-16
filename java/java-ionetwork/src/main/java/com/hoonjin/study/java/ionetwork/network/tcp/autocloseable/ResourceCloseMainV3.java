package com.hoonjin.study.java.ionetwork.network.tcp.autocloseable;

public class ResourceCloseMainV3 {

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
                try {
                    resource2.closeEx();
                } catch (CloseException e) { // close 예외는 걍 버리고 로그만 남긴다.
                    System.out.println("close ex = " + e);
                }
            }
            if (resource1 != null) {
                try {
                    resource1.closeEx();
                } catch (CloseException e) {
                    System.out.println("close ex = " + e);
                }
            }
        }
    }
}
