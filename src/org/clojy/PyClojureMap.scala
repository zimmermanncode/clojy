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


class PyClojureMap(override val clj: IPersistentMap)
  extends PyClojureObject(clj) {

  override def __len__ =
    this.clj.count

  override def __getitem__(pykey: PyObject) = clj2py(
    (py2clj(pykey) match {

      case key: String =>
        RT.find(this.clj, key) match {
          case null =>
            RT.find(this.clj, Keyword.intern(null, key))
          case entry =>
            entry
        }

      case key =>
        RT.find(this.clj, key)

    }) match {

      case null =>
        throw Py.KeyError(pykey)

      case entry: MapEntry =>
        entry.get(1)
    })
}
