package com.whj.jimmerdemo.dao;

import com.whj.jimmerdemo.model.TreeNode;
import org.babyfish.jimmer.spring.repository.JRepository;

public interface TreeNodeRepository extends JRepository<TreeNode, Long> {
    
}
