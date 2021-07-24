package org.scalatra.example.swagger

import org.scalatra.ScalatraServlet
import org.scalatra.swagger._


class ResourcesApp(implicit val swagger: Swagger) extends ScalatraServlet with NativeSwaggerBase

object FlowersSwagger{
  val Info = ApiInfo(
    "The Flowershop API",
    "Docs for the Flowers API",
    "http://scalatra.org",
    ContactInfo("Scalatra Team", "apiteam@scalatra.org", "https://github.com/scalatra/scalatra"),
    LicenseInfo("MIT", "http://opensource.org/licenses/MIT")
  )
}
class FlowersSwagger extends Swagger(Swagger.SpecVersion, "1", FlowersSwagger.Info)
