
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
/*import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;*/
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class RunTimeComplier {
	
	public static Object loadAndCompile() {
		
		Object returnObject = null;
		Reader reader = null;
		Writer writer = null;
		StandardJavaFileManager fileManager = null;
		
		try {
		
			// ### create a java file with user's solution
			
			// read the user input and put in a string
			String projectBasePath = new File("").getAbsolutePath().concat("/LeetCodeClone");
			String sourcePath = projectBasePath.concat("/src/main/java");
			String solutionFilePath = sourcePath.concat("/Solution.txt");
			reader = new FileReader(solutionFilePath);
			int data = reader.read();
			StringBuilder inputString = new StringBuilder();
			while(data != -1){
			  inputString.append((char) data);
			  data = reader.read();
			}
			// create a new file with the string
			File javaFile = new File(sourcePath.concat("/Solution.java"));
            writer = new FileWriter(javaFile);
            writer.write(inputString.toString());
            writer.flush();
            
            
            // ### compile the java file in the runtime
            
            // create a compiler
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
            fileManager = compiler.getStandardFileManager(diagnostics, null, null);
            // create a option list for running the compiler
            List<String> optionList = new ArrayList<String>();
            String binPath = projectBasePath.concat("/target");
            optionList.add("-d");
            optionList.add(binPath);
            //optionList.add("-classpath");
            //optionList.add("D:/app/workplace/MiniProject/bin/app/leetcode_engin_clone/");
            
            // assemble the to-compile unit
	        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(Arrays.asList(javaFile));
	        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, optionList, null, compilationUnits);
			
	        // execute the compilation
			if (task.call()) {
                // load and execute
                //System.out.println("ready to load and execute");
                // create a new custom class loader, pointing to the directory that contains the compiled classes
                URLClassLoader classLoader = new URLClassLoader(new URL[]{new File(sourcePath).toURI().toURL()});
                //System.out.println(classLoader.getURLs()[0].toString());
                // load the class from the class loader by name....
                Class<?> loadedClass = classLoader.loadClass("Solution");
                //System.out.println("after loading class");
                // create a new instance...
                returnObject = loadedClass.newInstance();
                
                // test script for invoke the method by name
/*                try {
					Method method = returnObject.getClass().getMethod("reverseString", String.class);
					try {
						System.out.println(method.invoke(returnObject, "123"));
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}*/
                
                classLoader.close();
            } else {
                for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
                    System.out.format("Error on line %d in %s%n",
                            diagnostic.getLineNumber(),
                            diagnostic.getSource().toUri());
                    System.out.println(diagnostic.getCode());
                }
            }
		} catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				writer.close();
				fileManager.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return returnObject;
	}
}
