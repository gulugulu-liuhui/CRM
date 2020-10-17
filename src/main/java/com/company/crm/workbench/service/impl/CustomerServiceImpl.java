package com.company.crm.workbench.service.impl;

import com.company.crm.utils.SqlSessionUtil;
import com.company.crm.workbench.dao.CustomerDao;
import com.company.crm.workbench.domain.Customer;
import com.company.crm.workbench.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao = SqlSessionUtil.getSqlSession().getMapper(CustomerDao.class);

    @Override
    public List<String> getCustomerName(String name) {

        List<String> sList = customerDao.getCustomerName(name);

        return sList;
    }
}
