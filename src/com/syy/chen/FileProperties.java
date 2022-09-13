package com.syy.chen;

import java.io.InputStream;

public class FileProperties extends java.util.Properties {

    private static final long serialVersionUID = 1L;
    private static FileProperties fileProperties = null;

    public FileProperties() {
        super();
    }

    public FileProperties(String fileName) {
        super();
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(
                    fileName);
            this.load(inputStream);
            inputStream.close();
        } catch (Exception e) {
            System.err.println("Exception in com.syy.chen.FileProperties(String fileName): "
                    + e.toString() + " for fileName: " + fileName);
        }
    }

    public FileProperties(java.util.Properties defaults) {
        super(defaults);
    }

    public static String getConfig(String name) {
        fileProperties = new FileProperties("/config/config.properties");
        return fileProperties.get(name).toString();
    }

}
