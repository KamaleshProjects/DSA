package com.dsa.cryptic.line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * You are given a historical family tree of the noble kingdom, represented as a tree structure.
 * The tree contains information about generations of ancestors and descendants.
 * Your goal is to answer a series of queries in a way that helps people establish their ancestral connections.
 * For each query, you will receive two names, let's call them Person X and Person Y.
 *
 * Person 1 is the root of the family tree. Your task is to determine whether Person X is an ancestor of Person Y
 * or not. If Person X is indeed an ancestor of Person Y, you should respond with YES otherwise, you should reply with
 * NO. Think of yourself as the custodian of this invaluable historical record, helping the kingdom's residents trace
 * their noble lineage. Can you provide accurate responses to these queries and unveil the ancestral ties that
 * bind the kingdom's inhabitants together?
 *
 */
public class CrypticLine {

    private static final Logger log = Logger.getLogger(CrypticLine.class.getName());

    private static final String SPACE = " ";

    /**
     * Input Format:
     *
     * The first line contains an integer N, representing the number of nodes in the family tree.
     * The second line contains an integer Q, representing the number of queries.
     * The following N - 1 lines each contain two space-separated integers U and V indicating an ancestral connection
     * between nodes U and V in the family tree. The next Q lines contain two space-separated integers X and Y,
     * representing the individuals for each query.
     *
     * Constraints:
     *
     * 1 <= N, Q <= 2*10^5
     * 1 <= U, V <= N
     * 1 <= X, Y <= N
     */
    public void readInputStdIn() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String NStr = br.readLine();
            String QStr = br.readLine();

            int N = Integer.parseInt(NStr);
            int Q = Integer.parseInt(QStr);

            int[][] ancestralConnection = new int[N-1][2];
            for (int i = 0; i < N; i++) {
                String connection = br.readLine();
                StringTokenizer tokenizer = new StringTokenizer(connection, SPACE);
                String nodeUStr = tokenizer.nextToken();
                String nodeVStr = tokenizer.nextToken();
                int nodeU = Integer.parseInt(nodeUStr);
                int nodeV = Integer.parseInt(nodeVStr);

                // v is child of u or u is parent of v is the assumption
                ancestralConnection[i][0] = nodeU;
                ancestralConnection[i][1] = nodeV;
            }

            int[][] ancestralQueries = new int[Q-1][2];
            for (int i = 0; i < Q; i++) {
                String query = br.readLine();
                StringTokenizer tokenizer = new StringTokenizer(query, SPACE);
                String XStr = tokenizer.nextToken();
                String YStr = tokenizer.nextToken();
                int x = Integer.parseInt(XStr);
                int y = Integer.parseInt(YStr);

                // is person x ancestor of person y or if y is descendant of x
                ancestralQueries[i][0] = x;
                ancestralQueries[i][1] = y;
            }

            // construct a tree lib


        } catch (IOException e) {
            log.log(Level.SEVERE, "error during reading of input from stdin", e);
        }
    }

    public void solve() {

    }

    /**
     * Output Format:
     *
     * For each query, output either YES if Person X is an ancestor of Person Y, or NO if Person X is not an ancestor
     * of Person Y.
     */
    public void printOutputStdOut() {

    }
}
