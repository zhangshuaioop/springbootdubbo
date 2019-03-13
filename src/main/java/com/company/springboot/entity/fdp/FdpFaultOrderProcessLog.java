package com.company.springboot.entity.fdp;

import java.util.Date;

public class FdpFaultOrderProcessLog {
    private Integer id;

    private Integer faultOrderProcessId;

    private String title;

    private String memo;

    private Integer processPersonId;

    private Date processTime;

    private Boolean flagConsole;

    private Integer rootId;

    public Integer getRootId() {
        return rootId;
    }

    public void setRootId(Integer rootId) {
        this.rootId = rootId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFaultOrderProcessId() {
        return faultOrderProcessId;
    }

    public void setFaultOrderProcessId(Integer faultOrderProcessId) {
        this.faultOrderProcessId = faultOrderProcessId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Integer getProcessPersonId() {
        return processPersonId;
    }

    public void setProcessPersonId(Integer processPersonId) {
        this.processPersonId = processPersonId;
    }

    public Date getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Date processTime) {
        this.processTime = processTime;
    }

    public Boolean getFlagConsole() {
        return flagConsole;
    }

    public void setFlagConsole(Boolean flagConsole) {
        this.flagConsole = flagConsole;
    }
}