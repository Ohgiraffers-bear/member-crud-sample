package ohgiraffers.springexample.aggregate.dto.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JoinMemberRequest {

    private String memberName;
    private String password;

}
