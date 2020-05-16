package edu.hawaii.its.creditxfer.type;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "MST_TRANSFER_CATALOG_EQUIV_UH", schema = "ODSMGR")
@IdClass(TargetId.class)
public class TargetCatalog implements Serializable {

    public static final long serialVersionUID = 2L;

    private String sourceInstitutionCode;
    private String mifValue;
    private String subjectCodeTrans;
    private String courseNumberTrans;
    private String academicPeriodStart;
    private String transGroupConnector;
    private Integer sequenceNumber;
    private String equivLeftParen;
    private String connector;
    private String subjectCodeEquiv;
    private String courseNumberEquiv;
    private String courseTitleEquiv;
    private Integer equivCreditsUsed;
    private String equivRightParen;
    private Date equivCourseActivityDate;

    @Id
    @Column(name = "SOURCE_INSTITUTION_CODE")
    public String getSourceInstitutionCode() {
        return sourceInstitutionCode;
    }

    public void setSourceInstitutionCode(String sourceInstitutionCode) {
        this.sourceInstitutionCode = sourceInstitutionCode;
    }

    @Id
    @Column(name = "MIF_VALUE")
    public String getMifValue() {
        return mifValue;
    }

    public void setMifValue(String mifValue) {
        this.mifValue = mifValue;
    }

    @Id
    @Column(name = "SUBJECT_CODE_TRANS")
    public String getSubjectCodeTrans() {
        return subjectCodeTrans;
    }

    public void setSubjectCodeTrans(String subjectCodeTrans) {
        this.subjectCodeTrans = subjectCodeTrans;
    }

    @Id
    @Column(name = "COURSE_NUMBER_TRANS")
    public String getCourseNumberTrans() {
        return courseNumberTrans;
    }

    public void setCourseNumberTrans(String courseNumberTrans) {
        this.courseNumberTrans = courseNumberTrans;
    }

    @Id
    @Column(name = "ACADEMIC_PERIOD_START")
    public String getAcademicPeriodStart() {
        return academicPeriodStart;
    }

    public void setAcademicPeriodStart(String academicPeriodStart) {
        this.academicPeriodStart = academicPeriodStart;
    }

    @Column(name = "TRANS_GROUP_CONNECTOR")
    public String getTransGroupConnector() {
        return transGroupConnector;
    }

    public void setTransGroupConnector(String transGroupConnector) {
        this.transGroupConnector = transGroupConnector;
    }

    @Id
    @Column(name = "SEQUENCE_NUMBER")
    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    @Column(name = "EQUIV_LEFT_PAREN")
    public String getEquivLeftParen() {
        return equivLeftParen;
    }

    public void setEquivLeftParen(String equivLeftParen) {
        this.equivLeftParen = equivLeftParen;
    }

    @Column(name = "CONNECTOR")
    public String getConnector() {
        return connector;
    }

    public void setConnector(String connector) {
        this.connector = connector;
    }

    @Column(name = "SUBJECT_CODE_EQUIV")
    public String getSubjectCodeEquiv() {
        return subjectCodeEquiv;
    }

    public void setSubjectCodeEquiv(String subjectCodeEquiv) {
        this.subjectCodeEquiv = subjectCodeEquiv;
    }

    @Column(name = "COURSE_NUMBER_EQUIV")
    public String getCourseNumberEquiv() {
        return courseNumberEquiv;
    }

    public void setCourseNumberEquiv(String courseNumberEquiv) {
        this.courseNumberEquiv = courseNumberEquiv;
    }

    @Column(name = "COURSE_TITLE_EQUIV")
    public String getCourseTitleEquiv() {
        return courseTitleEquiv;
    }

    public void setCourseTitleEquiv(String courseTitleEquiv) {
        this.courseTitleEquiv = courseTitleEquiv;
    }

    @Column(name = "EQUIV_CREDITS_USED")
    public Integer getEquivCreditsUsed() {
        return equivCreditsUsed;
    }

    public void setEquivCreditsUsed(Integer  equivCreditsUsed) {
        this.equivCreditsUsed = equivCreditsUsed;
    }

    @Column(name = "EQUIV_RIGHT_PAREN")
    public String getEquivRightParen() {
        return equivRightParen;
    }

    public void setEquivRightParen(String equivRightParen) {
        this.equivRightParen = equivRightParen;
    }

    @Column(name = "EQUIV_COURSE_ACTIVITY_DATE")
    public Date getEquivCourseActivityDate() {
        return equivCourseActivityDate;
    }

    public void setEquivCourseActivityDate(Date equivCourseActivityDate) {
        this.equivCourseActivityDate = equivCourseActivityDate;
    }

    @Override
    public String toString() {
        return "TargetCatalog [sourceInstitutionCode=" + sourceInstitutionCode
            + ", mifValue=" + mifValue
            + ", subjectCodeTrans=" + subjectCodeTrans
            + ", courseNumberTrans=" + courseNumberTrans
            + ", academicPeriodStart=" + academicPeriodStart
            + ", transGroupConnector=" + transGroupConnector
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
