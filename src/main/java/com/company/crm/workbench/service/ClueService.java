package com.company.crm.workbench.service;

import com.company.crm.workbench.domain.Clue;

public interface ClueService {
    boolean save(Clue c);

    Clue detail(String id);

    Boolean unbund(String id);
}
