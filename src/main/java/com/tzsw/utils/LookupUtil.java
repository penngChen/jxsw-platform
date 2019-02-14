package com.tzsw.utils;

import com.tzsw.model.*;
import com.tzsw.service.impl.*;
import com.tzsw.support.Constant;
import com.tzsw.support.SpringApplicationContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.ByteArrayInputStream;
import java.util.*;

/**
 * @Author: chenpeng
 * @Description: dom4j 解析
 * @Date: Created in 16:59 2018/11/29
 */

@Slf4j
public class LookupUtil {

    @Autowired
    private static CBXX101ServiceImpl cbxx101Service = SpringApplicationContextHolder.getBean(CBXX101ServiceImpl.class);

    @Autowired
    private static CBXX102ServiceImpl cbxx102Service = SpringApplicationContextHolder.getBean(CBXX102ServiceImpl.class);

    @Autowired
    private static JFXX101ServiceImpl jfxx101Service = SpringApplicationContextHolder.getBean(JFXX101ServiceImpl.class);

    @Autowired
    private static JFXX102ServiceImpl jfxx102Service = SpringApplicationContextHolder.getBean(JFXX102ServiceImpl.class);

    @Autowired
    private static HZDZ101ServiceImpl hzdz101Service = SpringApplicationContextHolder.getBean(HZDZ101ServiceImpl.class);

    @Autowired
    private static JYFK101ServiceImpl jyfk101Service = SpringApplicationContextHolder.getBean(JYFK101ServiceImpl.class);

    @Autowired
    private static DZXX101ServiceImpl dzxx101Service = SpringApplicationContextHolder.getBean(DZXX101ServiceImpl.class);

    @Autowired
    private static YWJY101ServiceImpl ywjy101Service = SpringApplicationContextHolder.getBean(YWJY101ServiceImpl.class);

    @Autowired
    private static SWDJ101ServiceImpl swdj101Service = SpringApplicationContextHolder.getBean(SWDJ101ServiceImpl.class);

    @Autowired
    private static SWDJ102ServiceImpl swdj102Service = SpringApplicationContextHolder.getBean(SWDJ102ServiceImpl.class);

    @Autowired
    private static PackageHeadServiceImpl packageHeadService = SpringApplicationContextHolder.getBean(PackageHeadServiceImpl.class);

