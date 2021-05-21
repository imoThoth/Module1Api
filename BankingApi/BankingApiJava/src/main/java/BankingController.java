import org.springframework.web.bind.annotation.*;



@RestController
//@RequestMapping("/justBanking")
public class BankingController {

        @PostMapping("/")
        public String sayHello(){
            return "Hello";
        }

        @GetMapping("/justBanking")
        public String getAirports(){
            return "Account Balance: £500";
        }

        @PutMapping("/")
        public String changeAirports(){
            return "\"00AB\", \"\", \"Iawo Field\", \"Anchor-point\", \"Pennsylvania\", \"US\", \"780\", \"5.95912\", \"-150.695999\", \"America\"";
        }

        @DeleteMapping("/")
        public String deleteAirport(){
            return "Success";
        }
    }


