

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ch.iEat.controller.IndexControllerTest;
import ch.iEat.controller.UserControllerTest;
import ch.iEat.service.UserTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
   UserTest.class,
   UserControllerTest.class,
   IndexControllerTest.class
})
public class TestSuite {   
} 