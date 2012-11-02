/**
 * Exercises for the first 6.005 Recitation on Scala.
 * 
 * Things we will do in recitation:
 * - Get everyone running Scala.  See:
 *   https://sites.google.com/site/jeevesprogramming/tutorial/introduction-to-scala-for-6-005
 * - Implement Newton's method to get familiar with recursive functions in
     Scala.
 */
import scala.math._

case object Unimplemented extends Exception

object SquareRootApprox {
  /* Section 1: Recursion. */
  /* Newton's method is an algorithm for computing square roots. */
  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  def improve(guess: Double, x: Double) =
    (guess + x / guess) / 2

  def isGoodEnough(guess: Double, x: Double) =
    abs(guess * guess - x) < 0.001

  def sqrt(x: Double) = sqrtIter(1.0, x)

  /* Exercise 1: Now implement Newton's method using nested functions. */
  def yourSqrt(x: Double) = throw Unimplemented

  /* Bonus exercise: The test in isGoodEnough is not too precise for small
     numbers and might lead to non-termination for very large ones.  (Why?)
     Design a different version of isGoodEnough which does not have these
     problems.  You may want to get by reading this:
     http://bloodredsun.com/2011/06/22/doubles-financial-calculations/ */

  /* Section 1.1: Recursion vs. tail recursion. */
  def factorial(n: Int): Int = if (n == 0) 1 else n * factorial(n - 1)

  /* Exercise 2: Implement a tail recursive version of factorial. How does
     evaluation of this differ? */
  def factorialTail(n: Int, acc:Int): Int = throw Unimplemented

  /* PART TWO: Map/filter/reduce. */
  /* Exercise 3: Use List.map to implement the incList funtion, which takes
     each element of a list and increments it by 1. */
  def incList(lst: List[Int]): List[Int] = throw Unimplemented

  /* E
  def getEvens(lst: List[Int]): List[Int] = {
                  lst.filter(x => x % 2 == 0)
                    }

                      def sumList(lst: List[Int]): Int = {
                            lst.foldLeft(0)((acc, x) => x + acc)
                              }

                                def mapWithFold[A, B](lst: List[A], f: A => B): List[B] = {
                                      lst.foldLeft(List[B]())((acc: List[B], x: A) => f(x)::acc)
                                        }

                                          def filterWithFold[A](lst: List[A], f: A => Boolean): List[A] = {
                                                lst.foldLeft(List[A]())((acc: List[A], x: A) => if (f(x)) x::acc else acc)
                                                  }

}
