package generic_utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class ITransform implements IAnnotationTransformer {
	public void tranform(ITestAnnotation annotation,Class testClass,Constructor testConstructor, Method testMehod) {
		annotation.setRetryAnalyzer(generic_utilities.RetryAnalyserImplementation.class);
		
	}

}
