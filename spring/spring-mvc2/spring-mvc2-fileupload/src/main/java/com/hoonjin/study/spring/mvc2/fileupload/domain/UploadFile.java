package com.hoonjin.study.spring.mvc2.fileupload.domain;

public record UploadFile(
    String uploadFileName,
    String storeFileName
) {
}
