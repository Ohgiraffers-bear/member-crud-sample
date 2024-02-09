package ohgiraffers.springexample.service;

import lombok.AllArgsConstructor;
import ohgiraffers.springexample.aggregate.dto.member.JoinMemberRequest;
import ohgiraffers.springexample.aggregate.dto.member.JoinMemberResponse;
import ohgiraffers.springexample.aggregate.entity.Member;
import ohgiraffers.springexample.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {
    private MemberRepository memberRepository;

    public JoinMemberResponse join(JoinMemberRequest joinMemberRequest) {

        Member member = Member.builder()
                .memberName(joinMemberRequest.getMemberName())
                .password(joinMemberRequest.getPassword())
                .build();

        Member savedMember = memberRepository.save(member);


        return new JoinMemberResponse(savedMember.getMemberNo(), savedMember.getMemberName());
    }
}
