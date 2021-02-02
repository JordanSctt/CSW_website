package fr.csw.java.admin;

import fr.csw.java.devis.Devis;
import fr.csw.java.devis.DevisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private DevisRepository devisRepository;

    @GetMapping("/admin/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("loginAdmin");
        return modelAndView;
    }

    @GetMapping("/devis/admin/list")
    public ModelAndView list() {
        List<Devis> allDevis = devisRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("listDevis");
        modelAndView.addObject("allDevis", allDevis);
        return modelAndView;
    }

    @GetMapping("/devis/admin/delete")
    public ModelAndView delete(@RequestParam int id) {
        Devis devis = new Devis();
        devis.setId(id);
        devisRepository.delete(devis);
        return list();
    }
}
