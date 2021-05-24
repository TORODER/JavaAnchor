package org.miact.service.impl;

import org.miact.pojo.FsElem;
import org.miact.pojo.FsElem;
import org.miact.pojo.FsElemType;
import org.miact.pojo.GlobalState;
import org.miact.service.PublicDataPortService;
import org.miact.utils.Keypair;
import org.miact.utils.Result;
import org.miact.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;


/**
 * @author miact
 */
@Service
public class PublicDataPortServiceImpl implements PublicDataPortService {

    @Override
    public Result getServerPublicData(String path) throws IOException {
        final FsElem fsElemTree = GlobalState.getOnly().getFsElemTree();
        final FsElem target = fsElemTree.fromPathGetChildElem(path);
        String base64TypeContent = "";
        if (target == null) {
            return Result.failure(ResultCode.RES_PATH_NOT_FIND,base64TypeContent);
        }
        if(target.getType() != FsElemType.FILE){
            return Result.failure(ResultCode.RES_PATH_IS_NO_FILE,base64TypeContent);
        }
        base64TypeContent = target.getFileContent(true);
        return Result.success(base64TypeContent);
    }

    @Override
    public Result getServerPublicDataIndex() {
        return Result.success(GlobalState.getOnly().getFsElemTree().toJson());
    }

    @Override
    public Result dropServerPublicFile(String path,String password,String readpasswd) {
        if (!password.equals(readpasswd)){
            return Result.failure(ResultCode.KEY_IS_ERROR);
        }
        final FsElem fsElemTree = GlobalState.getOnly().getFsElemTree();
        final FsElem target = fsElemTree.fromPathGetChildElem(path);
        if (StringUtils.isEmpty(target)){
            return Result.failure(ResultCode.FILE_IS_EXISTS);
        }
        if (!target.dropFiles(target.getFileElem())) {
            return Result.failure(ResultCode.FILE_NOT_DROP);
        }
        return Result.success();
    }

}
