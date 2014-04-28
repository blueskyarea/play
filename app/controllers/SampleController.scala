package controllers

import play.api._
import play.api.mvc._
import play.api.libs.iteratee.Enumerator
import com.sun.xml.internal.bind.v2.TODO

object SampleController extends Controller {

  def sample1() = Action {
    Ok(views.html.index("Sample Controller#sample1"))
  }

  def sample2() = Action {
    Ok(views.html.index("Sample Controller#sample2"))
  }

  val sample3 = Action{ request =>
    Ok("Got requst [" + request + "]")
  }

  val sample4 = Action{
    Ok("Hello World!")
  }

  val sample5 = Action{ request =>
    Ok("path:" + request.path)
  }

  def say() = Action{ implicit request =>
    Ok(greeting("Hello"))
  }
  private def greeting(say: String)(implicit req: RequestHeader) = {
    say + "," + req.remoteAddress
  }

  def sample6 = Action{
    //SimpleResult(
    //  header = ResponseHeader(200, Map(CONTENT_TYPE -> "text/html")),
      //body = Enumerator(views.html.index("Sample Controller#sample6"))
    //)
    Ok("SimpleResultってどうよ")
  }

  def yahoo = Action{
    Redirect("http://www.yahoo.co.jp")
  }

  def sample7(id: Long) = Action{
    Ok(views.html.index("id:" + id))
  }

  def sample8(path: String) = Action{
    Ok(views.html.index("path:" + path))
  }

  def sample9(id: Long) = Action{
    Ok(views.html.index("id:" + id))
  }

  def sample10(fixedValue: String) = Action{
    println("fixedValue:" + fixedValue)
    Ok(views.html.index("fixedValue:" + fixedValue))
  }

  def sample11(defaultValue: Int) = Action{
    println("defaultValue:" + defaultValue)
    Ok(views.html.index("defaultValue:" + defaultValue))
  }

  def sample12(optValue: Option[String]) = Action{
    println("optValue:" + optValue)
    val res = optValue match{
      case Some(opt) => opt
      case None => "Nothing"
    }
    Ok(views.html.index("optValue:" + res))
  }

  def sample13() = Action{
    Redirect(routes.SampleController.sample1)
  }
}