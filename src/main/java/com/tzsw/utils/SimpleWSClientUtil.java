package com.tzsw.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import com.tzsw.support.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import java.util.List;


/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 17:29 2018/11/21
 */
@Slf4j
public class SimpleWSClientUtil {

    private static PropertyFilter profilter = new PropertyFilter() {
        @Override
        public boolean apply(Object object, String name, Object value) {
            if ("DATABH".equalsIgnoreCase(name)) {
                //false表示DATABH字段将被排除在外
                return false;
            }
            return true;
        }
    };

    /**
     * 动态调用webservice服务
     *
     * @param wsdlUrl wsdl地址
     * @param method  调用的方法
     * @param args    参数
     * @return
     * @throws Exception
     */
    private static Object[] invoke(String wsdlUrl, String method, Object[] args) throws Exception {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = null;
        try {
            client = dcf.createClient(wsdlUrl);
            //设置超时单位为毫秒
            HTTPConduit http = (HTTPConduit) client.getConduit();
            HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
            long timeout = 60 * 1000;
            httpClientPolicy.setConnectionTimeout(timeout);  //连接超时
            httpClientPolicy.setAllowChunking(false);    //取消块编码
            httpClientPolicy.setReceiveTimeout(timeout);     //响应超时
            http.setClient(httpClientPolicy);
            return client.invoke(method, args);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (null != client) {
                client.close();
            }
        }
    }

    public static void invokeAllCity(String jgbs, String sjblx, List list) {
        for (Object o : list) {
            switch (jgbs) {
                case Constant.JGBS_GZ:
                    invokeAcceptMsgByGZ(sjblx, o);
                    continue;
                case Constant.JGBS_JA:
                    invokeAcceptMsgByJA(sjblx, o);
                    continue;
                case Constant.JGBS_FZ:
                    invokeAcceptMsgByFZ(sjblx, o);
                    continue;
                case Constant.JGBS_SR:
                    invokeAcceptMsgBySR(sjblx, o);
                default:
                    break;
            }
        }
    }

