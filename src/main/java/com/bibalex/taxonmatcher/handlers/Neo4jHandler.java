package com.bibalex.taxonmatcher.handlers;

import com.bibalex.taxonmatcher.models.Node;
import java.util.ArrayList;

/**
 * Created by Amr Morad
 */
public class Neo4jHandler {

    public ArrayList<Node> getChildren(int generatedNodeId){
        //TODO implement
        return new ArrayList<Node>();
    }

    public boolean hasChildren(int generatedNodeId){
        //TODO implement
        return true;
    }

    public ArrayList<Node> getAncestors(int generatedNodeId){
        //TODO implement
        return new ArrayList<Node>();
    }

    public int assignPageToNode(int generatedNodeId){
        //TODO implement
        return 0;
    }

    public boolean assignPageToNode(int generatedNodeId, int pageId){
        //TODO implement
        return true;
    }

    public Node getNativeVirusNode(){
        //TODO implement
        return new Node(5006, "Viruses");
    }

    public ArrayList<Node> getNodesFromIds(ArrayList<Integer> childrenIds){
        //TODO implement
        return new ArrayList<Node>();
    }

    public ArrayList<Node> getRootNodes(int resourceId){
        //TODO implement
        return new ArrayList<Node>();
    }
}
