// Define an "Unimplemented" exception for what the students are responsible
// for implementing.
case object Unimplemented extends Exception

abstract class Operator
case object Plus extends Operator
case object Minus extends Operator
case object Times extends Operator
case object Div extends Operator

sealed abstract class Expr
abstract class IntExpr extends Expr
abstract class BoolExpr extends Expr

case class IntConstant(v: Int) extends IntExpr
case class IntBinop(op: Operator, e1: IntExpr, e2: IntExpr) extends IntExpr

case class BoolConstant(v: Boolean) extends BoolExpr
case class BoolBinop(op: Operator, e1: BoolExpr, e2: BoolExpr) extends BoolExpr

class ArithEval {
  def eval(e: Expr): Expr = {
    e match {
      // Pattern match on *types*!
      case (i: IntExpr) => evalIntExpr(i)
      case (b: BoolExpr) => throw Unimplemented
    }
  }
  
  def evalIntExpr(e: IntExpr): IntExpr = {
    e match {
      case IntConstant(v) => throw Unimplemented
    }
  }
}
