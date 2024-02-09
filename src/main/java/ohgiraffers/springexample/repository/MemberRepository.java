package ohgiraffers.springexample.repository;

import ohgiraffers.springexample.aggregate.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
