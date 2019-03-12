package com.wzc.web.listener;

import com.wzc.bean.CircleExample;
import com.wzc.bean.TopicExample;
import com.wzc.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Service
public class ContextListener implements HttpSessionListener, ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context =servletContextEvent.getServletContext();
        IUserService userService = (IUserService) getObjectFromApplication(context,"userServiceImpl");
        ITopicService topicService = (ITopicService) getObjectFromApplication(context,"topicServiceImpl");
        ICircleService circleService = (ICircleService) getObjectFromApplication(context,"circleServiceImpl");
        context.setAttribute("userTotal",userService.countByExample(null));
        context.setAttribute("topicTotal",topicService.countByExample(null));
        TopicExample example1 =new TopicExample();
        example1.createCriteria().andStateNotEqualTo("1");
        context.setAttribute("auditTopicTotal",topicService.countByExample(example1));
        context.setAttribute("circleTotal",circleService.countByExample(null));
        CircleExample example2 =new CircleExample();
        example2.createCriteria().andCircleStateNotEqualTo("1");
        context.setAttribute("auditCircleTotal",circleService.countByExample(example2));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("                                                                    ");
        System.out.println("                            欢迎使用                                ");
        System.out.println("                                                                    ");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext context = httpSessionEvent.getSession().getServletContext();
        Integer onLineCount = (Integer) context.getAttribute("onLineCount");
        if(onLineCount==null){
            context.setAttribute("onLineCount", 1);
        }else{
            onLineCount++;
            context.setAttribute("onLineCount", onLineCount);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext context = httpSessionEvent.getSession().getServletContext();
        Integer onLineCount = (Integer) context.getAttribute("onLineCount");
        if(onLineCount==null){
            context.setAttribute("onLineCount", 1);
        }else{
            onLineCount--;
            context.setAttribute("onLineCount", onLineCount);
        }
    }

    /**
     * 通过WebApplicationContextUtils 得到Spring容器的实例。根据bean的名称返回bean的实例。
     * @param servletContext  ：ServletContext上下文。
     * @param beanName  :要取得的Spring容器中Bean的名称。
     * @return 返回Bean的实例。
     */
    private Object getObjectFromApplication(ServletContext servletContext,String beanName){
        //通过WebApplicationContextUtils 得到Spring容器的实例。
        ApplicationContext application=WebApplicationContextUtils.getWebApplicationContext(servletContext);
        //返回Bean的实例。
        return application.getBean(beanName);
    }
}
