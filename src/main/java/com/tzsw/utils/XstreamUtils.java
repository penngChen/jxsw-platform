package com.tzsw.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.tzsw.model.PackageHead;
import com.tzsw.model.receive.PackageHeadR;
import com.tzsw.support.Constant;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 14:18 2018/11/20
 */
public class XstreamUtils {

    private static String XML_TAG = "<?xml version='1.0' encoding='GBK'?>";

    /**
     * Description: 私有化构造
     */
    private XstreamUtils() {
        super();
    }

    /**
     * @return
     * @Description 为每次调用生成一个XStream
     * @Title getInstance
     */
    private static XStream getInstance() {
        XStream xStream = new XStream(new DomDriver("UTF-8")) {
            /**
             * 忽略xml中多余字段
             */
            @Override
            protected MapperWrapper wrapMapper(MapperWrapper next) {
                return new MapperWrapper(next) {
                    @SuppressWarnings("rawtypes")
                    @Override
                    public boolean shouldSerializeMember(Class definedIn, String fieldName) {
                        if (definedIn == Object.class) {
                            return false;
                        }
                        return super.shouldSerializeMember(definedIn, fieldName);
                    }
                };
            }
        };

        // 设置默认的安全校验
        XStream.setupDefaultSecurity(xStream);
        // 使用本地的类加载器
        xStream.setClassLoader(XstreamUtils.class.getClassLoader());
        // 允许所有的类进行转换
        xStream.addPermission(AnyTypePermission.ANY);
        return xStream;
    }

    /**
     * @param xml
     * @param clazz
     * @return
     * @Description 将xml字符串转化为java对象
     * @Title xmlToBean
     */
    public static <T> T xmlToBean(String xml, Class<T> clazz) {
        XStream xStream = getInstance();
        // 通过注解方式的，一定要有这句话
        xStream.processAnnotations(clazz);
        Object object = xStream.fromXML(xml);
        T cast = clazz.cast(object);
        return cast;
    }

    /**
     * @param object
     * @return
     * @Description 将java对象转化为xml字符串
     * @Title beanToXml
     */
    public static String beanToXml(Object object) {
        XStream xStream = getInstance();
        xStream.processAnnotations(object.getClass());
        // 剔除所有tab、制表符、换行符
        String xml = xStream.toXML(object).replaceAll("\\s+", " ");
//        String xml=xStream.toXML(object);
        return xml;
    }

    /**
     * @param object
     * @return
     * @Description 将java对象转化为xml字符串（包含xml头部信息）
     * @Title beanToXml
     */
    public static String beanToXmlWithTag(Object object) {
        String xml = XML_TAG + beanToXml(object);
        return xml;
    }

    private static StringBuilder getXMLPackageHead(PackageHead head) {
        StringBuilder sbHeadXml = new StringBuilder();
        sbHeadXml.append("<PackageHead>");
        sbHeadXml.append("<SJBBH>");
        sbHeadXml.append(head.getSJBBH());
        sbHeadXml.append("</SJBBH>");
        sbHeadXml.append("<SJBLX>");
        sbHeadXml.append(head.getSJBLX());
        sbHeadXml.append("</SJBLX>");
        sbHeadXml.append("<SFCF>");
        sbHeadXml.append(head.getSFCF());
        sbHeadXml.append("</SFCF>");
        sbHeadXml.append("<JGBS>");
        sbHeadXml.append(head.getJGBS());
        sbHeadXml.append("</JGBS>");
        sbHeadXml.append("<DWDM>");
        sbHeadXml.append(head.getDWDM());
        sbHeadXml.append("</DWDM>");
        sbHeadXml.append("<DWMC>");
        sbHeadXml.append(head.getDWMC());
        sbHeadXml.append("</DWMC>");
        sbHeadXml.append("<JLS>");
        sbHeadXml.append(head.getJLS());
        sbHeadXml.append("</JLS>");
        sbHeadXml.append("<SCRQ>");
        sbHeadXml.append(head.getSCRQ());
        sbHeadXml.append("</SCRQ>");
        sbHeadXml.append("</PackageHead>");
        return sbHeadXml;
    }

