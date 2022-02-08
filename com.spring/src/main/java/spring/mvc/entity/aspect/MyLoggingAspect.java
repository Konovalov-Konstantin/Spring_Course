package spring.mvc.entity.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {
    @Around("execution( * spring.mvc.entity.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methoName = methodSignature.getName();
        System.out.println("Begin of " + methoName);

        Object targetMethodResult = proceedingJoinPoint.proceed();

        System.out.println("End of " + methoName);

        return targetMethodResult;
    }
}
