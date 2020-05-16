package edu.hawaii.its.creditxfer.controller;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.hawaii.its.creditxfer.access.User;
import edu.hawaii.its.creditxfer.access.UserContextService;

@Controller
public class HomeController {

    private static final Log logger = LogFactory.getLog(HomeController.class);

    @Autowired
    private UserContextService userContextService;

    @GetMapping(value = { "/", "/home" })
    public String home(Locale locale) {
        logger.debug("User at home. The client locale is " + locale);

        return "home";
    }

    @PreAuthorize("hasRole('ROLE_UH')")
    @RequestMapping(value = { "/attributes" }, method = { RequestMethod.GET })
    public String attributes(Model model) {

        logger.info("Entered attributes...");

        User user = userContextService.getCurrentUser();
        logger.info("current user    : " + user);
        model.addAttribute("currentUser", user);

        logger.info("Leaving attributes.");

        return "attributes";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact() {
        return "contact";
    }

    @GetMapping(value = "/faq")
    public String faq() {
        return "help/faq";
    }

    @GetMapping(value = { "/glossary", "/glossary/" })
    public String glossary() {
        logger.debug("User at glossary.");
        return "glossary/glossary";
    }

    @GetMapping(value = { "/glossary/{id}" })
    public String glossary(@PathVariable String id) {
        logger.debug("User at glossary. id: >" + id + "<");
        return "glossary/glossary-" + id.trim();
    }

    @GetMapping(value = "/fonts")
    public String fonts() {
        logger.debug("User at fonts.");
        return "help/fonts";
    }

    @GetMapping(value = "/institutions")
    public String institutions() {
        return "institutions2";
    }

    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public String denied() {
        return "denied";
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String invalid() {
        return "redirect:/";
    }
}
