package utils;

public class TestContext {

    public static ThreadLocal<String> tcId =
            new ThreadLocal<>();

    public static ThreadLocal<String> requestPayload =
            new ThreadLocal<>();

    public static ThreadLocal<String> expectedResult =
            new ThreadLocal<>();

    public static ThreadLocal<String> actualResult =
            new ThreadLocal<>();

    public static ThreadLocal<String> httpStatus =
            new ThreadLocal<>();

    public static ThreadLocal<String> apiStatus =
            new ThreadLocal<>();
    
    public static ThreadLocal<String> responseBody =
            new ThreadLocal<>();
}
