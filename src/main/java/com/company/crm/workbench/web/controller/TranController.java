package com.company.crm.workbench.web.controller;

import com.company.crm.settings.domain.User;
import com.company.crm.settings.service.UserService;
import com.company.crm.settings.service.impl.UserServiceImpl;
import com.company.crm.utils.DateTimeUtil;
import com.company.crm.utils.PrintJson;
import com.company.crm.utils.ServiceFactory;
import com.company.crm.utils.UUIDUtil;
import com.company.crm.workbench.domain.Activity;
import com.company.crm.workbench.domain.Clue;
import com.company.crm.workbench.domain.Customer;
import com.company.crm.workbench.domain.Tran;
import com.company.crm.workbench.service.ActivityService;
import com.company.crm.workbench.service.ClueService;
import com.company.crm.workbench.service.CustomerService;
import com.company.crm.workbench.service.TranService;
import com.company.crm.workbench.service.impl.ActivityServiceImpl;
import com.company.crm.workbench.service.impl.ClueServiceImpl;
import com.company.crm.workbench.service.impl.CustomerServiceImpl;
import com.company.crm.workbench.service.impl.TranServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TranController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到交易控制器");

        String path = request.getServletPath();

        if("/workbench/transaction/add.do".equals(path)){

            add(request,response);

        }else if("/workbench/transaction/getCustomerName.do".equals(path)) {

            getCustomerName(request, response);

        }else if("/workbench/transaction/save.do".equals(path)) {

            save(request, response);

        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("执行添加交易的操作");

        String id = UUIDUtil.getUUID();
        String owner = request.getParameter("owner");
        String money = request.getParameter("money");
        String name = request.getParameter("name");
        String expectedDate = request.getParameter("expectedDate");
        String customerName = request.getParameter("customerName");
        String stage = request.getParameter("stage");
        String type = request.getParameter("type");
        String source = request.getParameter("source");
        String activityId = request.getParameter("activityId");
        String contactsId = request.getParameter("contactsId");
        String createTime = DateTimeUtil.getSysTime();
        String createBy = ((User)request.getSession().getAttribute("user")).getName();
        String description = request.getParameter("description");
        String contactSummary = request.getParameter("contactSummary");
        String nextContactTime = request.getParameter("nextContactTime");

        Tran t = new Tran();

        t.setId(id);
        t.setOwner(owner);
        t.setMoney(money);
        t.setName(name);
        t.setExpectedDate(expectedDate);
        t.setStage(stage);
        t.setType(type);
        t.setSource(source);
        t.setActivityId(activityId);
        t.setContactsId(contactsId);
        t.setCreateTime(createTime);
        t.setCreateBy(createBy);
        t.setDescription(description);
        t.setContactSummary(contactSummary);
        t.setNextContactTime(nextContactTime);

        TranService ts = (TranService) ServiceFactory.getService(new TranServiceImpl());

        boolean flag = ts.save(t, customerName);

        if (flag){

            //如果添加交易成功，跳转到列表页
            response.sendRedirect(request.getContextPath() + "/workbench/transaction/index.jsp");

        }

    }

    private void getCustomerName(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("取得客户名称列表（按照客户的名称模糊查询）");

        String name = request.getParameter("name");

        CustomerService cs = (CustomerService) ServiceFactory.getService(new CustomerServiceImpl());

        List<String> sList = cs.getCustomerName(name);

        PrintJson.printJsonObj(response, sList);

    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("进入到跳转到交易添加页的操作");

        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());

        List<User> uList = us.getUserList();

        request.setAttribute("uList", uList);
        request.getRequestDispatcher("/workbench/transaction/save.jsp").forward(request, response);

    }


}
