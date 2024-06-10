package ru.test.lesson1.aspects;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.test.lesson1.entity.MethodTrack;
import ru.test.lesson1.service.SaveMethodStatisticService;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Component
@Aspect
@Slf4j
@Order(1)
@RequiredArgsConstructor
public class TrackTimeAspect {

    private final SaveMethodStatisticService saveMethodStatisticService;

    @Around("@annotation(ru.test.lesson1.annotations.TrackTime)")
    public Object trackTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long time = System.currentTimeMillis();

        log.info("TrackTime aspect save data");

        Object result = joinPoint.proceed();

        long resultTime = System.currentTimeMillis() - time;

        MethodTrack build = getMethodTrack(joinPoint, resultTime);

        this.saveData(build);

        return result;
    }

    private MethodTrack getMethodTrack(ProceedingJoinPoint joinPoint, long resultTime) {
        return MethodTrack.builder()
                .methodName(joinPoint.getSignature().getName())
                .annotationAboveMethod("TrackTime")
                .className(joinPoint.getSignature().getDeclaringTypeName())
                .workTime(resultTime)
                .build();
    }


    private void saveData(MethodTrack data){
        saveMethodStatisticService.saveStatistic(data);
    }



}
