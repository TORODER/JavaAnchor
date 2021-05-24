package org.miact.service.impl;

import org.miact.factory.CreateFactory;
import org.miact.pojo.FsElem;
import org.miact.pojo.FsElemType;
import org.miact.service.GlobalState;
import org.miact.service.PublicDataPortService;
import org.miact.utils.Result;
import org.miact.utils.ResultCode;
import org.springframework.stereotype.Service;

import java.io.IOException;


/**
 * @author miact
 */
@Service
public class PublicDataPortServiceImpl implements PublicDataPortService {


    public GlobalState getGlobalState() {
        return (GlobalState) CreateFactory.getBean("globalStateImpl");
    }
    @Override
    public Result getServerPublicData(String path) throws IOException {
        System.out.println(path);
        final FsElem fsElemTree = getGlobalState().getFsElemTree();
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
        return Result.success(getGlobalState().getFsElemTree().toJson().get("child"));
    }

}
