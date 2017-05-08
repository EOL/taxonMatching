package com.bibalex.taxonmatcher.handlers;

import com.bibalex.taxonmatcher.models.Node;
import com.bibalex.taxonmatcher.models.SearchResult;
import com.bibalex.taxonmatcher.models.Strategy;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Amr.Morad on 4/19/2017.
 */
public class SearchHandler {

    private GlobalNamesHandler globalNameHandler;
    SolrHandler solrHandler;

    public SearchHandler()
    {
        globalNameHandler = new GlobalNamesHandler();
        solrHandler = new SolrHandler();
    }

    private String buildSearchQuery(Node node, Strategy strategy, Node ancestor){
        String searchQuery = "";
        String scientificNameAttr = "scientific_name";
        if (strategy != null){
            searchQuery += strategy.getIndex();
            searchQuery += strategy.getType().equalsIgnoreCase("in") ? " INCLUDES " : " = ";
            searchQuery += strategy.getAttribute().equalsIgnoreCase(scientificNameAttr) ?
                    node.getScientificName() : node.getCononicalForm();
            if (ancestor != null && !strategy.getAttribute().equalsIgnoreCase(scientificNameAttr)){
                //case other ancestor will not be valid in the code
                searchQuery += " AND ancestor_ids INCLUDES " + ancestor.getId();
            }
            if(globalNameHandler.isHybrid(node.getScientificName())){
                searchQuery += " AND is_hybrid = True";
            }
        }
        return searchQuery;
    }

    public ArrayList<SearchResult> getResults(Node node, Strategy strategy, Node ancestor){
        String searchQuery = buildSearchQuery(node, strategy, ancestor);
        SolrDocumentList solrResultDocuments = solrHandler.performQuery(searchQuery);
        ArrayList<SearchResult> results = new ArrayList<SearchResult>();
        for(SolrDocument document : solrResultDocuments){
            SearchResult result = new SearchResult((Integer) document.getFieldValue("id"),
                    mapChildrenNames(document.getFieldValues("children")));
            results.add(result);
        }
        return results;
    }

    private ArrayList<String> mapChildrenNames(Collection<Object> children){
        ArrayList<String> childrenNames = new ArrayList<String>();
        for(Object object : children){
            childrenNames.add(object != null ? object.toString() : null);
        }
        return childrenNames;
    }
}
