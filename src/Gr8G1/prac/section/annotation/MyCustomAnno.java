package Gr8G1.prac.section.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ TYPE, FIELD })
public @interface MyCustomAnno {
  String name() default "";
}
