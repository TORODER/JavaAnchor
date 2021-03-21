package org.miact.pojo;

import java.io.File;

/**
 * @author autopMateBook
 */
public class GlobalState {
    static private GlobalState onlyElem = null;

    private FsElem fsElemTree = null;

    private GlobalState() { }


    public FsElem getFsElemTree() {
        if(this.fsElemTree==null){
            String pwdPath = System.getProperty("user.dir");
            fsElemTree= new FsElem(new File(pwdPath + "/src"));
        }
        return fsElemTree;
    }

    public static GlobalState getOnly() {
        if (GlobalState.onlyElem == null) {
            GlobalState.onlyElem = new GlobalState();
        }
        return GlobalState.onlyElem;
    }

}