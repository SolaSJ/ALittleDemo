package com.sola.alittledemo.controller.Upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Sola
 * @date 2018/10/25
 */
@Component
public class CustomMultipartResolver extends CommonsMultipartResolver {

    private FileUploadProgressListener progressListener;

    @Autowired
    public void CustomMultipartResolver(FileUploadProgressListener progressListener) {
        this.progressListener = progressListener;
    }

    @Override
    public MultipartParsingResult parseRequest(HttpServletRequest request) throws MultipartException {
        String encoding = determineEncoding(request);
        FileUpload fileUpload = prepareFileUpload(encoding);
        //fileUpload.setFileSizeMax(1024 * 1024 * 500);// 单个文件最大500M
        //fileUpload.setSizeMax(1024 * 1024 * 500);// 一次提交总文件最大500M
        // 问文件上传进度监听器设置session用于存储上传进度
        progressListener.setSession(request.getSession());
        // 将文件上传进度监听器加入到 fileUpload 中
        fileUpload.setProgressListener(progressListener);
        try {
            List<FileItem> fileItems = ((ServletFileUpload) fileUpload).parseRequest(request);
            return parseFileItems(fileItems, encoding);
        } catch (FileUploadBase.SizeLimitExceededException ex) {
            throw new MaxUploadSizeExceededException(fileUpload.getSizeMax(), ex);
        } catch (FileUploadException ex) {
            throw new MultipartException("Could not parse multipart servlet request", ex);
        }
    }

}