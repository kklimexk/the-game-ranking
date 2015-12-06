package controllers

import db.Db
import play.api.mvc._
import play.api.libs.json.Json

class Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def rankingJson = Action {
    val ranking = Db.getRanking

    var jsonRanking = Json.arr()
    ranking.foreach { position =>
      val jsonPosition = Json.arr(
        position._1,
        position._2
      )
      jsonRanking :+= jsonPosition
    }

    val jsonRankingResult = Json.obj("aaData" -> jsonRanking)
    Ok(jsonRankingResult)
  }

}
