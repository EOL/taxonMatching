package com.bibalex.taxonmatcher.controllers;

import com.bibalex.taxonmatcher.handlers.*;
import com.bibalex.taxonmatcher.models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Amr.Morad on 3/12/2017.
 */
public class NodeMapper {

    private StrategyHandler strategyHandler;
    private GlobalNamesHandler globalNameHandler;
    private NodeHandler nodeHandler;
    private MatchingScoreHandler matchingScoreHandler;
    private int maxAncestorDepth;

    public NodeMapper(){
        strategyHandler = new StrategyHandler();
        globalNameHandler = new GlobalNamesHandler();
        nodeHandler = new NodeHandler();
        matchingScoreHandler = new MatchingScoreHandler();
        maxAncestorDepth = Integer.parseInt(ResourceHandler.getPropertyValue("maxAncestorDepth"));
    }

    public void mapAllNodesToPages(ArrayList<Node> rootNodes){
        mapNodes(rootNodes);
    }

    public void mapNodes(ArrayList<Node> rootNodes){
        System.out.println("mapNode");
        for(Node node : rootNodes){
            mapIfNeeded(node);
        }
    }

    public void mapIfNeeded(Node node){
        Strategy usedStrategy = strategyHandler.defaultStrategy();
        int usedAncestorDepth = 0;
        if (node.needsToBeMapped()){
            if(!node.hasAuthority()){
                usedStrategy = strategyHandler.firstNonScientificStrategy();
            }
        mapNode(node, usedAncestorDepth, usedStrategy);
        }
        if(node.hasChildren()){
            mapNodes(node.getChildren());
        }
    }

    public void mapNode(Node node, int depth, Strategy strategy){
        Node ancestor;
        if(globalNameHandler.isSurrogate(node.getName())){
            //TODO unmapped
            unmappedNode(node);
        }else{
            if (globalNameHandler.isVirus(node.getName())){
                //ancestor = Node.native node
            }else{
                ancestor = nodeHandler.matchedAncestor(node.getAncestors(), depth);
            }
        //    mapUnflaggedNode(node, ancestor, depth, strategy);
        }
    }

    public void mapUnflaggedNode(Node node, Node ancestor, int depth, Strategy strategy){
        //TODO choose the appropriate objetc instead of Node
        ArrayList<NodesIndex> results;
        //TODO call the search and obtain the results
//        if (results.size() == 1){
//            mapToPage(node, results[0]); //results[0] is assumed to contain integer for now
//        }else if (results.size() > 1){
//            mapToPage(node, findBestMatch(node, results));
//        }else{
//            Strategy nextStrategy = strategyHandler.getNextStrategy(strategy);
//            if (nextStrategy == null){
//                nextStrategy = strategyHandler.firstNonScientificStrategy();
//                depth++;
//                if (depth > maxAncestorDepth){
//                    unmappedNode(node);
//                }
//            }
//            mapUnflaggedNode(node, ancestor, depth, nextStrategy);
//        }
    }

    public int findBestMatch(Node node, ArrayList<NodesIndex> matchingNodes){
        ArrayList<MatchingScore> scores = new ArrayList<MatchingScore>();
        for(NodesIndex matchingNode : matchingNodes){
//            int matchedChildrenCount = matchingScoreHandler.countMatches(matchingNode.childNames, node.getChildren());
//            int matchedAncestorsCount = matchingScoreHandler.countAncestors(node);
//            double overallScore = matchingScoreHandler.calculateScore(matchedChildrenCount, matchedAncestorsCount);
//            MatchingScore score = new MatchingScore(matchedChildrenCount,
//                    matchedAncestorsCount, overallScore);
      //      scores.add(score);
        }
        Collections.sort(scores, new Comparator<MatchingScore>(){
            public int compare(MatchingScore score1, MatchingScore score2)
            {
                return  Double.compare(score1.getScore(), score2.getScore());
            }
        });
        return scores.get(0).getPageId();
    }



    public void mapToPage(Node node, int pageId){
        node.setPageId(pageId);
    }

    public void unmappedNode(Node node){
      //  Page newPage = new Page();
       // node.setPageId(newPage.getId());
    }

    public static void main(String [] args){
        ArrayList<Node> children = new ArrayList<Node>();
        Node child = new Node(1,1,1,1,1,1,"tat","valid","1",
                "url","kingdom","remarks", 1);
        children.add(child);

        ArrayList<Node> ancestors = new ArrayList<Node>();
        Node n = new Node(1,1,1,1,0,1,"kak","valid","1",
                "url", "kingdom", "remarks", 1);
        ancestors.add(n);

        n.setChildren(children);
        child.setAncestors(ancestors);
        NodeMapper nm = new NodeMapper();
        nm.mapIfNeeded(n);
    }
}
