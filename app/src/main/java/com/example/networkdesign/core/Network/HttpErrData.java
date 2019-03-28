package com.example.networkdesign.core.Network;

public class HttpErrData {
    /**
     * errmsg : 输入参数不符合规范, 日志记录需要提供客户端类型(clientType)
     * file : E:\WWW\code\developzw\sdtjyLP\coreFrame\ZWLog.php
     * line : 21
     */

    private String errmsg;
    private String file;
    private String line;

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}
