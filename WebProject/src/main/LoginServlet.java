package main;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
//        System.out.println("username:"+username);
//        System.out.println("passwprd:"+password);
        //连接数据进行数据查询
        //是否有该用户，密码是否对应该用户的密码
        //写死用户和密码 admin和666

        if("admin".equals(username)&&"666666".equals(password))
        {
            req.setAttribute("username",username);//参数回传
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
        else{
            //登陆失败会怎样
            req.setAttribute("username",username);//参数回传
            req.setAttribute("error","用户名或密码错误，请重新输入！");
            req.getRequestDispatcher("/").forward(req,resp); // 默认页面 welcome界面
        }
    }
}
