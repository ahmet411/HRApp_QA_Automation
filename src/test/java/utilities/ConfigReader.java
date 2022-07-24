package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static{
        FileInputStream input=null;
        properties=new Properties();
        String path="/Users/mindtekbatch5/IdeaProjects/HRApp_QA_Automation/src/test/resources/configurations/QAConfiguration.properties";
        try {
            input=new FileInputStream(path);
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Properties file files is not being read.");
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                System.out.println("Input object was not instantiated, and there was exception closing it.");
            }
        }
    }

    public static String getProperty(String key){ // URL
        return properties.getProperty(key); // www.google.com
    }

}
