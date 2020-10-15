package com.company.workbench.test;

import com.company.crm.utils.ServiceFactory;
import com.company.crm.utils.UUIDUtil;
import com.company.crm.workbench.domain.Activity;
import com.company.crm.workbench.service.ActivityService;
import com.company.crm.workbench.service.impl.ActivityServiceImpl;
import org.junit.Test;

public class ActivityTest {

    @Test
    public void testSave(){

        Activity a = new Activity();
        a.setId(UUIDUtil.getUUID());
        a.setName("宣传推广会");

        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        boolean flag = as.save(a);

        System.out.println(flag);

    }

    /*@Test
    public void testUpdate(){

        System.out.println("234");

    }*/

}
