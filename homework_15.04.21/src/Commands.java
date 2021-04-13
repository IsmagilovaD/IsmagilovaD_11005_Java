import java.lang.annotation.*;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface Commands {

    String[] aliases();
    String[] args() default "";
    String description() default "";
    int id();
    boolean inProgress() default false;
}
