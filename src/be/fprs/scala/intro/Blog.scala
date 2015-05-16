package be.fprs.scala.intro

/**
 *
 * Created by delans1 on 09-May-15 at 9:31 PM.
 */
class Blog(val article : String) {

  def len() : Int = {
    article.length()
  }
}

object Blog {

  def apply(t : String) : Blog = {
    new Blog(t)
  }
  def showInfo(article : Blog) : Unit = {
    println("The size of the article: " + article.len)
  }

}
