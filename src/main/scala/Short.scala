import argonaut._, Argonaut._

object Short {
  import Types._
  implicit def AccountCodecJson: CodecJson[Account] =
    casecodec3(Account.apply, Account.unapply)("urls", "username", "credential")

  implicit def SitesCodecJson: CodecJson[Sites] =
    // casecodec2(Sites.apply, Sites.unapply)("accounts")
    casecodec1(Sites.apply, Sites.unapply)("accounts")
}
