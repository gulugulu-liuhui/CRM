package com.company.crm.workbench.dao;

import com.company.crm.workbench.domain.Clue;

public interface ClueDao {


    int save(Clue c);

    Clue detail(String id);
}
