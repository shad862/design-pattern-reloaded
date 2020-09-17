package memoizer

import java.util

object memoizer_s1 extends App {

  def memoize[V, R](f: (V, V => R) => R): V => R = {
    val holder = new util.HashMap[V, R]()
    def fun:V => R = v => holder.computeIfAbsent(v, v => f(v, fun))
    fun
  }

  0 to 19 map memoize[Int, Int]((n, fun) => if (n < 2) 1 else fun(n - 1) + fun(n - 2)) foreach println
}