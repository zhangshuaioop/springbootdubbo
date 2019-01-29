package com.teekee.waterdropservice.entity.fdp;

/**
 * @Author Niting
 * @date 2018/10/19
 **/
public class GetFdprExtendPofileShow {
    private FdpFaultDispatchHrRelation extendPofile;
    private String dispatchOrderNumber;
    private String privateNote;

    public String getPrivateNote() {
        return privateNote;
    }

    public void setPrivateNote(String privateNote) {
        this.privateNote = privateNote;
    }

    public FdpFaultDispatchHrRelation getExtendPofile() {
        return extendPofile;
    }

    public void setExtendPofile(FdpFaultDispatchHrRelation extendPofile) {
        this.extendPofile = extendPofile;
    }

    public String getDispatchOrderNumber() {
        return dispatchOrderNumber;
    }

    public void setDispatchOrderNumber(String dispatchOrderNumber) {
        this.dispatchOrderNumber = dispatchOrderNumber;
    }
}
