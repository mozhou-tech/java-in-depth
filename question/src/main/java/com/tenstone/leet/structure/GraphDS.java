package com.tenstone.leet.structure;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by liuyuancheng on 2022/1/11  <br/>
 *
 * @author liuyuancheng
 */
public class GraphDS {

    static class Vertex {

        private String label;

        private Vertex() {}

        public Vertex(String label) {
            this.label = label;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return Objects.equals(label, vertex.label);
        }

        @Override
        public int hashCode() {
            return Objects.hash(label);
        }

        @Override
        public String toString(){
            return label;
        }
    }


    static class Graph {

        private Map<Vertex, List<Vertex>> adjVertices;

        public Graph() {
            adjVertices = Maps.newHashMap();
        }

        public void addVertex(String label) {
            adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
        }

        public void removeVertex(String label) {
            Vertex v = new Vertex(label);
            adjVertices.values().stream().forEach(e -> e.remove(v));
            adjVertices.remove(new Vertex(label));
        }

        public void addEdge(String label1, String label2) {
            Vertex v1 = new Vertex(label1);
            Vertex v2 = new Vertex(label2);
            adjVertices.get(v1).add(v2);
            adjVertices.get(v1).add(v1);
        }

        public void removeEdge(String label1, String label2) {
            Vertex v1 = new Vertex(label1);
            Vertex v2 = new Vertex(label2);
            List<Vertex> eV1 = adjVertices.get(v1);
            List<Vertex> eV2 = adjVertices.get(v2);
            if (Objects.nonNull(eV1)) {
                eV1.remove(v2);
            }
            if (Objects.nonNull(eV2)) {
                eV2.remove(v1);
            }
        }

        public List<Vertex> getVertexes(String label) {
            return adjVertices.get(new Vertex(label));
        }


        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            for (Vertex vertex : adjVertices.keySet()) {
                sb.append(vertex);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");

        System.out.println(graph);
        System.out.println(graph.getVertexes("Bob"));
    }
}
