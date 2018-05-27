package com.bibalex.taxonmatcher.handlers;

import com.bibalex.taxonmatcher.models.Node;
import java.util.ArrayList;

/**
 * Created by Amr Morad
 */
public class Neo4jHandler {

    public ArrayList<Node> getChildren(int generatedNodeId){
        Object response = RestClientHandler.doConnection(ResourceHandler.getPropertyValue("getChildren"), generatedNodeId,"generatedNodeId", null , null);
        System.out.println("===============================");
        System.out.println("returned children nodes " + response);
        System.out.println("===============================");
        ArrayList<Node> children = (ArrayList<Node>) response;
        return children;
    }

    public boolean hasChildren(int generatedNodeId){
        Object response = RestClientHandler.doConnection(ResourceHandler.getPropertyValue("hasChildren"), generatedNodeId,"generatedNodeId", null , null);
        System.out.println("===============================");
        System.out.println("has children ? " + response);
        System.out.println("===============================");
        boolean has_children = ((Boolean) response).booleanValue();
        return has_children;
    }

    public ArrayList<Node> getAncestors(int generatedNodeId){
        Object response = RestClientHandler.doConnection(ResourceHandler.getPropertyValue("getAncestors"), generatedNodeId,"generatedNodeId" , null, null);
        System.out.println("===============================");
        System.out.println("returned ancestors nodes " + response);
        System.out.println("===============================");
        ArrayList<Node> ancestors = (ArrayList<Node>) response;
        return ancestors;
    }

    public int assignPageToNode(int generatedNodeId){
        //TODO implement
        return 0;
    }

    public boolean assignPageToNode(int generatedNodeId, int pageId){
        Object response = RestClientHandler.doConnection(ResourceHandler.getPropertyValue("addPageIdtoNode"), generatedNodeId,"generatedNodeId" , pageId, "pageId");
        System.out.println("===============================");
        System.out.println("assigned page id " + pageId +" to node id "+generatedNodeId+" ? "+ response);
        System.out.println("===============================");
        boolean flag = ((Boolean) response).booleanValue();
        return flag;
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
            Object response = RestClientHandler.doConnection(ResourceHandler.getPropertyValue("getRootNodes"), resourceId, "resourceId" , null , null);
            System.out.println("===============================");
            System.out.println("returned root nodes " + response);
            System.out.println("===============================");
            ArrayList<Node> roots = (ArrayList<Node>) response;
        return roots;
    }

}
