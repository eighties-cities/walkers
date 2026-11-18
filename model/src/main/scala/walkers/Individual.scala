package walkers

/*
 * Copyright (C) 2026 Romain Reuillon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import bytepack.*

object Individual:
  enum Gender derives EnumMirror:
    case Male, Female
  enum Education derives EnumMirror:
    case Low, Medium, High

  type Location = (UnsignedByte, UnsignedByte)

case class Individual(
   age: UnsignedByte,
   gender: Individual.Gender,
   education: Individual.Education,
   home: Individual.Location) derives Pack

object Walker:
  case class Flags(smoke: Boolean, alcohol: Boolean, pa: Boolean)

case class Walker(
  age: UnsignedByte,
  gender: Individual.Gender,
  education: Individual.Education,
  home: Individual.Location,
  frailty: UnsignedByte,
  multimobidity: UnsignedShort,
  badl: UnsignedByte,
  bmi: Float,
  flags: Walker.Flags)

