package org.github.andrewrembrandt.cragmapper

import net.ruippeixotog.scalascraper.browser.JsoupBrowser

import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._
import net.ruippeixotog.scalascraper.model.Element
import scala.util.matching.Regex


case class Crag (name: String, ukcCragId: Int, climbs: List[Climb])
case class Climb (name: String)

/**
  * Created by andrew on 11/10/16.
  */
class UkcSearchScraper(val searchLoc: String) {

  val browser = JsoupBrowser()
  val cragSearchDoc = browser.get(s"http://www.ukclimbing.com/logbook/map/liveresults.php?g=0&loc=$searchLoc&dist=50&km=1&q=")

  def ukcCragIdFromResults(e: Element) = """id=([0-9]+)""".r.findFirstMatchIn(e.attr("onclick")).get.group(1).toInt

  def requestClimbs(ukcCragId: Int) = {
    val climbSearchDoc = browser.get(s"http://www.ukclimbing.com/logbook/crag.php?id=$ukcCragId")

  }

  val crags = cragSearchDoc >> elements(".panel") map {
    e => Crag(
      e >> text(".panel-heading"), ukcCragIdFromResults(e), Nil)
  }
}
