package com.company.crm.workbench.web.controller;

import com.company.crm.settings.domain.User;
import com.company.crm.settings.service.UserService;
import com.company.crm.settings.service.impl.UserServiceImpl;
import com.company.crm.utils.DateTimeUtil;
import com.company.crm.utils.PrintJson;
import com.company.crm.utils.ServiceFactory;
import com.company.crm.utils.UUIDUtil;
import com.company.crm.vo.PaginationVo;
import com.company.crm.workbench.domain.Activity;
import com.company.crm.workbench.domain.ActivityRemark;
import com.company.crm.workbench.service.ActivityService;
import com.company.crm.workbench.service.impl.ActivityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClueController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到线索控制器");

        String path = request.getServletPath();

        if("/workbench/clue/xxx.do".equals(path)){

            //xxx(request,response);

        } else if("/workbench/clue/xxx.do".equals(path)) {

            //xxx(request, response);

        }
    }



}
