package org.miact.service.impl;

import org.miact.factory.CreateFactory;
import org.miact.pojo.FsElem;
import org.miact.service.GlobalState;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author autopMateBook
 */

@Service
public class GlobalStateImpl implements GlobalState {
    private FsElem fsElemTree = null;

    @Override
    public FsElem getFsElemTree() {
        if (this.fsElemTree == null) {
            String pwdPath = System.getProperty("user.dir");
            fsElemTree = new FsElem(new File(pwdPath + "/export"));
        }
        return fsElemTree;
    }
}