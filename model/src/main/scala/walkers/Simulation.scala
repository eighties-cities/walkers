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

import scopt.*
import bytepack.file.*
import better.files.*

def loadWorld(data: File) =
  World(
    individuals = packedLoad[Individual]((data / Data.individuals).toJava).map(bytepack.Packed.apply),
    walkers = packedLoad[Walker]((data / Data.walkers).toJava).map(bytepack.Packed.apply)
  )


@main def simulation(args: String*) =
  case class Parameter(
    data: Option[java.io.File] = None)

  val builder = OParser.builder[Parameter]

  val parser =
    import builder._
    OParser.sequence(
      programName("walkers"),
      opt[java.io.File]("data").action((f, p) => p.copy(data = Some(f))).text("generated data directory").required()
    )
  OParser.parse(parser, args, Parameter()) match
    case Some(parameter) =>
      loadWorld(parameter.data.get.toScala)
