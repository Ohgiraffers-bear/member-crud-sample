package ohgiraffers.springexample.service;

import lombok.AllArgsConstructor;
import ohgiraffers.springexample.aggregate.dto.member.*;
import ohgiraffers.springexample.aggregate.entity.Member;
import ohgiraffers.springexample.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {
    private MemberRepository memberRepository;

    // 회원 등록
    public JoinMemberResponse join(JoinMemberRequest joinMemberRequest) {

        Member member = Member.builder()
                .memberName(joinMemberRequest.getMemberName())
                .password(joinMemberRequest.getPassword())
                .build();

        Member savedMember = memberRepository.save(member);


        return new JoinMemberResponse(savedMember.getMemberNo(), savedMember.getMemberName());
    }

    // 회원 번호로 조회
    public FindMemberResponse findByNo(Long memberNo) {

        Member foundedMember = memberRepository.findByMemberNo(memberNo)
                .orElseThrow(() -> new IllegalArgumentException("🤖 해당 번호로 조회되는 회원이 없습니다. memberNo = " + memberNo));

        return new FindMemberResponse(foundedMember.getMemberNo(), foundedMember.getMemberName());
    }

    // 회원 정보 업데이트
    public UpdateMemberResponse update(Long memberNo, UpdateMemberRequest updateMemberRequest) {

        Member foundedMember = memberRepository.findByMemberNo(memberNo)
                .orElseThrow(() -> new IllegalArgumentException("🤖 해당 번호로 조회되는 회원이 없습니다. memberNo = " + memberNo));

        foundedMember.update(updateMemberRequest.getMemberName(), updateMemberRequest.getPassword());

        Member updatedMember = memberRepository.save(foundedMember);

        return new UpdateMemberResponse(updatedMember.getMemberNo(), updatedMember.getMemberName());
    }

    // 회원 삭제
    public DeleteMemberResponse delete(Long memberNo) {

        Member foundedMember = memberRepository.findByMemberNo(memberNo)
                .orElseThrow(() -> new IllegalArgumentException("🤖 해당 번호로 조회되는 회원이 없습니다. memberNo = " + memberNo));

        memberRepository.delete(foundedMember);

        String deleteMessage = "성공적으로 삭제되었습니다.";

        return new DeleteMemberResponse(foundedMember.getMemberNo(), foundedMember.getMemberName(), deleteMessage);
    }
}
