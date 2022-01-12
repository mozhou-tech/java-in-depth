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

        private Node left, right;

        public Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    static class Tree {

        /**
         * 递归插入左树右树（自动有序）
         *
         * @param node 根节点
         * @param value 插入值
         */
        public void insert(Node node, int value) {
            // 小于在左树、大于在右树
            if (value < node.value) {
                if (Objects.nonNull(node.left)) {
                    // 递归到下一级子树
                    insert(node.left, value);
                } else {
                    log.info("Inserted {} to left of {}", value, node.value);
                    node.left = new Node(value);
                }
            } else if (value > node.value) {
                if (Objects.nonNull(node.right)){
                    insert(node.right,value);
                }else {
                    log.info("Inserted {} to right of {}", value, node.value);
                    node.right = new Node(value);
                }
            }
        }

        /**
         * 按顺序递归二叉树（可类比洋葱模型）
         *
         * @param node
         */
        public void traverseInOrder(Node node) {
            if (Objects.nonNull(node)) {
                // 打印左树（先打印最小值）
                traverseInOrder(node.left);
                // 打印完所有子树，才打印当前Node的值
                System.out.print(" " + node.value);
                // 打印右树（从小到大）
                traverseInOrder(node.right);
            }
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = new Node(5);
        log.info("Binary Tree Example");
        log.info("Building tree with root value {}", root.value);
        tree.insert(root, 2);
        tree.insert(root, 4);
        tree.insert(root, 8);
        tree.insert(root, 6);
        tree.insert(root, 7);
        tree.insert(root, 3);
        tree.insert(root, 9);
        log.info("Traversing tree in order");
        tree.traverseInOrder(root);
    }
}
