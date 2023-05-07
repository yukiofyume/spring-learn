package com.lwh.learn.tree;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-05 16:09:26
 * @describe --
 */
@Data
public class OrgTreeVO implements ITreeNode<OrgTreeVO>, Serializable {
    @Serial
    private static final long serialVersionUID = 8887010773094543450L;

    private Long id;
    private String name;
    private Long parentId;
    private List<OrgTreeVO> children;


    public OrgTreeVO(Long id) {
        this.id = id;
    }

    public OrgTreeVO(Long id, String name, Long parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }


    @Override
    public OrgTreeVO parent() {
        return parentId == null ? null : new OrgTreeVO(parentId);
    }

    /**
     * 这里重写 equals 方法是必须的，用这个方法判断node是否相等
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof OrgTreeVO && Objects.equals(id, ((OrgTreeVO) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
