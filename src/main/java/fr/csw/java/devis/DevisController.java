package fr.csw.java.devis;

import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class DevisController {

    @Autowired
    private DevisService devisService;

    @Autowired
    private DevisRepository devisRepository;


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

    @GetMapping("/devis/export")
    public void exportToPDF(HttpServletResponse response, int id) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "content-disposition";
        String headerValue = "attachment; filename=devisCSW_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        Optional<Devis> devisForPdf = devisRepository.findById(id);

        DevisPDFExporter exporter = new DevisPDFExporter(devisForPdf);
        exporter.export(response);

    }

}
