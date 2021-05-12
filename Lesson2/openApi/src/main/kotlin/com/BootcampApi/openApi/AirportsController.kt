package com.BootcampApi.openApi

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*


@RestController //writes return type of read method
@RequestMapping("/airports")
class OpenApiController{

    @PostMapping("/{id}")
    fun sayHello()  : String {
       // body("00AK", "", "Lowel Field", "Anchor-point", "Alaska", "US", "450", "5.959", "-151.695999", "America")
        return "\"00AK\", \"\", \"Lowel Field\", \"Anchor-point\", \"Alaska\", \"US\", \"450\", \"5.959\", \"-151.695999\", \"America\""
    }

    @GetMapping("/{id}")
    fun getAirports() : String {
      return  """00AK" "", "Lowel Field", "Anchor-point", "Alaska", "US", "450", "5.959", "-151.695999", "America"""
    }

    @PutMapping("/{id}")
    fun putAirport() : String {
       // return body("00AB", "", "Iawo Field", "Anchor-point", "Pennsylvania", "US", "780", "5.95912", "-150.695999", "America")
        return "\"00AB\", \"\", \"Iawo Field\", \"Anchor-point\", \"Pennsylvania\", \"US\", \"780\", \"5.95912\", \"-150.695999\", \"America\""
    }

    @DeleteMapping("/{id}")
    fun deleteAirport() : String{
        return "SUCCESS"
    }
}



fun body(icao: String, iata: String, name: String, city: String, state: String, country: String, elevation:String, lati :String, lon: String, tz : String) {

}

