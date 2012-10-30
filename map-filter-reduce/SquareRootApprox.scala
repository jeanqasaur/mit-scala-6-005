/**
 * From Martin Odersky's notes.
 */
import scala.math._

object SquareRootApprox {
  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  def improve(guess: Double, x: Double) =
    (guess + x / guess) / 2

  def isGoodEnough(guess: Double, x: Double) =
    abs(guess * guess - x) < 0.001

  def sqrt(x: Double) = sqrtIter(1.0, x)

  /* Nested functions. */
  def sqrt2(x: Double) = {
    def sqrtIter(guess: Double, x: Double): Double =
      if (isGoodEnough(guess, x)) guess
      else sqrtIter(improve(guess, x), x)
    def improve(guess: Double, x: Double) = (guess + x / guess) / 2
    def isGoodEnough(guess: Double, x: Double) =
      abs(guess * guess - x) < 0.001
    sqrtIter(1.0, x)
  }

  /* Exercise 4.4.1: The isGoodEnough test is not very precise for small
     numbers and might lead to non-termination for very large ones (why?).
     Design a different version of isGoodEnough which does not have these
     problems.
     
     Hint:
     http://bloodredsun.com/2011/06/22/doubles-financial-calculations/ */
}
