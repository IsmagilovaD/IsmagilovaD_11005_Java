import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileSaverTests {
    private OrdersFileSaver saver;
    private ArrayList<Order> products;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void openFile() throws IOException {
        File f = folder.newFile();
        saver = new OrdersFileSaver(f);

        products = new ArrayList<>();
        products.add(new Order("chair", 10));
        products.add(new Order("table", 5));
    }

    @Test
    public void readWriteProductsTest() {
        saver.saveOrders(products);
        List<Order> temp = saver.getOrders();

        assertEquals(products.size(), temp.size());

        for (int i = 0; i < products.size(); i++) {
            assertEquals(products.get(i).name, temp.get(i).name);
            assertEquals(products.get(i).count, temp.get(i).count);
        }
    }
}
