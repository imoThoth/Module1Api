package com.BootcampApi.openApi

import org.springframework.web.bind.annotation.*


@RestController //writes return type of read method
@RequestMapping("/airports")
class OpenApiController{

    @PostMapping("/{id}")
    fun sayHello()  : String {

//       val data: BCryptPasswordEncoder? = null
//
//        return data!!.encode("\"00AK\", \"\", \"Lowel Field\", \"Anchor-point\", \"Alaska\", \"US\", \"450\", \"5.959\", \"-151.695999\", \"America\"")
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



