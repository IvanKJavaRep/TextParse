package personal.ivan.spring.aspectAroundPointCutAnnotations;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


//не понял, зачем нужны эти аннотации.
@Aspect
@Component
public class StereotypeAnnotations {
    @Pointcut("within(@org.springframework.stereotype.Repository *)")
    public void execute() {
    }

    @Around("execute()")
    public Object testMethod(ProceedingJoinPoint joinPoint)
            throws Throwable {
        long start = System.nanoTime();
        Object returnValue = joinPoint.proceed();
        long end = System.nanoTime();
        String methodName = joinPoint.getSignature().getName();
        System.out.println(
                "Execution of " + methodName + " took " +
                        TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
        return returnValue;
    }
}
