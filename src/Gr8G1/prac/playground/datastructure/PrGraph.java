package Gr8G1.prac.playground.datastructure;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;


public class PrGraph {
  public static int[][] createMatrix(int[][] edges) {
    if (edges.length == 0) return edges;
    int size = Arrays.stream(edges).flatMapToInt(Arrays::stream).max().orElse(0) + 1;

    int[][] adjacencyMatrix = new int[size][size];

    for (int[] edge: edges) {
      int from = edge[0];
      int to = edge[1];
      int dir = edge[2];

      // directed
      if (dir == 1) adjacencyMatrix[to][from] = 1;

      // undirected
      adjacencyMatrix[from][to] = 1;
    }

    return adjacencyMatrix;
  }

  public static boolean getDirections(int[][] matrix, int from, int to) {
    Queue<Integer> q = new LinkedList<>() {{
      for (int i = 0; i < matrix.length; i++) {
        if (matrix[from][i] == 1) add(i);
      }
    }};

    boolean[] visited = new boolean[matrix.length];
    Arrays.fill(visited, false);

    while (q.size() > 0) {
      Integer c = q.remove();
      visited[c] = true;

      if (c == to) return true;

      for (int i = 0; i < matrix.length; i++) {
        if (!visited[i] && matrix[c][i] == 1) {
          q.add(i);
        }
      }
    }

    return false;
  }

  public static int getConnectedVertex(int[][] edges) {
    int vertex = 0;
    int size = Arrays.stream(edges).flatMapToInt(Arrays::stream).max().orElse(0) + 1;

    Queue<Integer> q = new LinkedList<>();
    int[][] adjMatrix = new int[size][size];
    boolean[] visited = new boolean[size];
    Arrays.fill(visited, false);

    for (int[] edge: edges) {
      int from = edge[0];
      int to = edge[1];

      adjMatrix[from][to] = adjMatrix[to][from] = 1;
    }

    System.out.println(
      Arrays.deepToString(adjMatrix)
            .replace("[[", "[\n  [")
            .replace("], ", "]\n  ")
            .replace("]]", "]\n]")
    );

    // Adjacency Matrix
    //
    // I/O  0  1  2  3  4  5
    //  0  [0, 1, 0, 0, 0, 0] - in 1
    //  1  [1, 0, 0, 0, 0, 0] - in 1
    //  2  [0, 0, 0, 1, 0, 0] - in 1
    //  3  [0, 0, 1, 0, 1, 0] - in 2
    //  4  [0, 0, 0, 1, 0, 1] - in 2
    //  5  [0, 0, 0, 0, 1, 0] - in 1
    //      1  1  1  2  2  1

    int[] flatEdges = Arrays.stream(edges).flatMapToInt(Arrays::stream).distinct().toArray();

    for (int e: flatEdges) {
      if (!visited[e]) {
        // vertexDFS(visited, e, adjMatrix);

        // vertexBFS
        q.add(e);

        while (q.size() > 0) {
          Integer c = q.remove();
          visited[c] = true;

          for (int i = 0; i < adjMatrix.length; i++) {
            if (!visited[i] && adjMatrix[c][i] == 1) {
              visited[i] = true;
              q.add(i);
            }
          }
        }

        vertex++;
      }
    }

    return vertex;
  }

  public static void vertexDFS(boolean[] visited, int v, int[][] adjMatrix) {
    visited[v] = true;

    for (int i = 0; i < adjMatrix[v].length; i++) {
      if (!visited[i] && adjMatrix[v][i] == 1) {
        vertexDFS(visited, i, adjMatrix);
      }
    }
  }

  public static String barcodeDFS(int leng) {
    String[] availableStr = {"1", "2", "3"};

    Function<String, Boolean> validBarcode = vBarcode -> {
      String s;
      String e;

      for (int i = 1; i < (vBarcode.length() / 2) + 1; i++) {
        s = vBarcode.substring(vBarcode.length() - i);
        e = vBarcode.substring(vBarcode.length() - (i * 2), vBarcode.length() - i);

        if (s.equals(e)) return false;
      }

      return true;
    };

    BiFunction<Integer, String, String> genBarcode = new BiFunction<>() {
      @Override
      public String apply(Integer i, String gBarcode) {
        if (i == leng) return gBarcode;

        String[] available = Arrays.stream(availableStr)
            .filter(n -> n.charAt(0) != gBarcode.charAt(gBarcode.length() - 1))
            .toArray(String[]::new);

        for (String c : available) {
          String temp = gBarcode + c;

          if (validBarcode.apply(temp)) {
            String nBarcode = this.apply(i + 1, temp);

            if (!nBarcode.equals("")) {
              return nBarcode;
            }
          }
        }

        return "";
      }
    };

    return genBarcode.apply(1, "1");
  }

  public static void main(String[] args) {
    // int[][] adjacencyList = createMatrix(new int[][] {
    //     {0, 1, 0},
    //     {1, 3, 0},
    //     {3, 2, 1},
    //     {2, 4, 0}
    // });

    // System.out.println(
    //     Arrays.deepToString(adjacencyList)
    //         .replace("[[", "[\n  [")
    //         .replace("], ", "]\n  ")
    //         .replace("]]", "]\n]")
    // );

    // System.out.println(
    //   getDirections(adjecencyList,1,4)
    // );

    System.out.println(
        getConnectedVertex(new int[][] {
            {0, 1},
            {2, 3},
            {3, 4},
            {4, 5}
        })
    );

    System.out.println(barcodeDFS(3));
    // System.out.println(barcodeDFS(7));
    // System.out.println(barcodeDFS(20));
  }
}
