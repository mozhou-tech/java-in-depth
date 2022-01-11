package com.tenstone.leet.structure;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * Created by liuyuancheng on 2022/1/11  <br/>
 * 二叉树是最多有2个节点的递归树结构
 *
 * @author liuyuancheng
 */
@Slf4j
public class BinaryTreeDS {

    @Data
    static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    static class Tree {
        public void insert(Node node, int value) {
            if (value < node.value) {
                if (Objects.nonNull(node.left)) {
                    insert(node.left, value);
                } else {
                    log.info("Inserted {} to left of {}", value, node.value);
                    node.left = new Node(value);
                }
            } else if (value > node.value) {
                if (Objects.nonNull(node.right)) {
                    log.info("Inserted {} to right of {}", value, node.value);
                    node.right = new Node(value);
                }
            }
        }


        public void traverseInOrder(Node node) {
            if (Objects.nonNull(node)) {
                traverseInOrder(node.left);
                log.info(" " + node.value);
                traverseInOrder(node.right);
            }
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = new Node(5);
        
    }
}
