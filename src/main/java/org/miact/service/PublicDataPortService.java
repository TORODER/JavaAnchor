package org.miact.service;

import org.miact.utils.Result;

import java.io.IOException;


/**
 * @author miact
 */
public interface PublicDataPortService {
    /**
     * 服务器的公共数据
     * @return 返回服务器公共数据结果
     */
    public Result getServerPublicData(String path) throws IOException;

    /**
     * 服务器的公共数据的索引
     * @return 返回的服务器索引
     */
    public Result getServerPublicDataIndex();
}
