package dependency_injection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyDIApplicationJUnitTest {
    private MessageServiceInjector injector;
    @Before
    public void setUp(){
        //mock the injector with anonymous class
        injector = () -> {
            //mock the message service
            return new MyDIApplication((msg, rec) -> System.out.println("Mock Message Service implementation"));
        };
    }

    @Test
    public void test() {
        Consumer consumer = injector.getConsumer();
        consumer.processMessages("Hi Pankaj", "pankaj@abc.com");
    }

    @After
    public void tear(){
        injector = null;
    }
}
