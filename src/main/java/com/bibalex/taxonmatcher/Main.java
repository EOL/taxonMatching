package com.bibalex.taxonmatcher;

import com.bibalex.taxonmatcher.controllers.NodeMapper;
import com.bibalex.taxonmatcher.handlers.LogHandler;
import com.bibalex.taxonmatcher.handlers.ResourceHandler;
import com.bibalex.taxonmatcher.models.Node;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ResourceHandler.initialize("config.properties");
        LogHandler.initializeHandler();

        ArrayList<Node> children = new ArrayList<Node>();
        Node child = new Node(1, 1,1,1,"tat","tateen","kingdom");
        children.add(child);

        ArrayList<Node> ancestors = new ArrayList<Node>();
        Node n = new Node(2, 1,1,1,"kak","kakeen","kingdom");
        ancestors.add(n);

        n.setChildren(children);
        child.setAncestors(ancestors);
        NodeMapper nm = new NodeMapper();
        nm.mapIfNeeded(n);
    }
}
