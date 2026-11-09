import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemServiceTest {
    private ItemService service;

    @BeforeEach
    public void setUp() {
        service = new ItemService();
    }

    @Test
    public void testAddingIncreasesCount() {
        assertEquals(0, service.getCount()); 
        
        service.addItem(new Item("New Item"));
        
        assertEquals(1, service.getCount()); 
    }

    @Test
    public void testInvalidActionThrows() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.addItem(new Item(""));
        });
        
        assertEquals("Item name cannot be empty!", exception.getMessage());
    }
}