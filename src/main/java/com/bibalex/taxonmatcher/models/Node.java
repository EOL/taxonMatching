package com.bibalex.taxonmatcher.models;

import java.util.ArrayList;

/**
 * Created by Amr.Morad
 */
public class Node {

    private int id;
    private int resourceId;
    private int pageId;
    private int parentId;
    private String scientificName;
    private String cononicalForm;
    private String rank;
    private ArrayList<Node> children;
    private ArrayList<Node> ancestors;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {

        return id;
    }

    public Node(int id, int resourceId, int pageId, int parentId, String scientificName, String cononicalForm, String rank) {
        this.id = id;

        this.resourceId = resourceId;
        this.pageId = pageId;
        this.parentId = parentId;
        this.scientificName = scientificName;
        this.cononicalForm = cononicalForm;
        this.rank = rank;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public void setAncestors(ArrayList<Node> ancestors) {
        this.ancestors = ancestors;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public void setCononicalForm(String cononicalForm) {
        this.cononicalForm = cononicalForm;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getResourceId() {

        return resourceId;
    }

    public int getPageId() {
        return pageId;
    }

    public int getParentId() {
        return parentId;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getCononicalForm() {
        return cononicalForm;
    }

    public String getRank() {
        return rank;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public ArrayList<Node> getAncestors() {
        return ancestors;
    }

    public boolean needsToBeMapped(){
        if (this != null && this.getPageId() != 0)
            return true;
        return false;
    }

    public boolean hasChildren(){
        if(this != null && this.children != null && this.children.size() != 0)
            return true;
        return false;
    }
}
