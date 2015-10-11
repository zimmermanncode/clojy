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

package org.clojy


import clojure.lang._

import org.python.core._


class ClojyObject(val py: PyObject)
  extends AClojyObject {

//--- Arithmetic methods ---

  def add(obj: Any) =
    py2clj(this.py._add(clj2py(obj)))

  def radd(obj: Any) =
    py2clj(clj2py(obj)._add(this.py))

  def sub(obj: Any) =
    py2clj(this.py._sub(clj2py(obj)))

  def rsub(obj: Any) =
    py2clj(clj2py(obj)._sub(this.py))

  def mul(obj: Any) =
    py2clj(this.py._mul(clj2py(obj)))

  def rmul(obj: Any) =
    py2clj(clj2py(obj)._mul(this.py))

  def div(obj: Any) =
    py2clj(this.py._div(clj2py(obj)))

  def rdiv(obj: Any) =
    py2clj(clj2py(obj)._div(this.py))

//--- Override Object methods ---

  override def toString =
    this.py.toString

//--- Implement Runnable ---

  override def run =
    this.invoke

//--- Implement clojure.lang.IFn ---

  private def _invoke(args: Any*) =
    this.py.__call__(args.map{arg: Any => clj2py(arg)}.toArray)

  override def invoke =
    py2clj(this.py.__call__)

  override def invoke(arg1: Any) =
    py2clj(this.py.__call__(clj2py(arg1)))

  override def invoke(arg1: Any, arg2: Any) =
    py2clj(this.py.__call__(
      clj2py(arg1), clj2py(arg2)))

  override def invoke(arg1: Any, arg2: Any, arg3: Any) =
    py2clj(this.py.__call__(
      clj2py(arg1), clj2py(arg2), clj2py(arg3)))

  override def invoke(arg1: Any, arg2: Any, arg3: Any, arg4: Any) =
    py2clj(this.py.__call__(
      clj2py(arg1),
      clj2py(arg2),
      clj2py(arg3),
      clj2py(arg4)))

  override def invoke(
    arg1: Any, arg2: Any, arg3: Any, arg4: Any, arg5: Any
  ) =
    this._invoke(arg1, arg2, arg3, arg4, arg5)

  override def invoke(
    arg1: Any, arg2: Any, arg3: Any, arg4: Any, arg5: Any, arg6: Any
  ) =
    this.py.__call__()

  override def invoke(
    arg1: Any, arg2: Any, arg3: Any, arg4: Any, arg5: Any, arg6: Any,
    arg7: Any
  ) =
    this.py.__call__()

  override def invoke(
    arg1: Any, arg2: Any, arg3: Any, arg4: Any, arg5: Any, arg6: Any,
    arg7: Any, arg8: Any
  ) =
    this.py.__call__()

  override def invoke(
    arg1: Any, arg2: Any, arg3: Any, arg4: Any, arg5: Any, arg6: Any,
    arg7: Any, arg8: Any, arg9: Any
  ) =
    this.py.__call__()

  override def invoke(
    arg1: Any, arg2: Any, arg3: Any, arg4: Any, arg5: Any, arg6: Any,
    arg7: Any, arg8: Any, arg9: Any, arg10: Any
  ) =
    this.py.__call__()

  override def invoke(
    arg1: Any, arg2: Any, arg3: Any, arg4: Any, arg5: Any, arg6: Any,
    arg7: Any, arg8: Any, arg9: Any, arg10: Any, arg11: Any
  ) =
    this.py.__call__()

  override def invoke(
    arg1: Any, arg2: Any, arg3: Any, arg4: Any, arg5: Any, arg6: Any,
    arg7: Any, arg8: Any, arg9: Any, arg10: Any, arg11: Any, arg12: Any
  ) =
    this.py.__call__()

  override def invoke(
    arg1: Any, arg2: Any, arg3: Any, arg4: Any, arg5: Any, arg6: Any,
    arg7: Any, arg8: Any, arg9: Any, arg10: Any, arg11: Any, arg12: Any,
    arg13: Any
  ) =
    this.py.__call__()

  override def invoke(
    arg1: Any, arg2: Any, arg3: Any, arg4: Any, arg5: Any, arg6: Any,
    arg7: Any, arg8: Any, arg9: Any, arg10: Any, arg11: Any, arg12: Any,
    arg13: Any, arg14: Any
  ) =
    this.py.__call__()

  override def invoke(
    arg1: Any, arg2: Any, arg3: Any, arg4: Any, arg5: Any, arg6: Any,
    arg7: Any, arg8: Any, arg9: Any, arg10: Any, arg11: Any, arg12: Any,
    arg13: Any, arg14: Any, arg15: Any
  ) =
    this.py.__call__()

  override def invoke(
    arg1: Any, arg2: Any, arg3: Any, arg4: Any, arg5: Any, arg6: Any,
    arg7: Any, arg8: Any, arg9: Any, arg10: Any, arg11: Any, arg12: Any,
    arg13: Any, arg14: Any, arg15: Any, arg16: Any
  ) =
    this.py.__call__()

  override def invoke(
    arg1: Any, arg2: Any, arg3: Any, arg4: Any, arg5: Any, arg6: Any,
    arg7: Any, arg8: Any, arg9: Any, arg10: Any, arg11: Any, arg12: Any,
    arg13: Any, arg14: Any, arg15: Any, arg16: Any, arg17: Any
  ) =
    this.py.__call__()

  override def invoke(
    arg1: Any, arg2: Any, arg3: Any, arg4: Any, arg5: Any, arg6: Any,
    arg7: Any, arg8: Any, arg9: Any, arg10: Any, arg11: Any, arg12: Any,
    arg13: Any, arg14: Any, arg15: Any, arg16: Any, arg17: Any, arg18: Any
  ) =
    this.py.__call__()

  override def invoke(
    arg1: Any, arg2: Any, arg3: Any, arg4: Any, arg5: Any, arg6: Any,
    arg7: Any, arg8: Any, arg9: Any, arg10: Any, arg11: Any, arg12: Any,
    arg13: Any, arg14: Any, arg15: Any, arg16: Any, arg17: Any, arg18: Any,
    arg19: Any
  ) =
    this.py.__call__()

  override def invoke(
    arg1: Any, arg2: Any, arg3: Any, arg4: Any, arg5: Any, arg6: Any,
    arg7: Any, arg8: Any, arg9: Any, arg10: Any, arg11: Any, arg12: Any,
    arg13: Any, arg14: Any, arg15: Any, arg16: Any, arg17: Any, arg18: Any,
    arg19: Any, arg20: Any
  ) =
    this.py.__call__()

  override def invoke(
    arg1: Any, arg2: Any, arg3: Any, arg4: Any, arg5: Any, arg6: Any,
    arg7: Any, arg8: Any, arg9: Any, arg10: Any, arg11: Any, arg12: Any,
    arg13: Any, arg14: Any, arg15: Any, arg16: Any, arg17: Any, arg18: Any,
    arg19: Any, arg20: Any, args: Object*
  ) =
    this.py.__call__()

  override def applyTo(args: ISeq) =
    py2clj(this.py.__call__(clj2py(args.first)))
    // if (args count)
    //   // this.py.__call__((while (args) yield args.first) map{arg: Any => clj2py(arg)} toArray)
    //   this.py.__call__(Stream continually(args next) map{arg: Any => clj2py(arg)} toArray)
    // else
    //   this.py.__call__

}
