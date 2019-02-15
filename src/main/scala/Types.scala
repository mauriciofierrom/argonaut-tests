object Types {
  case class Account(urls: List[String], userName: String, credential: String)
  // case class Sites(accounts: List[Account], port: Int)
  case class Sites(accounts: List[Account])
}
