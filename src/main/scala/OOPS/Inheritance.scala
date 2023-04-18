package OOPS

object Inheritance extends App {
  trait Driving {
    def driveUsing(): String
  }

  trait Flying {
    def flyUsing(): String
  }

  trait Sailing {
    def sailUsing(): String
  }

  case class Car() extends Driving {
    override def driveUsing(): String = {
      "A car be driven"
    }
  }

  case class Ship() extends Sailing {
    override def sailUsing(): String = {
      "a Boat can be sailed."
    }
  }

  case class Aeroplane() extends Flying {
    override def flyUsing(): String = {
      "an Aeroplane can be flown"
    }
  }

  case class FlyingCar() extends Driving with Flying {
    override def driveUsing(): String = "Flying car can be drive"

    override def flyUsing(): String = "Flying car can also be flown"
  }

  case class Hovercraft() extends Sailing with Driving {
    override def sailUsing(): String = "Hovercraft can be sailed"

    override def driveUsing(): String = "Hovrcraft can also be drive"
  }
}