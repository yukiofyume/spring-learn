package com.lwh.learn.tree;

import java.util.List;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-05 14:32:43
 * @describe tree 定义
 */
public interface ITreeNode<T extends ITreeNode<T>> {

    T parent();

    void setChildren(List<T> children);

    List<T> getChildren();
}
