package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class MemoryMemberRepository implements MemberRepository {
    //저장소?
    private static final Map<Long,Member> store = new HashMap<>();

    @Override
    public Member findById(Long id) {
        return store.get(id);
    }

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }
}
