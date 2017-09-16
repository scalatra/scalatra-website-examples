package org.scalatra.example.swagger

import org.scalatra.ScalatraServlet
import org.scalatra.swagger.{ApiInfo, NativeSwaggerBase, Swagger}


class ResourcesApp(implicit val swagger: Swagger) extends ScalatraServlet with NativeSwaggerBase

object FlowersSwagger{
  val Info = ApiInfo(
    "The Flowershop API",
    "Docs for the Flowers API",
    "http://scalatra.org",
    "apiteam@scalatra.org",
    "MIT",
    "http://opensource.org/licenses/MIT")
}
class FlowersSwagger extends Swagger("2.0", "1", FlowersSwagger.Info)
