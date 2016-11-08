package syveien.no;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by arnfinno on 11.09.2016.
 */

@Controller
public class VareController {

    @Autowired
    VareRepository repository;

    @RequestMapping("/")
    public String redirect() {
        System.out.println("redirect");
        return "redirect:liste";
    }
    //Henter varelista og legger til i home
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String listAlle(ModelMap map){
        List<Vare> vareList =repository.findAll();
        map.addAttribute("liste", vareList);
        System.out.println("listAlle til home");
        return "home";
    }

    //Login kall for å laste login-side
    @RequestMapping(path = "/login" ,method = RequestMethod.GET)
    public String visLogin(){
        System.out.println("login");
        return "login";
    }

    //Lagrer en vare til MongoDB
    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public @ResponseBody
    Vare save(@RequestParam(value = "navn") String vareNavn){
        Vare vare = new Vare(vareNavn);
        repository.save(vare);
        System.out.println("lagre");
        return vare;
    }

    //Enderer varenavnet i MongoDB
    @RequestMapping(path = "/endre", method = RequestMethod.POST)
    public @ResponseBody
    Vare save(@RequestParam(value = "id") String id, @RequestParam(value = "navn") String vareNavn) {
        System.out.println(id+vareNavn);
        Vare vare = new Vare(id, vareNavn);
        repository.save(vare);
        System.out.println("endre");
        return vare;
    }

    //Henter liste.htm
    @RequestMapping(path = "/liste", method = RequestMethod.GET)
    public String visAlle(ModelMap map){
        map.addAttribute("liste", repository.findAll());
        System.out.println("visAlle i liste.htm");
        return "liste";
    }

    //Sletter en etter ID
    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public @ResponseBody
    boolean delete (@PathVariable(value = "id") String id) {
        repository.delete(id);
        return true;
    }
    //Sletter alle...
    @RequestMapping(path = "/deleteAll", method = RequestMethod.GET)
    public @ResponseBody
    boolean deleteAll() {
        System.out.println("Slett alle!");
        repository.deleteAll();
        return true;
    }

    //Henter inn alle objektene fra databasen til liste
    @RequestMapping(path = "/list/json", method = RequestMethod.GET)
    public @ResponseBody
    List<Vare> getJson() {
        System.out.println("getJson");
        return repository.findAll();
    }
}
