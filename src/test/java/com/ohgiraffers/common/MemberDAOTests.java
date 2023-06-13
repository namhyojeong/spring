package com.ohgiraffers.common;

import com.ohgiraffers.java.ContextConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.lang.module.Configuration;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = {ContextConfiguration.class})
public class MemberDAOTests {

    @Autowired
    private MemberDAO memberDAO;

    @Test
    public void testCreatedMemberDAO() {

        assertNotNull(memberDAO);
    }

    @Test
    public void testFindMemberBySequence() {

        int sequence = 1;
        Member findMember = memberDAO.findMemberBySequence(sequence);
        assertEquals("남효정", findMember.getName());
    }

    @Test
    public void testSave() {

        Member member = new Member(3, "user05", "pass05", "효뎡이짱");
        boolean result = memberDAO.save(member);
        assertTrue(result);
    }

}
