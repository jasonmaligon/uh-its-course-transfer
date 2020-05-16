package edu.hawaii.its.creditxfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import edu.hawaii.its.creditxfer.repository.SourceCatalogRepository;
import edu.hawaii.its.creditxfer.repository.TargetCatalogRepository;
import edu.hawaii.its.creditxfer.type.CatalogDto;
import edu.hawaii.its.creditxfer.type.SourceCatalog;
import edu.hawaii.its.creditxfer.type.TargetCatalog;

@Service
public class CatalogService {

    @Autowired
    private SourceCatalogRepository sourceCatalogRepository;

    @Autowired
    private TargetCatalogRepository targetCatalogRepository;

    public List<SourceCatalog> findAllSourceCatalog() {
        return sourceCatalogRepository.findAllByOrderBySourceInstitutionCode();
    }

    public List<TargetCatalog> findAllTargetCatalog() {
        return targetCatalogRepository.findAllByOrderBySourceInstitutionCode();
    }

    @Cacheable(value = "catalogGrouped")
    public List<CatalogDto> findAllBySourceGrouped(String sourceInstitutionCode, String mifValue, String subjectCodeTrans) {
        return sourceCatalogRepository.findAllBySourceGrouped(sourceInstitutionCode, mifValue, subjectCodeTrans);
    }

    @Cacheable(value = "catalogNonGrouped")
    public List<CatalogDto> findAllBySourceNonGrouped(String sourceInstitutionCode, String subjectCodeTrans) {
        return sourceCatalogRepository.findAllBySourceNonGrouped(sourceInstitutionCode, subjectCodeTrans);
    }

    @Cacheable(value = "catalogBoth")
    public List<SourceCatalog> findAllForBoth(String sourceInstitutionCode, String mifValue, String subjectCodeTrans) {
        return sourceCatalogRepository.findAllForBoth(sourceInstitutionCode, mifValue, subjectCodeTrans);
    }

    @Cacheable(value = "catalogSubjects")
    public List<String> findAllSubjectsBySource(String sourceInstitutionCode) {
        return sourceCatalogRepository.findAllSubjectsBySource(sourceInstitutionCode);
    }
}
