package hello.core.order;

public interface OrderService {
    Order cteateOrder(Long memberId, String itemName, int itemPrice);
}
