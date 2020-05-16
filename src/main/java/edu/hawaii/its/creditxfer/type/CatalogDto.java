package edu.hawaii.its.creditxfer.type;

import java.util.Date;

public class CatalogDto {

    private String mifValue;
    private String sourceInstitutionCode;
    private String subjectCodeTrans;
    private String courseNumberTrans;
    private String courseTitleTrans;
    private Integer courseLowHoursTrans;
    private Integer courseHighHoursTrans;
    private String reviewInd;
    private String tastCode;
    private String transMinGradeCode;
    private String transGroupPrimaryInd;
    private String transGroupConnector;
    private String academicPeriodStart;
    private Date transCourseActivityDate;
    private Integer sequenceNumber;
    private String equivLeftParen;
    private String connector;
    private String subjectCodeEquiv;
    private String courseNumberEquiv;
    private String courseTitleEquiv;
    private Integer equivCreditsUsed;
    private String equivRightParen;
    private Date equivCourseActivityDate;

    public CatalogDto() {
        // Empty
    }

    public CatalogDto(String mifValue, String sourceInstitutionCode, String subjectCodeTrans, String courseNumberTrans,
        String courseTitleTrans, Integer courseLowHoursTrans, Integer courseHighHoursTrans, String reviewInd, String tastCode,
        String transMinGradeCode, String transGroupPrimaryInd, String transGroupConnector, String academicPeriodStart,
        Date transCourseActivityDate, Integer sequenceNumber, String equivLeftParen, String connector,
        String subjectCodeEquiv, String courseNumberEquiv, String courseTitleEquiv, Integer equivCreditsUsed, String
        equivRightParen, Date equivCourseActivityDate) {
        this.mifValue = mifValue;
        this.sourceInstitutionCode = sourceInstitutionCode;
        this.subjectCodeTrans = subjectCodeTrans;
        this.courseNumberTrans = courseNumberTrans;
        this.courseTitleTrans = courseTitleTrans;
        this.courseLowHoursTrans = courseLowHoursTrans;
        this.courseHighHoursTrans = courseHighHoursTrans;
        this.reviewInd = reviewInd;
        this.tastCode = tastCode;
        this.transMinGradeCode = transMinGradeCode;
        this.transGroupPrimaryInd = transGroupPrimaryInd;
        this.transGroupConnector = transGroupConnector;
        this.academicPeriodStart = academicPeriodStart;
        this.transCourseActivityDate = transCourseActivityDate;
        this.sequenceNumber = sequenceNumber;
        this.equivLeftParen = equivLeftParen;
        this.connector = connector;
        this.subjectCodeEquiv = subjectCodeEquiv;
        this.courseNumberEquiv = courseNumberEquiv;
        this.courseTitleEquiv = courseTitleEquiv;
        this.equivCreditsUsed = equivCreditsUsed;
        this.equivRightParen = equivRightParen;
        this.equivCourseActivityDate = equivCourseActivityDate;
    }

    public String getMifValue() {
        return mifValue;
    }

    public void setMifValue(String mifValue) {
        this.mifValue = mifValue;
    }

    public String getSourceInstitutionCode() {
        return sourceInstitutionCode;
    }

    public void setSourceInstitutionCode(String sourceInstitutionCode) {
        this.sourceInstitutionCode = sourceInstitutionCode;
    }

    public String getSubjectCodeTrans() {
        return subjectCodeTrans;
    }

    public void setSubjectCodeTrans(String subjectCodeTrans) {
        this.subjectCodeTrans = subjectCodeTrans;
    }

    public String getCourseNumberTrans() {
        return courseNumberTrans;
    }

    public void setCourseNumberTrans(String courseNumberTrans) {
        this.courseNumberTrans = courseNumberTrans;
    }

    public String getCourseTitleTrans() {
        return courseTitleTrans;
    }

    public void setCourseTitleTrans(String courseTitleTrans) {
        this.courseTitleTrans = courseTitleTrans;
    }

    public Integer getCourseLowHoursTrans() {
        return courseLowHoursTrans;
    }

    public void setCourseLowHoursTrans(Integer courseLowHoursTrans) {
        this.courseLowHoursTrans = courseLowHoursTrans;
    }

    public Integer getCourseHighHoursTrans() {
        return courseHighHoursTrans;
    }

    public void setCourseHighHoursTrans(Integer courseHighHoursTrans) {
        this.courseHighHoursTrans = courseHighHoursTrans;
    }

