package com.bookitaka.NodeulProject.member.repository;

import com.bookitaka.NodeulProject.member.model.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {

  boolean existsByMemberEmail(String memberEmail);

  boolean existsByMemberEmailAndMemberName(String memberEmail, String memberName);

  Member findByMemberEmail(String memberEmail);

  @Transactional
  void deleteByMemberEmail(String memberEmail);

  List<Member> findByMemberName(String memberName);

  Page<Member> findByMemberEmailContainingAndMemberEmailNot(String keyword, String excludedMemberEmail, Pageable pageable);
  Page<Member> findByMemberNameContainingAndMemberEmailNot(String keyword, String excludedMemberEmail, Pageable pageable);
  Page<Member> findByMemberEmailContainingAndMemberNameContainingAndMemberEmailNot(String memberEmail, String memberName, String excludedMemberEmail, Pageable pageable);
  Page<Member> findByMemberEmailNot(String memberEmail, Pageable pageable);
}
