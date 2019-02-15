import argonaut._, Argonaut._

object Manual {
  import Types._

  implicit def AccountDecodeJson: DecodeJson[Account] =
    DecodeJson(c => for {
      urls <- (c --\ "urls").as[List[String]]
      username <- (c --\ "username").as[String]
      credential <- (c --\ "credential").as[String]
    } yield Account(urls, username, credential))

  implicit def AccountEncodeJson: EncodeJson[Account] =
      jencode3L((a: Account) =>
          (a.urls, a.userName, a.credential))("urls", "username", "credential")

  implicit def SitesDecodeJson: DecodeJson[Sites] =
    DecodeJson(c => for {
      accounts <- (c --\ "accounts").as[List[Account]]
    } yield Sites(accounts))

  implicit def SitesEncodeJson: EncodeJson[Sites] =
      jencode1L((s: Sites) =>
          (s.accounts))("accounts")
}
