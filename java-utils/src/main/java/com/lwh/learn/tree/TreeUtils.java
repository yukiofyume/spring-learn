package com.lwh.learn.tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-05 14:36:15
 * @describe --
 */
public class TreeUtils {

    public static <T extends ITreeNode<T>> List<T> list2Tree(List<T> list) {
        var roots = new LinkedList<T>();
        var relations = new HashMap<T, List<T>>();
        // 第一次遍历，记录节点间的父子关系
        for (T node : list) {
            if (node.parent() == null) {
                roots.add(node);
            }
            List<T> relation = relations.computeIfAbsent(node.parent(), p -> new LinkedList<>());
            relation.add(node);
        }
        // 第二次遍历，根据父子关系建立树
        var stack = roots.stream().collect(Collectors.toCollection(Stack::new));
        while (!stack.isEmpty()) {
            T node = stack.pop();
            node.setChildren(relations.getOrDefault(node, Collections.emptyList()));
            stack.addAll(node.getChildren());
        }
        return roots;
    }

    /**
     * 层序遍历
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T extends ITreeNode<T>> List<T> tree2List(List<T> list) {
        List<T> resList = new ArrayList<>();
        if (list.size() < 1) {
            return resList;
        }
        list.forEach(root -> {
            var queue = new ArrayDeque<T>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int count = queue.size();
                List<T> tmpList = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    T cur = queue.poll();
                    Optional.ofNullable(cur).ifPresent(s -> {
                        s.getChildren().forEach(queue::offer);
                        cur.setChildren(null);
                        tmpList.add(cur);
                    });
                }
                resList.addAll(tmpList);
            }
        });
        return resList;
    }

    public static void main(String[] args) {
        List<OrgTreeVO> orgTreeVOS = new ArrayList<>();
        orgTreeVOS.add(new OrgTreeVO(1L, "父节点1", null));
        orgTreeVOS.add(new OrgTreeVO(2L, "子节点1", 1L));
        orgTreeVOS.add(new OrgTreeVO(3L, "子节点2", 1L));
        orgTreeVOS.add(new OrgTreeVO(4L, "子节点3", 1L));
        List<OrgTreeVO> treeList = list2Tree(orgTreeVOS);
        List<OrgTreeVO> listList = tree2List(treeList);
    }
}
