package Utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class SUTDetails {

    private static Logger logger = LoggerFactory.getLogger(SUTDetails.class);
    private static SUTDetails sutDetailsInstance = null;

    private String host;
    private int port;
    private String scheme;
    private String contextSuffix;

    public static final String sutFile = "sut.txt";


    private SUTDetails(Properties properties) {
        this.host = getSutSettings(properties, "HOST");
        this.port = Integer.parseInt(getSutSettings(properties, "PORT"));
        this.scheme = getSutSettings(properties, "SCHEME");
        this.contextSuffix = getSutSettings(properties, "CONTEXT_SUFFIX");
    }

    public static SUTDetails getInstance() {
        try {
            if (sutDetailsInstance == null) {
                Properties prop = new Properties();
                InputStream in = getResource(sutFile).openStream();
                prop.load(in);
                sutDetailsInstance = new SUTDetails(prop);
            }
            return sutDetailsInstance;
        } catch (IOException e) {
            logger.error("Failed to read sut.txt due to ='{}'", e.getMessage(), e);
            throw new RuntimeException("Failed to read sut.txt", e);
        }
    }

    public static URL getResource(String resourceName) {
        ClassLoader loader = SUTDetails.class.getClassLoader();
        URL url = loader.getResource(resourceName);
        if (url == null) {
            throw new IllegalArgumentException("resource not found: " + resourceName);
        }
        return url;
    }


    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getScheme() {
        return scheme;
    }

    public static String getSutSettings(Properties prop, String propertyKey) {
        return System.getProperty(propertyKey) == null ? prop.getProperty(propertyKey) : System.getProperty(propertyKey);
    }

    public String getContextSuffix() {
        return contextSuffix;
    }

    public void setContextSuffix(String contextSuffix) {
        this.contextSuffix = contextSuffix;
    }


}