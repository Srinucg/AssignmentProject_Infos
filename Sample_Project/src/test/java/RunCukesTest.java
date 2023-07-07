import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.IOException;


@RunWith(Cucumber.class)
@CucumberOptions(


        plugin ={"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","timeline:test-output-thread/"},

        features = {"src/test/resources/features"},
        glue = {""},
    monochrome = true,


        tags = "@Exampl123"

)
public class RunCukesTest  {
    @BeforeClass
    public static void setup() throws IOException {


    }

    @AfterClass
    public static void writeExtentReport() throws IOException {


    }

}