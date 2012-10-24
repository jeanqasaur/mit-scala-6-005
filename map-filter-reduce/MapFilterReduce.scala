/**
  Examples for map, filter, and reduce lecture.
*/

import scala.math._

object MapFilterReduce {
  /**
   * Implementing our own map.
   */
  def map[A, B] (f: A => B, seq: List[A]): List[B] = {
    var result: List[B] = List ()
    seq.foreach (x => result ::= f (x))
    return result.reverse
  }

  /**
   * Implemeting our own filter.
   */
  def filter[A] (f: A => Boolean, seq: List[A]): List[A] = {
    var result: List[A] = List ()
    seq.foreach (x => if (f (x)) { result ::= x })
    return result.reverse
  }

  /**
   * Partially applied functions.
   */
  def mysqrt = scala.math.sqrt _

  /**
   * Some helper functions.
   */
  def powerOfTwo (k: Double):Double = pow (2, k)
  def isOdd (x: Int): Boolean = x % 2 == 1

  def flatten[A](list: List[List[A]]): List[A] = {
    return list.foldLeft (List (): List[A])(_++_)
  }


  /**                                           
   * Map examples.
   */
  def mapExamples (): Unit = {
    println (List (1: Double, 4, 9, 16).map (sqrt))
    println (List ('A', 'B').map ((s: Char) => s.toLower))
    println (map (powerOfTwo, List (1: Double, 2, 3, 4)))
    println (map ((k: Double) => pow (2, k), List (1: Double, 2, 3, 4)))
  }
  /**
   * Filter examples.
   */
  def filterExamples (): Unit = {
    println (List (1, 2, 3, 4).filter (isOdd))
    println (List (1, 2, 3, 4).filter (x => x % 2 == 1))
    println (filter ((c: Char) => c.isLetter, List ('x', 'y', '2', '3', 'a')))
    println (filter ((s: String) => s.length () > 0, List ("abc", "", "d")))
  }

  def reduceExamples (): Unit = {
    println (List (1, 2, 3).foldLeft (0)(_+_))
    println (List (5, 8, 3, 1).foldLeft (0)(max _))
    println (List (1, 2, 3, 4).foldLeft ("")((s, x) => s + x))
    println (flatten (
              List (List (1, 2), List (3, 4), List (), List (5), List ())))
  }
}