    public static boolean paseXmlByString(String xml) {
        boolean result = false;
        String serviceCode = "";
        String dataBH = "";
        String sfcf = "";
        List<CBXX101> cbxx101List = new ArrayList<>();
        List<CBXX102> cbxx102List = new ArrayList<>();
        List<JFXX101> jfxx101List = new ArrayList<>();
        List<JFXX102> jfxx102List = new ArrayList<>();
        List<YWJY101> ywjy101List = new ArrayList<>();
        List<HZDZ101> hzdz101List = new ArrayList<>();
        List<DZXX101> dzxx101List = new ArrayList<>();
        List<SWDJ101> swdj101List = new ArrayList<>();
        List<SWDJ102> swdj102List = new ArrayList<>();
        List<JYFK101> jyfk101List = new ArrayList<>();
        PackageHead packageHead = new PackageHead();
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new ByteArrayInputStream(xml.getBytes(Constant.CHARSET_NAME)));
            Element rootElement = document.getRootElement();
            Iterator iterator = rootElement.elementIterator();
            while (iterator.hasNext()) {
                Element element1 = (Element) iterator.next();
                Iterator iterator1 = element1.elementIterator();
                while (iterator1.hasNext()) {
                    Element element2 = (Element) iterator1.next();
                    if ("PackageHead".equals(element1.getName())) {
                        String name = element2.getName();
                        String text = element2.getText();
                        switch (name) {
                            case "SJBBH":
                                packageHead.setSJBBH(text);
                                dataBH = text;
                                continue;
                            case "SJBLX":
                                packageHead.setSJBLX(text);
                                serviceCode = text;
                                continue;
                            case "SFCF":
                                packageHead.setSFCF(text);
                                sfcf = text;
                                continue;
                            case "DWDM":
                                packageHead.setDWDM(text);
                                continue;
                            case "DWMC":
                                packageHead.setDWMC(text);
                                continue;
                            case "JGBS":
                                packageHead.setJGBS(text);
                                continue;
                            case "JLS":
                                packageHead.setJLS(text);
                                continue;
                            case "SCRQ":
                                packageHead.setSCRQ(text);
                            default:
                                break;
                        }
                    } else if ("Data".equals(element1.getName())) {
                        Iterator iterator2 = element2.elementIterator();
                        if ("JFXX101".equals(serviceCode)) {
                            JFXX101 jfxx101 = lookupByJFXX101(iterator2);
                            jfxx101.setDATABH(dataBH);
                            jfxx101List.add(jfxx101);
                        } else if ("JFXX102".equals(serviceCode)) {
                            JFXX102 jfxx102 = lookupByJFXX102(iterator2);
                            jfxx102.setDATABH(dataBH);
                            jfxx102List.add(jfxx102);
                        } else if ("HZDZ101".equals(serviceCode)) {
                            HZDZ101 hzdz101 = lookupByHZDZ101(iterator2);
                            hzdz101.setDATABH(dataBH);
                            hzdz101List.add(hzdz101);
                        } else if ("JYFK101".equals(serviceCode)) {
                            JYFK101 jyfk101 = lookupByJYFK101(iterator2);
                            jyfk101.setDATABH(dataBH);
                            jyfk101List.add(jyfk101);
                        } else if ("YWJY101".equals(serviceCode)) {
                            YWJY101 ywjy101 = lookupByYWJY101(iterator2);
                            ywjy101.setDATABH(dataBH);
                            ywjy101List.add(ywjy101);
                        } else if ("SWDJ101".equals(serviceCode)) {
                            SWDJ101 swdj101 = lookupBySWDJ101(iterator2);
                            swdj101.setDATABH(dataBH);
                            swdj101List.add(swdj101);
                        } else if ("SWDJ102".equals(serviceCode)) {
                            SWDJ102 swdj102 = lookupBySWDJ102(iterator2);
                            swdj102.setDATABH(dataBH);
                            swdj102List.add(swdj102);
                        } else if ("DZXX101".equals(serviceCode)) {
                            DZXX101 dzxx101 = lookupByDZXX101(iterator2);
                            dzxx101.setDATABH(dataBH);
                            dzxx101List.add(dzxx101);
                        } else if ("CBXX101".equals(serviceCode)) {
                            CBXX101 cbxx101 = lookupByCBXX101(iterator2);
                            cbxx101.setDATABH(dataBH);
                            cbxx101List.add(cbxx101);
                        } else if ("CBXX102".equals(serviceCode)) {
                            CBXX102 cbxx102 = lookupByCBXX102(iterator2);
                            cbxx102.setDATABH(dataBH);
                            cbxx102List.add(cbxx102);
                        }
                    }
                }
            }
            removeList(cbxx101List, cbxx102List, jfxx101List, jfxx102List, hzdz101List, ywjy101List, swdj101List, swdj102List, dzxx101List, jyfk101List);
            if (!StringUtils.isEmpty(packageHead)) {
                if (sfcf.equals(Constant.ISSFCF)) {
                    packageHeadService.deletePackageHeadByDATABH(dataBH);
                }
                packageHeadService.insertPackageHead(packageHead);
            }
            if (!CollectionUtils.isEmpty(cbxx101List)) {
                if (sfcf.equals(Constant.ISSFCF)) {
                    cbxx101Service.deleteCBXX101ByDATABH(dataBH);
                }
                cbxx101Service.insertCBXX101(cbxx101List);
                result = true;
            }
            if (!CollectionUtils.isEmpty(cbxx102List)) {
                if (sfcf.equals(Constant.ISSFCF)) {
                    cbxx102Service.deleteCBXX102ByDATABH(dataBH);
                }
                cbxx102Service.insertCBXX102(cbxx102List);
                result = true;
            }
            if (!CollectionUtils.isEmpty(jfxx101List)) {
                if (sfcf.equals(Constant.ISSFCF)) {
                    jfxx101Service.deleteJFXX101ByDATABH(dataBH);
                }
                jfxx101Service.insertJFXX101(jfxx101List);
                result = true;
            }
            if (!CollectionUtils.isEmpty(jfxx102List)) {
                if (sfcf.equals(Constant.ISSFCF)) {
                    jfxx102Service.deleteJFXX102ByDATABH(dataBH);
                }
                jfxx102Service.insertJFXX102(jfxx102List);
                result = true;
            }
            if (!CollectionUtils.isEmpty(dzxx101List)) {
                if (sfcf.equals(Constant.ISSFCF)) {
                    dzxx101Service.deleteDZXX101ByDATABH(dataBH);
                }
                dzxx101Service.insertDZXX101(dzxx101List);
                result = true;
            }
            if (!CollectionUtils.isEmpty(hzdz101List)) {
                if (sfcf.equals(Constant.ISSFCF)) {
                    hzdz101Service.deleteHZDZ101ByDATABH(dataBH);
                }
                hzdz101Service.insertHZDZ101(hzdz101List);
                result = true;
            }
            if (!CollectionUtils.isEmpty(jyfk101List)) {
                if (sfcf.equals(Constant.ISSFCF)) {
                    jyfk101Service.deleteJYFK101ByDATABH(dataBH);
                }
                jyfk101Service.insertJYFK101(jyfk101List);
                result = true;
            }
            if (!CollectionUtils.isEmpty(ywjy101List)) {
                if (sfcf.equals(Constant.ISSFCF)) {
                    ywjy101Service.deleteYWJY101ByDATABH(dataBH);
                }
                ywjy101Service.insertYWJY101(ywjy101List);
                result = true;
            }
            if (!CollectionUtils.isEmpty(swdj101List)) {
                if (sfcf.equals(Constant.ISSFCF)) {
                    swdj101Service.deleteSWDJ101ByDATABH(dataBH);
                }
                swdj101Service.insertSWDJ101(swdj101List);
                result = true;
            }
            if (!CollectionUtils.isEmpty(swdj102List)) {
                if (sfcf.equals(Constant.ISSFCF)) {
                    swdj102Service.deleteSWDJ102ByDATABH(dataBH);
                }
                swdj102Service.insertSWDJ102(swdj102List);
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("数据包：" + serviceCode + "解析出现异常：" + e.getMessage());
            result = false;
        }
        return result;
    }

    private static CBXX101 lookupByCBXX101(Iterator iterator) {
        CBXX101 cbxx101 = new CBXX101();
        while (iterator.hasNext()) {
            Element element1 = (Element) iterator.next();
            String name = element1.getName();
            String text = element1.getText();
            switch (name) {
                case "XH":
                    cbxx101.setXH(text);
                    continue;
                case "AAZ400":
                    cbxx101.setAAZ400(text);
                    continue;
                case "SBUUID":
                    cbxx101.setSBUUID(text);
                    continue;
                case "AAB001":
                    cbxx101.setAAB001(text);
                    continue;
                case "AAB998":
                    cbxx101.setAAB998(text);
                    continue;
                case "AAB003":
                    cbxx101.setAAB003(text);
                    continue;
                case "AAB004":
                    cbxx101.setAAB004(text);
                    continue;
                case "AAB301":
                    cbxx101.setAAB301(text);
                    continue;
                case "AAE004":
                    cbxx101.setAAE004(text);
                    continue;
                case "AAE005":
                    cbxx101.setAAE005(text);
                    continue;
                case "AAE006":
                    cbxx101.setAAE006(text);
                    continue;
                case "AAE007":
                    cbxx101.setAAE007(text);
                    continue;
                case "AAB065":
                    cbxx101.setAAB065(text);
                    continue;
                case "AAE036":
                    cbxx101.setAAE036(text);
                    continue;
                case "AAA321":
                    cbxx101.setAAA321(text);
                    continue;
                case "AAA322":
                    cbxx101.setAAA322(text);
                    continue;
                case "AAE418":
                    cbxx101.setAAE418(text);
                    continue;
                case "AAE419":
                    cbxx101.setAAE419(text);
                    continue;
                case "AAE420":
                    cbxx101.setAAE420(text);
                    continue;
                case "AAE421":
                    cbxx101.setAAE421(text);
                    continue;
                case "AAE422":
                    cbxx101.setAAE422(text);
                    continue;
                case "AAE423":
                    cbxx101.setAAE423(text);
                    continue;
                case "AAE424":
                    cbxx101.setAAE424(text);
                    continue;
                case "AAE425":
                    cbxx101.setAAE425(text);
                    continue;
                case "AAE426":
                    cbxx101.setAAE426(text);
                default:
                    break;
            }
        }
        return cbxx101;
    }

    private static CBXX102 lookupByCBXX102(Iterator iterator) {
        CBXX102 cbxx102 = new CBXX102();
        while (iterator.hasNext()) {
            Element element1 = (Element) iterator.next();
            String name = element1.getName();
            String text = element1.getText();
            switch (name) {
                case "XH":
                    cbxx102.setXH(text);
                    continue;
                case "AAZ400":
                    cbxx102.setAAZ400(text);
                    continue;
                case "SBUUID":
                    cbxx102.setSBUUID(text);
                    continue;
                case "AAC001":
                    cbxx102.setAAC001(text);
                    continue;
                case "AAC002":
                    cbxx102.setAAC002(text);
                    continue;
                case "AAC003":
                    cbxx102.setAAC003(text);
                    continue;
                case "AAC004":
                    cbxx102.setAAC004(text);
                    continue;
                case "AAC006":
                    cbxx102.setAAC006(text);
                    continue;
                case "AAC161":
                    cbxx102.setAAC161(text);
                    continue;
                case "AAE005":
                    cbxx102.setAAE005(text);
                    continue;
                case "AAE006":
                    cbxx102.setAAE006(text);
                    continue;
                case "AAC147":
                    cbxx102.setAAC147(text);
                    continue;
                case "AAC058":
                    cbxx102.setAAC058(text);
                    continue;
                case "AAE036":
                    cbxx102.setAAE036(text);
                    continue;
                case "AAA321":
                    cbxx102.setAAA321(text);
                    continue;
                case "AAA322":
                    cbxx102.setAAA322(text);
                    continue;
                case "AAE418":
                    cbxx102.setAAE418(text);
                    continue;
                case "AAE419":
                    cbxx102.setAAE419(text);
                    continue;
                case "AAE420":
                    cbxx102.setAAE420(text);
                    continue;
                case "AAE421":
                    cbxx102.setAAE421(text);
                    continue;
                case "AAE422":
                    cbxx102.setAAE422(text);
                    continue;
                case "AAE423":
                    cbxx102.setAAE423(text);
                    continue;
                case "AAE424":
                    cbxx102.setAAE424(text);
                    continue;
                case "AAE425":
                    cbxx102.setAAE425(text);
                    continue;
                case "AAE426":
                    cbxx102.setAAE426(text);
                default:
                    break;
            }
        }
        return cbxx102;
    }

    private static JFXX101 lookupByJFXX101(Iterator iterator) {
        JFXX101 jfxx101 = new JFXX101();
        while (iterator.hasNext()) {
            Element element1 = (Element) iterator.next();
            String name = element1.getName();
            String text = element1.getText();
            switch (name) {
                case "XH":
                    jfxx101.setXH(text);
                    continue;
                case "AAZ400":
                    jfxx101.setAAZ400(text);
                    continue;
                case "AAA027":
                    jfxx101.setAAA027(text);
                    continue;
                case "SBUUID":
                    jfxx101.setSBUUID(text);
                    continue;
                case "AAB034":
                    jfxx101.setAAB034(text);
                    continue;
                case "AAZ288":
                    jfxx101.setAAZ288(text);
                    continue;
                case "AAD009":
                    jfxx101.setAAD009(text);
                    continue;
                case "AAE140":
                    jfxx101.setAAE140(text);
                    continue;
                case "AAB001":
                    jfxx101.setAAB001(text);
                    continue;
                case "AAE003":
                    jfxx101.setAAE003(text);
                    continue;
                case "AAA115":
                    jfxx101.setAAA115(text);
                    continue;
                case "AAB119":
                    jfxx101.setAAB119(text);
                    continue;
                case "AAB084":
                    jfxx101.setAAB084(text);
                    continue;
                case "AAB121":
                    jfxx101.setAAB121(text);
                    continue;
                case "AAB120":
                    jfxx101.setAAB120(text);
                    continue;
                case "AAA042":
                    jfxx101.setAAA042(text);
                    continue;
                case "AAE080":
                    jfxx101.setAAE080(text);
                    continue;
                case "AAA041":
                    jfxx101.setAAA041(text);
                    continue;
                case "AAE082":
                    jfxx101.setAAE082(text);
                    continue;
                case "AAE056":
                    jfxx101.setAAE056(text);
                    continue;
                case "AAE239":
                    jfxx101.setAAE239(text);
                    continue;
                case "AAB165":
                    jfxx101.setAAB165(text);
                    continue;
                case "AAE530":
                    jfxx101.setAAE530(text);
                    continue;
                case "AAE531":
                    jfxx101.setAAE531(text);
                    continue;
                case "AAF020":
                    jfxx101.setAAF020(text);
                    continue;
                case "AAA321":
                    jfxx101.setAAA321(text);
                    continue;
                case "AAA322":
                    jfxx101.setAAA322(text);
                    continue;
                case "AAE418":
                    jfxx101.setAAE418(text);
                    continue;
                case "AAZ083":
                    jfxx101.setAAZ083(text);
                default:
                    break;
            }
        }
        return jfxx101;
    }

    private static JFXX102 lookupByJFXX102(Iterator iterator) {
        JFXX102 jfxx102 = new JFXX102();
        while (iterator.hasNext()) {
            Element element1 = (Element) iterator.next();
            String name = element1.getName();
            String text = element1.getText();
            switch (name) {
                case "XH":
                    jfxx102.setXH(text);
                    continue;
                case "AAZ400":
                    jfxx102.setAAZ400(text);
                    continue;
                case "AAA027":
                    jfxx102.setAAA027(text);
                    continue;
                case "SBUUID":
                    jfxx102.setSBUUID(text);
                    continue;
                case "AAB034":
                    jfxx102.setAAB034(text);
                    continue;
                case "AAZ288":
                    jfxx102.setAAZ288(text);
                    continue;
                case "AAD009":
                    jfxx102.setAAD009(text);
                    continue;
                case "AAE140":
                    jfxx102.setAAE140(text);
                    continue;
                case "AAB001":
                    jfxx102.setAAB001(text);
                    continue;
                case "AAE003":
                    jfxx102.setAAE003(text);
                    continue;
                case "AAA115":
                    jfxx102.setAAA115(text);
                    continue;
                case "AAC001":
                    jfxx102.setAAC001(text);
                    continue;
                case "AAC040":
                    jfxx102.setAAC040(text);
                    continue;
                case "AAE180":
                    jfxx102.setAAE180(text);
                    continue;
                case "EAE180":
                    jfxx102.setEAE180(text);
                    continue;
                case "AAA042":
                    jfxx102.setAAA042(text);
                    continue;
                case "AAE020":
                    jfxx102.setAAE020(text);
                    continue;
                case "AAA041":
                    jfxx102.setAAA041(text);
                    continue;
                case "AAE082":
                    jfxx102.setAAE082(text);
                    continue;
                case "AAE056":
                    jfxx102.setAAE056(text);
                    continue;
                case "AAE239":
                    jfxx102.setAAE239(text);
                    continue;
                case "AAB165":
                    jfxx102.setAAB165(text);
                    continue;
                case "AAE530":
                    jfxx102.setAAE530(text);
                    continue;
                case "AAE531":
                    jfxx102.setAAE531(text);
                    continue;
                case "AAF020":
                    jfxx102.setAAF020(text);
                    continue;
                case "AAA321":
                    jfxx102.setAAA321(text);
                    continue;
                case "AAA322":
                    jfxx102.setAAA322(text);
                    continue;
                case "AAE418":
                    jfxx102.setAAE418(text);
                    continue;
                case "AAZ083":
                    jfxx102.setAAZ083(text);
                default:
                    break;
            }
        }
        return jfxx102;
    }

    private static HZDZ101 lookupByHZDZ101(Iterator iterator) {
        HZDZ101 hzdz101 = new HZDZ101();
        while (iterator.hasNext()) {
            Element element1 = (Element) iterator.next();
            String name3 = element1.getName();
            String value3 = element1.getText();
            switch (name3) {
                case "SJBBH":
                    hzdz101.setSJBBH(value3);
                    continue;
                case "SJBLX":
                    hzdz101.setSJBLX(value3);
                    continue;
                case "RECORD_INDEX":
                    hzdz101.setRECORD_INDEX(value3);
                    continue;
                case "SJX":
                    hzdz101.setSJX(value3);
                    continue;
                case "SJXNR":
                    hzdz101.setSJXNR(value3);
                    continue;
                case "RKHJYSBYY":
                    hzdz101.setRKHJYSBYY(value3);
                default:
                    break;
            }
        }
        return hzdz101;
    }

    private static JYFK101 lookupByJYFK101(Iterator iterator) {
        JYFK101 jyfk101 = new JYFK101();
        while (iterator.hasNext()) {
            Element element1 = (Element) iterator.next();
            String name3 = element1.getName();
            String value3 = element1.getText();
            switch (name3) {
                case "SJBBH":
                    jyfk101.setSJBBH(value3);
                    continue;
                case "SJBLX":
                    jyfk101.setSJBLX(value3);
                    continue;
                case "RECORD_INDEX":
                    jyfk101.setRECORD_INDEX(value3);
                    continue;
                case "SJX":
                    jyfk101.setSJX(value3);
                    continue;
                case "SJXNR":
                    jyfk101.setSJXNR(value3);
                    continue;
                case "RKHJYSBYY":
                    jyfk101.setRKHJYSBYY(value3);
                default:
                    break;
            }
        }
        return jyfk101;
    }

    private static YWJY101 lookupByYWJY101(Iterator iterator) {
        YWJY101 jyfk101 = new YWJY101();
        while (iterator.hasNext()) {
            Element element1 = (Element) iterator.next();
            String name3 = element1.getName();
            String value3 = element1.getText();
            switch (name3) {
                case "XH":
                    jyfk101.setXH(value3);
                    continue;
                case "YWXH":
                    jyfk101.setYWXH(value3);
                    continue;
                case "AAE418":
                    jyfk101.setCSSJC(value3);
                    continue;
                case "AAE419":
                    jyfk101.setCLZT(value3);
                    continue;
                case "AAE420":
                    jyfk101.setSBYY_DM(value3);
                    continue;
                case "AAE421":
                    jyfk101.setSBYY(value3);
                    continue;
                case "AAE422":
                    jyfk101.setSJTB_SJ(value3);
                    continue;
                case "AAE423":
                    jyfk101.setLRR_DM(value3);
                    continue;
                case "AAE425":
                    jyfk101.setXGR_DM(value3);
                    continue;
                case "AAE424":
                    jyfk101.setLRRQ(value3);
                    continue;
                case "AAE426":
                    jyfk101.setXGRQ(value3);
                default:
                    break;
            }
        }
        return jyfk101;
    }

    private static DZXX101 lookupByDZXX101(Iterator iterator) {
        DZXX101 dzxx101 = new DZXX101();
        while (iterator.hasNext()) {
            Element element1 = (Element) iterator.next();
            String name = element1.getName();
            String text = element1.getText();
            switch (name) {
                case "XH":
                    dzxx101.setXH(text);
                    continue;
                case "AAZ400":
                    dzxx101.setAAZ400(text);
                    continue;
                case "SBUUID":
                    dzxx101.setSBUUID(text);
                    continue;
                case "AAE310":
                    dzxx101.setAAE310(text);
                    continue;
                case "AAE311":
                    dzxx101.setAAE311(text);
                    continue;
                case "AAA027":
                    dzxx101.setAAA027(text);
                    continue;
                case "AAB034":
                    dzxx101.setAAB034(text);
                    continue;
                case "AAE140":
                    dzxx101.setAAE140(text);
                    continue;
                case "AAE080":
                    dzxx101.setAAE080(text);
                    continue;
                case "AAE082":
                    dzxx101.setAAE082(text);
                    continue;
                case "AAE056":
                    dzxx101.setAAE056(text);
                    continue;
                case "BAC121":
                    dzxx101.setBAC121(text);
                    continue;
                case "AAE239":
                    dzxx101.setAAE239(text);
                    continue;
                case "AIC152":
                    dzxx101.setAIC152(text);
                    continue;
                case "AAA321":
                    dzxx101.setAAA321(text);
                    continue;
                case "AAA322":
                    dzxx101.setAAA322(text);
                    continue;
                case "AAE418":
                    dzxx101.setAAE418(text);
                default:
                    break;
            }
        }
        return dzxx101;
    }

    private static SWDJ101 lookupBySWDJ101(Iterator iterator) {
        SWDJ101 swdj101 = new SWDJ101();
        while (iterator.hasNext()) {
            Element element1 = (Element) iterator.next();
            String name = element1.getName();
            String text = element1.getText();
            switch (name) {
                case "XH":
                    swdj101.setXH(text);
                    continue;
                case "AAZ400":
                    swdj101.setAAZ400(text);
                    continue;
                case "SBUUID":
                    swdj101.setSBUUID(text);
                    continue;
                case "AAB001":
                    swdj101.setAAB001(text);
                    continue;
                case "AAB998":
                    swdj101.setAAB998(text);
                    continue;
                case "AAB003":
                    swdj101.setAAB003(text);
                    continue;
                case "AAB004":
                    swdj101.setAAB004(text);
                    continue;
                case "AAB301":
                    swdj101.setAAB301(text);
                    continue;
                case "AAE004":
                    swdj101.setAAE004(text);
                    continue;
                case "AAE005":
                    swdj101.setAAE005(text);
                    continue;
                case "AAE006":
                    swdj101.setAAE006(text);
                    continue;
                case "AAE007":
                    swdj101.setAAE007(text);
                    continue;
                case "AAB065":
                    swdj101.setAAB065(text);
                    continue;
                case "AAE036":
                    swdj101.setAAE036(text);
                    continue;
                case "AAA321":
                    swdj101.setAAA321(text);
                    continue;
                case "AAA322":
                    swdj101.setAAA322(text);
                    continue;
                case "AAE418":
                    swdj101.setAAE418(text);
                default:
                    break;
            }
        }
        return swdj101;
    }

    private static SWDJ102 lookupBySWDJ102(Iterator iterator) {
        SWDJ102 swdj102 = new SWDJ102();
        while (iterator.hasNext()) {
            Element element1 = (Element) iterator.next();
            String name = element1.getName();
            String text = element1.getText();
            switch (name) {
                case "XH":
                    swdj102.setXH(text);
                    continue;
                case "AAZ400":
                    swdj102.setAAZ400(text);
                    continue;
                case "SBUUID":
                    swdj102.setSBUUID(text);
                    continue;
                case "AAC001":
                    swdj102.setAAC001(text);
                    continue;
                case "AAC002":
                    swdj102.setAAC002(text);
                    continue;
                case "AAC003":
                    swdj102.setAAC003(text);
                    continue;
                case "AAC004":
                    swdj102.setAAC004(text);
                    continue;
                case "AAC006":
                    swdj102.setAAC006(text);
                    continue;
                case "AAC147":
                    swdj102.setAAC147(text);
                    continue;
                case "AAC058":
                    swdj102.setAAC058(text);
                    continue;
                case "AAE036":
                    swdj102.setAAE036(text);
                    continue;
                case "AAA321":
                    swdj102.setAAA321(text);
                    continue;
                case "AAA322":
                    swdj102.setAAA322(text);
                    continue;
                case "AAE418":
                    swdj102.setAAE418(text);
                default:
                    break;
            }
        }
        return swdj102;
    }

    public static PackageHead getAllPackageHead(String busipacket) {
        PackageHead packageHead = new PackageHead();
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(new ByteArrayInputStream(busipacket.getBytes(Constant.CHARSET_NAME)));
            Element rootElement = document.getRootElement();
            Iterator iterator = rootElement.elementIterator();
            while (iterator.hasNext()) {
                Element element1 = (Element) iterator.next();
                Iterator iterator1 = element1.elementIterator();
                while (iterator1.hasNext()) {
                    Element element2 = (Element) iterator1.next();
                    if ("PackageHead".equals(element1.getName())) {
                        String name = element2.getName();
                        String text = element2.getText();
                        switch (name) {
                            case "SJBBH":
                                packageHead.setSJBBH(text);
                                continue;
                            case "SJBLX":
                                packageHead.setSJBLX(text);
                                continue;
                            case "SFCF":
                                packageHead.setSFCF(text);
                                continue;
                            case "DWDM":
                                packageHead.setDWDM(text);
                                continue;
                            case "DWMC":
                                packageHead.setDWMC(text);
                                continue;
                            case "JGBS":
                                packageHead.setJGBS(text);
                                continue;
                            case "JLS":
                                packageHead.setJLS(text);
                                continue;
                            case "SCRQ":
                                packageHead.setSCRQ(text);
                            default:
                                break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("头部文件解析出现异常：" + e.getMessage());
        }
        return packageHead;
    }

    public static Map<String, String> getTZXX101(String xml) {
        Map<String, String> map = new HashMap<>(4);
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new ByteArrayInputStream(xml.getBytes(Constant.CHARSET_NAME)));
            Element rootElement = document.getRootElement();
            Iterator iterator = rootElement.elementIterator();
            while (iterator.hasNext()) {
                Element element1 = (Element) iterator.next();
                Iterator iterator1 = element1.elementIterator();
                while (iterator1.hasNext()) {
                    Element element2 = (Element) iterator1.next();
                    if ("Data".equals(element1.getName())) {
                        Iterator iterator2 = element2.elementIterator();
                        while (iterator2.hasNext()) {
                            Element element3 = (Element) iterator2.next();
                            String name3 = element3.getName();
                            String value3 = element3.getText();
                            switch (name3) {
                                case "FILEPATH":
                                    map.put("FILEPATH", value3);
                                    continue;
                                case "FILENAME":
                                    map.put("FILENAME", value3);
                                default:
                                    break;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("TZXX101解析出现异常：" + e.getMessage());
        }
        return map;
    }

    private static void removeList(List<CBXX101> cbxx101List, List<CBXX102> cbxx102List, List<JFXX101> jfxx101List, List<JFXX102> jfxx102List, List<HZDZ101> hzdz101List, List<YWJY101> ywjy101List, List<SWDJ101> swdj101List, List<SWDJ102> swdj102List, List<DZXX101> dzxx101List, List<JYFK101> jyfk101List) {
        Iterator<CBXX101> cbxx101Iterator = cbxx101List.iterator();
        while (cbxx101Iterator.hasNext()) {
            if (StringUtils.isEmpty(cbxx101Iterator.next().getXH())) {
                cbxx101Iterator.remove();
            }
        }
        Iterator<CBXX102> cbxx102Iterator = cbxx102List.iterator();
        while (cbxx102Iterator.hasNext()) {
            if (StringUtils.isEmpty(cbxx102Iterator.next().getXH())) {
                cbxx102Iterator.remove();
            }
        }
        Iterator<JFXX101> jfxx101Iterator = jfxx101List.iterator();
        while (jfxx101Iterator.hasNext()) {
            if (StringUtils.isEmpty(jfxx101Iterator.next().getXH())) {
                jfxx101Iterator.remove();
            }
        }
        Iterator<JFXX102> jfxx102Iterator = jfxx102List.iterator();
        while (jfxx102Iterator.hasNext()) {
            if (StringUtils.isEmpty(jfxx102Iterator.next().getXH())) {
                jfxx102Iterator.remove();
            }
        }
        Iterator<HZDZ101> hzdz101Iterator = hzdz101List.iterator();
        while (hzdz101Iterator.hasNext()) {
            if (StringUtils.isEmpty(hzdz101Iterator.next().getSJBBH())) {
                hzdz101Iterator.remove();
            }
        }
        Iterator<DZXX101> dzxx101Iterator = dzxx101List.iterator();
        while (dzxx101Iterator.hasNext()) {
            if (StringUtils.isEmpty(dzxx101Iterator.next().getXH())) {
                dzxx101Iterator.remove();
            }
        }
        Iterator<YWJY101> ywjy101Iterator = ywjy101List.iterator();
        while (ywjy101Iterator.hasNext()) {
            if (StringUtils.isEmpty(ywjy101Iterator.next().getXH())) {
                ywjy101Iterator.remove();
            }
        }
        Iterator<SWDJ101> swdj101Iterator = swdj101List.iterator();
        while (swdj101Iterator.hasNext()) {
            if (StringUtils.isEmpty(swdj101Iterator.next().getXH())) {
                swdj101Iterator.remove();
            }
        }
        Iterator<SWDJ102> swdj102Iterator = swdj102List.iterator();
        while (swdj102Iterator.hasNext()) {
            if (StringUtils.isEmpty(swdj102Iterator.next().getXH())) {
                swdj102Iterator.remove();
            }
        }

        Iterator<JYFK101> jyfk101Iterator = jyfk101List.iterator();
        while (jyfk101Iterator.hasNext()) {
            if (StringUtils.isEmpty(jyfk101Iterator.next().getSJBBH())) {
                jyfk101Iterator.remove();
            }
        }
    }
}
