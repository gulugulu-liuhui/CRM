package com.company.crm.workbench.service;

import com.company.crm.workbench.domain.Tran;

public interface TranService {
    boolean save(Tran t, String customerName);
}
