package aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author antoan
 */
@Aspect
@Component
public class VerifyAspect {

	@Before("execution(* set*(..))")
	public void authorizeBefore() {
		System.err.println("GET METHODS AUTHORIZED");
	}

}
