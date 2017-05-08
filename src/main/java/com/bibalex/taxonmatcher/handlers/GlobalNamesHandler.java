package com.bibalex.taxonmatcher.handlers;

import org.globalnames.parser.ScientificNameParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by Amr.Morad on 4/16/2017.
 */
public class GlobalNamesHandler {

    private JSONParser parser;

    public GlobalNamesHandler(){
        parser = new JSONParser();
    }

    private JSONObject getParsedJson(String name){
        String jsonStr = ScientificNameParser.instance()
                .fromString(name)
                .renderCompactJson();
        try {
            return (JSONObject)parser.parse(jsonStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean parseAndGetResult(String name, String attribute){
        Object att = (getParsedJson(name)).get(attribute);
        return att == null ? false : (Boolean)att;
    }

    public boolean isVirus(String name){
        return parseAndGetResult(name, "virus");
    }

    public boolean isSurrogate(String name){
        return parseAndGetResult(name, "surrogate");
    }

    public boolean isHybrid(String name){
        return parseAndGetResult(name, "hybrid");
    }

    public boolean hasAuthority(String name){
        return parseAndGetResult(name, "authorship");
    }
}
