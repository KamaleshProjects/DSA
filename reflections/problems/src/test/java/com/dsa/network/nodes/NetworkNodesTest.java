package com.dsa.network.nodes;

import com.dsa.vec.Vec;
import com.dsa.vec.VecArr;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NetworkNodesTest {

    @Test
    public void testSolve() {
        NetworkNodes networkNodes = new NetworkNodes();

        Vec<Vec<Integer>> weights = new VecArr<>();
        Vec<Integer> weight1 = new VecArr<>();
        weight1.append(2); weight1.append(1); weight1.append(1);
        Vec<Integer> weight2 = new VecArr<>();
        weight2.append(2); weight2.append(3); weight2.append(1);
        Vec<Integer> weight3 = new VecArr<>();
        weight3.append(3); weight3.append(4); weight3.append(1);
        weights.append(weight1); weights.append(weight2); weights.append(weight3);

        Assertions.assertEquals(2, networkNodes.solve(weights, 4, 2));
    }
}
