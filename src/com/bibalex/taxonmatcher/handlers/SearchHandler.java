package com.bibalex.taxonmatcher.handlers;

import com.bibalex.taxonmatcher.models.Node;
import com.bibalex.taxonmatcher.models.Strategy;

import java.util.ArrayList;

/**
 * Created by Amr.Morad on 3/19/2017.
 */
public class SearchHandler {

    private GlobalNamesHandler globalNameHandler;

    public SearchHandler(){
        globalNameHandler = new GlobalNamesHandler();
    }

    public String buildSearchQuery(Node node, Strategy strategy, ArrayList<Node> otherAncestors){
        String searchQuery = "";
        if (strategy != null){
            searchQuery += strategy.getIndex();
            searchQuery += strategy.getType().equalsIgnoreCase("in") ? " INCLUDES " : " = ";
            searchQuery += node.getName(); //check
            if (node.getAncestors() != null && !node.getAncestors().isEmpty() &&
                    strategy.getAttribute() != "scientific_name"){
                if (otherAncestors != null && !otherAncestors.isEmpty()){
                    searchQuery += " AND (other_ancestor_ids INCLUDES ";
                }else{
                    searchQuery += "kkk";
                }
            }
            if(globalNameHandler.isHybrid(node.getName())){
                searchQuery += " AND is_hybrid = True";
            }
        }
        return searchQuery;
    }

   // public ArrayList<Node> getResults(){
        //TODO call solr

//    }
}
