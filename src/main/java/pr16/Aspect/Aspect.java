package pr16.Aspect;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    @Around("@annotation(LogExecutionTime)")
    Object showExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable
    {
        long startTime=System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long endTime=System.currentTimeMillis()-startTime;

        log.info(joinPoint.getSignature().getName()+" executed in "+endTime+" ms");

        return proceed;
    }
}
