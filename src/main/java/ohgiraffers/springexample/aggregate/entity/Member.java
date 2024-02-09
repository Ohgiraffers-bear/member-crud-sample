package ohgiraffers.springexample.aggregate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Builder
@Table(name = "member_tb")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    private long memberNo;

    private String memberName;

    private String password;

    public Member(long memberNo, String memberName, String password) {
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.password = password;
    }
}
