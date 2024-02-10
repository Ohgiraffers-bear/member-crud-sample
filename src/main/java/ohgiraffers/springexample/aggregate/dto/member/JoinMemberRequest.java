package ohgiraffers.springexample.aggregate.dto.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JoinMemberRequest {

    private String memberName;
    private String password;

}
