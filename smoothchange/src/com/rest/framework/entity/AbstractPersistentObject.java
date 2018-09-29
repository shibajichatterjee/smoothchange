package com.rest.framework.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractPersistentObject extends AbstractIdentifierObject {

    private static final long serialVersionUID = 1L;

    /*@Column(name="approve_status")
    private String approveStatus;
    
	@Column(name="maker_id")
    private String makerId;	
	
    @Column(name="maker_date")
    @Temporal (value=TemporalType.TIMESTAMP)
    private Date makerDate;   
    
    @Column(name="checker_id")
    private String checkerId;  
    
    @Column(name="checker_date")  
    @Temporal (value=TemporalType.TIMESTAMP)
    private Date checkerDate ;
    
    @Column(name="free_text1")
    private String freeText1 ;
    
    @Column(name="free_text2")
    private String freeText2 ;
    
    @Column(name="free_text3")
    private String freeText3 ;
    
    @Column(name="free_value1")
    private String freeValue1 ;
    
    @Column(name="free_value2")
    private String freeValue2;
    
    @Column(name="free_value3")
    private String freeValue3;

	public String getApproveStatus() {
		return approveStatus;
	}
	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}
	public String getMakerId() {
		return makerId;
	}
	public void setMakerId(String makerId) {
		this.makerId = makerId;
	}
	public Date getMakerDate() {
		return makerDate;
	}
	public void setMakerDate(Date makerDate) {
		this.makerDate = makerDate;
	}
	public String getCheckerId() {
		return checkerId;
	}
	public void setCheckerId(String checkerId) {
		this.checkerId = checkerId;
	}
	public Date getCheckerDate() {
		return checkerDate;
	}
	public void setCheckerDate(Date checkerDate) {
		this.checkerDate = checkerDate;
	}
	public String getFreeText1() {
		return freeText1;
	}
	public void setFreeText1(String freeText1) {
		this.freeText1 = freeText1;
	}
	public String getFreeText2() {
		return freeText2;
	}
	public void setFreeText2(String freeText2) {
		this.freeText2 = freeText2;
	}
	public String getFreeText3() {
		return freeText3;
	}
	public void setFreeText3(String freeText3) {
		this.freeText3 = freeText3;
	}
	public String getFreeValue1() {
		return freeValue1;
	}
	public void setFreeValue1(String freeValue1) {
		this.freeValue1 = freeValue1;
	}
	public String getFreeValue2() {
		return freeValue2;
	}
	public void setFreeValue2(String freeValue2) {
		this.freeValue2 = freeValue2;
	}
	public String getFreeValue3() {
		return freeValue3;
	}
	public void setFreeValue3(String freeValue3) {
		this.freeValue3 = freeValue3;
	}*/
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
