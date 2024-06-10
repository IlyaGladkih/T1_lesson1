package ru.test.lesson1.aspects;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.test.lesson1.entity.MethodTrack;
import ru.test.lesson1.service.SaveMethodStatisticService;

import java.util.concurrent.CompletableFuture;

@Component
@Aspect
@Slf4j
@Order(1)
@RequiredArgsConstructor
public class AsyncTrackTimeAspect {

    private final SaveMethodStatisticService service;

    @Around("@annotation(ru.test.lesson1.annotations.TrackAsyncTime)")
    public Object trackTimeAsync(ProceedingJoinPoint joinPoint) throws Throwable {

        long time = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long resultTime = System.currentTimeMillis() - time;

        CompletableFuture.runAsync(()->saveResult(joinPoint,resultTime));

        return result;
    }

    private void saveResult(ProceedingJoinPoint joinPoint, long resultTime){

        log.info("Async aspect save data");

        MethodTrack build = getMethodTrack(joinPoint, resultTime);

        this.saveData(build);

        log.info(build.toString());
    }

    private MethodTrack getMethodTrack(ProceedingJoinPoint joinPoint, long resultTime) {
        return MethodTrack.builder()
                .methodName(joinPoint.getSignature().getName())
                .annotationAboveMethod("TrackAsyncTime")
                .className(joinPoint.getSignature().getDeclaringTypeName())
                .workTime(resultTime)
                .build();
    }


    private void saveData(MethodTrack data){
        service.saveStatistic(data);
    }

}
