package graph_depth;

import java.util.*;

/**
 * @author Niu
 * @date 2026-03-08
 */
public class Problem46_Lt399 {
    public static void main(String[] args) {
        double[] calcEquation = new Problem46_Lt399().calcEquation(List.of(List.of("a", "e"), List.of("b", "e"))
                , new double[]{4.0, 3.0},
                List.of(List.of("a", "b"), List.of("e", "e"), List.of("x", "x")));
        System.out.println(Arrays.toString(calcEquation));

    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 构建图：每个变量是节点，每条边有权重
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        // 建图
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];
            
            graph.computeIfAbsent(a, k -> new HashMap<>()).put(b, value);
            graph.computeIfAbsent(b, k -> new HashMap<>()).put(a, 1.0 / value);
        }
        
        double[] ans = new double[queries.size()];
        Set<String> knownVariables = graph.keySet();
        
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String variable1 = query.get(0);
            String variable2 = query.get(1);
            
            if (!knownVariables.contains(variable1) || !knownVariables.contains(variable2)) {
                ans[i] = -1.0;
            } else if (variable1.equals(variable2)) {
                ans[i] = 1.0;
            } else {
                ans[i] = bfs(graph, variable1, variable2);
            }
        }
        return ans;
    }
    /**
     * BFS 搜索从 start 到 target 的路径
     * @param graph 图结构
     * @param start 起始变量
     * @param target 目标变量
     * @return 计算结果，如果无法到达返回 -1.0
     */
    private double bfs(Map<String, Map<String, Double>> graph, String start, String target) {
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(new Node(start, 1.0));
        visited.add(start);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            String node = current.name;
            double product = current.value;
            
            if (node.equals(target)) {
                return product;
            }
            
            if (!graph.containsKey(node)) {
                continue;
            }
            
            for (Map.Entry<String, Double> entry : graph.get(node).entrySet()) {
                String neighbor = entry.getKey();
                double weight = entry.getValue();
                
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(new Node(neighbor, product * weight));
                }
            }
        }
        
        return -1.0;
    }
    
    /**
     * BFS 节点类，存储变量名和累积的乘积值
     */
    static class Node {
        String name;
        double value;
        
        Node(String name, double value) {
            this.name = name;
            this.value = value;
        }
    }
}
