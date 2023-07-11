package com.cwru.platform.service;

import com.cwru.platform.dao.AlphaDao;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
//@Scope("prototype") 多例
public class AlphaService {

    @Autowired
    private AlphaDao alphaDao;

    public String find() {
        return alphaDao.Select();
    }

//
//    public AlphaService() {
//        System.out.println("实例化AlphaService");
//    }
//
//
//    @PostConstruct
//    public void init() {
//        System.out.println("初始化AlphaService");
//    }
//
//    @PreDestroy
//    public void destory(){
//        System.out.println("销毁AlphaService");
//    }

}
