package com.bibalex.taxonmatcher.handlers;

import com.bibalex.taxonmatcher.models.Node;
import java.util.ArrayList;

/**
 * Created by Amr.Morad on 3/9/2017.
 */
public class NodeHandler {

    public Node matchedAncestor(ArrayList<Node> ancestors, int depth){
        System.out.println("matched ancestor");
        int i = 0;
        if (ancestors != null) {
            for (Node ancestor : ancestors) {
                if (ancestor.getPageId() != 0 && i >= depth)
                    return ancestor;
                i++;
            }
        }
        System.out.println("matched ancestor: will return null");
        return null;
    }

    public ArrayList<Node> nativeVirus(){
        //TODO: implement native virus from DWH
        return new Neo4jHandler().getNativeVirusNode();
//        return new Node(1,1,9, "virus", "viruseen", "kingdom");
//        return new Node("1", "Virus", "kingdom", "viruseen", "viruses", "virussss");

    }

}
