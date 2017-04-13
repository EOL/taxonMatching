package com.bibalex.taxonmatcher.models;

import java.util.ArrayList;

/**
 * Created by Amr.Morad on 3/9/2017.
 */
public class Node {

    int resourceId;
    int harvestId;
    int pageId;
    int sitePk;
    int parentId;
    int scientificNameId;
    String name;
    String taxonomicStatus;
    String  resourcePk;
    String  furtherInformationUrl;
    String  rank;
    String  remarks;
    int  removedByHarvestId;
    ArrayList<Node> children;
    ArrayList<Node> ancestors;

    public Node(int resourceId, int harvestId, int pageId, int sitePk, int parentId, int scientificNameId, String name, String taxonomicStatus,
                String resourcePk, String furtherInformationUrl, String rank, String remarks, int removedByHarvestId){//, ArrayList<Node> children,
                //ArrayList<Node> ancestors) {
        this.resourceId = resourceId;
        this.harvestId = harvestId;
        this.pageId = pageId;
        this.sitePk = sitePk;
        this.parentId = parentId;
        this.scientificNameId = scientificNameId;
        this.name = name;
        this.taxonomicStatus = taxonomicStatus;
        this.resourcePk = resourcePk;
        this.furtherInformationUrl = furtherInformationUrl;
        this.rank = rank;
        this.remarks = remarks;
        this.removedByHarvestId = removedByHarvestId;
//        this.children = children;
//        this.ancestors = ancestors;
    }

    public ArrayList<Node> getAncestors() {
        return ancestors;
    }

    public void setAncestors(ArrayList<Node> ancestors) {
        this.ancestors = ancestors;
    }

    public boolean needsToBeMapped(){
        if (this != null && this.getPageId() != 0)
            return true;
        return false;
    }

    public boolean hasAuthority(){
        //ToDO
        return true;
    }

    public boolean hasChildren(){
        if(this.children.size() != 0)
            return true;
        return false;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }
    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public void setHarvestId(int harvestId) {
        this.harvestId = harvestId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public void setSitePk(int sitePk) {
        this.sitePk = sitePk;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public void setScientificNameId(int scientificNameId) {
        this.scientificNameId = scientificNameId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTaxonomicStatus(String taxonomicStatus) {
        this.taxonomicStatus = taxonomicStatus;
    }

    public void setResourcePk(String resourcePk) {
        this.resourcePk = resourcePk;
    }

    public void setFurtherInformationUrl(String furtherInformationUrl) {
        this.furtherInformationUrl = furtherInformationUrl;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setRemovedByHarvestId(int removedByHarvestId) {
        this.removedByHarvestId = removedByHarvestId;
    }

    public int getResourceId() {

        return resourceId;
    }

    public ArrayList<Node> getChildren() {

        return children;
    }

    public int getHarvestId() {
        return harvestId;
    }

    public int getPageId() {
        return pageId;
    }

    public int getSitePk() {
        return sitePk;
    }

    public int getParentId() {
        return parentId;
    }

    public int getScientificNameId() {
        return scientificNameId;
    }

    public String getName() {
        return name;
    }

    public String getTaxonomicStatus() {
        return taxonomicStatus;
    }

    public String getResourcePk() {
        return resourcePk;
    }

    public String getFurtherInformationUrl() {
        return furtherInformationUrl;
    }

    public String getRank() {
        return rank;
    }

    public String getRemarks() {
        return remarks;
    }

    public int getRemovedByHarvestId() {
        return removedByHarvestId;
    }
}
