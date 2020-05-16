package edu.hawaii.its.creditxfer.type;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "MST_TRANSFER_CATALOG_SOURCE_UH", schema = "ODSMGR")
@IdClass(SourceId.class)
public class SourceCatalog implements Serializable {

    public static final long serialVersionUID = 2L;

    private String sourceInstitutionCode;
    private String mifValue;
    private String subjectCodeTrans;
    private String courseNumberTrans;
    private String academicPeriodStart;
    private String transGroupConnector;
    private String courseTitleTrans;
    private Integer courseLowHoursTrans;
    private Integer courseHighHoursTrans;
    private String reviewInd;
    private String tastCode;
    private String transMinGradeCode;
    private String transGroupPrimaryInd;
    private Date transCourseActivityDate;

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

    @Id
    @Column(name = "TRANS_GROUP_CONNECTOR")
    public String getTransGroupConnector() {
        return transGroupConnector;
    }

    public void setTransGroupConnector(String transGroupConnector) {
        this.transGroupConnector = transGroupConnector;
    }

    @Column(name = "COURSE_TITLE_TRANS")
    public String getCourseTitleTrans() {
        return courseTitleTrans;
    }

    public void setCourseTitleTrans(String courseTitleTrans) {
        this.courseTitleTrans = courseTitleTrans;
    }

    @Column(name = "COURSE_LOW_HOURS_TRANS")
    public Integer getCourseLowHoursTrans() {
        return courseLowHoursTrans;
    }

    public void setCourseLowHoursTrans(Integer courseLowHoursTrans) {
        this.courseLowHoursTrans = courseLowHoursTrans;
    }

    @Column(name = "COURSE_HIGH_HOURS_TRANS")
    public Integer getCourseHighHoursTrans() {
        return courseHighHoursTrans;
    }

    public void setCourseHighHoursTrans(Integer courseHighHoursTrans) {
        this.courseHighHoursTrans = courseHighHoursTrans;
    }

    @Column(name = "REVIEW_IND")
    public String getReviewInd() {
        return reviewInd;
    }

    public void setReviewInd(String reviewInd) {
        this.reviewInd = reviewInd;
    }

    @Column(name = "TAST_CODE")
    public String getTastCode() {
        return tastCode;
    }

    public void setTastCode(String tastCode) {
        this.tastCode = tastCode;
    }

    @Column(name = "TRANS_MIN_GRADE_CODE")
    public String getTransMinGradeCode() {
        return transMinGradeCode;
    }

    public void setTransMinGradeCode(String transMinGradeCode) {
        this.transMinGradeCode = transMinGradeCode;
    }

    @Column(name = "TRANS_GROUP_PRIMARY_IND")
    public String getTransGroupPrimaryInd() {
        return transGroupPrimaryInd;
    }

    public void setTransGroupPrimaryInd(String transGroupPrimaryInd) {
        this.transGroupPrimaryInd = transGroupPrimaryInd;
    }

    @Column(name = "TRANS_COURSE_ACTIVITY_DATE")
    public Date getTransCourseActivityDate() {
        return transCourseActivityDate;
    }

    public void setTransCourseActivityDate(Date transCourseActivityDate) {
        this.transCourseActivityDate = transCourseActivityDate;
    }

    @Override
    public String toString() {
        return "SourceCatalog [sourceInstitutionCode=" + sourceInstitutionCode
            + ", mifValue=" + mifValue
            + ", subjectCodeTrans=" + subjectCodeTrans
            + ", courseNumberTrans=" + courseNumberTrans
            + ", academicPeriodStart=" + academicPeriodStart
            + ", transGroupConnector=" + transGroupConnector
            + ", courseTitle=" + courseTitleTrans
            + ", courseLowHoursTrans=" + courseLowHoursTrans
            + ", courseHighHoursTrans=" + courseHighHoursTrans
            + ", reviewInd=" + reviewInd
            + ", tastCode=" + tastCode
            + ", transMinGradeCode=" + transMinGradeCode
            + ", transGroupPrimaryInd=" + transGroupPrimaryInd
            + ", transCourseActivityDate=" + transCourseActivityDate
            + "]";
    }
}
