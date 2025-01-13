package com.hoonjin.study.java.ionetwork.io.member.impl;

import com.hoonjin.study.java.ionetwork.io.member.Member;
import com.hoonjin.study.java.ionetwork.io.member.MemberRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Serializable 마커 인터페이스를 붙인 객체에 사용할 수 있는데, 쓰지 말자! (version 이슈 등 문제점들이 있음)
public class ObjectMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "java/java-ionetwork/temp/members-object.dat";

    @Override
    public void add(Member member) {
        List<Member> members = findAll();
        members.add(member);

        try (FileOutputStream fos = new FileOutputStream(FILE_PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(members);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (List<Member>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>(); // List.of() 는 add가 불가한 immutable list
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
