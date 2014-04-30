package models

class Practice {

  def findList(): List[(Int, String, String)] = {
    List((1, "Japan", "Tokyo"),(2, "USA", "Washington"))
  }
}

object Practice extends Practice
