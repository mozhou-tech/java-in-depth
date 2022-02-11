package com.tenstone.refect;


import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Objects;

/**
 * Created by liuyuancheng on 2022/2/7  <br/>
 * http://hannesdorfmann.com/annotation-processing/annotationprocessing101/
 *
 * @author liuyuancheng
 */
@ClassDemoAnnotation
public class AnnotationDemo {

    public AnnotationDemo() {
        final ClassDemoAnnotation annotation = AnnotationDemo.class.getAnnotation(ClassDemoAnnotation.class);
        if (Objects.nonNull(annotation)) {
            System.out.println("我的头上有个注解@ClassDemoAnnotation");
        }
    }

    public static void main(String[] args) throws Exception {
        final AnnotationDemo annotationDemo = AnnotationDemo.class.getConstructor().newInstance();
        annotationDemo.method1();
        annotationDemo.method2();
        annotationDemo.method3();
        annotationDemo.method4();
        annotationDemo.parameter("hello");
    }

    @MethodReflectAnnotation(value = '+', loop = 3)
    public void method1() throws NoSuchMethodException {
        final MethodReflectAnnotation method1 = this.getClass()
                .getDeclaredMethod("method1")
                .getAnnotation(MethodReflectAnnotation.class);
        for (int i = 0; i < method1.loop(); i++) {
            System.out.print(method1.value());
        }
        System.out.println();
    }

    @MethodReflectAnnotation(value = 'x', loop = 2)
    public void method2() throws NoSuchMethodException {
        final MethodReflectAnnotation method1 = this.getClass()
                .getDeclaredMethod("method2")
                .getAnnotation(MethodReflectAnnotation.class);
        for (int i = 0; i < method1.loop(); i++) {
            System.out.print(method1.value());
        }
        System.out.println();
    }

    @MethodReflectAnnotation(value = '9', loop = 9)
    public void method3() throws NoSuchMethodException {
        final MethodReflectAnnotation method1 = this.getClass()
                .getDeclaredMethod("method3")
                .getAnnotation(MethodReflectAnnotation.class);
        for (int i = 0; i < method1.loop(); i++) {
            System.out.print(method1.value());
        }
        System.out.println();
    }

    public void method4() throws NoSuchMethodException {
        final MethodReflectAnnotation method1 = this.getClass()
                .getDeclaredMethod("method4")
                .getAnnotation(MethodReflectAnnotation.class);
        if (Objects.nonNull(method1)) {
            for (int i = 0; i < method1.loop(); i++) {
                System.out.print(method1.value());
            }
        } else {
            System.out.print("no annotation.");
        }

        System.out.println();
    }

    @MethodReflectAnnotation
    public void parameter(@ParamReflectAnnotation(value = '%') String input) throws NoSuchMethodException {
        final Method parameter = this.getClass().getDeclaredMethod("parameter", String.class);
        final Parameter[] parameters = parameter.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            final ParamReflectAnnotation annotation = parameters[i].getAnnotation(ParamReflectAnnotation.class);
            if (Objects.nonNull(annotation)) {
                final String input1 = parameters[i].getName();
                System.out.println(input1);
                final char wrapChar = annotation.value();
                if (input1.equals("arg0")) {
                    System.out.println(wrapChar + input + wrapChar);
                }
            }
        }

    }
}
