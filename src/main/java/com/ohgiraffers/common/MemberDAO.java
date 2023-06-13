package com.ohgiraffers.common;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberDAO {

    private final Map<Integer, Member> memberMap;

    public MemberDAO() {
        this.memberMap = new HashMap<>();

        this.memberMap.put(1, new Member(1, "user01", "pass01", "남효정"));
        this.memberMap.put(2, new Member(2, "user02", "pass02", "효뎡"));

    }

    public Member findMemberBySequence(int sequence) {

        return memberMap.get(sequence);
    }

    public boolean save(Member member) {

        int before = memberMap.size();

        memberMap.put(member.getSequence(), member);

        int after = memberMap.size();

        return after > before ? true:false;
    }
}
