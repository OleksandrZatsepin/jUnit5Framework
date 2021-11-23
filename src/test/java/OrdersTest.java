import model.ApiResponse;
import model.Order;
import model.OrderStatus;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.provider.ValueSource;
import service.ApiException;

import static constant.HTTPStatusCodes.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Order tests:")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrdersTest extends BaseTest {

    @DisplayName("Add Orders with different statuses")
    @org.junit.jupiter.api.Order(1)
    @ParameterizedTest
    @EnumSource(OrderStatus.class)
    void shouldReturnOrdersWithAvailableStatus(OrderStatus orderStatus) throws ApiException {
        Order response = apiService.addOrder(Order.getDefaultOrder(orderStatus));
        assertThat(response).matches(order -> order.getStatus().equals(response.getStatus()));
        System.out.println("Order with Id " + response.getId().toString() + " for pet with petId " + response.getPetId().toString() + " was created successfully");
    }

    @DisplayName("Add Orders with test orderId >= 1 and <= 10")
    @org.junit.jupiter.api.Order(2)
    @ParameterizedTest
    @ValueSource(longs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void shouldReturnOrdersWithTestId(Long orderId) throws ApiException {
        Order testOrder = Order.getDefaultOrder();
        testOrder.setId(orderId);
        Order response = apiService.addOrder(testOrder);
        assertThat(response).matches(order -> order.getId().equals(response.getId()));
        System.out.println("Order with Id " + response.getId().toString() + " was created successfully");
    }

    @DisplayName("Find Test Orders with orderId >= 1 and <= 10")
    @org.junit.jupiter.api.Order(3)
    @ParameterizedTest
    @ValueSource(longs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void shouldFindOrdersWithTestId(Long orderId) throws ApiException {
        Order response = apiService.findOrderById(orderId);
        assertThat(response).matches(order -> order.getId().equals(response.getId()));
        System.out.println("Order with Id " + response.getId().toString() + " was found successfully");
    }

    @DisplayName("Remove Test Orders with orderId >= 1 and <= 10")
    @org.junit.jupiter.api.Order(4)
    @ParameterizedTest
    @ValueSource(longs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void shouldDeleteOrdersWithTestId(Long orderId) throws ApiException {
        ApiResponse response = apiService.removeOrderById(orderId);
        assertThat(response.getCode()).isEqualTo(STATUS_CODE_OK);
        System.out.println("Order with Id " + response.getMessage() + " was removed successfully");
    }

    @DisplayName("Throws exception, when try to remove random Order")
    @org.junit.jupiter.api.Order(5)
    @Test
    void shouldThrowExceptionWhenTryRemoveRandomOrder() {
        Order order = Order.getDefaultOrder();
        assertThrows(ApiException.class, () -> apiService.removeOrderById(order.getId()), "throws when Order not found");
        System.out.println("Test Order with orderId " + order.getId() + " was not found");
    }
}
