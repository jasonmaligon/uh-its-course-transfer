package edu.hawaii.its.creditxfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.hawaii.its.creditxfer.type.SourceCatalog;
import edu.hawaii.its.creditxfer.type.CatalogDto;

public interface SourceCatalogRepository
    extends JpaRepository<SourceCatalog, Integer> {

    List<SourceCatalog> findAllByOrderBySourceInstitutionCode();

    @Query("select new edu.hawaii.its.creditxfer.type.CatalogDto(s.mifValue, s.sourceInstitutionCode, " +
        "s.subjectCodeTrans, s.courseNumberTrans, s.courseTitleTrans, s.courseLowHoursTrans, " +
        "s.courseHighHoursTrans, s.reviewInd, s.tastCode, s.transMinGradeCode, " +
        "s.transGroupPrimaryInd, s.transGroupConnector, s.academicPeriodStart, " +
        "s.transCourseActivityDate, e.sequenceNumber, e.equivLeftParen, e.connector, " +
        "e.subjectCodeEquiv, e.courseNumberEquiv, e.courseTitleEquiv, e.equivCreditsUsed, " +
        "e.equivRightParen, e.equivCourseActivityDate) " +
        "from SourceCatalog s inner join TargetCatalog e " +
        "on s.transGroupConnector is not null " +
        "and s.mifValue = e.mifValue and s.sourceInstitutionCode = e.sourceInstitutionCode " +
        "and s.subjectCodeTrans = e.subjectCodeTrans and s.courseNumberTrans = e.courseNumberTrans " +
        "and s.academicPeriodStart = e.academicPeriodStart " +
        "and s.transGroupConnector = e.transGroupConnector " +
        "where s.sourceInstitutionCode = :sourceInstitutionCode " +
        "and s.mifValue = :mifValue and s.subjectCodeTrans = :subjectCodeTrans")
    List<CatalogDto> findAllBySourceGrouped(@Param("sourceInstitutionCode") String sourceInstitutionCode,
        @Param("mifValue") String mifValue, @Param("subjectCodeTrans") String subjectCodeTrans);

    @Query("select new edu.hawaii.its.creditxfer.type.CatalogDto(s.mifValue, s.sourceInstitutionCode, " +
        "s.subjectCodeTrans, s.courseNumberTrans, s.courseTitleTrans, s.courseLowHoursTrans, " +
        "s.courseHighHoursTrans, s.reviewInd, s.tastCode, s.transMinGradeCode, " +
        "s.transGroupPrimaryInd, s.transGroupConnector, s.academicPeriodStart, " +
        "s.transCourseActivityDate, e.sequenceNumber, e.equivLeftParen, e.connector, " +
        "e.subjectCodeEquiv, e.courseNumberEquiv, e.courseTitleEquiv, e.equivCreditsUsed, " +
        "e.equivRightParen, e.equivCourseActivityDate) " +
        "from SourceCatalog s inner join TargetCatalog e " +
        "on s.mifValue = e.mifValue and s.sourceInstitutionCode = e.sourceInstitutionCode " +
        "and s.subjectCodeTrans = e.subjectCodeTrans and s.courseNumberTrans = e.courseNumberTrans " +
        "and s.academicPeriodStart = e.academicPeriodStart " +
        "and s.transGroupConnector is null and e.transGroupConnector is null " +
        "where s.sourceInstitutionCode = :sourceInstitutionCode and " +
        "s.subjectCodeTrans = :subjectCodeTrans")
    List<CatalogDto> findAllBySourceNonGrouped(@Param("sourceInstitutionCode") String sourceInstitutionCode,
        @Param("subjectCodeTrans") String subjectCodeTrans);

    @Query("select s from SourceCatalog s where s.sourceInstitutionCode = :sourceInstitutionCode and " +
        "s.mifValue = :mifValue and s.subjectCodeTrans = :subjectCodeTrans and " +
        "s.transGroupPrimaryInd is null and s.transGroupConnector is not null")
    List<SourceCatalog> findAllForBoth(@Param("sourceInstitutionCode") String
        sourceInstitutionCode, @Param("mifValue") String mifValue, @Param("subjectCodeTrans") String subjectCodeTrans);

    @Query("select distinct s.subjectCodeTrans from SourceCatalog s " +
        "where s.sourceInstitutionCode = :sourceInstitutionCode")
    List<String> findAllSubjectsBySource(@Param("sourceInstitutionCode") String sourceInstitutionCode);
}