case object Cola extends MenuItem {
  val cost: BigDecimal = 0.5
  val isHot: Boolean = false
  val isFood: Boolean = false
  val serviceCharge: ServiceCharge = NoServiceCharge
}

case object Coffee extends MenuItem {
  val cost: BigDecimal = 1
  val isHot: Boolean = true
  val isFood: Boolean = false
  val serviceCharge: ServiceCharge = NoServiceCharge
}

case object CheeseSandwich extends MenuItem {
  val cost: BigDecimal = 2
  val isHot: Boolean = false
  val isFood: Boolean = true
  val serviceCharge: ServiceCharge = TenPercentServiceCharge
}

case object SteakSandwich extends MenuItem {
  val cost: BigDecimal = 4.5
  val isHot: Boolean = true
  val isFood: Boolean = true
  val serviceCharge: ServiceCharge = TwentyPercentServiceCharge
}

case object Lobster extends MenuItem {
  val cost: BigDecimal = 25
  val isHot: Boolean = true
  val isFood: Boolean = true
  val serviceCharge: ServiceCharge = TwentyFivePercentServiceCharge
}

