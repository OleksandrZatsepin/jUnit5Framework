import model.Order;

import org.junit.jupiter.api.Test;

public class OrderTest extends BaseTest {

    @Test
    void shouldBeAbleToAddOrder() {
        final Order defaultOrder = Order.getDefaultOrder();
        apiService.addOrder(defaultOrder);
    }

    @Test
    void shouldReturnOrderByValidId() {
        final Order defaultOrder = apiService.getOrderByValidId((long) 1);
        assert defaultOrder.getId().equals((long) 1);
    }

}
