package com.wyh.demo.hope;

import java.util.*;

/**
 * @Classname LeetCode207
 * @Description TODO
 * @Date 2022/9/8 0:08
 * @Created by 61635
 * 课程表
 */
public class LeetCode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 记录每个位置的入度数
        int[] indegrees = new int[numCourses];
        // 去除掉某个节点时 减少相应的位置的入度数 类似于 3和4节点要依赖0节点
        // 当0节点被去除掉是 相应的3和4节点也需要减少入度数
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        //Set<Integer> set = new LinkedHashSet<>();
        for(int i = 0;i<numCourses;i++){
            adjacency.add(new ArrayList<>());
        }
        for(int[] cp:prerequisites){
            indegrees[cp[0]]++;
            // 反应节点之间的关系 有可能是相互关系 也有能多个数值关注cp[1]
            adjacency.get(cp[1]).add(cp[0]);
        }
        // 添加没有入度的节点到队列
        for(int i = 0;i<numCourses;i++){
            if(indegrees[i] == 0){
                queue.add(i);
                //set.add(i);
            }
        }
        // 当队列不为空是 一直循环 并且减少课程
        while(!queue.isEmpty()){
            int i = queue.poll();
            numCourses--;
            for(int curr:adjacency.get(i)){
                if(--indegrees[curr] == 0){
                    queue.add(curr);
                    //set.add(curr);
                }
            }
        }
        return numCourses <= 0;
    }
}
