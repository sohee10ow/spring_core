package hello.core.member;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    // ⭐️ MemberRepository 에 뭐가 들어갈지를 생성자를 통해서 선택을 할거임 (생성자 주입)
    // Appconfig 쪽에 MemoryMemberRepository를 파라미터로 넣어줬기 때문에
    // memberRepository = MemoryMemberRepository 가 되고 할당이 됨.

    //⭐️ 추상화에서만 의존하게 됨. >>
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findeMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //Test 용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
