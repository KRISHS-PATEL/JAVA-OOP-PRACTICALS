import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class SignupForm {
    @NotBlank
    @MaxLength(20)
    String username;

    @NotBlank
    @MaxLength(40)
    String email;

    SignupForm(String username, String email) {
        this.username = username;
        this.email = email;
    }
}

public class FormValidator {
    static List<String> validate(Object obj) throws IllegalAccessException {
        List<String> errors = new ArrayList<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(obj);
            if (field.isAnnotationPresent(NotBlank.class) &&
                (value == null || value.toString().trim().isEmpty())) {
                errors.add(field.getName() + " must not be blank");
            }
            MaxLength max = field.getAnnotation(MaxLength.class);
            if (max != null && value != null && value.toString().length() > max.value()) {
                errors.add(field.getName() + " is too long");
            }
        }
        return errors;
    }

    public static void main(String[] args) throws Exception {
        SignupForm form = new SignupForm("", "student@example.com");
        List<String> errors = validate(form);
        if (errors.isEmpty()) System.out.println("Valid form");
        else for (String error : errors) System.out.println(error);
    }
}
