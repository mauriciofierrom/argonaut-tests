import org.scalatest._
import org.scalatest.Matchers._

import argonaut._, Argonaut._

import Manual._
import Types._

class ManualSpec extends FunSpec {
  describe("Encoding/Decoding") {
    val response: String =
      s"""
      {
        "accounts": [
        {
          "urls": [
          "http://www.something.com"
          ],
          "username": "user1",
          "credential": "credential1"
        },
        {
          "urls": [
          "http://www.other.com"
          ],
          "username": "user2",
          "credential": "credential2"
        }
        ],
        "port": 3600
      }
      """
    it("Encodes and decodes responses") {
      val encoded = Sites(
        List(
          Account(List("http://www.something.com"), "user1", "credential1"),
          Account(List("http://www.other.com"), "user2", "credential2"),
            ))
      val Right(encodedResponse): Either[String, Sites] = Parse.decodeEither[Sites](response)

      encodedResponse should equal(encoded)
    }
  }
}
