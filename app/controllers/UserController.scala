package controllers;

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models._

object UserController extends Controller {
  /** Form定義 */
  val userForm = Form(
    mapping(
      "name" -> nonEmptyText,
      "email" -> email)
      (User.apply)(User.unapply))

  /** 初期画面関数 */
  def entryInit = Action{
    val filledForm = userForm.fill(User("user name", "email address"))
    Ok(views.html.user.entry(filledForm))
  }

  /** ユーザー登録関数 */
  def entrySubmit = Action{ implicit request =>
    userForm.bindFromRequest.fold(
      errors => {
        println("error!")
        BadRequest(views.html.user.entry(errors))
      },
      success => {
        println("entry success!")
        Ok(views.html.user.entrySubmit())
      }
    )
  }
}