    private static StringBuilder getXMLPackageHeadR(PackageHeadR head) {
        StringBuilder sbHeadXml = new StringBuilder();
        sbHeadXml.append("<PackageHead>");
        sbHeadXml.append("<SJBBH>");
        sbHeadXml.append(head.getSJBBH());
        sbHeadXml.append("</SJBBH>");
        sbHeadXml.append("<SJBLX>");
        sbHeadXml.append(head.getSJBLX());
        sbHeadXml.append("</SJBLX>");
        sbHeadXml.append("<JGBS>");
        sbHeadXml.append(head.getJGBS());
        sbHeadXml.append("</JGBS>");
        sbHeadXml.append("<DWDM>");
        sbHeadXml.append(head.getDWDM());
        sbHeadXml.append("</DWDM>");
        sbHeadXml.append("<DWMC>");
        sbHeadXml.append(head.getDWMC());
        sbHeadXml.append("</DWMC>");
        sbHeadXml.append("<SCRQ>");
        sbHeadXml.append(head.getSCRQ());
        sbHeadXml.append("</SCRQ>");
        sbHeadXml.append("<RECODE_ZT>");
        sbHeadXml.append(head.getRECODE_ZT());
        sbHeadXml.append("</RECODE_ZT>");
        sbHeadXml.append("<REMSG_ZT>");
        sbHeadXml.append(head.getREMSG_ZT());
        sbHeadXml.append("</REMSG_ZT>");
        sbHeadXml.append("</PackageHead>");
        return sbHeadXml;
    }

    private static StringBuilder setTzxx001(String fileName, String filePath) {
        StringBuilder TZXX001 = null;
        TZXX001 = new StringBuilder();
        TZXX001.append("<Data>");
        TZXX001.append("<Record index=\"" + 1 + "\">");
        TZXX001.append("<FILEPATH>" + filePath + "</FILEPATH>");
        TZXX001.append("<FILENAME>" + fileName + "</FILENAME>");
        TZXX001.append("</Record>");
        TZXX001.append("</Data>");
        return TZXX001;
    }

    private static StringBuilder setSSYWORTZXX(String SJBBH, String RECODE, String REMSG) {
        StringBuilder ssyw = null;
        ssyw = new StringBuilder();
        ssyw.append("<Data>");
        ssyw.append("<Record index=\"" + 1 + "\">");
        ssyw.append("<SJBBH>" + SJBBH + "</SJBBH>");
        ssyw.append("<RECODE>" + RECODE + "</RECODE>");
        ssyw.append("<REMSG>" + REMSG + "</REMSG>");
        ssyw.append("</Record>");
        ssyw.append("</Data>");
        return ssyw;
    }

    /*
     * @Description 封装业务系统传递给人社部门的批量通知信息
     * @Param
     * @return
     **/
    public static String getTZXX001(PackageHead packageHead, String fileName, String filePath) {
        String xml = Constant.XMLFileHeader;
        StringBuilder headxml = getXMLPackageHead(packageHead);
        xml = xml + headxml.toString();
        StringBuilder dataxml = setTzxx001(fileName, filePath);
        xml = xml + dataxml.toString();
        xml = xml + "</Package>";
        return xml;
    }

    /*
     * @Description 封装接收人设部门传递的数据 并返回相应信息
     * @Param 
     * @return 
     **/

    public static String getSSYWOrTZXX(PackageHeadR packageHead, String SJBBH, String RECODE, String REMSG) {
        String xml = Constant.XMLFileHeader;
        StringBuilder headxml = getXMLPackageHeadR(packageHead);
        xml = xml + headxml.toString();
        StringBuilder dataxml = setSSYWORTZXX(SJBBH, RECODE, REMSG);
        xml = xml + dataxml.toString();
        xml = xml + "</Package>";
        return xml;
    }

//    public static String getApiException(String errCode, String errMsg) {
//        String xml = "<?xml version=\"1.0\" encoding=\"GBK\"?>";
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("<ResponseText>");
//        stringBuilder.append("<errCode>");
//        stringBuilder.append(errCode);
//        stringBuilder.append("</errCode>");
//        stringBuilder.append("<errMsg>");
//        stringBuilder.append(errMsg);
//        stringBuilder.append("</errMsg>");
//        stringBuilder.append("</ResponseText>");
//        xml = xml + stringBuilder.toString();
//        return xml;
//    }
}
