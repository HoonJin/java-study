package com.hoonjin.study.java.webservice;

import com.hoonjin.study.java.ionetwork.io.member.Member;
import com.hoonjin.study.java.ionetwork.io.member.MemberRepository;
import com.hoonjin.study.java.was.httpserver.HttpRequest;
import com.hoonjin.study.java.was.httpserver.HttpResponse;
import com.hoonjin.study.java.was.httpserver.annotation.Mapping;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.hoonjin.study.java.util.MyLogger.log;

@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @Mapping("/")
    public void home(HttpResponse response) {
        String body = "<html><body>" +
            "<h1>Member Manager</h1>" +
            "<ul>" +
            "<li><a href='/members'>Member List</a></li>" +
            "<li><a href='/add-member-form'>Add New Member</a></li>" +
            "</ul>" +
            "</body></html>";
        response.writeBody(body);
    }

    @Mapping("/members")
    public void members(HttpResponse response) {
        List<Member> members = memberRepository.findAll();

        StringBuilder body = new StringBuilder();
        body.append("<html><body>");

        body.append("<h1>Member List</h1>");
        body.append("<ul>");

        for (Member member : members) {
            body.append("<li>")
                .append("ID: ").append(member.getId())
                .append(", NAME: ").append(member.getName())
                .append(", AGE: ").append(member.getAge())
                .append("</li>");
        }

        body.append("</ul>");
        body.append("<a href='/'>Back To Home</a>");
        body.append("</body></html>");
        response.writeBody(body.toString());
    }

    @Mapping("/add-member-form")
    public void addMemberForm(HttpResponse response) {
        String body = "<html><body>" +
            "<h1>Add New Member</h1>" +
            "<form method='POST' action='/add-member'>" +
            "ID: <input type='text' name='id' /><br />" +
            "NAME: <input type='text' name='name' /><br />" +
            "AGE: <input type='text' name='age' /><br />" +
            "<input type='submit' value='add' />" +
            "</form>" +
            "<a href='/'>Back To Home</a>" +
            "</body></html>";
        response.writeBody(body);
    }

    @Mapping("/add-member")
    public void addMember(HttpRequest request, HttpResponse response) {
        log("request = " + request);
        String id = request.getBody("id");
        String name = request.getBody("name");
        int age = Integer.parseInt(request.getBody("age"));

        Member member = new Member(id, name, age);
        memberRepository.add(member);

        String body = "<html><body>" +
            "<h1>Save OK</h1>" +
            "<a href='/'>Back To Home</a>" +
            "</body></html>";
        response.writeBody(body);
    }
}
