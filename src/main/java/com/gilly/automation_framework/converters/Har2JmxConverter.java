package com.gilly.automation_framework.converters;

import com.gilly.automation_framework.har.pojo.Param;
import com.gilly.automation_framework.har.pojo.PostData;
import com.gilly.automation_framework.har.pojo.QueryString;
import com.gilly.automation_framework.har.pojo.Request;
import com.gilly.automation_framework.jmx.pojo.CacheManager;
import com.gilly.automation_framework.jmx.pojo.CollectionProperty;
import com.gilly.automation_framework.jmx.pojo.CookieManager;
import com.gilly.automation_framework.jmx.pojo.ElementProperty;
import com.gilly.automation_framework.jmx.pojo.ElementType;
import com.gilly.automation_framework.jmx.pojo.HTTPArgument;
import com.gilly.automation_framework.jmx.pojo.HTTPArguments;
import com.gilly.automation_framework.jmx.pojo.HTTPSamplerProxy;
import com.gilly.automation_framework.jmx.pojo.HashTree;
import com.gilly.automation_framework.jmx.pojo.Header;
import com.gilly.automation_framework.jmx.pojo.HeaderManager;
import com.gilly.automation_framework.jmx.pojo.JThreadGroup;
import com.gilly.automation_framework.jmx.pojo.JmeterTestPlan;
import com.gilly.automation_framework.jmx.pojo.TestPlan;
import com.gilly.automation_framework.jmx.pojo.TransactionController;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.core.har.HarNameValuePair;
import net.lightbody.bmp.core.har.HarPostData;
import net.lightbody.bmp.core.har.HarPostDataParam;
import net.lightbody.bmp.core.har.HarRequest;

/**
 *
 * @author Rajesh
 */
public class Har2JmxConverter {

    public void generateJmxFile(Har har) throws IOException {
        HashTree mainHashTree = new HashTree();
        ElementProperty t_userDefinedVariables = new ElementProperty("TestPlan.user_defined_variables", ElementType.ARGUMENTS.getName(), "ArgumentsPanel", "Arguments", "TestPlan", true);
        CollectionProperty t_collProp = new CollectionProperty();
        t_collProp.setName("Arguments.arguments");
        t_userDefinedVariables.getProperties().add(t_collProp);
        TestPlan testPlan = new TestPlan();
        testPlan.setUser_defined_variables(t_userDefinedVariables);
        mainHashTree.getjElements().add(testPlan);
        HashTree testPlanTree = new HashTree();

        //Add Cache Manager
        CacheManager cmanager = new CacheManager();
        cmanager.setClearEachIteration(false);
        cmanager.setUseExpires(false);
        testPlanTree.getjElements().add(cmanager);
        testPlanTree.getjElements().add(new HashTree());

        //Add Cookie Manager
        CookieManager cookieMgr = new CookieManager();
        CollectionProperty cookies = new CollectionProperty();
        cookies.setName("CookieManager.cookies");
        cookieMgr.setCookies(cookies);
        cookieMgr.setClearEachIteration(false);
        cookieMgr.setPolicy("default");
        cookieMgr.setImplementation("org.apache.jmeter.protocol.http.control.HC4CookieHandler");
        testPlanTree.getjElements().add(cookieMgr);
        testPlanTree.getjElements().add(new HashTree());

        //Add Header Manager
        HeaderManager headMgr = new HeaderManager();
        CollectionProperty headers = new CollectionProperty();
        headers.setName("HeaderManager.headers");
        ElementProperty elProp1 = new ElementProperty("", "Header");
        Header header1 = new Header();
        header1.setHeaderName("Accept-Encoding");
        header1.setValue("gzip,deflate,sdch");
        elProp1.getProperties().add(header1.getHeaderName());
        elProp1.getProperties().add(header1.getValue());
        headers.getElementProps().add(elProp1);
        ElementProperty elProp2 = new ElementProperty("", "Header");
        Header header2 = new Header();
        header2.setHeaderName("Accept");
        header2.setValue("text/javascript, text/html, application/xml, text/xml, */*");
        elProp2.getProperties().add(header2.getHeaderName());
        elProp2.getProperties().add(header2.getValue());
        headers.getElementProps().add(elProp2);
        headMgr.setHeaders(headers);
        testPlanTree.getjElements().add(headMgr);
        testPlanTree.getjElements().add(new HashTree());

        //Add Thread Group
        JThreadGroup threadGroup = new JThreadGroup();
        threadGroup.setOn_sample_error("continue");
        threadGroup.setMain_controller("LoopController");
        threadGroup.setNum_threads("1");
        threadGroup.setRamp_time("1");
        long currentTimemillis = System.currentTimeMillis();
        threadGroup.setStart_time(currentTimemillis);
        threadGroup.setEnd_time(currentTimemillis);
        threadGroup.setScheduler(true);
        threadGroup.setDuration("60");
        threadGroup.setDelay(null);
        threadGroup.setDelayedStart(true);
        testPlanTree.getjElements().add(threadGroup);
        HashTree threadGroupTree = new HashTree();
        TransactionController tc = new TransactionController();
        tc.setIncludeTimers(false);
        tc.setParent(false);
        threadGroupTree.getjElements().add(tc);
        //Adding requests
        HashTree requestsHashTree = new HashTree();
        List<HarEntry> entries = har.getLog().getEntries();
        for (HarEntry entry : entries) {
            HarRequest request = entry.getRequest();
            HTTPSamplerProxy sampler = convertRequestToHTTPSampler(request);
            requestsHashTree.getjElements().add(sampler);
            requestsHashTree.getjElements().add(new HashTree());
        }
        threadGroupTree.getjElements().add(requestsHashTree);
        testPlanTree.getjElements().add(threadGroupTree);
        mainHashTree.getjElements().add(testPlanTree);
        JmeterTestPlan jmtp = new JmeterTestPlan();
        jmtp.getHashTree().add(mainHashTree);
        convertToJmx(jmtp);
    }

