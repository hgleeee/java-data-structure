package ch10_trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    private Node root;
    private int index;

    public Trie() {
        this.root = new Node("");
    }

    public void insert(String key, int value) {
        Node tempNode = root;

        for (int i = 0; i < key.length(); ++i) {
            char c = key.charAt(i);
            int asciiIndex = transformAsciiIndex(c);

            // 하위노드에 해당 알파벳이 존재하지 않는 경우
            if (tempNode.getChild(asciiIndex) == null) {
                Node node = new Node(String.valueOf(c));
                tempNode.setChild(asciiIndex, node, value);
                tempNode = node;
                continue;
            }
            // 존재하는 경우
            tempNode = tempNode.getChild(asciiIndex);
        }

        tempNode.setLeaf(true);
    }

    public boolean search(String key) {

        Node tempNode = root;

        for (int i = 0; i < key.length(); ++i) {
            char c = key.charAt(i);
            int asciiIndex = transformAsciiIndex(c);
            if (tempNode.getChild(asciiIndex) == null) {
                return false;
            }
            tempNode = tempNode.getChild(asciiIndex);
        }
        return true;
    }

    public Integer searchAsMap(String key) {

        Node tempNode = root;

        for (int i = 0; i < key.length(); ++i) {
            char c = key.charAt(i);
            int asciiIndex = transformAsciiIndex(c);
            if (tempNode.getChild(asciiIndex) == null) {
                return null;
            }
            tempNode = tempNode.getChild(asciiIndex);
        }
        return tempNode.getValue();
    }

    // AutoComplete : 자동 완성
    public List<String> allWordsWithPrefix(String prefix) {

        List<String> allWords = new ArrayList<>();
        Node tempNode = root;

        for (int i = 0; i < prefix.length(); ++i) {
            int asciiIndex = transformAsciiIndex(prefix.charAt(i));
            if (tempNode.getChild(asciiIndex) == null) {
                return new ArrayList<>();
            }
            tempNode = tempNode.getChild(asciiIndex);
        }

        collect(tempNode, prefix, allWords);
        return allWords;
    }

    // 가장 긴 접두사 반환
    public String longestCommonPrefix() {
        Node tempNode = root;
        StringBuilder longestCommonPrefixSb = new StringBuilder();

        // 하위노드가 여러 개거나 leaf 노드일 때까지 반복 수행
        while (countNumOfChildren(tempNode) == 1 && !tempNode.isLeaf()) {
            tempNode = tempNode.getChild(index);
            longestCommonPrefixSb = longestCommonPrefixSb.append((char)(index + 'a'));
        }
        return longestCommonPrefixSb.toString();
    }

    // 정렬
    public void sort() {
        List<String> list = allWordsWithPrefix("");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    // 하위 노드의 갯수 반환
    private int countNumOfChildren(Node trieNode) {
        int numOfChildren = 0; // 하위 노드 개수 0으로 초기화

        // 하위 노드의 개수 만큼 반복 수행
        for (int i = 0; i < trieNode.getChildren().length; i++) {
            // 하위 노드가 존재하면
            if (trieNode.getChild(i) != null) {
                numOfChildren++; // 하위 노드 1 증가
                index = i; // 단일 노드의 인덱스
            }
        }
        return numOfChildren;
    }

    private void collect(Node node, String prefix, List<String> allWords) {
        if (node == null) {
            return;
        }
        if (node.isLeaf()) {
            allWords.add(prefix);
            return;
        }
        // 노드의 자식노드의 수 만큼 반복 수행
        for (Node childNode : node.getChildren()) {
            if (childNode == null) {
                continue;
            }
            // 자식노드의 알파벳
            String childCharacter = childNode.getCharacter();
            collect(childNode, prefix + childCharacter, allWords);
        }
    }

    private int transformAsciiIndex(char c) {
        return c - 'a';
    }
}
