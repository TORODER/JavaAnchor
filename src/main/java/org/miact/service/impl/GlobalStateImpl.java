package org.miact.service.impl;

import org.miact.pojo.FsElem;
import org.miact.service.GlobalState;

import java.io.File;

/**
 * @author autopMateBook
 */
public class GlobalStateImpl implements GlobalState {
    private FsElem fsElemTree = null;
    private GlobalStateImpl() { }
    @Override
    public FsElem getFsElemTree() {
        if(this.fsElemTree==null){
            String pwdPath = System.getProperty("user.dir");
            fsElemTree= new FsElem(new File(pwdPath + "/export"));
        }
        return fsElemTree;
    }

    //    static private GlobalState onlyElem = null;
    //    public static GlobalState getOnly() {
    //        if (GlobalState.onlyElem == null) {
    //            GlobalState.onlyElem = new GlobalState();
    //        }
    //        return GlobalState.onlyElem;
    //    }

}