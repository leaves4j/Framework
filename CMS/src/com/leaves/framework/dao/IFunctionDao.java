package com.leaves.framework.dao;

import com.leaves.framework.common.IOperations;
import com.leaves.framework.model.Function;

/**
 * User: jiangq
 * Date: 2015/3/13
 * Time: 15:17
 * Description:
 */
public interface IFunctionDao extends IOperations<Function> {

    void deleteChildren(String id);
}
