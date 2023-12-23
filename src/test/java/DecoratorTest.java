import com.example.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class DecoratorTest {

    @Test
    public void testPaperDecorator() {
        Item item = new Flower();
        Item ribbonItem = new RibbonDecorator(item);
        Item paperDecoratedItem = new PaperDecorator(ribbonItem);         
        assertEquals("A flower with Ribbon with Paper", paperDecoratedItem.getDescription());
        assertEquals(63.0, paperDecoratedItem.price(), 0.01);
    }
}
