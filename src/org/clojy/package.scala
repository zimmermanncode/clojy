/* clojy
 *
 * From Clojure to Python and back
 *
 * Copyright (C) 2015 Stefan Zimmermann <zimmermann.code@gmail.com>
 *
 * clojy is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * clojy is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with clojy. If not, see <http://www.gnu.org/licenses/>.
 */

package org/*.clojy*/


import java.lang._
import java.math._

import clojure.lang._

import org.python.core._


/** From Clojure to Python and back.
 */
package object /*org.*/clojy {

  /** Convert a Clojure object to a Jython object.
   */
  def clj2py(obj: Any): PyObject = obj match {

    case clj: ClojyObject =>
      clj.py

    case clj: Keyword =>
      new PyClojureKeyword(clj)

    case clj: IPersistentMap =>
      new PyClojureMap(clj)

    case clj: BigInt =>
      new PyLong(clj.toBigInteger)

    case num: BigInteger =>
      new PyLong(num)

    case num: Long => //- Py.java2py converts every Long to PyLong
      if (Integer.MIN_VALUE <= num && num <= Integer.MAX_VALUE)
        new PyInteger(num.toInt)
      else
        new PyLong(num)

    case py: PyObject =>
      py

    case _ =>
      Py.java2py(obj)
  }

  /** Convert a Jython object to a Clojure object.
   */
  def py2clj(obj: PyObject): Object = obj match {

    case py: PyClojureObject =>
      py.clj

    case _: PyString => //- Also covers PyUnicode
      obj.toString

    case _: PyInteger =>
      obj.asLong: Long

    case py: PyLong => //- PyLong uses BigInteger
      try obj.asLong: Long
      catch { //- Overflow!
        case e: PyException =>
          BigInt.fromBigInteger(py.getValue)
      }

    case _: PyFloat =>
      obj.asDouble: Double

    case _: PyNone =>
      null

    case _ =>
      new ClojyObject(obj)
  }

  // def seq(seq: ISeq) =
  //     if (args count)
  // this.py.__call__((while (args) yield args.first) map{arg: Any => Clojy.clj2py(arg)} toArray)
  //         this.py.__call__(Stream continually(args next) map{arg: Any => Clojy.clj2py(arg)} toArray)
}
