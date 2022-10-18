package ChainOfResponsibility;

public class Test {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor( new ErrorLogProcessor(null)));
        logProcessor.log(LogProcessor.ERROR,"Error happen");
        logProcessor.log(LogProcessor.DEBUG,"Need to debug this");
        logProcessor.log(LogProcessor.INFO,"Just for Info");
    }
}
