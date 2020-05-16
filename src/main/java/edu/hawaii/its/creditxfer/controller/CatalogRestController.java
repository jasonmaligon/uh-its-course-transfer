package edu.hawaii.its.creditxfer.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.hawaii.its.creditxfer.service.CatalogService;
import edu.hawaii.its.creditxfer.type.CatalogDto;
import edu.hawaii.its.creditxfer.type.SourceCatalog;
import edu.hawaii.its.creditxfer.type.TargetCatalog;

@RestController
public class CatalogRestController {

    private static final Log logger = LogFactory.getLog(InstitutionRestController.class);

    @Autowired
    private CatalogService catalogService;

    @GetMapping(value = "/api/sourceCatalog")
    public ResponseEntity<List<SourceCatalog>> sourceCatalog() {
        logger.info("Entered REST catalog...");
        List<SourceCatalog> catalog = catalogService.findAllSourceCatalog();
        return ResponseEntity
            .ok()
            .body(catalog);
    }

    @GetMapping(value = "/api/targetCatalog")
    public ResponseEntity<List<TargetCatalog>> targetCatalog() {
        logger.info("Entered REST target catalog...");
        List<TargetCatalog> catalog = catalogService.findAllTargetCatalog();
        return ResponseEntity
            .ok()
            .body(catalog);
    }

    @GetMapping(value = "/api/catalogGrouped/source/{source}/target/{target}/subject/{subject}")
    public ResponseEntity<List<CatalogDto>> catalogBySourceGrouped(
        @PathVariable String source, @PathVariable String target, @PathVariable String subject) {
        logger.info("Entered REST catalog (source=" + source + ")...");
        List<CatalogDto> catalog = catalogService.findAllBySourceGrouped(source, target.toUpperCase(), subject.toUpperCase());
        return ResponseEntity
            .ok()
            .body(catalog);
    }

    @GetMapping(value = "/api/catalogNonGrouped/source/{source}/subject/{subject}")
    public ResponseEntity<List<CatalogDto>> catalogBySourceNonGrouped(
        @PathVariable String source, @PathVariable String subject) {
        logger.info("Entered REST catalog nongrouped (source=" + source + ")...");
        List<CatalogDto> catalog = catalogService.findAllBySourceNonGrouped(source, subject.toUpperCase());
        return ResponseEntity
            .ok()
            .body(catalog);
    }

    @GetMapping(value = "/api/sourceCatalogBoth/source/{source}/target/{target}/subject/{subject}")
    public ResponseEntity<List<SourceCatalog>> catalogBySourceBoth(
        @PathVariable String source, @PathVariable String target, @PathVariable String subject) {
        logger.info("Entered REST catalog both (source=" + source + ")...");
        List<SourceCatalog> catalog = catalogService.findAllForBoth(source, target.toUpperCase(), subject.toUpperCase());
        return ResponseEntity
            .ok()
            .body(catalog);
    }

    @GetMapping(value = "/api/sourceCatalog/source/{source}/subjects")
    public ResponseEntity<List<String>> catalogSubjects(
        @PathVariable String source) {
        logger.info("Entered REST catalog subjects (source=" + source + ")...");
        List<String> catalog = catalogService.findAllSubjectsBySource(source);
        return ResponseEntity
            .ok()
            .body(catalog);
    }
}
