package org.miact.service;

import org.miact.utils.Result;

import java.io.IOException;


/**
 * @author miact
 */
public interface PublicDataPortService {
    Result getServerPublicData(String path) throws IOException;

    Result getServerPublicDataIndex();

    Result dropServerPublicFile(String path,String passwd,String realpasswd);
}
