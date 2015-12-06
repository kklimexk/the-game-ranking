package db

import play.api.db.DB
import play.api.Play.current

object Db {
  def getRanking: List[(String, Int)] = {
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
    ranking.sortWith(_._2 > _._2)
  }
}
