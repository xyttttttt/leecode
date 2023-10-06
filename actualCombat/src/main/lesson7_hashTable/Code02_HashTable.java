package main.lesson7_hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
 * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
 *
 * 示例 1：
 *
 * 输入：grid = [[3,2,1],[1,7,6],[2,7,7]]
 * 输出：1
 * 解释：存在一对相等行列对：
 * - (第 2 行，第 1 列)：[2,7,7]
 * 示例 2：
 *
 *
 * 输入：grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
 * 输出：3
 * 解释：存在三对相等行列对：
 * - (第 0 行，第 0 列)：[3,1,2,2]
 * - (第 2 行, 第 2 列)：[2,4,2,2]
 * - (第 3 行, 第 2 列)：[2,4,2,2]
 *
 * */
public class Code02_HashTable {

    public int equalPairs(int[][] grid) {
        int len = grid.length;
        Map<List<Integer>,Integer> map = new HashMap<>();
        for(int row = 0;row < len;row++){
            List<Integer> s = new ArrayList<Integer>();
            for(int col = 0;col < len;col++){
                s.add(grid[row][col]);
            }
            if(map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }else{
                map.put(s,1);
            }
        }
        int res = 0;
        for(int col = 0;col < len;col++){
            List<Integer> s = new ArrayList<Integer>();
            for(int row = 0;row < len;row++){
                s.add(grid[row][col]);
            }
            if(map.containsKey(s)){
                res +=map.get(s);
            }
        }
        return res;
    }
}
