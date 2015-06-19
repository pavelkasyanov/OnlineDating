package pack.analize;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;
/**
 * Created by Кирилл on 18.06.15.
 */

public class PropertiesAnalizatorMap {/*implements AnalizatorMap {
    private static final String ANALIZATOR_MAP = "analizators.properties";
    private Properties props;
    boolean isWeb;

    public static void main(String[] args) {
        System.out.println(new PropertiesAnalizatorMap(false).props.getProperty("наш"));
        System.out.println("Ваш".toLowerCase((new Locale("RU"))));
    }

    PropertiesAnalizatorMap() {
        this(true);
    }

    PropertiesAnalizatorMap(boolean isWeb) {
        this.isWeb = isWeb;
        initProperties();
    }

    @Override
    public String matched(String word) {
        return props.getProperty(word);
    }

    @Override
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
        InputStream resourceAsStream = Analizators.class.getClassLoader().getResourceAsStream(ANALIZATOR_MAP);
        try {
            props.load(resourceAsStream);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void initPropertiesMain() {
        props = new Properties();
        URL url = ClassLoader.getSystemResource(ANALIZATOR_MAP);
        try {
            props.load(url.openStream());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    */
}