    public String getReviewInd() {
        return reviewInd;
    }

    public void setReviewInd(String reviewInd) {
        this.reviewInd = reviewInd;
    }

    public String getTastCode() {
        return tastCode;
    }

    public void setTastCode(String tastCode) {
        this.tastCode = tastCode;
    }

    public String getTransMinGradeCode() {
        return transMinGradeCode;
    }

    public void setTransMinGradeCode(String transMinGradeCode) {
        this.transMinGradeCode = transMinGradeCode;
    }

    public String getTransGroupPrimaryInd() {
        return transGroupPrimaryInd;
    }

    public void setTransGroupPrimaryInd(String transGroupPrimaryInd) {
        this.transGroupPrimaryInd = transGroupPrimaryInd;
    }

    public String getTransGroupConnector() {
        return transGroupConnector;
    }

    public void setTransGroupConnector(String transGroupConnector) {
        this.transGroupConnector = transGroupConnector;
    }

    public String getAcademicPeriodStart() {
        return academicPeriodStart;
    }

    public void setAcademicPeriodStart(String academicPeriodStart) {
        this.academicPeriodStart = academicPeriodStart;
    }

    public Date getTransCourseActivityDate() {
        return transCourseActivityDate;
    }

    public void setTransCourseActivityDate(Date transCourseActivityDate) {
        this.transCourseActivityDate = transCourseActivityDate;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getEquivLeftParen() {
        return equivLeftParen;
    }

    public void setEquivLeftParen(String equivLeftParen) {
        this.equivLeftParen = equivLeftParen;
    }

    public String getConnector() {
        return connector;
    }

    public void setConnector(String connector) {
        this.connector = connector;
    }

    public String getSubjectCodeEquiv() {
        return subjectCodeEquiv;
    }

    public void setSubjectCodeEquiv(String subjectCodeEquiv) {
        this.subjectCodeEquiv = subjectCodeEquiv;
    }

    public String getCourseNumberEquiv() {
        return courseNumberEquiv;
    }

    public void setCourseNumberEquiv(String courseNumberEquiv) {
        this.courseNumberEquiv = courseNumberEquiv;
    }

    public String getCourseTitleEquiv() {
        return courseTitleEquiv;
    }

    public void setCourseTitleEquiv(String courseTitleEquiv) {
        this.courseTitleEquiv = courseTitleEquiv;
    }

    public Integer getEquivCreditsUsed() {
        return equivCreditsUsed;
    }

    public void setEquivCreditsUsed(Integer equivCreditsUsed) {
        this.equivCreditsUsed = equivCreditsUsed;
    }

    public String getEquivRightParen() {
        return equivRightParen;
    }

    public void setEquivRightParen(String equivRightParen) {
        this.equivRightParen = equivRightParen;
    }

    public Date getEquivCourseActivityDate() {
        return equivCourseActivityDate;
    }

    public void setEquivCourseActivityDate(Date equivCourseActivityDate) {
        this.equivCourseActivityDate = equivCourseActivityDate;
    }

    @Override
    public String toString() {
        return "CatalogDto [mifValue=" + mifValue
            + ", sourceInstitutionCode=" + sourceInstitutionCode
            + ", subjectCodeTrans=" + subjectCodeTrans
            + ", courseNumberTrans=" + courseNumberTrans
            + ", courseTitleTrans=" + courseTitleTrans
            + ", courseLowHoursTrans=" + courseLowHoursTrans
            + ", courseHighHoursTrans=" + courseHighHoursTrans
            + ", reviewInd=" + reviewInd
            + ", tastCode=" + tastCode
            + ", transMinGradeCode=" + transMinGradeCode
            + ", transGroupPrimaryInd=" + transGroupPrimaryInd
            + ", transGroupConnector=" + transGroupConnector
            + ", academicPeriodStart=" + academicPeriodStart
            + ", transCourseActivityDate=" + transCourseActivityDate
            + ", sequenceNumber=" + sequenceNumber
            + ", equivLeftParen=" + equivLeftParen
            + ", connector=" + connector
            + ", subjectCodeEquiv=" + subjectCodeEquiv
            + ", courseNumberEquiv=" + courseNumberEquiv
            + ", courseTitleEquiv=" + courseTitleEquiv
            + ", equivCreditsUsed=" + equivCreditsUsed
            + ", equivRightParen=" + equivRightParen
            + ", equivCourseActivityDate=" + equivCourseActivityDate
            + "]";
    }
}
