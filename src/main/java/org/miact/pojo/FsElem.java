package org.miact.pojo;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.util.*;


/**
 * @author autopMateBook
 */
public class FsElem {
    File fileElem;
    FsElemType type;
    FileType fileType;
    ArrayList<FsElem> childElemList = null;
    HashMap<String, FsElem> childElemMap = null;


    public FsElem(File fileElem) {
        this.fileElem = fileElem;
        this.type = fileElem.isDirectory() ? FsElemType.DIR : FsElemType.FILE;
        this.childElemList = new ArrayList<FsElem>();
        if(this.type==FsElemType.FILE){
            this.fileType = FileTypeAnalysis.analysis(this.fileElem);
        }else {
            this.fileType = FileType.UNDEFINITION;
        }
        switch (this.type) {
            case DIR:
                final File[] nextListFiles = this.fileElem.listFiles();
                if (nextListFiles != null) {
                    for (File nextFile : nextListFiles) {
                        childElemList.add(new FsElem(nextFile));
                    }
                }
                break;
            case FILE:
            default:
                break;
        }
    }

    public HashMap<String, FsElem> getChildElemMap() {
        if (this.childElemMap == null) {
            this.childElemMap = new HashMap<String, FsElem>();
            for (final FsElem nextChildElem : this.childElemList) {
                childElemMap.put(nextChildElem.fileElem.getName(), nextChildElem);
            }
        }
        return childElemMap;
    }

    public FsElem fromPathGetChildElem(String callPath) {
        String[] callPathSlices = callPath.split("/");
        callPathSlices = Arrays.stream(callPathSlices).filter((v) -> !v.isEmpty()).toArray(String[]::new);
        FsElem nowFsElem = this;
        for (final String nextPathSlice : callPathSlices) {
            if (nowFsElem.getChildElemMap().containsKey(nextPathSlice)) {
                nowFsElem = nowFsElem.getChildElemMap().get(nextPathSlice);
            } else {
                return null;
            }
        }
        return nowFsElem;
    }

    public FsElemType getType() {
        return type;
    }


    public JSONObject toJson() {
        final JSONObject toJsonObj = new JSONObject();
        toJsonObj.put("type", this.type.code);
        toJsonObj.put("name", this.fileElem.getName());
        ArrayList<JSONObject> childList = new ArrayList<JSONObject>();
        for (final FsElem nextFsElem : this.childElemList) {
            childList.add(nextFsElem.toJson());
        }
        toJsonObj.put("child", childList);
        toJsonObj.put("fileType",this.fileType.typeCode);
        return toJsonObj;
    }


    public String getFileContent(boolean useBase64) throws IOException {
        byte[] fileElemContentBytes = Files.readAllBytes(this.fileElem.toPath());
        if (useBase64) {
            return new String(Base64.getEncoder().encode(fileElemContentBytes));
        } else {
            return new String(fileElemContentBytes);
        }

    }

    public File getFileElem(){
        return fileElem;
    }

    public boolean dropFiles(File fileElem){
        boolean result = false;
        if(fileElem.isDirectory()){
            File[] childrenFiles = fileElem.listFiles();
            for (File childFile:childrenFiles){
                result = dropFiles(childFile);
                if(!result){
                    return result;
                }
            }
        }
        result = fileElem.delete();
        return result;
    }
}