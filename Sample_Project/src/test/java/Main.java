import org.junit.runner.JUnitCore;

public class Main {

    public static void main(String[] args){
        JUnitCore jcore = new JUnitCore();

          jcore.run(RunCukesTest.class);
    }
}
