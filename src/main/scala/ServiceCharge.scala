sealed trait ServiceCharge {
  val value: BigDecimal
}

case object NoServiceCharge extends ServiceCharge {
  val value = 0
}

case object TenPercentServiceCharge extends ServiceCharge {
  val value = 0.1
}

case object TwentyPercentServiceCharge extends ServiceCharge {
  val value = 0.2
}

case object TwentyFivePercentServiceCharge extends ServiceCharge {
  val value = 0.25
}
