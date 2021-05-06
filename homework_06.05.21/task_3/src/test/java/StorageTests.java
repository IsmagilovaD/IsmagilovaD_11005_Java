
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StorageTests {
    private Storage storage;
    private OrdersRuntimeSaver saver;

    @Before
    public void prepareOrders() {
        saver = new OrdersRuntimeSaver();
        saver.orders.add(new Order("chair", 10));
        saver.orders.add(new Order("table", 5));
        storage = new Storage(saver);
    }

    @Test
    public void createNewOrderTest() {

        storage.createNewOrder("phone", 15);

        assertEquals(3, saver.orders.size());
        assertEquals("phone", saver.orders.get(2).name);
        assertEquals(15, saver.orders.get(2).count);
    }

    @Test
    public void getOrderTestSucceed() {

        Order p = storage.getOrder("table");

        assertNotNull(p);
        assertEquals("table", p.name);
        assertEquals(5, p.count);
    }

    @Test
    public void getOrderTestFailed() {

        Order p = storage.getOrder("phone");

        assertNull(p);
    }

    @Test
    public void deleteOrderTestSucceed() {

        storage.deleteOrder("table");

        assertEquals(1, saver.orders.size());
    }

    @Test
    public void deleteOrderTestFailed() {

        storage.deleteOrder("cake");

        assertEquals(2, saver.orders.size());
    }

    @Test
    public void changeQuantityTestSucceed() {

        Order p = storage.getOrder("chair");
        p.setCount(5);

        assertEquals(5, p.count);
    }

    @Test
    public void changeQuantityTestFailed() {

        storage.changeOrder("apple", 10);
        Order p = storage.getOrder("apple");
        assertNull(p);
    }
}
