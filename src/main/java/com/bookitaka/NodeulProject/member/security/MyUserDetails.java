package com.bookitaka.NodeulProject.member.security;

import com.bookitaka.NodeulProject.member.model.Member;
import com.bookitaka.NodeulProject.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetails implements UserDetailsService {

  private final MemberRepository memberRepository;

  @Override
  public UserDetails loadUserByUsername(String memberEmail) throws UsernameNotFoundException {
    final Member member = memberRepository.findByMemberEmail(memberEmail);

    if (member == null) {
      throw new UsernameNotFoundException("Member '" + memberEmail + "' not found");
    }

    return org.springframework.security.core.userdetails.User//
        .withUsername(memberEmail)//
        .password(member.getMemberPassword())//
        .authorities(member.getMemberRole())//
        .accountExpired(false)//
        .accountLocked(false)//
        .credentialsExpired(false)//
        .disabled(false)//
        .build();
  }

}
