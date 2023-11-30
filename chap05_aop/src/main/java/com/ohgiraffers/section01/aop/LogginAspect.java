package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

// @Aspect: point과 advice를 하나의 클래스 단위로 정의하기 위한 어노테이션이다.
/*
* pointcut: 특정 조건에 의해 필터링된 조인포인트, 수많은 조인포인트 중에 특정 메소드만 횡단 공통기능을 수행하기 위해서 사용한다.
* advice: 횡단 관심에 해당하는 공통 기능의 코드, 독립된 클래스의 메소드로 작성한다.
*   -before: 메소드 실행 전에 동작
*   -After: 메소드 실행 후에 동작
*   -After-returning: 메소드가 정상적으로 실행된 후에 동작
*   -After-throwing: 예외가 발생한 후에 동작
*   -Around: 메소드 호출 이전, 이후, 예외발생 등 모든 시점에 동작
* */
@Aspect
@Component
public class LogginAspect {

    /*
    * pointcut: 관심 조인 포인트를 결정하여 어드바이스가 실행되는 시기를 제어한다.
    * execution: 메서드 실행 조인 포인트를 매칭한다.
    * */

    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void logPointcut(){
        // excution([수식어] 리턴타입 [클래스이름].이름(파라미터)
        // 수식어 생략 가능 public private protected default (접근제어자)
        // *Service*(..) : 매개변수가 0개 이상인 모든 메소드
        // *Service.*(*): 매개 변수가 1개인 모든 메소드
        // *Service.*(*,..): 매개변수가 2개인 모든 메소드
    }

    /*
    * joinPoint: 포인트컷으로 패치한 실행지점
    * 이렇게 매치된 조인포인트에서 해야할 일이 어드바이스이다.
    * 매개변수로 전달한 joinPoint 객체는 현재 조인 포인트의 메소드명, 인수값 등의 자세한 정보를 엑세스 할 수 있다.
    * */

    @Before("LogginAspect.logPointcut()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("before joinPoint.getTarget() " + joinPoint.getTarget());
        System.out.println("Before joinpoint.getSignature() " + joinPoint.getSignature());
        if(joinPoint.getArgs().length>0){
            System.out.println("before joinpoint.getArgs()[0] " + joinPoint.getArgs()[0]);
        }
    }

    @After("logPointcut()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("Atfer joinPoint.getTarget()" + joinPoint.getTarget());
        System.out.println("Atfer joinPoint.getSignature() " + joinPoint.getSignature());
        if(joinPoint.getArgs().length >0){
            System.out.println("After joinPoint.getArgs()[0] " + joinPoint.getArgs()[0]);
        }
    }
    /*
    * aop가 적용될 메소드가 에러 없이 성공적으로 실행된 이후의 시점을 말한다.
    * returning 속성은 리턴값으로 받아올 오브젝트의 매개변수 이름과 동일해야 한다.
    *
    * */
    @AfterReturning(pointcut = "logPointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result){
        System.out.println("After Returning result =" + result);
        if(result != null && result instanceof Map){
            ((Map<Long,MemberDTO>) result).put(100L, new MemberDTO(100L, "반환값 가공"));
        }
    }
    /*
    * aop가 적용될 메소드가 에러를 발생하여 Exception
    * */
    // throwing 속성의 이름과 매개변수의 이름이 동일해야 한다.
    @AfterThrowing(pointcut = "logPointcut()", throwing = "exception")
    public void logAfterThrowing(Throwable exception) {
        System.out.println("after throwing exception " + exception);
    }

    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Before " + joinPoint.getSignature().getName());

        // 원본 조인포인트를 실행한다
        Object result = joinPoint.proceed();
        System.out.println("Around " + joinPoint.getSignature().getName());

        //원본 조인포인트를 호출한 쪽 혹은 다른 어드바이스가 다시 실행할 수 있도록 반환한다.
        return result;
    }





}


