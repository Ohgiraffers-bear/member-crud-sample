package ohgiraffers.springexample.repository;

import ohgiraffers.springexample.aggregate.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByMemberNo(Long memberNo);
}
