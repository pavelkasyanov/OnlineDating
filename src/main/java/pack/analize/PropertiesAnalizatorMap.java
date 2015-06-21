package pack.analize;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;
/**
 * Created by Кирилл on 18.06.15.
 */

public class PropertiesAnalizatorMap  {
    private static final String ANALIZATOR_MAP = "configCompatibility.properties";
    private Properties props;
    boolean isWeb;

    public PropertiesAnalizatorMap() {
        this(false);
    }

    PropertiesAnalizatorMap(boolean isWeb) {
        this.isWeb = isWeb;
        initProperties();
    }


    public String matched(String word) {
        return props.getProperty(word);
    }


    public void reInit() {
        initProperties();
    }

    private void initProperties() {
        if (isWeb) {
            initPropertiesWeb();
        } else {
            initPropertiesMain();
        }
    }

    private void initPropertiesWeb() {
        props = new Properties();
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(ANALIZATOR_MAP);
        try {
            props.load(resourceAsStream);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void initPropertiesMain(){
        props = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(ANALIZATOR_MAP);
            props.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
