package com.sola.alittledemo.controller.Upload;

import org.apache.commons.fileupload.ProgressListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * @author Sola
 * @date 2018/10/25
 */
@Component
public class FileUploadProgressListener implements ProgressListener {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private HttpSession session;

    public void setSession(HttpSession session) {
        this.session = session;
        // 保存上传状态
        UploadProgress progress = new UploadProgress();
        session.setAttribute("progress", progress);
    }

    @Override
    public void update(long bytesRead, long contentLength, int items) {
        UploadProgress progress = (UploadProgress) session.getAttribute("progress");
        progress.setBytesRead(bytesRead);
        progress.setContentLength(contentLength);
        progress.setItems(items);
        log.info("已上传{}, 总长度{}, {}", bytesRead, contentLength, items);
    }

}
