
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/*Design and implement a "Code Problem Test Engine" similar to Leetcode.

- it defines an interface for solving code challenge
- it allows problem admin to create problems and test cases
- it takes user's code as input and shows whether it passes or fails the tests
- Stretch: show error trace message
- Stretch: take user defined input parameter for test run*/

// defined by system admin
public class Engine {

	public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestCase.class);
        if (result.wasSuccessful()) {
        	System.out.println("Your answer is correct.");
        } else {
        	System.out.println("Your answer is wrong.");
        	// print out the first failure message
        	if (!result.getFailures().isEmpty()) {
        		System.out.println(result.getFailures().get(0).getMessage());
        	}
        }
	}
	
}
