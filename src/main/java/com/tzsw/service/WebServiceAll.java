package com.tzsw.service;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @Author: chenpeng
 * @Description:
 * @Date: Created in 16:22 2018/11/16
 */

@WebService(name = "WebServiceAll", targetNamespace = "http://service.zjtzsw.com/")
public interface WebServiceAll {

    /**
     * 人设平台请求
     */
    @WebMethod(action = "http://service.zjtzsw.com/receiveSwGxxx")
    @WebResult(name = "result", targetNamespace = "http://service.zjtzsw.com/")
    public String receiveSwGxxx(@WebParam(name = "servicecode", targetNamespace = "http://service.zjtzsw.com/") String servicecode,
                                @WebParam(name = "busipacket", targetNamespace = "http://service.zjtzsw.com/") String busipacket);

    /*
     * @Description业务系统请求
     * @Param
     * @return
     **/

    @WebMethod(action = "http://service.zjtzsw.com/receiveBusiness")
    @WebResult(name = "result", targetNamespace = "http://service.zjtzsw.com/")
    public String receiveBusiness(@WebParam(name = "servicecode", targetNamespace = "http://service.zjtzsw.com/") String servicecode,
                                  @WebParam(name = "busipacket", targetNamespace = "http://service.zjtzsw.com/") String busipacket);

    /*
     * @Description 测试服务
     * @Param
     * @return
     **/

    @WebMethod(action = "http://service.zjtzsw.com/receiveTest", operationName = "receiveTest")
    @WebResult(name = "result", targetNamespace = "http://service.zjtzsw.com/")
    public String receiveTest(@WebParam(name = "account", targetNamespace = "http://service.zjtzsw.com/") String account, @WebParam(name = "fileName", targetNamespace = "http://service.zjtzsw.com/") String fileName, @WebParam(name = "date", targetNamespace = "http://service.zjtzsw.com/") String date);
}
