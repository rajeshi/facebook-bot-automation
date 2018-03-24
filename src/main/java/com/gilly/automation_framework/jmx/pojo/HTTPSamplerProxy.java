package com.gilly.automation_framework.jmx.pojo;

import java.io.Serializable;
import java.net.URL;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class HTTPSamplerProxy extends BaseInfo implements Serializable {

    @XmlElement(name = "elementProp")
    private HTTPArguments httpArguments;
    @XmlElement(name = "HeaderManager.headers")
    private HeaderManager headers;
    @XmlElement(name = "collectionProp")
    private PostData postData;
    @XmlElement(name = "stringProp")
    private StringProp domain;
    @XmlElement(name = "stringProp")
    private StringProp port;
    @XmlElement(name = "stringProp")
    private StringProp connect_timeout;
    @XmlElement(name = "stringProp")
    private StringProp response_timeout;
    @XmlElement(name = "stringProp")
    private StringProp protocol;
    @XmlElement(name = "stringProp")
    private StringProp contentEncoding;
    @XmlElement(name = "stringProp")
    private StringProp path;
    @XmlElement(name = "stringProp")
    private StringProp method;
    @XmlElement(name = "boolProp")
    private BoolProp follow_redirects;
    @XmlElement(name = "boolProp")
    private BoolProp auto_redirects;
    @XmlElement(name = "boolProp")
    private BoolProp use_keepalive;
    @XmlElement(name = "boolProp")
    private BoolProp DO_MULTIPART_POST;
    @XmlElement(name = "stringProp")
    private StringProp implementation;
    @XmlElement(name = "boolProp")
    private BoolProp monitor;
    @XmlElement(name = "stringProp")
    private StringProp embedded_url_re;
    @XmlElement(name = "stringProp")
    private StringProp comments;
    @XmlTransient
    private URL url;

    public HTTPSamplerProxy() {
        super("HttpTestSampleGui", "HTTPSamplerProxy", "", true);
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
        int _port = url.getPort() != -1 ? url.getPort() : ("HTTPS".equalsIgnoreCase(url.getProtocol()) ? 443 : 80);
        this.port = new StringProp();
        this.port.setName("HTTPSampler.port");
        this.port.setValue(String.valueOf(_port));
        this.path = new StringProp();
        this.path.setName("HTTPSampler.path");
        this.path.setValue(url.getPath());
        if (this.path.getValue() == null || this.path.getValue().isEmpty()) {
            super.setTestname(url.getHost());
        } else {
            super.setTestname(this.path.getValue());
        }
        this.protocol = new StringProp();
        this.protocol.setName("HTTPSampler.protocol");
        this.protocol.setValue(url.getProtocol());
        this.domain = new StringProp();
        this.domain.setName("HTTPSampler.domain");
        this.domain.setValue(url.getHost());
        this.port = new StringProp();
        this.port.setName("HTTPSampler.port");
        if (url.getPort() != -1) {
            this.port.setValue(String.valueOf(url.getPort()));
        } else {
            if ("HTTPS".equalsIgnoreCase(url.getProtocol())) {
                this.port.setValue(String.valueOf(443));
            } else {
                this.port.setValue(String.valueOf(80));
            }
        }
    }

    public PostData getPostData() {
        return postData;
    }

    public void setPostData(PostData postData) {
        this.postData = postData;
    }

    public HTTPArguments getHttpArguments() {
        return httpArguments;
    }

    public void setHttpArguments(HTTPArguments httpArguments) {
        this.httpArguments = httpArguments;
    }

    public void setHeaders(HeaderManager headers) {
        this.headers = headers;
    }

    public StringProp getDomain() {
        return domain;
    }

    public StringProp getPort() {
        return port;
    }

    public StringProp getConnect_timeout() {
        return connect_timeout;
    }

    public void setConnect_timeout(String connect_timeout) {
        this.connect_timeout = new StringProp();
        this.connect_timeout.setName("HTTPSampler.connect_timeout");
        this.connect_timeout.setValue(connect_timeout);
    }

    public StringProp getResponse_timeout() {
        return response_timeout;
    }

    public void setResponse_timeout(String response_timeout) {
        this.response_timeout = new StringProp();
        this.response_timeout.setName("HTTPSampler.response_timeout");
        this.response_timeout.setValue(response_timeout);
    }

    public StringProp getProtocol() {
        return protocol;
    }

    public StringProp getContentEncoding() {
        return contentEncoding;
    }

    public void setContentEncoding(String contentEncoding) {
        this.contentEncoding = new StringProp();
        this.contentEncoding.setName("HTTPSampler.contentEncoding");
        this.contentEncoding.setValue(contentEncoding);
    }

    public StringProp getPath() {
        return path;
    }

    public StringProp getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = new StringProp();
        this.method.setName("HTTPSampler.method");
        this.method.setValue(method);
    }

    public BoolProp isFollow_redirects() {
        return follow_redirects;
    }

    public void setFollow_redirects(boolean follow_redirects) {
        this.follow_redirects = new BoolProp();
        this.follow_redirects.setName("HTTPSampler.follow_redirects");
        this.follow_redirects.setValue(follow_redirects);
    }

    public BoolProp getAuto_redirects() {
        return auto_redirects;
    }

    public void setAuto_redirects(boolean auto_redirects) {
        this.auto_redirects = new BoolProp();
        this.auto_redirects.setName("HTTPSampler.auto_redirects");
        this.auto_redirects.setValue(auto_redirects);
    }

    public BoolProp getUse_keepalive() {
        return use_keepalive;
    }

    public void setUse_keepalive(boolean use_keepalive) {
        this.use_keepalive = new BoolProp();
        this.use_keepalive.setName("HTTPSampler.use_keepalive");
        this.use_keepalive.setValue(use_keepalive);
    }

    public BoolProp getDO_MULTIPART_POST() {
        return DO_MULTIPART_POST;
    }

    public void setDO_MULTIPART_POST(boolean DO_MULTIPART_POST) {
        this.DO_MULTIPART_POST = new BoolProp();
        this.DO_MULTIPART_POST.setName("HTTPSampler.DO_MULTIPART_POST");
        this.DO_MULTIPART_POST.setValue(DO_MULTIPART_POST);
    }

    public BoolProp getMonitor() {
        return monitor;
    }

    public void setMonitor(boolean monitor) {
        this.monitor = new BoolProp();
        this.monitor.setName("HTTPSampler.monitor");
        this.monitor.setValue(monitor);
    }

    public StringProp getEmbedded_url_re() {
        return embedded_url_re;
    }

    public void setEmbedded_url_re(String embedded_url_re) {
        this.embedded_url_re = new StringProp();
        this.embedded_url_re.setName("HTTPSampler.embedded_url_re");
        this.embedded_url_re.setValue(embedded_url_re);
    }

    public HeaderManager getHeaders() {
        return headers;
    }

    public BoolProp getFollow_redirects() {
        return follow_redirects;
    }

    public StringProp getImplementation() {
        return implementation;
    }

    public void setImplementation(String implementation) {
        this.implementation = new StringProp();
        this.implementation.setName("HTTPSampler.implementation");
        this.implementation.setValue(implementation);
    }

    public StringProp getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = new StringProp();
        this.comments.setName("TestPlan.comments");
        this.comments.setValue(comments);
    }
}
