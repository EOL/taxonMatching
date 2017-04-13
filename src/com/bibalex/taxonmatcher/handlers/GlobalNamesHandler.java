package com.bibalex.taxonmatcher.handlers;

import org.globalnames.parser.ScientificNameParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by Amr.Morad on 3/16/2017.
 */
public class GlobalNamesHandler {

    private JSONParser parser;

    public GlobalNamesHandler(){
        parser = new JSONParser();
    }

    public boolean isVirus(String name){
        boolean isVirus = false;
        String jsonStr = ScientificNameParser.instance()
                .fromString(name)
                .renderCompactJson();
        try {
            JSONObject jsonObject = (JSONObject)parser.parse(jsonStr);
            isVirus = (boolean)jsonObject.get("virus");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return isVirus;
    }

    public boolean isSurrogate(String name){
        boolean isSurrogate = false;
        String jsonStr = ScientificNameParser.instance()
                .fromString(name)
                .renderCompactJson();
        try {
            JSONObject jsonObject = (JSONObject)parser.parse(jsonStr);
            isSurrogate = (boolean)jsonObject.get("surrogate");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return isSurrogate;
    }

    public boolean isHybrid(String name){
        boolean isHybrid = false;
        String jsonStr = ScientificNameParser.instance()
                .fromString(name)
                .renderCompactJson();
        try {
            JSONObject jsonObject = (JSONObject)parser.parse(jsonStr);
            System.out.println(jsonObject.toString());
            isHybrid = (boolean)jsonObject.get("hybrid");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return isHybrid;
    }
}
