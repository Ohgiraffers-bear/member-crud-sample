package ohgiraffers.springexample.controller;

import ohgiraffers.springexample.aggregate.dto.member.JoinMemberResponse;
import ohgiraffers.springexample.aggregate.dto.member.JoinMemberRequest;
import ohgiraffers.springexample.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    private MemberService memberService;

    @PostMapping
    public ResponseEntity<JoinMemberResponse> joinMember(@RequestBody JoinMemberRequest joinMemberRequest) {

        JoinMemberResponse joinMemberResponse = memberService.join(joinMemberRequest);

        return ResponseEntity.ok(joinMemberResponse);
    }
}
