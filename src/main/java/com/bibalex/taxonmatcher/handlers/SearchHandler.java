package com.bibalex.taxonmatcher.handlers;

import com.bibalex.taxonmatcher.controllers.NodeMapper;
import com.bibalex.taxonmatcher.models.Node;
import com.bibalex.taxonmatcher.models.SearchResult;
import com.bibalex.taxonmatcher.models.Strategy;
import org.apache.logging.log4j.Logger;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Amr.Morad
 */
public class SearchHandler {

    private GlobalNamesHandler globalNameHandler;
    private SolrHandler solrHandler;
    private static Logger logger;

    public SearchHandler()
    {
        globalNameHandler = new GlobalNamesHandler();
        solrHandler = new SolrHandler();
        logger = LogHandler.getLogger(NodeMapper.class.getName());
    }

    private String buildSearchQuery(Node node, Strategy strategy, Node ancestor){
        String searchQuery = "";
        String scientificNameAttr = "scientific_name";
        if (strategy != null){
            searchQuery += strategy.getIndex();
            searchQuery += strategy.getType().equalsIgnoreCase("in") ? " : " : " = ";
            searchQuery += strategy.getAttribute().equalsIgnoreCase(scientificNameAttr) ?
                    node.getScientificName() : globalNameHandler.getCanonicalForm(node.getScientificName());
            if (ancestor != null && !strategy.getAttribute().equalsIgnoreCase(scientificNameAttr)){
                //case other ancestor will not be valid in the code
                searchQuery += " AND ancestor_ids : " + ancestor.getGeneratedNodeId();
            }
            if(globalNameHandler.isHybrid(node.getScientificName())){
                searchQuery += " AND is_hybrid = True";
            }
        }
        logger.info("Search query is: " + searchQuery);
        return searchQuery;
    }

//    private ArrayList<Integer> splitAndConvert(String solrField){
//        return new ArrayList(Arrays.asList(solrField.split("\\|")));
//    }

    public ArrayList<SearchResult> getResults(Node node, Strategy strategy, Node ancestor){
        String searchQuery = buildSearchQuery(node, strategy, ancestor);
        SolrDocumentList solrResultDocuments = solrHandler.performQuery(searchQuery);
        ArrayList<SearchResult> results = new ArrayList<SearchResult>();
        for(SolrDocument document : solrResultDocuments){
            ArrayList<Integer> children = castObjectsCollectionToIntegerList(document.getFieldValues("children"));
            SearchResult result = new SearchResult(Integer.parseInt(document.getFieldValue("pageId").
                    toString()), Integer.parseInt(document.getFieldValue("id").
                    toString()), children);
            results.add(result);
        }
        return results;
    }

    private ArrayList<Integer> castObjectsCollectionToIntegerList(Collection<Object> childrenCollection){
        ArrayList<Integer> children = new ArrayList<Integer>();
        for(Object child : childrenCollection){
            children.add((Integer) child);
        }
        return children;
    }

//    private ArrayList<String> mapChildrenNames(Collection<Object> children){
//        ArrayList<String> childrenNames = new ArrayList<String>();
//        for(Object object : children){
//            childrenNames.add(object != null ? object.toString() : null);
//        }
//        return childrenNames;
//    }
}
