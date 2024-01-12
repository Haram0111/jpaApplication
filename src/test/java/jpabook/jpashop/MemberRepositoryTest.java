package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = JpashopApplication.class)
//springframwork에 있는 Transactional을 사용할 것, 테스트를 마치면 롤백함
//모든 데이터 변경은 트랜젝션 안에서 이루어져야 한다
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
//    @Transactional
//    @Rollback(false)
    public void testMember() throws Exception {
        //given
        Member member = new Member();
        member.setUsername("memberB");

        //when
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
    }
}