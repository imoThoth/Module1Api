import com.fasterxml.jackson.databind.ObjectMapper
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpRequest.BodyPublishers.noBody
import java.net.http.HttpResponse


fun main(args: Array<String>) {
   val url = "https://http-challenge.multiverse-coaches.io"
    try {

        println("FIRST REQUEST")
        val client = HttpClient.newHttpClient()
        // first request (GET)
        val request = HttpRequest.newBuilder(
            URI.create(url))
           .header("accept", "application/json")

            .method("GET", noBody())
            .build()
       println(request)
       val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        println(response.body())


        //SECOND REQUEST
        val values = mapOf("name" to "Tosin")
        val objectMapper = ObjectMapper()
        val requestBody: String = objectMapper
            .writeValueAsString(values)

        val json = "{" +
        "\"name\":\"tosin\"" +
                "}";


        println("SECOND REQUEST")
        val request1 = HttpRequest.newBuilder(
            //URI.create("$url/apprentices"))"https://http-challenge.multiverse-coaches.io"
             URI.create("$url/apprentices"))
            .header("content-type", "application/json")
            .POST( HttpRequest.BodyPublishers.ofString(json))
            .build()
        println(request1)
        val response1 = client.send(request1, HttpResponse.BodyHandlers.ofString())
        println(response1.body())

        var holder = "";
        val header = response1.headers().map()
        for(i in header){
           if (i.key.toString() == "your-id") {
             holder = i.value[0];
         }
       }


        println("Third Request")
        val request2 = HttpRequest.newBuilder(
            //URI.create("$url/apprentices"))"https://http-challenge.multiverse-coaches.io"
            URI.create("$url/apprentices/$holder?'Your-Id'"))
            .header("content-type", "application/json")
            .method( "GET" , noBody())
            .build()
        println(request2)
        val response2 = client.send(request2, HttpResponse.BodyHandlers.ofString())
        println(response2.body())


        println("Fourth Request")
        val json2 = "guest = " + "einstein " + "guest = " + "einstein " + "guest = " + "michaelJackson ";
        val request3 = HttpRequest.newBuilder(
            //URI.create("$url/apprentices"))"https://http-challenge.multiverse-coaches.io"
            URI.create("$url/apprentices/$holder?'Your-Id'"))
            .header("Content-Type","application/x-www-form-urlencoded")
            .method("PATCH", HttpRequest.BodyPublishers.ofString(json2))
            .build()
        println(request3)
        val response3 = client.send(request3, HttpResponse.BodyHandlers.ofString())
        println(response3.body())

        println("Fifth Request")
        val params = "?starter=philadelphia-light-on-toast&main=honey-soy-marinated-pheasant&dessert=chocolate-flavour-vanilla-ice-cream"
        val request4 = HttpRequest.newBuilder(
            //URI.create("$url/apprentices"))"https://http-challenge.multiverse-coaches.io"
            URI.create("$url/apprentices/$holder/menus$params"))
            .header("Content-Type","application/x-www-form-urlencoded")
            .method("GET", noBody())
            .build()
        println(request4)
        val response4 = client.send(request4, HttpResponse.BodyHandlers.ofString())
        println(response4.body())

        println("Final Request")
        val request5 = HttpRequest.newBuilder(
            URI.create("$url/apprentices/$holder"))
            .DELETE()
            .build()
        println(request5)
        val response5 = client.send(request5, HttpResponse.BodyHandlers.ofString())
        println(response5.body())

    } catch (e: Exception) {
        e.printStackTrace()
    }
}