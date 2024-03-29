class LoyaltyCard(stars: Int) {

  private val percentage: BigDecimal = stars match {
    case num if num < 3 => 0
    case num if num > 8 => 0.20
    case num => num * 0.025
  }

  val percentageDecrease: BigDecimal = 1 - percentage

}

