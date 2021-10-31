package com.serhiihonchar;

import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    //Метод принимает класс и возвращает созданный объект этого класса
    static Employee methodReturnObject(Employee employee) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class employeeClass = Employee.class;
        Constructor<Employee> constructor2 =
                employeeClass.getConstructor(int.class, String.class, String.class);
        employee = constructor2.newInstance(1, "Serhii", "IT");
        return employee;
    }

    //Метод принимает object и вызывает у него все методы без параметров
    static void returnAllMethodsWithoutParameters(Object obj) {
        obj = Object.class;
        Method[] someMethod2 = ((Class) obj).getDeclaredMethods();
        for (Method method : someMethod2) {
            if (Arrays.toString(method.getParameterTypes()).equals("[]")) {
                System.out.println(method);
            }
        }
    }

    //Метод принимает object и выводит на экран все сигнатуры методов в который есть final
    static void printMethodsWithFinal(Object obj) {//need to refactor
        obj = Object.class;
        Method[] someMethod3 = ((Class) obj).getDeclaredMethods();
        for (Method method : someMethod3) {
            if (Modifier.isFinal(method.getModifiers()))//Modifier.isFinal(mods)
                System.out.println(method);
        }
    }


    //Метод принимает Class и выводит все не публичные методы этого класса
    static void printNotPublicMethods(Class clazz) {
        clazz = Class.class;
        Method[] someMethod4 = clazz.getDeclaredMethods();
        for (int i = 0; i < someMethod4.length; i++) {
            int modifiers = someMethod4[i].getModifiers();
            if (!Modifier.isPublic(modifiers)) {
                System.out.println(someMethod4[i]);
            }
        }
    }

    //Метод принимает Class и выводит всех предков класса и все интерфейсы
    // которое класс имплементирует
    static void printParentClassesAndInterfaces(Class clazz) {
        clazz = Class.class.getSuperclass();
        System.out.println(clazz);
        Class[] theInterfaces = clazz.getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++) {
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }

    //Метод принимает объект и меняет всего его приватные поля на их нулевые значение (null, 0, false etc)+
    static void changeValues(Employee employee) throws NoSuchFieldException, IllegalAccessException {
        employee = new Employee(10, "Serhii", "IT");
        Class employeeClass = employee.getClass();
        Field field1 = employeeClass.getDeclaredField("salary");
        Field field2 = employeeClass.getDeclaredField("isVaccinated");
        field1.setAccessible(true);
        field2.setAccessible(true);
//        double salaryValue = (Double) field1.get(employee);
//        boolean isVaccinatedValue =  (Boolean)field2.get(employee);
        field1.set(employee, 0);
        field2.set(employee, false);
        System.out.println(employee);
    }

    public static void main(String[] args) throws
            InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Employee employee = new Employee();
        System.out.println(methodReturnObject(employee));
        System.out.println("==================================================================================");
        Object o1 = new Object();
        returnAllMethodsWithoutParameters(o1);
        System.out.println("==================================================================================");
        Object o2 = new Object();
        printMethodsWithFinal(o2);
        System.out.println("==================================================================================");
        Class c1 = Employee.class;
        printNotPublicMethods(c1);
        System.out.println("==================================================================================");
        Employee emp1 = new Employee();
        Class employeeClass = emp1.getClass();
        printParentClassesAndInterfaces(employeeClass);
        System.out.println("==================================================================================");
        Employee emp = new Employee();
        changeValues(emp);
    }
}