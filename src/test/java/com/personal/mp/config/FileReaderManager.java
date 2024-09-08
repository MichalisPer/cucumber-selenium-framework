package com.personal.mp.config;

public class FileReaderManager {

    private static FileReaderManager fileReaderManager;
    private static ConfigFileReader configFileReader;

    private FileReaderManager() {

    }

    public static FileReaderManager getInstance() {
        if (fileReaderManager == null) {
            fileReaderManager = new FileReaderManager();
        }
        return fileReaderManager;
    }

    public ConfigFileReader getConfigFileReader() {
        return (configFileReader == null) ? configFileReader = new ConfigFileReader() : configFileReader;
    }
}
