package com.bibalex.taxonmatcher.models;

import java.util.ArrayList;

/**
 * Created by amr.morad.
 */
public class SearchResult {

    private int nodeId;
    private int pageId;
    private ArrayList<Integer> children;

    public SearchResult(int nodeId, int pageId, ArrayList<Integer> children) {
        this.nodeId = nodeId;
        this.pageId = pageId;
        this.children = children;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public void setChildren(ArrayList<Integer> children) {
        this.children = children;
    }

    public int getPageId() {
        return pageId;
    }

    public ArrayList<Integer> getChildren() {
        return children;
    }

    public int getNodeId() {
        return nodeId;
    }
}
