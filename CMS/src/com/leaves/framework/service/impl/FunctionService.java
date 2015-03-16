package com.leaves.framework.service.impl;

import com.leaves.framework.dao.IFunctionDao;
import com.leaves.framework.model.Function;
import com.leaves.framework.service.IFunctionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: jiangq
 * Date: 2015/3/13
 * Time: 15:37
 * Description:
 */
@Service("functionService")
@Transactional
public class FunctionService implements IFunctionService {
    @Resource(name = "functionDao")
    IFunctionDao functionDao;

    @Override
    public List<Function> findAll() {
        return functionDao.findAll();
    }

    @Override
    public String addOrUpdate(Function function) {
        functionDao.createOrUpdate(function);
        return "ok";
    }

    @Override
    public void deleteById(String id) {
        functionDao.deleteById(id);
        functionDao.deleteChildren(id);
    }
}
