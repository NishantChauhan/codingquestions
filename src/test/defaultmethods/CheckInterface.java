package test.defaultmethods;

public interface CheckInterface {
    public String functionMethod();
    default String checkMethod(){
        return "default method";
    }
    static String checkStaticMethod(){
        return "static method";
    }
}
