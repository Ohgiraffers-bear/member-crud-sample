package ohgiraffers.springexample.controller;

import lombok.RequiredArgsConstructor;
import ohgiraffers.springexample.aggregate.dto.member.*;
import ohgiraffers.springexample.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<JoinMemberResponse> joinMember(@RequestBody JoinMemberRequest joinMemberRequest) {

        JoinMemberResponse joinMemberResponse = memberService.join(joinMemberRequest);

        return ResponseEntity.ok(joinMemberResponse);
    }

    @GetMapping("/{memberNo}")
    public ResponseEntity<FindMemberResponse> findMember(@PathVariable Long memberNo) {

        FindMemberResponse findMemberResponse = memberService.findByNo(memberNo);

        return ResponseEntity.ok(findMemberResponse);
    }

    @PutMapping("/{memberNo}")
    public ResponseEntity<UpdateMemberResponse> updateMember(@PathVariable Long memberNo, @RequestBody UpdateMemberRequest updateMemberRequest) {

        UpdateMemberResponse updateMemberResponse = memberService.update(memberNo, updateMemberRequest);

        return ResponseEntity.ok(updateMemberResponse);
    }

    @DeleteMapping("/{memberNo}")
    public ResponseEntity<DeleteMemberResponse> deleteMember(@PathVariable Long memberNo) {

        DeleteMemberResponse deleteMemberResponse = memberService.delete(memberNo);

        return ResponseEntity.ok(deleteMemberResponse);
    }
}
