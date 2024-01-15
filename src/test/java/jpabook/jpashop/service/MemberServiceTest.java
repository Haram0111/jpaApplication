package jpabook.jpashop.service;

import jakarta.annotation.security.RunAs;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.respository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureHttpGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberServiceTest {

    @Autowired private MemberService memberService;
    @Autowired private MemberRepository memberRepository;

    @Test
    @Transactional
    public void 회원가입() throws Exception{
        //given
        Member member = new Member();
        member.setName("Kem");

        //when
        Long savedId = memberService.join(member);

        //then
        Assertions.assertEquals(member, memberService.findOne(savedId));
    }

    @Test
    public void 중복_회원_예외() throws Exception{
        //given

        //when

        //then
    }

}