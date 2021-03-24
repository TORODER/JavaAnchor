package org.miact.pojo;

/**
 * @author autopMateBook
 */
public enum FileType {
    /** type to int code
     * 1 is markdown
     * 2 is raw text
     * 9999 is unDefinition or is Dir
     */

    MARKDOWN(1),
    TEXT(2),
    UNDEFINITION(9999);

    public int typeCode;

    FileType(int typeCode){
        this.typeCode=typeCode;
    }
}
