package com.xyz.interceptorlogdemo.entity;

import org.hibernate.resource.jdbc.LogicalConnection;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "t_logger_infos")
public class LoggerEntity implements Serializable {

    @Id
    /**
     * strategy提供4中属性：
     * -AUTO主键由程序控制, 是默认选项 ,不设置就是这个
     * -IDENTITY 主键由数据库生成, 采用数据库自增长, Oracle不支持这种方式
     * -SEQUENCE 通过数据库的序列产生主键, MYSQL  不支持
     * -Table 提供特定的数据库产生主键, 该方式更有利于数据库的移植
     */
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ali_id")
    private Long id;

    @Column(name = "ali_client_ip")
    private String clientIp;

    @Column(name = "ali_uri")
    private String uri;

    @Column(name = "ali_type")
    private String type;

    @Column(name = "ali_method")
    private String method;

    @Column(name = "ali_param_data")
    private String paramData;

    @Column(name = "ali_session_id")
    private String sessionId;

    @Column(name = "ali_time",insertable = false)
    private Timestamp time;

    @Column(name = "ali_returm_time")
    private String returnTime;

    @Column(name = "ali_return_data")
    private String returnData;

    @Column(name = "ali_http_status_code")
    private String httpStatusCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getReturnData() {
        return returnData;
    }

    public void setReturnData(String returnData) {
        this.returnData = returnData;
    }

    public String getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(String httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public int getTimeConsuming() {
        return timeConsuming;
    }

    public void setTimeConsuming(int timeConsuming) {
        this.timeConsuming = timeConsuming;
    }

    @Column(name = "ali_time_consuming")
    private int timeConsuming;

}
