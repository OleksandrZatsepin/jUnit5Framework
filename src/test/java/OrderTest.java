import model.Order;

import org.junit.jupiter.api.Test;

public class OrderTest extends BaseTest {

    @Test
    void shouldReturnUserByUsername() {
        final Order order = apiService.getOrderByValidId((long) 1);
        assert order.getId().equals((long) 1);
    }

    @Test
    void shouldBeAbleToAddOrder() {
        final Order defaultOrder = Order.getDefaultOrder();
        apiService.addOrder(defaultOrder);
    }

}
