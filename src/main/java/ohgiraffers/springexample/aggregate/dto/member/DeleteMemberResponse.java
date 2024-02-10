package ohgiraffers.springexample.aggregate.dto.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteMemberResponse {

    private Long memberNo;
    private String memberName;
    private String deleteMessage;
}
