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


class PyClojureObject(val clj: Object)
  extends PyObjectDerived(PyType.fromClass(clj.getClass, false)) {

  // this.javaProxy = clj
  JyAttribute.setAttr(this, JyAttribute.JAVA_PROXY_ATTR, clj)
}
