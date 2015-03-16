package com.leaves.framework.service;

import com.leaves.framework.model.Function;

import java.util.List;

/**
 * User: jiangq
 * Date: 2015/3/13
 * Time: 15:19
 * Description:
 */
public interface IFunctionService {
    /**
     * 查询所有功能
     * @return 功能list
     */
    List<Function> findAll();

    /**
     * 新增或更新功能
     * @param function 功能
     * @return ok/existed
     */
    String addOrUpdate(Function function);

    /**
     * 删除功能
     * @param id 功能id
     */
    void deleteById(String id);
}
