package org.miact.pojo;

/**
 * @author autopMateBook
 */
public enum FileType {
    /** type to int code
     * 0 is markdown
     * 1 is raw text
     * 999 is unDefinition or is Dir
     */

    markdown(0),
    text(1),
    unDefinition(999);

    public int typeCode;

    FileType(int typeCode){
        this.typeCode=typeCode;
    }
}
