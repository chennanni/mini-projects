
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Method;

public class TestCaseBase {
	
	static SolutionInterface solution;
	
	public static SolutionInterface getSolution() {
		return solution;
	}
	
	@BeforeClass
	public static void setUp() {
		solution = (SolutionInterface) RunTimeComplier.loadAndCompile();
	}
	
	@Test
	public void testImplementSolutionInterface() {
        try {
            Class<?> userImplementedClass = solution.getClass();
            Method userImplementedMethod = userImplementedClass.getMethod("reverseString", String.class); // method name + method parameter
            Class<?> userImplementedReturnType = userImplementedMethod.getReturnType();
            assertTrue("method returns the wrong type.", userImplementedReturnType.equals(String.class));
        } catch (NoSuchMethodException | SecurityException e) {
            fail("method is missing.");
        }
	}
	
}
