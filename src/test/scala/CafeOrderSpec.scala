import org.scalatest._

class CafeOrderSpec extends WordSpec with Matchers {



  "Calculate bill" should {
    "return total cost with no service charge" when {
      "the purchased items are drinks" in {

        val order: List[MenuItem] = List(Cola, Coffee)
        object newOrder extends CafeOrder(order)
        val result = newOrder.calculateBill
        result shouldBe "£1.50"
      }
    }

    "return total cost with 10% service charge" when {
      "the purchased items contain any food" in {
        val order: List[MenuItem] = List(CheeseSandwich, Coffee)
        object newOrder extends CafeOrder(order)
        val result = newOrder.calculateBill
        result shouldBe "£3.30"
      }
    }

    "return total cost with 20% service charge" when {
      "the purchased items contain any hot food" in {
        val order: List[MenuItem] = List(SteakSandwich, Cola)
        object newOrder extends CafeOrder(order)
        val result = newOrder.calculateBill
        result shouldBe "£6.00"
      }
    }

    "return total cost with 20% service charge" when {
      "the purchased items contain any hot food with a maximum £20 service charge" in {
        val order: List[MenuItem] = List.fill[MenuItem](25)(SteakSandwich)
        object newOrder extends CafeOrder(order)
        val result = newOrder.calculateBill
        result shouldBe "£132.50"
      }
    }

    "return total cost with 25% service charge" when {
      "the purchased items contain any premium food with a maximum £40 service charge" in {
        val order: List[MenuItem] = List.fill[MenuItem](9)(Lobster)
        object newOrder extends CafeOrder(order)
        val result = newOrder.calculateBill
        result shouldBe "£265.00"
      }
    }

    "return total bill with no discounts" when {
      "the purchased items doesn't contain any premium food and the customer has a loyalty card with less than 3 stars" in {
        val order: List[MenuItem] = List(SteakSandwich, Coffee)
        val loyaltyCard: LoyaltyCard = new LoyaltyCard(stars = 2)
        object newOrder extends CafeOrder(order, Some(loyaltyCard))
        val result = newOrder.calculateBill
        result shouldBe "£6.60"
      }
    }

    "return total bill with discounts" when {
      "the purchased items doesn't contain any premium food and the customer has a loyalty card with 3 stars" in {
        val order: List[MenuItem] = List(SteakSandwich, Coffee)
        val loyaltyCard: LoyaltyCard = new LoyaltyCard(stars = 3)
        object newOrder extends CafeOrder(order, Some(loyaltyCard))
        val result = newOrder.calculateBill
        result shouldBe "£6.10"
      }
    }

    "return total bill with no discounts" when {
      "the purchased items contain any premium food and the customer has a loyalty card with 5 stars" in {
        val order: List[MenuItem] = List(Lobster, SteakSandwich, Coffee)
        val loyaltyCard: LoyaltyCard = new LoyaltyCard(stars = 5)
        object newOrder extends CafeOrder(order, Some(loyaltyCard))
        val result = newOrder.calculateBill
        result shouldBe "£38.12"
      }
    }

    "return total bill with discounts" when {
      "the purchased items doesn't contain any premium food and the customer has a loyalty card with 8 stars" in {
        val order: List[MenuItem] = List(CheeseSandwich, Cola)
        val loyaltyCard: LoyaltyCard = new LoyaltyCard(stars = 8)
        object newOrder extends CafeOrder(order, Some(loyaltyCard))
        val result = newOrder.calculateBill
        result shouldBe "£2.20"
      }
    }

    "return total bill with discounts" when {
      "the purchased items doesn't contain any premium food and the customer has a loyalty card with 10 stars" in {
        val order: List[MenuItem] = List(SteakSandwich, CheeseSandwich, Cola, Coffee)
        val loyaltyCard: LoyaltyCard = new LoyaltyCard(stars = 10)
        object newOrder extends CafeOrder(order, Some(loyaltyCard))
        val result = newOrder.calculateBill
        result shouldBe "£7.68"
      }
    }

  }

}
