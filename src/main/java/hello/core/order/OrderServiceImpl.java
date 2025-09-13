package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //이게 OCP를 위반한 상태임
    // MemberRepository는 추상클래스 (DiscountPolicy) 에도 의존 하고 있고 , 구체 클래스 (FixDiscountPolicy) 에도 의존 하고 있기 때문에
    // OCP를 위반한 상태가 됨 >> 클라이언트에서 코드 변경이 이루어짐.
    //  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //  private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


    // DIP를 지키면서 하려면 구체 클래스에 대한 객체를 생성 하지 않아야 하는데
    // discountPolicy가 정확하게 어떤 구체 클래스를 가르치는지 객체가 생성 되지 않았기 때문에 NPE 가 터짐
    // 그럼 여기서 누군가가 orderserviceImple ( 클라이언트 ) 대신에 구체 클래스를 대신 주입 해줘야함.
    private DiscountPolicy discountPolicy;


    @Override

    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
