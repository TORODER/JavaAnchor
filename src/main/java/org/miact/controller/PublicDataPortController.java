package org.miact.controller;

import org.miact.factory.CreateFactory;
import org.miact.service.PublicDataPortService;
import org.miact.utils.Result;
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

    @RequestMapping("/file")
    @ResponseBody
    public Result getServerPublicData(String path) throws IOException {
        return publicDataPortService.getServerPublicData(path);
    }

    @RequestMapping("/index")
    @ResponseBody
    public Result getServerPublicDataIndex() throws Exception{
        return publicDataPortService.getServerPublicDataIndex();
    }

}