package com.bibalex.taxonmatcher.handlers;

import com.bibalex.taxonmatcher.controllers.NodeMapper;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Amr.Morad
 */
public class FileHandler {

    private FileWriter outputFile;
    private static Logger logger;

    public FileHandler(){
        logger = LogHandler.getLogger(NodeMapper.class.getName());
        try {
            outputFile = new FileWriter(ResourceHandler.getPropertyValue("outputFileName"));
        } catch (IOException e) {
            logger.error("output file exception "+e);
        }
    }

    public void writeToFile(String s){
        outputFile.write(s);
    }

}
