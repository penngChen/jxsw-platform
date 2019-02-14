package com.tzsw.utils;

import com.jcraft.jsch.*;
import com.tzsw.support.Constant;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Date;
import java.util.Properties;
import java.util.Vector;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 9:38 2018/12/4
 */

@Slf4j
public class SFTPUtil {

    private static ChannelSftp sftp;

    private static SFTPUtil instance = null;

    private SFTPUtil() {
    }

    public static ChannelSftp connectWhichone(String JGBS) {
        switch (JGBS) {
            case Constant.JGBS_GZ:
                return connect(Constant.HOST, Constant.PORT, Constant.USERNAME + JGBS, Constant.PASSWORD_GZ);
            case Constant.JGBS_JA:
                return connect(Constant.HOST, Constant.PORT, Constant.USERNAME + JGBS, Constant.PASSWORD_JA);
            case Constant.JGBS_FZ:
                return connect(Constant.HOST, Constant.PORT, Constant.USERNAME + JGBS, Constant.PASSWORD_FZ);
            case Constant.JGBS_SR:
                return connect(Constant.HOST, Constant.PORT, Constant.USERNAME + JGBS, Constant.PASSWORD_SR);
            default:
                break;
        }
        return null;
    }

    /**
     * 连接sftp服务器
     *
     * @param host     主机
     * @param port     端口
     * @param username 用户名
     * @param password 密码
     * @return
     */

    public static ChannelSftp connect(String host, int port, String username, String password) {
        ChannelSftp sftp = null;
        try {
            JSch jsch = new JSch();
            jsch.getSession(username, host, port);
            Session sshSession = jsch.getSession(username, host, port);
            sshSession.setPassword(password);
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            log.info("SFTP Session 连接中.");
            Channel channel = sshSession.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
            log.info("连接到SFTP:" + host);
        } catch (Exception e) {
            log.error("连接sftp服务器出现异常：" + e.getMessage());
        }
        return sftp;
    }

    /**
     * 上传文件
     *
     * @param directory 上传的目录
     * @param XML       要上传的文件字符串
     * @param fileName  要文件名
     */
    public static boolean upload(ChannelSftp sftp, String directory, String XML, String fileName) {
        log.info("File starts uploading: sftp=" + sftp + ">>>>>>directory=" + directory + ">>>>>>>fileName=" + fileName);
        boolean result = false;
        InputStream input = null;
        try {
            log.info("当前上传目录为：" + sftp.pwd());
            createDir(sftp, directory);
            input = new ByteArrayInputStream(XML.getBytes(Constant.CHARSET_NAME));
            sftp.put(input, fileName);
            input.close();
            result = true;
            log.info("上传文件成功>>>>>>>>>>>" + fileName);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("上传文件失败：" + e.getMessage());
        }
        return result;
    }





    /*
     * @Description 读取SFTP上的文件内容
     * @Param
     * @return
     **/

    public static String readSftp(ChannelSftp sftp, String directory, String downloadFile) {
        log.info("File starts reading: ");
        BufferedReader reader = null;
        try {
            sftp.cd(directory);
//            File file = new File(Constant.DOWNLOAN_URL + downloadFile);
//            FileOutputStream fileOutputStream = new FileOutputStream(file);
//            sftp.get(downloadFile, fileOutputStream);
            reader = new BufferedReader(new InputStreamReader(sftp.get(downloadFile), Constant.CHARSET_NAME));
            StringBuffer sb = new StringBuffer();
            String text = null;
            while ((text = reader.readLine()) != null) {
                sb.append(text);
            }
//            fileOutputStream.close();
            return sb.toString();
        } catch (Exception e) {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                    log.error("SFTP读取文件内容不存在");
                    return "";
                }
                log.error("读取sftp文件出错");
            }
            return "";
        }
    }

    /**
     * 下载文件
     *
     * @param directory    下载目录
     * @param downloadFile 下载的文件
     * @param saveFile     存在本地的路径
     */
    public static boolean download(ChannelSftp sftp, String directory, String downloadFile, String saveFile) {
        boolean flag = false;
        try {
            log.info(downloadFile + "文件开始下载>>>>>>>");
            sftp.cd(directory);
            File file = new File(saveFile);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            sftp.get(downloadFile, fileOutputStream);
            fileOutputStream.close();
            log.info("下载成功>>>>>>>");
            flag = true;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return flag;
    }

    /**
     * 下载文件
     *
     * @param downloadFilePath 下载的文件完整目录
     * @param saveFile         存在本地的路径
     */
    public File download(String downloadFilePath, String saveFile) {
        try {
            int i = downloadFilePath.lastIndexOf('/');
            if (i == -1) {
                return null;
            }
            sftp.cd(downloadFilePath.substring(0, i));
            File file = new File(saveFile);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            sftp.get(downloadFilePath.substring(i + 1), fileOutputStream);
            fileOutputStream.close();
            return file;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    /**
     * 删除文件
     *
     * @param directory  要删除文件所在目录
     * @param deleteFile 要删除的文件
     */
    public static boolean delete(ChannelSftp sftp, String directory, String deleteFile) {
        boolean result = false;
        try {
            sftp.cd(directory);
            sftp.rm(deleteFile);
            result = true;
        } catch (Exception e) {
            log.error("删除文件失败" + e.getMessage());
        }
        return result;
    }

    public static void disconnect(ChannelSftp sftp) {
        try {
            sftp.getSession().disconnect();
        } catch (JSchException e) {
            log.error(e.getMessage());
        }
        sftp.quit();
        sftp.disconnect();
    }

    /**
     * 创建目录
     *
     * @param createpath
     * @return
     */
    public static boolean createDir(ChannelSftp sftp, String createpath) {
        try {
            if (isDirExist(createpath, sftp)) {
                sftp.cd(createpath);
                return true;
            }
            String pathArry[] = createpath.split("/");
            StringBuffer filePath = new StringBuffer("/");
            for (String path : pathArry) {
                if ("".equals(path)) {
                    continue;
                }
                filePath.append(path + "/");
                if (isDirExist(filePath.toString(), sftp)) {
                    sftp.cd(filePath.toString());
                } else {
                    // 建立目录
                    sftp.mkdir(filePath.toString());
                    // 进入并设置为当前目录
                    sftp.cd(filePath.toString());
                }

            }
//            sftp.cd(createpath);
            return true;
        } catch (SftpException e) {
            e.printStackTrace();
            log.error("创建目录失败：" + e.getMessage());
        }
        return false;
    }

    /**
     * 判断目录是否存在
     */
    public static boolean isDirExist(String directory, ChannelSftp sftp) {
        boolean isDirExistFlag = false;
        try {
            SftpATTRS sftpATTRS = sftp.lstat(directory);
            isDirExistFlag = true;
            return sftpATTRS.isDir();
        } catch (Exception e) {
            if ("no such file".equals(e.getMessage().toLowerCase())) {
                isDirExistFlag = false;
            }
        }
        return isDirExistFlag;
    }

    /**
     * 列出目录下的文件
     *
     * @param directory 要列出的目录
     * @throws SftpException
     */
    public Vector<ChannelSftp.LsEntry> listFiles(String directory) throws SftpException {
        return sftp.ls(directory);
    }

    public static void main(String[] args) {
        boolean flag = false;
        flag = true;
        System.out.println(flag);
    }

}
