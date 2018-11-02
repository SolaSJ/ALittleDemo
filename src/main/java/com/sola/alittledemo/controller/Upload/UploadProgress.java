package com.sola.alittledemo.controller.Upload;

/**
 * @author Sola
 * @date 2018/10/25
 */
public class UploadProgress {

    // 已读取文件的比特数
    private long bytesRead;

    // 文件总比特数
    private long contentLength;

    // 正读的第几个文件
    private long items;

    public long getBytesRead() {
        return bytesRead;
    }

    public void setBytesRead(long bytesRead) {
        this.bytesRead = bytesRead;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public long getItems() {
        return items;
    }

    public void setItems(long items) {
        this.items = items;
    }

}
