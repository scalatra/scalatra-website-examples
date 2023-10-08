package org.scalatra.example

import org.scalatra._
import org.squeryl._
import org.squeryl.dsl._
import org.scalatra.example.data.DatabaseInit
import org.scalatra.example.data.DatabaseSessionSupport
import org.scalatra.example.models.Article
import org.scalatra.example.models.BlogDb
import java.util.Random
import java.util.Collections

class ArticlesController extends ScalatraServlet
  with SessionSupport
	with DatabaseSessionSupport
	with MethodOverride
	with FlashMapSupport
  with PrimitiveTypeMode {

  // To supply FlashMap to Twirl templates
  private implicit def flashMap: FlashMap = flash

  get("/") {
    contentType = "text/html"

    val articles = from(BlogDb.articles)(select(_))
    html.index(articles.toList)
  }

  val newArticle = get("/articles/new") {
    contentType = "text/html"

    val article = new Article()
    html.form(article)
  }

  post("/articles") {
    contentType = "text/html"

    val article = new Article(0, params("title"), params("body"))

    if(Article.create(article)) {
      flash("notice") = "Article successfully created"
      redirect("/")
    } else {
      flash("error") = "There were problems creating your article"
      html.form(article)
    }
  }

  get("/create-db") {
    contentType = "text/html"

    BlogDb.create
    redirect("/articles/new")
  }
}
