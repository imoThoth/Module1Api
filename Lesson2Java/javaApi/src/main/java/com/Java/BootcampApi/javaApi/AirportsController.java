package com.Java.BootcampApi.javaApi;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airports")
public class AirportsController {

    @PostMapping("/{id}")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/{id}")
    public String getAirports(){
        return "\"\"\"00AK\" \"\", \"Lowel Field\", \"Anchor-point\", \"Alaska\", \"US\", \"450\", \"5.959\", \"-151.695999\", \"America\"\"\"";
    }

    @PutMapping("/{id}")
    public String changeAirports(){
        return "\"00AB\", \"\", \"Iawo Field\", \"Anchor-point\", \"Pennsylvania\", \"US\", \"780\", \"5.95912\", \"-150.695999\", \"America\"";
    }

    @DeleteMapping("/{id}")
    public String deleteAirport(){
        return "Success";
    }
}
