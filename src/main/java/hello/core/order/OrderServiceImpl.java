package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order cteateOrder(Long memberId, String itemName, int itemPrice) {
        Member byId = memberRepository.findById(memberId);
        int discount = discountPolicy.discount(byId, itemPrice);

        return new Order(memberId, itemName, itemPrice, discount);
    }
}