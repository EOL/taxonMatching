package com.bibalex.taxonmatcher.handlers;

import com.bibalex.taxonmatcher.models.Node;

import java.util.ArrayList;

/**
 * Created by Amr.Morad on 3/21/2017.
 */
public class MatchingScoreHandler {

    private double minimumAncestoryMatchPercentage;
    private double childMatchWeight;
    private double ancestorMatchWeight;

    public MatchingScoreHandler(){
        minimumAncestoryMatchPercentage = Double.parseDouble(ResourceHandler.getPropertyValue("minimumAncestoryMatchPercentage"));
        childMatchWeight = Double.parseDouble(ResourceHandler.getPropertyValue("childMatchWeight"));
        ancestorMatchWeight = Double.parseDouble(ResourceHandler.getPropertyValue("ancestorMatchWeight"));
    }

    public int countMatches(ArrayList<Node> matchingNodeChildren, ArrayList<Node> nodeChildren){
        matchingNodeChildren.retainAll(nodeChildren);
        return matchingNodeChildren.size();
    }

//    private ArrayList<String> getCildrenNames(ArrayList<Node> childrenNodes){
//        ArrayList<String> childrenNames = new ArrayList<String>();
//        for(Node childNode : childrenNodes){
//            childrenNames.add(childNode != null ? childNode.getScientificName() : null);
//        }
//        return childrenNames;
//    }

    public int countAncestors(Node node){
        int count = 0;
        if (node != null && node.getAncestors() != null) {
            for (Node n : node.getAncestors()) {
                if (n.getPageId() != 0)
                    count++;
            }
            return matchingAncestorsScore(count, node.getAncestors().size());
        }
        return 0;
    }

    public int matchingAncestorsScore(int matchingAncestorsCount, int totalAncestorsCount){
        if(matchingAncestorsCount <= (totalAncestorsCount * minimumAncestoryMatchPercentage))
            return 0;
        return matchingAncestorsCount;
    }

    public double calculateScore(int matchingChildren, int matchingAncestors){
        return matchingChildren * childMatchWeight + matchingAncestors * ancestorMatchWeight;
    }
}
