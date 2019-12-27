package notifyportal.controller;

import notifyportal.model.*;
import notifyportal.repository.*;

import notifyportal.service.EmailService;
import notifyportal.service.LicenceExpireService;
import notifyportal.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @Autowired
    private LicenceExpireService licenceExpireService;

    @GetMapping({"/", "/index"})
    public ModelAndView homePage(ModelAndView modelAndView) {

        List<AgreementModel> agrList = mainService.getAllAgreements();

        modelAndView.addObject("agreementsList", agrList);
        modelAndView.setViewName("frontend/index");
        return modelAndView;
    }

    @PostMapping("/doc-save")
    public ModelAndView uploadDoc(@RequestParam String fileName, @RequestParam int agr, @RequestParam String name,
                                  @RequestParam String email, ModelAndView modelAndView, RedirectAttributes redirect) {

        PersonsModel Persons = mainService.storePersons(name, email);
        DocsModel Docs = mainService.storeDocs(fileName, agr, Persons.getPersID(), false);

        redirect.addFlashAttribute("message", "Person and document were successfully stored!");
        modelAndView.setViewName("redirect:/index");
        return modelAndView;

    }

    @PostMapping("agr-save")
    public ModelAndView storeAgreement(@RequestParam String agrName, @RequestParam String compName,
                                       @RequestParam Date expDate, ModelAndView modelAndView,
                                       RedirectAttributes redirect) {

        AgreementModel agreement = mainService.storeAgreement(agrName, compName, expDate);

        redirect.addFlashAttribute("message", "Agreement was successfully stored!");
        modelAndView.setViewName("redirect:/index");
        return modelAndView;

    }

    @PostMapping("/notify-send")
    public ModelAndView sendNotify(ModelAndView modelAndView, RedirectAttributes redirect) {

        licenceExpireService.calculateWhoseLicenceExpire(true);

        redirect.addFlashAttribute("message", "Notification for expired agreements was send!");
        modelAndView.setViewName("redirect:/index");
        return modelAndView;
    }

    @PostMapping("/delete-docs-users")
    public ModelAndView deleteAllDocsAndPersons(ModelAndView modelAndView, RedirectAttributes redirect) {

        String message = mainService.deleteAllDocsAndPersons();

        redirect.addFlashAttribute("message", message);
        modelAndView.setViewName("redirect:/index");
        return modelAndView;

    }

    @PostMapping("/delete-all")
    public ModelAndView deleteAllAgreements(ModelAndView modelAndView, RedirectAttributes redirect) {

        mainService.deleteAllDocsAndPersons();
        mainService.deleteAllAgreements();

        redirect.addFlashAttribute("message", "Agreements, documents and persons " +
                "successfully deleted!");
        modelAndView.setViewName("redirect:/index");
        return modelAndView;

    }

}
