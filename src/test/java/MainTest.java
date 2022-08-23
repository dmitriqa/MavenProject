import org.testng.Assert;
import org.testng.annotations.Test;  //фреймворк - набор инструментов котрый мы будем использовать для чего-то.

public class MainTest {

    @Test
    void testGetSum() {
        int result;

        result = Main.getSum(10, 10);
        Assert.assertEquals(result, 20);

        result = Main.getSum(0, 0);
        Assert.assertEquals(result, 0);

        result = Main.getSum(-10, -10);
        Assert.assertEquals(result, -20);

        result = Main.getSum(0, 0);
        Assert.assertEquals(result, 0);

        result = Main.getSum(-10, 10);
        Assert.assertEquals(result, 0);
    }
}
