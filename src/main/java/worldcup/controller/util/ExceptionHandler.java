package worldcup.controller.util;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ExceptionHandler {
    public static void retryForIllegalArgument(Runnable runnable, Consumer<String> exceptionMessageHandling) {
        while (true) {
            try {
                runnable.run();
                return;
            } catch (IllegalArgumentException exception) {
                exceptionMessageHandling.accept(exception.getMessage());
            }
        }
    }

    public static <T> T retryForIllegalArgument(Supplier<T> supplier, Consumer<String> exceptionMessageHandling) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                exceptionMessageHandling.accept(exception.getMessage());
            }
        }
    }
}
