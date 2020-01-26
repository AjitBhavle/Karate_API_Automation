package com.altimetrik.TestFeatures;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

//@RunWith(Karate.class)

/*@CucumberOptions( features = "classpath:com/altimetrik/TestFeatures/", plugin = {
		"com.cucumber.ExtentCucumberFormatter:D:\\Users\\ABhavle\\eclipse-workspace\\Karate_API_Automation\\target\\html-report\\Karate_ExtentReport1.html",
		"html:target/html-report" , "pretty" })*/
@KarateOptions(features = {"classpath:com/altimetrik/TestFeatures/"})

public class TestRunner {
	@Test
	public void testParallel() {
		String karateOutputPath = "target/surefire-reports";
		Results results = Runner.parallel(getClass(), 2,karateOutputPath	);
        generateReport(results.getReportDir());
        assertTrue(results.getErrorMessages(), results.getFailCount() == 0);  
	}
	public static void generateReport(String karateOutputPath) {        
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
        List<String> jsonPaths = new ArrayList(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"), "Karate_API_Automation");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();        
    }

}


