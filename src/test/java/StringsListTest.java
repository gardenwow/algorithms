import org.example.StringListImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class StringsListTest {
    private StringListImpl stringList = new StringListImpl();


    @Test
    private void addStringListTest(){
        stringList.add(2, "poka");
        Assertions.assertEquals("poka", stringList.get(2));



    }
}
