package com.tzsw.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 14:13 2019/1/25
 */
public class Test {

    /**
     * 连接 FTP 服务器
     *
     * @param addr:            FTP 服务器 IP 地址
     * @param port:            FTP 服务器端口号
     * @param username:        登录用户名
     * @param password:        登录密码
     * @param controlEncoding: 文件传输的编码
     * @return org.apache.commons.net.ftp.FTPClient
     */
    public static FTPClient connectFtpServer(String addr, int port, String username, String password, String controlEncoding) {
        FTPClient ftpClient = new FTPClient();
        try {
            /**设置文件传输的编码*/
            ftpClient.setControlEncoding(controlEncoding);
            ftpClient.connect(addr, port);
            if (StringUtils.isBlank(username)) {
                ftpClient.login("Anonymous", "");
            } else {
                ftpClient.login(username, password);
            }
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.abort();
                ftpClient.disconnect();
            } else {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ftpClient;
    }


    /**
     * 读取FTP文件
     *
     * @param ftpClient:          连接成功有效的 FTP客户端连接
     * @param relativeRemotePath: ftpFile 文件在服务器所在的绝对路径，此方法强制路径使用右斜杠"\"，如 "\video\2018.mp4"
     * @return java.lang.String
     */
    public static String readFile(FTPClient ftpClient, String relativeRemotePath) {
        /**如果 FTP 连接已经关闭，或者连接无效，则直接返回*/
        if (!ftpClient.isConnected() || !ftpClient.isAvailable()) {
            System.out.println(">>>>>FTP服务器连接已经关闭或者连接无效*********");
            return "";
        }
        BufferedReader reader = null;
        try {
            FTPFile[] ftpFiles = ftpClient.listFiles(relativeRemotePath);
            FTPFile ftpFile = null;
            if (ftpFiles.length >= 1) {
                ftpFile = ftpFiles[0];
            }
            StringBuffer sb = new StringBuffer();
            if (ftpFile != null && ftpFile.isFile()) {
                String workDir = relativeRemotePath.substring(0, relativeRemotePath.lastIndexOf("\\"));
                if (StringUtils.isBlank(workDir)) {
                    workDir = "/";
                }
                ftpClient.changeWorkingDirectory(workDir);
                reader = new BufferedReader(new InputStreamReader(ftpClient.retrieveFileStream(ftpFile.getName()), "utf-8"));
                String text = null;
                while ((text = reader.readLine()) != null) {
                    sb.append(text);
                }
            }
            return sb.toString();
        } catch (IOException e) {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                    return "";
                }
            }
            return "";
        }
    }


    /**
     * 使用完毕，应该及时关闭连接
     *
     * @param ftpClient:
     * @return org.apache.commons.net.ftp.FTPClient
     */
    public static FTPClient closeFTPConnect(FTPClient ftpClient) {
        try {
            if (ftpClient != null && ftpClient.isConnected()) {
                ftpClient.abort();
                ftpClient.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ftpClient;
    }
}
