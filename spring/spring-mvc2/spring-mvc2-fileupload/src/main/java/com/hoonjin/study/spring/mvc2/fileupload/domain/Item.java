package com.hoonjin.study.spring.mvc2.fileupload.domain;

import java.util.List;

public record Item(
    Long id,
    String iteName,
    UploadFile attacheFile,
    List<UploadFile> imageFiles
) {
}
