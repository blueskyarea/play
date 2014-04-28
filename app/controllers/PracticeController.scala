package controllers

import play.api.mvc._
import org.joda.time.DateTime
import org.joda.time.Duration

object PracticeController extends Controller {

  def showRequest = Action {
    aaa =>
    Ok("Request:" + aaa)
  }

  def check(date: DateTime): Either[Int, String] = {
    val today = DateTime.now
    if (date.isEqual(today)) {
      Right("今日は誕生日です。")
    } else {
      Left(100)
    }
  }

  def showBirthDay() = Action {
    val birthDay = DateTime.now
    check(birthDay) match {
      case Right(msg) => {
        Ok(msg)
      }
      case Left(day) => {
        Ok("誕生日まで" + day + "日です。")
      }
    }
  }
}
