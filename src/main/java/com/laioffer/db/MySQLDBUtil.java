package com.laioffer.db;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class MySQLDBUtil {
    private static final String INSTANCE = "twitchproject.c6teopct2idb.us-east-2.rds.amazonaws.com"; // amazon databse mysql connection: endpoints
    private static final String PORT_NUM = "3306";
    private static final String DB_NAME = "jupiter";
    public static String getMySQLAddress() throws IOException {
        Properties prop = new Properties();
        String propFileName = "config.properties";

        // read file of config.properties
        // 用stream 是因为file 数据可能很大
        InputStream inputStream = MySQLDBUtil.class.getClassLoader().getResourceAsStream(propFileName);
        prop.load(inputStream);


        String username = prop.getProperty("user");
        String password = prop.getProperty("password");
        return String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s&autoReconnect=true&serverTimezone=UTC&createDatabaseIfNotExist=true",
                INSTANCE, PORT_NUM, DB_NAME, username, password);
    }
}
