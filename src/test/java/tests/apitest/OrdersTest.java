package tests.apitest;

import model.Order;

import model.OrderStatus;
import model.Pet;
import model.PetStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import service.ApiException;
import tests.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Orders for pets tests")
public class OrdersTest extends BaseTest {

    static List<Order> orders = new ArrayList<>();
    @BeforeAll
    static void addTestOrders() throws ApiException {
        for (OrderStatus status : OrderStatus.values()) {
            Order order = Order.getDefaultOrder(status);
            orders.add(order);
            apiService.addOrder(order);
        }
    }

    @Disabled("Not working yet")
    @ParameterizedTest
    @MethodSource("getAllAvailableOrderStatuses")
    void shouldOnlyReturnOrdersByAvailableStatus(OrderStatus orderStatus) throws ApiException {
        List<Order> response = apiService.findOrdersByStatus(orderStatus);
        assertThat(response).hasSizeGreaterThan(0);
        assertThat(response).allMatch(order -> order.getStatus().equals(orderStatus));
    }
//    @Test
//    void shouldBeAbleToAddOrder() {
//        final Order defaultOrder = Order.getDefaultOrder();
//        apiService.addOrder(defaultOrder);
//    }

//    @Test
//    void shouldReturnOrderByValidId() {
//        final Order defaultOrder = apiService.getOrderByValidId((long) 1);
//        assert defaultOrder.getId().equals((long) 1);
//    }

    static Stream<OrderStatus> getAllAvailableOrderStatuses() {
        return Arrays.stream(OrderStatus.values());
    }
}
