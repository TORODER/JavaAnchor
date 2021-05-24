package org.miact.controller;

import org.miact.factory.CreateFactory;
import org.miact.service.PublicDataPortService;
import org.miact.utils.Keypair;
import org.miact.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @author autopMateBook
 */
@Controller
@RequestMapping("/api/v0/public")
public class PublicDataPortController {

    PublicDataPortService publicDataPortService = (PublicDataPortService) CreateFactory.getBean("publicDataPortServiceImpl");

    @Autowired
    private Keypair keypair;

    /**
     * 服务器的公共数据
     * @return 返回服务器公共数据结果
     */
    @RequestMapping("/file")
    @ResponseBody
    public Result getServerPublicData(String path) throws IOException {
        return publicDataPortService.getServerPublicData(path);
    }

    /**
     * 服务器的公共数据的索引
     * @return 返回的服务器索引
     */
    @RequestMapping("/index")
    @ResponseBody
    public Result getServerPublicDataIndex(){
        return publicDataPortService.getServerPublicDataIndex();
    }

    /**
     * 删除服务器公共数据
     * @return 返回的删除结果
     */
    @RequestMapping("/drop")
    @ResponseBody
    public Result dropServerPublicFile(String path,String password){
        return publicDataPortService.dropServerPublicFile(path,password,keypair.getSecretkey());
    }


}