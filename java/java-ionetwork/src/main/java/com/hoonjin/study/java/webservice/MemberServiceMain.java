package com.hoonjin.study.java.webservice;

import com.hoonjin.study.java.ionetwork.io.member.MemberRepository;
import com.hoonjin.study.java.ionetwork.io.member.impl.FileMemberRepository;
import com.hoonjin.study.java.was.httpserver.HttpServer;
import com.hoonjin.study.java.was.httpserver.HttpServlet;
import com.hoonjin.study.java.was.httpserver.ServletManager;
import com.hoonjin.study.java.was.httpserver.annotation.AnnotationServletV3;
import com.hoonjin.study.java.was.httpserver.servlet.DiscardServlet;

import java.io.IOException;
import java.util.List;

public class MemberServiceMain {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        MemberRepository memberRepository = new FileMemberRepository();
        MemberController memberController = new MemberController(memberRepository);
        HttpServlet annotationServlet = new AnnotationServletV3(List.of(memberController));
        ServletManager servletManager = new ServletManager();
        servletManager.add("/favicon.ico", new DiscardServlet());
        servletManager.setDefaultServlet(annotationServlet);

        HttpServer httpServer = new HttpServer(PORT, servletManager);
        httpServer.start();
    }
}
