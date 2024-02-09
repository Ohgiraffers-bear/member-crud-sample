package ohgiraffers.springexample.aggregate.dto.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JoinMemberResponse {

    private long memberId;
    private String memberName;

    public JoinMemberResponse(long memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
    }
}
