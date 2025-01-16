package com.hoonjin.study.java.ionetwork.network.tcp.autocloseable;

public class ResourceCloseMainV4 {

    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 처리");

            // 핵심 예외 안에 close 시 발생한 익셉션을 suppress 해서 넣어둠
            Throwable[] suppressed = e.getSuppressed();
            for (Throwable throwable : suppressed) {
                System.out.println("suppressed = " + throwable);
            }

            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException 처리");
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CallException, CloseException {
        // try with resources 에서 익셉션 발생시 우선 자원 정리 후 catch 를 처리한다.
        try (ResourceV2 resource1 = new ResourceV2("Resource1");
             ResourceV2 resource2 = new ResourceV2("Resource2")) {

            resource1.call();
            resource2.callEx();
        } catch (CallException e) {
            System.out.println("e = " + e);
            throw e;
        }
    }
}
