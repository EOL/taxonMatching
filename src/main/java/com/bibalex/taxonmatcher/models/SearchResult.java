package com.bibalex.taxonmatcher.models;

import java.util.ArrayList;

/**
 * Created by amr.morad on 5/3/17.
 */
public class SearchResult {

    private int pageId;
    private ArrayList<String> childrenNames;

    public int getPageId() {
        return pageId;
    }

    public ArrayList<String> getChildrenNames() {
        return childrenNames;
    }

    public SearchResult(int pageId, ArrayList<String> childrenNames) {
        this.pageId = pageId;
        this.childrenNames = childrenNames;
    }
}