    private HTTPSamplerProxy convertRequestToHTTPSampler(HarRequest request) {
        HTTPSamplerProxy sampler = new HTTPSamplerProxy();
        sampler.setFollow_redirects(true);
        sampler.setAuto_redirects(false);
        sampler.setUse_keepalive(true);
        sampler.setDO_MULTIPART_POST(false);
        sampler.setMonitor(false);
        sampler.setMethod(request.getMethod().toUpperCase());
        URL url = null;
        try {
            url = new URL(request.getUrl());
            sampler.setUrl(url);
            sampler.setAuto_redirects(false);
            sampler.setConnect_timeout(null);
            sampler.setResponse_timeout(null);
            sampler.setContentEncoding(null);
            sampler.setFollow_redirects(true);
            sampler.setDO_MULTIPART_POST(false);
            sampler.setMonitor(false);
            sampler.setEmbedded_url_re(null);
            sampler.setImplementation(null);
            sampler.setComments(null);
        } catch (MalformedURLException ex) {
        }
        HTTPArguments httpArguments = new HTTPArguments();
        try {
            httpArguments.setTestname(new String(sampler.getUrl().toString().getBytes("UTF-8"), "ASCII"));
        } catch (UnsupportedEncodingException ex) {
        }
        HTTPArgument httpArgument = new HTTPArgument();

        //add postData to Http Sampler
        HarPostData postData = request.getPostData();
        CollectionProperty collProp = new CollectionProperty();
        if (postData != null) {
            for (HarPostDataParam param : postData.getParams()) {
                if (param.getName() != null) {
                    ElementProperty elementProp = new ElementProperty(param.getName(), "HTTPArgument");
                    httpArgument.setArgumentName(param.getName());
                    httpArgument.setArgumentValue(param.getValue());
                    httpArgument.setArgumentDesc(param.getName() + "=>" + param.getValue());
                    httpArgument.setArgumentMetadata("=");
                    httpArgument.setUse_equals(true);
                    httpArgument.setAlways_encode(false);
                    elementProp.getProperties().add(httpArgument.getArgumentName());
                    elementProp.getProperties().add(httpArgument.getArgumentValue());
                    elementProp.getProperties().add(httpArgument.getArgumentMetadata());
                    elementProp.getProperties().add(httpArgument.isUse_equals());
                    elementProp.getProperties().add(httpArgument.isAlways_encode());
                    collProp.getElementProps().add(elementProp);
                }
            }
        }
        //add queryString to the Http Sampler
        if (!request.getQueryString().isEmpty()) {
            for (HarNameValuePair param : request.getQueryString()) {
                if (param.getName() != null) {
                    ElementProperty elementProp = new ElementProperty(param.getName(), "HTTPArgument");
                    httpArgument.setArgumentName(param.getName());
                    httpArgument.setArgumentValue(param.getValue());
                    httpArgument.setArgumentDesc(param.getName() + "=>" + param.getValue());
                    httpArgument.setArgumentMetadata("=");
                    httpArgument.setUse_equals(true);
                    httpArgument.setAlways_encode(false);
                    elementProp.getProperties().add(httpArgument.getArgumentName());
                    elementProp.getProperties().add(httpArgument.getArgumentValue());
                    elementProp.getProperties().add(httpArgument.getArgumentMetadata());
                    elementProp.getProperties().add(httpArgument.isUse_equals());
                    elementProp.getProperties().add(httpArgument.isAlways_encode());
                    collProp.getElementProps().add(elementProp);
                }
            }
        }
        httpArguments.setHttpArguments(collProp);
        sampler.setHttpArguments(httpArguments);
        return sampler;
    }

    private void convertToJmx(JmeterTestPlan jmtp) {
        try {
            JAXBContext context = JAXBContext.newInstance(JmeterTestPlan.class);
            JAXBIntrospector introspector = context.createJAXBIntrospector();
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            if (null == introspector.getElementName(jmtp)) {
                JAXBElement jaxbElement = new JAXBElement(new QName("jmeterTestPlan"), Object.class, jmtp);
                m.marshal(jaxbElement, sw);
            } else {
                m.marshal(jmtp, sw);
            }
            System.out.println(sw.toString());
            File file = new File("performance_test.jmx");
            FileWriter fw = new FileWriter(file);
            fw.write(sw.toString());
            fw.close();
        } catch (JAXBException | IOException ex) {
            throw new RuntimeException("Unable to parse the xml file");
        }
    }
}
