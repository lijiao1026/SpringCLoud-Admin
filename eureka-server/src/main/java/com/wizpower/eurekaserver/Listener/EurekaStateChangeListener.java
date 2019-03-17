package com.wizpower.eurekaserver.Listener;


import com.netflix.appinfo.InstanceInfo;
import com.wizpower.eurekaserver.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * EurekaInstanceRegisteredEvent 和EurekaServerStartedEvent事件会在eureka服务启动后被触发
 * 首先触发Eureka服务器EurekaInstanceRegisteredEvent，然后判断如果eureka服务器已经在运行，则触发EurekaServerStartedEvent
 */
@Component
public class EurekaStateChangeListener {
    @Autowired
    private MailService mailService;

    @Value("${spring.mail.toMail}")
    private String toMail;
    /**
     * 客户端下线触发事件
     * @param eurekaInstanceCanceledEvent
     */
    @EventListener
    public void listen(EurekaInstanceCanceledEvent eurekaInstanceCanceledEvent) {
        //服务断线事件
        String appName = eurekaInstanceCanceledEvent.getAppName();
        String serverId = eurekaInstanceCanceledEvent.getServerId();
        System.out.println("客户端下线");
        mailService.sendSimpleMail(toMail,"服务掉线通知","服务名:"+appName+"掉线了，serverId为"+serverId);
    }

    /**
     * 微服务进行注册时触发
     * @param event
     */
    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        System.out.println(instanceInfo);

        System.out.println(" 微服务注册");

    }

    /**
     * 客户端续约事件
     * @param event
     */
    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {

        System.out.println(" 客户端续约"+event.getAppName()+" "+event.getServerId());


    }

    /**
     * 服务端可用事件
     * @param event
     */
    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        System.out.println("服务端可用");

    }

    /**
     * 服务端启动事件
     * @param event
     */
    @EventListener
    public void listen(EurekaServerStartedEvent event) {

        System.out.println("服务端启动");
        //Server启动
    }
}
