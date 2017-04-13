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
        return 0;
    }

    public int countAncestors(Node node){
        int count = 0;
        for(Node n : node.getAncestors()){
            if (n.getPageId() != 0)
                count++;
        }
        return matchingAncestorsScore(count, node.getAncestors().size());
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
