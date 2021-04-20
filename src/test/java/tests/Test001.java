package tests;

import base.TestRunner;
import org.testng.annotations.Test;
import utils.logger.Log;

public class Test001 extends TestRunner {

    @Test
    public void test_001(){
        Log.info("Test 1");
    }

}
