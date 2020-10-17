package com.company.crm.workbench.service.impl;

import com.company.crm.utils.SqlSessionUtil;
import com.company.crm.workbench.dao.TranDao;
import com.company.crm.workbench.dao.TranHistoryDao;
import com.company.crm.workbench.service.TranService;

public class TranServiceImpl implements TranService {

    private TranDao tranDao = SqlSessionUtil.getSqlSession().getMapper(TranDao.class);
    private TranHistoryDao tranHistoryDao = SqlSessionUtil.getSqlSession().getMapper(TranHistoryDao.class);

}
