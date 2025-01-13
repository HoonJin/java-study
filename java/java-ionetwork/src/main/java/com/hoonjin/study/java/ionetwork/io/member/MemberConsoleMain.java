package com.hoonjin.study.java.ionetwork.io.member;

import com.hoonjin.study.java.ionetwork.io.member.impl.DataMemberRepository;
import com.hoonjin.study.java.ionetwork.io.member.impl.FileMemberRepository;
import com.hoonjin.study.java.ionetwork.io.member.impl.MemoryMemberRepository;
import com.hoonjin.study.java.ionetwork.io.member.impl.ObjectMemberRepository;

import java.util.List;
import java.util.Scanner;

public class MemberConsoleMain {

//    private static final MemberRepository memberRepository = new MemoryMemberRepository();
//    private static final MemberRepository memberRepository = new FileMemberRepository();
//    private static final MemberRepository memberRepository = new DataMemberRepository();
    private static final MemberRepository memberRepository = new ObjectMemberRepository();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. 회원등록 | 2. 회원목록 조회 | 3. 종료");
            System.out.print("input: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // newline 제거

            switch (choice) {
                case 1:
                    registerMember(scanner);
                    break;
                case 2:
                    displayMembers();
                    break;
                case 3:
                    System.out.println("종료");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private static void registerMember(Scanner scanner) {
        System.out.print("아이디 입력: ");
        String id = scanner.nextLine();
        System.out.print("이름 입력: ");
        String name = scanner.nextLine();
        System.out.print("나이 입력: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        Member newMember = new Member(id, name, age);
        memberRepository.add(newMember);
    }

    private static void displayMembers() {
        List<Member> members = memberRepository.findAll();
        members.forEach(member ->
            System.out.printf("[ID: %s, Name: %s, Age, %d]\n", member.getId(), member.getName(), member.getAge())
        );
    }
}
