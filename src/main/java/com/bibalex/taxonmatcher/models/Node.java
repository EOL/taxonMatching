
package com.bibalex.taxonmatcher.models;

import com.bibalex.taxonmatcher.handlers.Neo4jHandler;

import java.util.ArrayList;

/**
 * Created by Amr.Morad
 */
public class Node {

    String nodeId;
    int resourceId;
    String scientificName;
    int generatedNodeId;
    String rank;
    int parentGeneratedNodeId;
    String parentNodeId;
    String acceptedNodeId;
    int acceptedNodeGeneratedId;
    int pageId;
    Neo4jHandler neo4jHandler;

    public Node(String nodeId, int resourceId, String scientificName, int generatedNodeId, String rank, int parentGeneratedNodeId,
                String parentNodeId, String acceptedNodeId, int acceptedNodeGeneratedId, int pageId) {
        this.nodeId = nodeId;
        this.resourceId = resourceId;
        this.scientificName = scientificName;
        this.generatedNodeId = generatedNodeId;
        this.rank = rank;
        this.parentGeneratedNodeId = parentGeneratedNodeId;
        this.parentNodeId = parentNodeId;
        this.acceptedNodeId = acceptedNodeId;
        this.acceptedNodeGeneratedId = acceptedNodeGeneratedId;
        this.pageId = pageId;
        neo4jHandler = new Neo4jHandler();
    }

    public Node(int resourceId, String nodeId, String scientificName, String rank, int parentGeneratedNodeId) {
        this.nodeId = nodeId;
        this.resourceId = resourceId;
        this.scientificName = scientificName;
        this.rank = rank;
        this.parentGeneratedNodeId = parentGeneratedNodeId;
    }

    public Node(int resourceId, String nodeId){
        this.resourceId = resourceId;
        this.nodeId = nodeId;
    }

    public Node(String nodeId, String scientificName, int resourceId){
        this.resourceId = resourceId;
        this.nodeId = nodeId;
        this.scientificName = scientificName;
    }

    public Node(String parentNodeId, int resourceId){
        this.resourceId = resourceId;
        this.parentNodeId = parentNodeId;
    }


    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public int getGeneratedNodeId() {
        return generatedNodeId;
    }

    public void setGeneratedNodeId(int generatedNodeId) {
        this.generatedNodeId = generatedNodeId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getParentGeneratedNodeId() {
        return parentGeneratedNodeId;
    }

    public void setParentGeneratedNodeId(int parentGeneratedNodeId) {
        this.parentGeneratedNodeId = parentGeneratedNodeId;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public String getParentNodeId() {
        return parentNodeId;
    }

    public void setParentNodeId(String parentNodeId) {
        this.parentNodeId = parentNodeId;
    }

    public String getAcceptedNodeId() {
        return acceptedNodeId;
    }

    public void setAcceptedNodeId(String acceptedNodeId) {
        this.acceptedNodeId = acceptedNodeId;
    }

    public int getAcceptedNodeGeneratedId() {
        return acceptedNodeGeneratedId;
    }

    public void setAcceptedNodeGeneratedId(int acceptedNodeGeneratedId) {
        this.acceptedNodeGeneratedId = acceptedNodeGeneratedId;
    }

    public boolean needsToBeMapped(){
        //resourceId = 0 indicates the DWH id
        if (this != null && ((this.getPageId() == 0) || (this.resourceId != 0)))
            return true;
        return false;
    }

    public boolean hasChildren(){
        return neo4jHandler.hasChildren(this.generatedNodeId);
    }

    public ArrayList<Node> getChildren(){
        return neo4jHandler.getChildren(this.generatedNodeId);
    }

    public ArrayList<Node> getAnecstors(){
        return neo4jHandler.getAncestors(this.generatedNodeId);
    }
}
