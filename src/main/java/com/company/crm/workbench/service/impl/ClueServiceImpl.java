package com.company.crm.workbench.service.impl;

import com.company.crm.utils.SqlSessionUtil;
import com.company.crm.workbench.dao.ClueActivityRelationDao;
import com.company.crm.workbench.dao.ClueDao;
import com.company.crm.workbench.domain.Clue;
import com.company.crm.workbench.service.ClueService;

public class ClueServiceImpl implements ClueService {

    private ClueDao clueDao = SqlSessionUtil.getSqlSession().getMapper(ClueDao.class);
    private ClueActivityRelationDao clueActivityRelationDao = SqlSessionUtil.getSqlSession().getMapper(ClueActivityRelationDao.class);

    @Override
    public boolean save(Clue c) {

        boolean flag = true;

        int count = clueDao.save(c);

        if (count != 1){

            flag = false;

        }

        return flag;
    }

    @Override
    public Clue detail(String id) {

        Clue c = clueDao.detail(id);

        return c;
    }

    @Override
    public Boolean unbund(String id) {

        Boolean flag = true;

        int count = clueActivityRelationDao.unbund(id);

        if (count != 1){

            flag = false;

        }

        return flag;
    }
}
