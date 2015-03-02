

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ch.iMampf.controller.IndexControllerTest;
import ch.iMampf.controller.UserControllerTest;
import ch.iMampf.service.UserTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
   UserTest.class,
   UserControllerTest.class,
   IndexControllerTest.class
})
public class TestSuite {   
} 