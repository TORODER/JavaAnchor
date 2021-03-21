package org.miact.pojo;

/**
 * @author autopMateBook
 */

public enum FsElemType {
    /*
     * FILE is File Type
     * Dir is Dir Type
     * */
    FILE(0, "File"),
    DIR(1, "Dir");

    public int code;
    public String message;

    FsElemType(int code, String message) {
        this.code = code;
        this.message = message;
    }

}