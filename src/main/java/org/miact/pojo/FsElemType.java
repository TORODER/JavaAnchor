package org.miact.pojo;

/**
 * @author autopMateBook
 */

public enum FsElemType {
    /*
     * FILE is File Type
     * Dir is Dir Type
     * */

    DIR(0, "Dir"),
    FILE(1, "File");

    public int code;
    public String message;

    FsElemType(int code, String message) {
        this.code = code;
        this.message = message;
    }

}