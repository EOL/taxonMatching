package com.bibalex.taxonmatcher.handlers;

import com.bibalex.taxonmatcher.handlers.ResourceHandler;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;

/**
 * Created by Amr.Morad
 */
public class SolrHandler {

    String zkHostString;
    String defaultCollection;
//    SolrClient solr;
    CloudSolrClient solr;

    public SolrHandler(){
        zkHostString = ResourceHandler.getPropertyValue("zookeeperHost");
        defaultCollection = ResourceHandler.getPropertyValue("defaultCollection");
        //solr = new CloudSolrClient.Builder().withZkHost(zkHostString).build();
        solr = new CloudSolrClient(zkHostString);
        solr.setDefaultCollection(defaultCollection);
    }

    public SolrDocumentList performQuery(String queryString){
        SolrQuery query = new SolrQuery();
        query.setQuery(queryString);
        try {
            return solr.query(query).getResults();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static void main(String [] args){
        SolrHandler sh = new SolrHandler();
    }

}
