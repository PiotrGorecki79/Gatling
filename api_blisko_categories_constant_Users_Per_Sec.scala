package computerdatabase // 1

import io.gatling.core.Predef._ // 2
import io.gatling.http.Predef._
import scala.concurrent.duration._

class api_blisko_categories_constant_Users_Per_Sec_2 extends Simulation { // 3

  val httpConf = http // 4
    .baseURL("https://api-blisko.pracuj.pl/categories") // 5
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // 6
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

  val scn = scenario("api_blisko_categories_constant_Users_Per_Sec_2") // 7
    .exec(http("request_1")  // 8
    .get("/")) // 9
    .pause(5) // 10

  setUp( // 11
    scn.inject(constantUsersPerSec(2) during(1 minutes)) // 12
  ).protocols(httpConf) // 13
}