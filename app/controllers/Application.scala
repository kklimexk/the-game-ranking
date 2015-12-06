package controllers

import play.api.db.DB
import play.api.mvc._
import play.api.Play.current

class Application extends Controller {

  def index = Action {
    type Player = (String, Int)

    var ranking = List.empty[Player]

    val conn = DB.getConnection()
    try {
      val stmt = conn.createStatement

      val rs = stmt.executeQuery("SELECT * FROM ranking")

      while (rs.next) {
        ranking :+= (rs.getString("player"), rs.getInt("points"))
      }
    } finally {
      conn.close()
    }
    Ok(views.html.index(ranking.sortWith(_._2 > _._2)))
  }

}
