package controllers

import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import org.joda.time.DateTime
import org.joda.time.Duration

import models._

object PracticeController extends Controller {
  /** Form定義 */
  val inputForm = Form(
    mapping(
      "ta" -> text)
    (InputField.apply)(InputField.unapply))

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

  /**
   * 入力フィールドを表示する
   * @return
   */
  def showInputField() = Action {
    Ok(views.html.inputField())
  }

  /**
   * 出力フィールドを表示する
   * @return
   */
  def showOutputField() = Action { implicit request =>
    inputForm.bindFromRequest.fold(
      errors => {
        Ok(views.html.outputField())
      },
      success => {
        Ok(views.html.outputField(success.textarea))
      }
    )
  }

  /**
   * リストを表示する
   */
  def showList() = Action {
    val sampleList = Practice.findList()
    Ok(views.html.showList(sampleList))
  }
}
