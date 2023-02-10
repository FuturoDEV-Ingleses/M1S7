package M1S7.LoggingTeste.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoggingController {
    
    Logger logg = LoggerFactory.getLogger(LoggingController.class);

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/numberInf")
    public String number(@RequestParam(name = "number", required = false, 
        defaultValue = "22") String numero, Model model){

        try{
            int valor = Integer.parseInt(numero);
            model.addAttribute("valor", numero);

            if(valor > 10 || valor < 1){
                logg.warn("O valor informado é superior ou inferior ao permitido");
            }
            
            logg.info("Operação realizada.");
        }catch(Exception ex){
            logg.error("Erro de Conversão para Int!");
        }

        return "number";
    }

}
