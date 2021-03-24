package org.miact.service.impl;

import org.miact.pojo.FsElem;
import org.miact.pojo.FsElem;
import org.miact.pojo.FsElemType;
import org.miact.pojo.GlobalState;
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

    @Override
    public Result getServerPublicData(String path) throws IOException {

        System.out.println(path);

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

}
