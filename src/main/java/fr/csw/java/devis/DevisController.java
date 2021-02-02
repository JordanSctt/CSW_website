package fr.csw.java.devis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DevisController {

    @Autowired
    private DevisService devisService;


    @GetMapping("/accueil")
    public ModelAndView accueil() {
        return new ModelAndView("accueil");
    }

    @GetMapping("/devis/get/new")
    public ModelAndView displayFormNewDevis() {
        ModelAndView modelAndView = new ModelAndView("devis");
        return modelAndView;
    }

    @PostMapping("/devis/post/new")
    public ModelAndView newDevis(@ModelAttribute("request") Devis request) {
        Devis newDevis = devisService.save(request);
        System.out.println(newDevis.toString());
        ModelAndView modelAndView = new ModelAndView("detailDevis");
        modelAndView.addObject("devis", newDevis);
        return modelAndView;
    }


}
