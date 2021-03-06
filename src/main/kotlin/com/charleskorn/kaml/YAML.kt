/*

   Copyright 2018 Charles Korn.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/

package com.charleskorn.kaml

import kotlinx.serialization.AbstractSerialFormat
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.StringFormat
import kotlinx.serialization.decode

object YAML : AbstractSerialFormat(), StringFormat {
    override fun <T> parse(serializer: DeserializationStrategy<T>, string: String): T {
        val parser = YamlParser(string)
        val rootNode = YamlNode.fromParser(parser)
        val input = YamlInput.createFor(rootNode)
        return input.decode(serializer)
    }

    override fun <T> stringify(serializer: SerializationStrategy<T>, obj: T): String {
        TODO("not implemented")
    }
}
