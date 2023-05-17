package com.ksathe.javapracticedemo.leetcode;
import java.util.*;

public class Solution2246 {
    //https://leetcode.com/problems/longest-path-with-different-adjacent-characters/
    int longestPath = 1;
    public int longestPath(int[] parent, String nodesInfo) {
        if (parent.length == nodesInfo.length() && parent.length > 1) {
            List<Node> allNodesByIndex = new ArrayList<>(parent.length);
            for (int i = 0; i < parent.length; i++) {
                Node currParent = (i == 0) ? null : allNodesByIndex.get(parent[i]);
                //TODO remove i from node contructor
                Node curr = new Node(i, nodesInfo.charAt(i), new HashSet<>(), currParent);
                allNodesByIndex.add(curr);
            }
            for (int i = (nodesInfo.length() - 1); i > 0; i--) {
                updateChildren(allNodesByIndex, i, parent);
            }
            Queue<Node> inspectionList = new ArrayDeque<>();
            inspectionList.add(allNodesByIndex.get(0));//add root

            while(!inspectionList.isEmpty()) {
                Node curr = inspectionList.poll();
                List<String> allPaths = calculatePaths(curr.name.toString(), curr);
                int pathTemp = getLongestFromList(allPaths);
                longestPath = Math.max(longestPath, pathTemp);
            }
            //return longest
            return longestPath;
        } else {
            return parent.length == 1 ? 1 : 0;
        }
    }

    private List<String> calculatePaths(String path, Node currNode) {
        List<String> paths = new ArrayList<>();
        if (currNode == null || currNode.children.isEmpty()) {
            return paths;
        }

        for (Node n: currNode.children) {
            // build and add to paths
        }
        return paths;
    }

    // given n paths in the list find all 2 path combinations and return longest
    private int getLongestFromList(List<String> paths) {
        //
        return 0;
    }
    private void updateChildren(List<Node> list, int currIndex, int[] parent) {
        if (currIndex > 0) {
            Node curr = list.get(currIndex);
            Node parentNode = list.get(parent[currIndex]);
            curr.parent = parentNode;
            parentNode.children.add(curr);
        }
    }

    private class Node {
        //Integer parentIndex;
        Character name;
        Set<Node> children;
        Node parent;

        public Node(Integer pIndex,Character id, Set<Node> nodes, Node pp) {
            //this.parentIndex = pIndex;
            this.name = id;
            this.children = nodes;
            this.parent = pp;
        }
    }
}
