package com.imaginea.user_registration.util;

import com.imaginea.user_registration.constant.Constant;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <h1> PropertyUtil.class </h1>
 * The PropertyUtil class is responsible to load properties or configuration file to memory.
 * 
 * @author maninders
 */
public class PropertyUtil {

    static Logger log = Logger.getLogger(PropertyUtil.class);

    private static Properties properties = loadPropertiesFile();

    /**
     * This method is responsible to load properties file to memory.
     * @return java.util.Properties
     */
    private  static Properties loadPropertiesFile() {

        Properties properties = new Properties();
        InputStream inputStream = null;
        PropertyUtil propertyUtil = new PropertyUtil();
        String[] fileList = Constant.FILE_NAME_TO_LOAD.split(" ");

        for (String fileName : fileList) {
            try {
                inputStream = propertyUtil.getClass().getClassLoader().getResourceAsStream(fileName);
                properties.load(inputStream);
                if(inputStream == null){
                    log.info("Unable to load properity file : " + fileName);
                }
            } catch (IOException e) {
                log.error("IOException exception : " + e);
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        log.error("Error while closing inputStream : " + e);
                    }
                }
            }
        }
            return properties;
    }

    /**
     * This method is to return Properties Object, which represents set of key value pair objects in memory
     * @return java.util.Properties
     */
    public static Properties getProperties(){
        return properties;
    }
}
