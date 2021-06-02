import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CRUDHolderMethodsTest {
    private CRUDHolder<Order> holder;

    @Before
    public void prepareOrders() {
        holder = new CRUDHolder<Order>();
        holder.items.add(new Order("chair", 10));
        holder.items.add(new Order("table", 5));
        holder.items.add(new Order("phone", 18));
        holder.items.add(new Order("notebook", 3));
        holder.items.add(new Order("apple", 8));
    }

    @Test
    public void readTestSucceed() {
        Order order = holder.read(2);
        assertEquals(holder.items.get(2), order);
    }

    @Test(expected = IllegalArgumentException.class)
    public void readTestFailed() {
        Order order = holder.read(18);
    }

    @Test
    public void createTestSucceed() {

        holder.create(new Order("bottle", 6));

        assertEquals(6, holder.items.size());
        assertEquals("bottle", holder.items.get(5).name);
        assertEquals(6, holder.items.get(5).value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTestFailed() {
        holder.create(new Order("chair", 10));
    }

    @Test
    public void updateTestSucceed() {
        holder.update(new Order("chair", 20));

        assertEquals(5, holder.items.size());
        assertEquals("chair", holder.items.get(0).name);
        assertEquals(20, holder.items.get(0).value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateTestFailed() {
        holder.update(new Order("pen", 900));
    }

    @Test
    public void deleteTestSucceed() {
        holder.delete(new Order("chair", 8));

        assertEquals(4, holder.items.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteTestFailed() {
        holder.delete(new Order("lamp", 1));
    }

}

