package com.bibalex.taxonmatcher.handlers;

import com.bibalex.taxonmatcher.models.Node;
import java.util.ArrayList;

/**
 * Created by Amr.Morad on 3/9/2017.
 */
public class NodeHandler {

    public Node matchedAncestor(ArrayList<Node> ancestors, int depth){
        int i = 0;
        for(Node ancestor : ancestors){
            if (ancestor.getPageId() != 0 && i >= depth)
                return ancestor;
            i++;
        }
        return null;
    }
}
