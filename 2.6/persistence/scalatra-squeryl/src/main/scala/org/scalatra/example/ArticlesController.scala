package org.scalatra.example

import org.scalatra._
import scalate.ScalateSupport
import org.scalatra.example.data.DatabaseInit
import org.scalatra.example.data.DatabaseSessionSupport
import org.scalatra.example.models.Article
import org.scalatra.example.models.BlogDb
import org.squeryl.PrimitiveTypeMode._
import java.util.Random
import java.util.Collections

class ArticlesController extends ScalatraServlet 
  with SessionSupport
	with DatabaseSessionSupport 
	with ScalateSupport
	with MethodOverride
	with FlashMapSupport {

  get("/") {
    contentType = "text/html"
      
    val articles = from(BlogDb.articles)(select(_))
    ssp("/articles/index", "articles" -> articles)
  }
  
  val newArticle = get("/articles/new") { 
    contentType = "text/html"
      
    val article = new Article()
    ssp("/articles/new", "article" -> article)
  }
  
  post("/articles") {
    contentType = "text/html"
    
    val article = new Article(0, params("title"), params("body"))

    if(Article.create(article)) {
      flash("notice") = "Article successfully created"
      redirect("/")
    } else {
      flash("error") = "There were problems creating your article"
      ssp("articles/new", "article" -> article)
    }
  }

  get("/create-db") {
    contentType = "text/html"

    BlogDb.create
    redirect("/articles/new")
  }

  notFound {
    // Try to render a ScalateTemplate if no route matched
    findTemplate(requestPath) map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound()
  }
  
}
