package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Get_value_properties {
    //Variables
    private final Properties prop = new Properties();
    //constants
    private static final String FILE_PROPERTIES = "config.properties";

    //Methods
    private void openProperties() {
        try {
            prop.load(new FileInputStream(FILE_PROPERTIES));
        } catch (IOException eIO) {
            System.out.println("Error: can not open the properties file" + eIO.getMessage());
            eIO.printStackTrace();
        }
    }

    /**
     * get url that it is stored into config.properties
     *
     * @return String
     */
    public String getUrlIndex() {
        openProperties();
        return prop.getProperty("Url.index");
    }
}
