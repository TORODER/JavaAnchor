package org.miact.pojo;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class FileTypeAnalysisElem {
    List<String> matchExtension;
    final FileType targetType;


    FileTypeAnalysisElem(List<String> matchExtension, FileType targetType) {
        this.matchExtension = matchExtension;
        this.targetType = targetType;
    }


    public boolean match(String extension) {
        for (final String matchExtensionElem : matchExtension) {
            if (matchExtensionElem.equals(extension)) {
                return true;
            }
        }
        return false;
    }
}


/**
 * @author autopMateBook
 */
public class FileTypeAnalysis {
    static FileType analysis(File sourceFile) {
        final String fileName = sourceFile.getName();
        final List<String> fileEx = Arrays.asList(fileName.split("\\."));
        String fileExtension = "";
        if (fileEx.size() > 0) {
            fileExtension = fileEx.get(fileEx.size() - 1);
        }
        ArrayList<FileTypeAnalysisElem> fileTypeAnalysisAtoms = new ArrayList<FileTypeAnalysisElem>();
        fileTypeAnalysisAtoms.add(new FileTypeAnalysisElem(Stream.of("js", "ts", "py", "yml", "xml", "iml", "txt", "java", "json", "text").collect(Collectors.toList()), FileType.TEXT));
        fileTypeAnalysisAtoms.add(new FileTypeAnalysisElem(Stream.of("md", "markdown").collect(Collectors.toList()), FileType.MARKDOWN));

        for (final FileTypeAnalysisElem nextFileTypeAnalysisElem : fileTypeAnalysisAtoms) {
            if (nextFileTypeAnalysisElem.match(fileExtension)) {
                return nextFileTypeAnalysisElem.targetType;
            }
        }
        return FileType.UNDEFINITION;
    }
}
