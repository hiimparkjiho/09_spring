package com.ohgiraffers.section02.reflection;

import java.lang.reflect.*;

public class Application {
    /*
    * 리플렉션이란?
    * 컴파일된 자바 코드에서 역으로 클래스를 불러 메서드 및 필드 정보를 구해오는 방법으로 반사, 투영이라는 의미를 가진다.
    * 리플렉션은 jvm에서 실행되는 애플리케이션의 런타입 동작을 검사하거나 수정할 수 있는 기능이 필요한 경우 사용한다.
    * 스프링 프레임워크, 마이바티스, 하이버네이트(jpa), jackson 등의 라이브러리에서 사용한다.
    * reflection을 사용해서 스프링에서는 런타임 시에 개발자가 등록한 빈을 애플리케이션 내에서 사용할 수 있게 하는 것이다.
    *
    * reflection은 강력한 도구이지만 무분별하게 사용해서는 안된다.
    * 1. 오버헤드 발생: 성능의 저하를 발생할 수 있기 때문에 성능에 민감한 애플리케이션에서는 사용하지 않는다.
    * 2. 캡슐화 저해: private로 설정한 member에 접근 가능하기 때문에 코드 기능이 저하되며 여러 가지 문제를 발생시킬 수 있다.
    *
    * reflection 사용되는 경우
    * 1. ioc 컨테이너
    * 2. app
    * 3. 마이바티스 메퍼
    * 4. log43dbc
    * */

    public static void main(String[] args){
        Class class1 = Account.class;
        System.out.println("class1: " + class1);

        Class clas2 = new Account().getClass();
        System.out.println("clas2: " + clas2);

        try {
            Class clacc3 = Class.forName("com.ohgiraffers.section02.reflection.Account");
            System.out.println("class3: " + clacc3);
            // Double 자료형 배열을 로드
            Class class4 = Class.forName("[D");
            Class class5 = double[].class;
            System.out.println("class4: " + class4);
            System.out.println("class5: " + class5);

            Class class6 = Class.forName("[Ljava.lang.String;");
            Class class7 = String[].class;
            System.out.println("class6: " + class6);
            System.out.println("class7: " + class7);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class class8= Double.TYPE;
        System.out.println("class8: " + class8);

        Class class9 = void.class;
        System.out.println("class9: " + class9);

        /*
        * 클래스의 메타 정보를 이용하여 여러가지 정보를 반환받은 메소드를 제공하낟
        * 상속된 부모 클래스를 반홚다
        * */
        Class superClass = class1.getSuperclass();
        System.out.println("superClass: " + superClass);

        Field[] fields = Account.class.getDeclaredFields();
        for(Field field: fields){
            System.out.println("modifers: " + Modifier.toString(field.getModifiers()));
        }

        Constructor[] constructors = Account.class.getConstructors();

        for(Constructor con: constructors){
            System.out.println("name: " + con.getName());
            Class[] params = con.getParameterTypes();
            for(Class param: params){
                System.out.println("parameerType: " + param.getTypeName());
            }
        }

        try {
            Account acc = (Account)constructors[1].newInstance("26", "110-223-12345", "1234", 100);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        Method[] methods = Account.class.getDeclaredMethods();
        Method getBalanceMethod = null;
        for(Method method : methods){
            System.out.println(Modifier.toString(method.getModifiers()) + " " +
            method.getReturnType().getSimpleName() + " " + method.getName());

            if("getBalance".equals(method.getName())){
                getBalanceMethod = method;
            }
        }

        try {
            System.out.println(getBalanceMethod.invoke(((Account) constructors[0].newInstance())));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
