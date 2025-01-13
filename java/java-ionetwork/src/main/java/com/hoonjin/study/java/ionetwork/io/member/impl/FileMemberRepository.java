package com.hoonjin.study.java.ionetwork.io.member.impl;

import com.hoonjin.study.java.ionetwork.io.member.Member;
import com.hoonjin.study.java.ionetwork.io.member.MemberRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FileMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "java/java-ionetwork/temp/members-txt.dat";
    private static final String DELIMITER = ",";

    @Override
    public void add(Member member) {
        try (FileWriter fw = new FileWriter(FILE_PATH, UTF_8, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(member.getId() + DELIMITER + member.getName() + DELIMITER + member.getAge());
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        try (FileReader fs = new FileReader(FILE_PATH, UTF_8);
             BufferedReader reader = new BufferedReader(fs)) {
            ArrayList<Member> members = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] elements = line.split(DELIMITER);
                Member member = new Member(elements[0], elements[1], Integer.valueOf(elements[2]));
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
