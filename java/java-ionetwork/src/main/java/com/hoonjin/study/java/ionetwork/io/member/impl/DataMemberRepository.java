package com.hoonjin.study.java.ionetwork.io.member.impl;

import com.hoonjin.study.java.ionetwork.io.member.Member;
import com.hoonjin.study.java.ionetwork.io.member.MemberRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "java/java-ionetwork/temp/members-data.dat";

    @Override
    public void add(Member member) {
        try (FileOutputStream fos = new FileOutputStream(FILE_PATH, true);
             DataOutputStream dos = new DataOutputStream(fos)) {
            dos.writeUTF(member.getId());
            dos.writeUTF(member.getName());
            dos.writeInt(member.getAge());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             DataInputStream dis = new DataInputStream(fis)) {
            ArrayList<Member> members = new ArrayList<>();

            while (dis.available() > 0) {
                Member member = new Member(dis.readUTF(), dis.readUTF(), dis.readInt());
                members.add(member);
            }
            return members;
        } catch (FileNotFoundException e) {
            return List.of();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
