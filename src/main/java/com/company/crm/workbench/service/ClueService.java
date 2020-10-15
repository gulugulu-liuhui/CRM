package com.company.crm.workbench.service;

import com.company.crm.workbench.domain.Clue;
import com.company.crm.workbench.domain.Tran;

public interface ClueService {
    boolean save(Clue c);

    Clue detail(String id);

    Boolean unbund(String id);

    Boolean bund(String cid, String[] aids);

    boolean convert(String clueId, Tran t, String createBy);
}
