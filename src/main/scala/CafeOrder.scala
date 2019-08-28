import java.text.NumberFormat.getCurrencyInstance

import scala.math.BigDecimal.RoundingMode

class CafeOrder(order: List[MenuItem], optLoyaltyCard: Option[LoyaltyCard] = None) {

  def format(cost: BigDecimal): String = getCurrencyInstance.format(cost.setScale(2, RoundingMode.HALF_EVEN))

  val cost: BigDecimal = order.map(_.cost).sum

  val preServiceChargeCost: BigDecimal = optLoyaltyCard match {
    case Some(loyaltyCard) if !order.contains(Lobster) => loyaltyCard.percentageDecrease * cost
    case _ => cost
  }

  val serviceCharge: BigDecimal = {
    order.map(_.serviceCharge).maxByOption(_.value) match {
      case Some(TwentyFivePercentServiceCharge) if preServiceChargeCost * TwentyFivePercentServiceCharge.value > 40 => 40
      case Some(TwentyPercentServiceCharge) if preServiceChargeCost * TwentyPercentServiceCharge.value > 20 => 20
      case Some(serviceCharge) => preServiceChargeCost * serviceCharge.value
      case _ => preServiceChargeCost
    }
  }

  val calculateBill: String = format(serviceCharge + preServiceChargeCost)

}