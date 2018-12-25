package com.platform.springboot.entity.cfg;

/**
 * @author liukan
 * @create 2018年03月27日 14:40
 */
public class CfgOperateProcessConfig {

    private int id;

    private String type;

    private String status;

    private int statusSortId;

    private String operateDisplayName;

    private String operateName;

    private int operateSortId;

    private boolean flagDisplay;

    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusSortId() {
        return statusSortId;
    }

    public void setStatusSortId(int statusSortId) {
        this.statusSortId = statusSortId;
    }

    public String getOperateDisplayName() {
        return operateDisplayName;
    }

    public void setOperateDisplayName(String operateDisplayName) {
        this.operateDisplayName = operateDisplayName;
    }

    public String getOperateName() {
        return operateName;
    }

    public void setOperateName(String operateName) {
        this.operateName = operateName;
    }

    public int getOperateSortId() {
        return operateSortId;
    }

    public void setOperateSortId(int operateSortId) {
        this.operateSortId = operateSortId;
    }

    public boolean isFlagDisplay() {
        return flagDisplay;
    }

    public void setFlagDisplay(boolean flagDisplay) {
        this.flagDisplay = flagDisplay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