    /**
     * cxf动态调用调用sendRsGxxx方法
     *
     * @return
     */
    public static String invokesendRsGxxx(String servicecode, String busipacket) {
        try {
            String method = "sendRsGxxx";
            Object[] args = new Object[]{servicecode, busipacket};
            Object[] result = invoke(Constant.SENDRSGXXX_ADDRESS, method, args);
            return result[0].toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static void invokeAcceptMsgByFZ(String servicecode, Object o) {
        String results = "";
        try {
            String method = "acceptMsg";
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(new java.net.URL(Constant.FZ_ADDRESS));
            call.setOperationName(new QName(Constant.FZ_NAMESPACE, method));
            call.setSOAPActionURI("");
            call.addParameter(new QName(Constant.FZ_NAMESPACE, "servicecode"), XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter(new QName(Constant.FZ_NAMESPACE, "json_busipacket"), XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnType(XMLType.XSD_STRING);
            call.setReturnQName(new QName(Constant.FZ_NAMESPACE, "result"));
            Object[] paramsObject = new Object[]{servicecode, ObjectTOString(o)};
            results = call.invoke(paramsObject).toString();
            log.info("执行抚州业务系统【" + servicecode + "】请求返回结果：" + results);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("执行抚州业务系统【" + servicecode + "】请求失败：" + e.getMessage());
        }
    }

    private static void invokeAcceptMsgByGZ(String servicecode, Object o) {
        String results = "";
        try {
            String method = "acceptMsgGZ";
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(new java.net.URL(Constant.GZ_ADDRESS));
            call.setOperationName(new QName(Constant.GZ_NAMESPACE, method));
            call.setSOAPActionURI("");
            call.addParameter(new QName(Constant.GZ_NAMESPACE, "servicecode"), XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter(new QName(Constant.GZ_NAMESPACE, "json_busipacket"), XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnType(XMLType.XSD_STRING);
            call.setReturnQName(new QName(Constant.GZ_NAMESPACE, "result"));
            Object[] paramsObject = new Object[]{servicecode, ObjectTOString(o)};
            results = call.invoke(paramsObject).toString();
            log.info("执行赣州业务系统【" + servicecode + "】请求返回结果：" + results);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("执行赣州业务系统【" + servicecode + "】请求失败：" + e.getMessage());
        }
    }

    private static void invokeAcceptMsgByJA(String servicecode, Object o) {
        String results = "";
        try {
            String method = "acceptMsg";
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(new java.net.URL(Constant.JA_ADDRESS));
            call.setOperationName(new QName(Constant.JA_NAMESPACE, method));
            call.setSOAPActionURI("");
            call.addParameter(new QName(Constant.JA_NAMESPACE, "servicecode"), XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter(new QName(Constant.JA_NAMESPACE, "json_busipacket"), XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnType(XMLType.XSD_STRING);
            call.setReturnQName(new QName(Constant.JA_NAMESPACE, "result"));
            Object[] paramsObject = new Object[]{servicecode, ObjectTOString(o)};
            results = call.invoke(paramsObject).toString();
            log.info("执行吉安业务系统【" + servicecode + "】请求返回结果：" + results);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("执行吉安业务系统【" + servicecode + "】请求失败：" + e.getMessage());
        }
    }

    private static void invokeAcceptMsgBySR(String servicecode, Object o) {
        String results = "";
        try {
            String method = "acceptMsg";
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(new java.net.URL(Constant.SR_ADDRESS));
            call.setOperationName(new QName(Constant.SR_NAMESPACE, method));
            call.setSOAPActionURI("");
            call.addParameter(new QName(Constant.SR_NAMESPACE, "servicecode"), XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter(new QName(Constant.SR_NAMESPACE, "json_busipacket"), XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnType(XMLType.XSD_STRING);
            call.setReturnQName(new QName(Constant.SR_NAMESPACE, "result"));
            Object[] paramsObject = new Object[]{servicecode, ObjectTOString(o)};
            results = call.invoke(paramsObject).toString();
            log.info("执行上饶业务系统【" + servicecode + "】请求返回结果：" + results);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("执行上饶业务系统【" + servicecode + "】请求失败：" + e.getMessage());
        }
    }

    /**
     * 使用 axis调用webservice
     *
     * @return
     */
    public static String invokesendRsGxxx2(String servicecode, String busipacket) {
        String results = "";
        try {
            String method = "sendRsGxxx";
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(new java.net.URL(Constant.SENDRSGXXX_ADDRESS));
            call.setOperationName(new QName(Constant.SENDRSGXXX_NAMESPACE, method));
            call.setSOAPActionURI(Constant.SENDRSGXXX_NAMESPACE + method);
            call.addParameter(new QName(Constant.SENDRSGXXX_NAMESPACE, "servicecode"), XMLType.XSD_STRING, ParameterMode.IN);
            call.addParameter(new QName(Constant.SENDRSGXXX_NAMESPACE, "busipacket"), XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnType(XMLType.XSD_STRING);
            call.setReturnQName(new QName(Constant.SENDRSGXXX_NAMESPACE, "result"));
            Object[] paramsObject = new Object[]{servicecode, busipacket};
            results = call.invoke(paramsObject).toString();
            log.info("执行人设平台接口请求返回数据：" + results);
            return results;
        } catch (Exception e) {
            e.printStackTrace();
            log.info("执行人设平台接口请求失败：" + results);
            return "";
        }
    }

    private static String ObjectTOString(Object o) {
        TypeUtils.compatibleWithJavaBean = true;
        return JSON.toJSONString(o, profilter, SerializerFeature.WriteMapNullValue);
    }

//    private static void updateAllStatus(String results, String servicecode, Object o) {
//        if (!results.equals("0")) {
//            try {
//                switch (servicecode) {
//                    case "JFXX101":
//                        JFXX101 jfxx101 = (JFXX101) o;
//                        String DATABH = jfxx101.getDATABH();
//                        break;
//                    case "JFXX102":
//                        JFXX102 jfxx102 = (JFXX102) o;
//                        break;
//                    case "HZDZ101":
//                        HZDZ101 hzdz101 = (HZDZ101) o;
//                        break;
//                    case "JYFK101":
//                        JYFK101 jyfk101 = (JYFK101) o;
//
//
//                        break;
//                    case "YWJY101":
//                        YWJY101 ywjy101 = (YWJY101) o;
//
//                        break;
//                    case "SWDJ101":
//                        SWDJ101 swdj101 = (SWDJ101) o;
//
//
//                        break;
//                    case "SWDJ102":
//                        SWDJ102 swdj102 = (SWDJ102) o;
//
//
//                        break;
//                    case "DZXX101":
//                        DZXX101 dzxx101 = (DZXX101) o;
//
//
//                        break;
//                    case "CBXX101":
//                        CBXX101 cbxx101 = (CBXX101) o;
//                        break;
//                    case "CBXX102":
//                        CBXX102 cbxx102 = (CBXX102) o;
//                        break;
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
